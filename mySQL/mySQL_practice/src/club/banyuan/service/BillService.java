package club.banyuan.service;

import club.banyuan.dto.Supplier;
import club.banyuan.dto.Bill;
import club.banyuan.dto.Validation;
import club.banyuan.util.JdbcUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BillService {

  private static final SimpleDateFormat time = new SimpleDateFormat("yyyy/MM/dd HH:mm");

  // 根据账单id获取账单信息
  public Bill getBillById(int id) {
    // SQL 语句
    String sql = "select * from Bill where id = ?";
    Map<String, Object> map = JdbcUtil.queryOne(sql, id);
    return JSONObject.parseObject(JSONObject.toJSONString(map), Bill.class);
  }

  // 获取账单列表
  public List<Bill> getBillList() {
    // SQL 语句
//    String sql = "select id, providerName, product, updateTime, isPay, money from Bill";
    String sql = "select * from Bill";
    List<Map<String, Object>> list = JdbcUtil.queryAll(sql);
    return JSONObject.parseArray(JSONObject.toJSONString(list), Bill.class);
  }

  // 获取指定信息的账单列表
  public List<Bill> getBillList(Bill bill) {
//    String sql = "select id, providerName, product, updateTime, isPay, money from Bill where product like ?";
    String sql = "select * from Bill where product like ?";
    String sqlIsPay = "select * from Bill where product like ? and isPay like ?";
    String productLike = "%" + bill.getProduct() + "%";
    int isPayStrLike = bill.getIsPay();
    List<Map<String, Object>> list;
    if (isPayStrLike != -1) {
      list = JdbcUtil.queryAll(sqlIsPay, productLike, isPayStrLike);
    } else {
      list = JdbcUtil.queryAll(sql, productLike);
    }
    return JSONObject.parseArray(JSONObject.toJSONString(list), Bill.class);
  }

  // 更新账单信息
  public void updateBill(Bill bill) {
    // SQL 语句
    String sql = "update Bill set isPay = ?, isPayStr = ?, money = ?, product = ?, providerId = ?, updateTime = ?, providerName = ? where id = ?";
    String isPayStr = bill.getIsPay() == 1 ? "已付款" : "未付款";
    String providerName = getProviderNameById(bill);
    String updateTime = time.format(new Date());
    JdbcUtil.update(sql, bill.getIsPay(), isPayStr, bill.getMoney(), bill.getProduct(), bill.getProviderId(), updateTime, providerName, bill.getId());
  }

  // 新增账单信息
  public void insertBill(Bill bill) {
    // SQL 语句
    String sql = "insert into Bill(isPay, isPayStr, money, product, providerId, updateTime, providerName) values (?, ?, ?, ?, ?, ?, ?)";
    bill.setIsPay(bill.getIsPay());
    bill.setProviderId(bill.getProviderId());
    bill.setProviderName(getProviderNameById(bill));
    bill.setUpdateTime(time.format(new Date()));
    JdbcUtil.update(sql, bill.getIsPay(), bill.getIsPayStr(), bill.getMoney(), bill.getProduct(), bill.getProviderId(), bill.getUpdateTime(), bill.getProviderName());
  }

  // 删除账单信息
  public void deleteBill(Bill bill) {
    // SQL
    String sql = "delete from Bill where id = ?";
    JdbcUtil.update(sql, bill.getId());
  }

  // 根据账单中供应商id得到供应商名称
  public String getProviderNameById(Bill bill) {
    // 找到 providerName 的 SQL 语句
    String providerNameSQL = "select name from supplier where id = ?";
    Map<String, Object> providerInformation = JdbcUtil.queryOne(providerNameSQL, bill.getProviderId());
    Supplier supplier = JSONObject.parseObject(JSONObject.toJSONString(providerInformation), Supplier.class);
    return supplier.getName();
  }
}
