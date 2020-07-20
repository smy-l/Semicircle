package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.Bill;
import club.banyuan.mbm.uti.PropUtil;
import club.banyuan.mbm.uti.ValidationUtil;
import com.alibaba.fastjson.JSONObject;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillService {

  private static int billId;
  private static final String BILL_STORE_PATH = PropUtil.getProp("bill.store.path");
  private static List<Bill> billList;
  private static SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
    }
  }

  //检查账单关联id是否关联已有供应商
  private boolean checkProId(Bill bill) {
    File file = new File(PropUtil.getProp(BILL_STORE_PATH));
    try (FileInputStream fileInputStream = new FileInputStream(file)) {
      byte[] bytes = fileInputStream.readAllBytes();
      List<Bill> tempBillList = JSONObject.parseArray(new String(bytes), Bill.class);
      for (Bill bill1 : tempBillList) {
        if (bill1.getProviderId() == bill.getProviderId()) {
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
    ValidationUtil.validate(bill);
    if (checkProId(bill)) {
      synchronized (billList) {
        bill.setId(billId++);
        bill.setTime(time.format(new Date()));
        billList.add(bill);
        save();
      }
    }
  }

  //查：根据product(商品名称)进行模糊查找，isPay进行排查
  public List<Bill> findBillList(String productStr, int isPay){
    List<Bill> list = new ArrayList<>();
    String product = productStr.trim();
    for (Bill bill : billList) {
      if(bill.getProduct().contains(product) && bill.isPay() == isPay){
        list.add(bill);
      }
    }
    return list;
  }

  //查：根据Id查询账单
  public Bill getBillById(int id){
    for (Bill bill : billList) {
      if(bill.getId() == id){
        return bill;
      }
    }
    return null;
  }

  //改
  public void modifyBill(Bill bill){
    synchronized (billList){
      Bill newBill = getBillById(bill.getId());
      newBill.setMoney(bill.getMoney());
      newBill.setPay(bill.isPay());
      newBill.setProduct(bill.getProduct());
      newBill.setProductDescription(bill.getProductDescription());
      newBill.setTime(time.format(new Date()));
    }
  }

  //删除
  public void deleteBill(int id){
    synchronized (billList){
      Bill bill = getBillById(id);
      billList.remove(bill);
      save();
    }
  }

  public List<Bill> getBillList() {
    return billList;
  }

  public List<Bill> getBillList(Bill bill){
    return findBillList(bill.getProduct(), bill.isPay());
  }

}
