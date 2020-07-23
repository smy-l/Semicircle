package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.Bill;
import club.banyuan.mbm.entity.Supplier;
import club.banyuan.mbm.exception.BadRequestException;
import club.banyuan.mbm.exception.FormPostException;
import club.banyuan.mbm.uti.PropUtil;
import club.banyuan.mbm.uti.ValidationUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillService {

  private static int billId;
  private static final String BILL_STORE_PATH = "bill.store.path";
  private final String SUPPLIER_STORE_PATH = "supplier.store.path";
  private static List<Bill> billList;
  private SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  static {
    load();
    billId = billList.size() + 1;
    for (Bill bill : billList) {
      if (billId < bill.getId()) {
        billId = bill.getId() + 1;
      }
    }
  }

  //加载文件
  private static void load() {
    File file = new File(PropUtil.getProp(BILL_STORE_PATH));
    if (file.exists()) {
      try (FileInputStream fileInputStream = new FileInputStream(file)) {
        byte[] bytes = fileInputStream.readAllBytes();
        billList = JSONObject.parseArray(new String(bytes), Bill.class);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.err.println("账单文件不存在");
      billList = new ArrayList<>();
    }
  }

  //检查账单关联id是否关联已有供应商
  public boolean checkProId(Bill bill) {
    File file = new File(PropUtil.getProp(SUPPLIER_STORE_PATH));
    try (FileInputStream fileInputStream = new FileInputStream(file)) {
      byte[] bytes = fileInputStream.readAllBytes();
      List<Supplier> tempSupplierList = JSONObject.parseArray(new String(bytes), Supplier.class);
      for (Supplier supplier : tempSupplierList) {
        if (supplier.getId() == bill.getProviderId()) {
          return true;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  //保存信息
  private static void save() {
    File file = new File(PropUtil.getProp(BILL_STORE_PATH));
    try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
      String jsonStr = JSONObject.toJSONString(billList);
      byte[] bytes = jsonStr.getBytes();
      fileOutputStream.write(bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //添加bill
  public void addBill(Bill bill) {
//    try {
//      ValidationUtil.validate(bill);
//    } catch (Exception e) {
//      throw new FormPostException(e.getMessage());
//    }
    if (checkProId(bill)) {
//      System.out.println("mubiao: " + bill);
      synchronized (billList) {
        bill.setId(billId++);
        bill.setUpdateTime(time.format(new Date()));
        bill.setProviderName(getBillProviderName(bill));
        bill.setIsPayStr(bill.getIsPay() == 1 ? "已付款" : "未付款");
        billList.add(bill);
        save();
      }
    }
  }

  private String getBillProviderName(Bill bill) {
    try (FileInputStream fileInputStream = new FileInputStream(PropUtil.getProp(SUPPLIER_STORE_PATH))) {
      byte[] bytes = fileInputStream.readAllBytes();
      List<Supplier> supplierList = JSONObject.parseArray(new String(bytes), Supplier.class);
      for (Supplier supplier : supplierList) {
        if (supplier.getId() == bill.getProviderId()) {
          return supplier.getName();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  //查：根据product(商品描述)进行模糊查找，isPay进行排查
  public List<Bill> findBillList(String productStr, int isPay) {
    List<Bill> list = new ArrayList<>();
    String product = productStr.trim();

    for (Bill bill : billList) {
      if (bill.getProduct().contains(product) || product.length() == 0) {
        if (isPay != -1) {
          if (bill.getIsPay() == isPay) {
            list.add(bill);
          }
        } else {
          list.add(bill);
        }
      }
    }
    return list;
  }

  //查：根据Id查询账单
  public Bill getBillById(int id) {
    for (Bill bill : billList) {
      if (bill.getId() == id) {
        return bill;
      }
    }
    throw new BadRequestException("账单id:" + id + "不存在");
  }

  //改
  public void modifyBill(Bill bill) {
    synchronized (billList) {
//      System.out.println("modifyTo" + bill);
      Bill newBill = getBillById(bill.getId());
      newBill.setMoney(bill.getMoney());
      newBill.setIsPay(bill.getIsPay());
      newBill.setProduct(bill.getProduct());
      newBill.setUpdateTime(time.format(new Date()));
      newBill.setProviderName(getBillProviderName(bill));
      newBill.setIsPayStr(bill.getIsPay() == 1 ? "已付款" : "未付款");
      System.out.println(newBill);
    }
  }

  //删除
  public void deleteBill(int id) {
    synchronized (billList) {
      Bill bill = getBillById(id);
      billList.remove(bill);
      save();
    }
  }

  public List<Bill> getBillList() {
    return billList;
  }

  public List<Bill> getBillList(Bill bill) {
    return findBillList(bill.getProduct(), bill.getIsPay());
  }

}
