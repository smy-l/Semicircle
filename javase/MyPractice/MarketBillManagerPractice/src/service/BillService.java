package service;

import com.alibaba.fastjson.JSONObject;
import entity.Bill;
import entity.Supplier;
import myUtil.PropUtil;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BillService {
  private static int billId;
  private static final String BILL_STORE_PATH = "bill.store.path";
  private static List<Bill> billList;
  private static final String SUPPLIER_STORE_PATH = "supplier.store.path";
  private static SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  static {
    load();
    Optional<Bill> max = billList.stream().max(Comparator.comparingInt(Bill::getId));
    billId = max.map(bill -> bill.getId() + 1).orElse(1);
  }

  //加载，保存，增，删，，查

  //加载
  public static void load() {
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

  //保存
  public static void save() {
    File file = new File(PropUtil.getProp(BILL_STORE_PATH));
    try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
      String jsonStr = JSONObject.toJSONString(billList);
      fileOutputStream.write(jsonStr.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //增
  public void addBill(Bill bill) {
    synchronized (billList) {
      bill.setId(billId++);
      bill.setUpdateTime(time.format(new Date()));
      bill.setIsPay(bill.getIsPay());
      bill.setProviderName(getProviderName(bill));
      billList.add(bill);
      save();
    }
  }

  //删
  public void deleteBill(Bill bill) {
    synchronized (billList) {
      Bill billId = getBillById(bill.getId());
      billList.remove(billId);
    }
    save();
  }

  //改
  public void modifyBill(Bill bill) {
    synchronized (billList) {
      Bill modifyBill = getBillById(bill.getId());
      modifyBill.setProviderName(getProviderName(bill));
      modifyBill.setUpdateTime(time.format(new Date()));
      modifyBill.setIsPay(bill.getIsPay());
      modifyBill.setMoney(bill.getMoney());
      modifyBill.setProduct(bill.getProduct());
      modifyBill.setProviderId(bill.getProviderId());
    }
    save();
  }

  //查：根据product(商品描述)进行模糊查找，isPay进行排查
  public List<Bill> findBill(String product, int isPay) {
    List<Bill> list = new ArrayList<>();
    for (Bill bill : billList) {
      if (bill.getProduct().contains(product.trim()) || product.trim().length() == 0) {
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

  public Bill getBillById(int id) {
    for (Bill bill : billList) {
      if (bill.getId() == id) {
        return bill;
      }
    }
    return null;
  }


  private String getProviderName(Bill bill) {
    File file = new File(PropUtil.getProp(SUPPLIER_STORE_PATH));
    try (FileInputStream fileInputStream = new FileInputStream(file)) {
      byte[] bytes = fileInputStream.readAllBytes();
      List<Supplier> suppliers = JSONObject.parseArray(new String(bytes), Supplier.class);
      for (Supplier supplier : suppliers) {
        if (supplier.getId() == bill.getProviderId()) {
          return supplier.getName();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Bill> getBillList() {
    return billList;
  }

  public List<Bill> getBillList(Bill bill) {
    return findBill(bill.getProduct(), bill.getIsPay());
  }

}
