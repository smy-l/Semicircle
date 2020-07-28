package club.banyuan.service;

import club.banyuan.dto.Supplier;
import club.banyuan.dto.Validation;
import club.banyuan.util.JdbcUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SupplierService {

  // 根据供应商id获取供应商信息
  public Supplier getSupplierById(int id) {
    // SQL 语句
//    String sql = "select name, desc, phone, contactPerson from supplier where id = ?";
    String sql = "select name, phone, contactPerson from supplier where id = ?";
    Map<String, Object> map = JdbcUtil.queryOne(sql, id);
    return JSONObject.parseObject(JSONObject.toJSONString(map), Supplier.class);
  }

  // 获取供应商列表
  public List<Supplier> getSupplierList() {
    // SQL 语句
//    String sql = "select id, name, desc, phone, contactPerson from supplier";
    String sql = "select id, name, phone, contactPerson from supplier";
    List<Map<String, Object>> list = JdbcUtil.queryAll(sql);
    return JSONObject.parseArray(JSONObject.toJSONString(list), Supplier.class);
  }

  // 获取指定信息的供应商列表
  public List<Supplier> getSupplierList(Supplier supplier) {
    List<Supplier> supplierList = getSupplierList();
    List<Supplier> list = new ArrayList<>();
    for (Supplier s1 : supplierList) {
      if (s1.getName().contains(supplier.getName().trim())) {
        list.add(s1);
      }
    }
    return list;
  }

  // 更新供应商信息
  public void updateSupplier(Supplier supplier) {
    //根据供应商id获取供应商信息
    Supplier s1 = getSupplierById(supplier.getId());
    if (s1 != null) {
      s1.setName(supplier.getName());
      s1.setContactPerson(supplier.getContactPerson());
      s1.setDesc(supplier.getDesc());
      s1.setPhone(supplier.getPhone());
      // SQL 语句
      String sql = "update supplier set name = ?, contactPerson = ?, phone = ?";
      JdbcUtil.update(sql, s1.getName(), s1.getContactPerson(), s1.getPhone());
    }
  }

  // 新增供应商信息
  public void insertSupplier(Supplier supplier) {
    // SQL 语句
    String sql = "insert into supplier(name, contactPerson, phone) values (?, ?, ?)";
    JdbcUtil.update(sql, supplier.getName(), supplier.getContactPerson(), supplier.getPhone());
  }

  // 删除供应商信息
  public void deleteSupplier(Supplier supplier) {
    // SQL
    String sql = "delete from supplier where id = ?";
    JdbcUtil.update(sql, supplier.getId());
  }
}
