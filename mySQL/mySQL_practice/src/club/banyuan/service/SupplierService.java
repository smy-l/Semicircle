package club.banyuan.service;

import club.banyuan.dto.Supplier;
import club.banyuan.exception.FormPostException;
import club.banyuan.util.JdbcUtil;
import club.banyuan.util.ValidationUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class SupplierService {

  // 根据供应商id获取供应商信息
  public Supplier getSupplierById(int id) {
    // SQL 语句
//    String sql = "select name, phone, contactPerson, description from supplier where id = ?";
    String sql = "select * from supplier where id = ?";
    Map<String, Object> map = JdbcUtil.queryOne(sql, id);
    return JSONObject.parseObject(JSONObject.toJSONString(map), Supplier.class);
  }

  // 获取供应商列表
  public List<Supplier> getSupplierList() {
    // SQL 语句
//    String sql = "select id, name, phone, description, contactPerson from supplier";
    String sql = "select * from supplier";
    List<Map<String, Object>> list = JdbcUtil.queryAll(sql);
    return JSONObject.parseArray(JSONObject.toJSONString(list), Supplier.class);
  }

  // 获取指定信息的供应商列表
  public List<Supplier> getSupplierList(Supplier supplier) {
    // 查询包含指定信息的供应商列表
    String sql = "select * from supplier where name like ? and description like ?";
    String nameLike = "%" + supplier.getName().trim() + "%";
    String descLike = "%" + supplier.getDescription().trim() + "%";
    List<Map<String, Object>> list = JdbcUtil.queryAll(sql, nameLike, descLike);
    return JSONObject.parseArray(JSONObject.toJSONString(list), Supplier.class);
  }

  // 更新供应商信息
  public void updateSupplier(Supplier supplier) {
      // SQL 语句
      String sql = "update supplier set name = ?, contactPerson = ?, phone = ?, description = ? where id = ?";
      JdbcUtil.update(sql, supplier.getName(), supplier.getContactPerson(), supplier.getPhone(), supplier.getDescription(), supplier.getId());
  }

  // 新增供应商信息
  public void insertSupplier(Supplier supplier) {
    if (supplier.getName().equals("")) {
      throw new FormPostException("供应商名字不为空");
    }
    try {
      ValidationUtil.validate(supplier);
    } catch (Exception e) {
      throw new FormPostException(e.getMessage());
    }
    // SQL 语句
    String sql = "insert into supplier(name, contactPerson, phone, description) values (?, ?, ?, ?)";
    JdbcUtil.update(sql, supplier.getName(), supplier.getContactPerson(), supplier.getPhone(), supplier.getDescription());
  }

  // 删除供应商信息
  public void deleteSupplier(Supplier supplier) {
    // SQL
    String sql = "delete from supplier where id = ?";
    JdbcUtil.update(sql, supplier.getId());
  }
}
