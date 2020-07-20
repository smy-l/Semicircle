package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.Supplier;
import club.banyuan.mbm.uti.PropUtil;
import club.banyuan.mbm.uti.ValidationUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static club.banyuan.mbm.uti.ValidationUtil.validate;

public class SupplierService {

  private static int supplierId;
  private static final String SUPPLIER_STORE_PATH = "supplier.store.path";
  private static List<Supplier> supplierList;

  static {
    load();
    supplierId = supplierList.size() + 1;
    for (Supplier supplier : supplierList) {
      if (supplierId < supplier.getId()) {
        supplierId = supplier.getId() + 1;
      }
    }
  }

  //供应商列表
  private static void load() {
    File file = new File(PropUtil.getProp(SUPPLIER_STORE_PATH));
    if (file.exists()) {
      try (FileInputStream fileInputStream = new FileInputStream(file)) {
        byte[] bytes = fileInputStream.readAllBytes();
        supplierList = (JSONObject.parseArray(new String(bytes), Supplier.class));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.err.println("供应商文件不存在");
      supplierList = new ArrayList<>();
    }
  }

  //得到

  //保存供应商
  public static void save() {
    try (FileOutputStream fileOutputStream = new FileOutputStream(PropUtil.getProp(SUPPLIER_STORE_PATH))) {
      String jsonStr = JSONObject.toJSONString(supplierList);
      byte[] bytes = jsonStr.getBytes();
      fileOutputStream.write(bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //增：增加一个供应商
  public void addSupplier(Supplier supplier) {
    validate(supplier);
    synchronized (supplierList) {
      supplier.setId(supplierId++);
      supplierList.add(supplier);
      save();
    }
  }

  //查(组合查询)：根据name和description寻找符合条件的供应商,返回列表
  public static List<Supplier> findSupplierList(String nameStr, String descriptionStr) {
    String name = nameStr.trim();
    String description = descriptionStr.trim();
    List<Supplier> rlt = new ArrayList<>();
    for (Supplier supplier : supplierList) {
      if (supplier.getName().contains(name) && supplier.getDesc().contains(description)) {
        rlt.add(supplier);
      }
    }
    return rlt;
  }

  //查：根据id(String)查询供应商
  public Supplier getSupplierById(String id) {
    int toId = Integer.parseInt(id);
    for (Supplier supplier : supplierList) {
      if (supplier.getId() == toId) {
        return supplier;
      }
    }
    return null;
  }

  //查：根据id(int)查询供应商
  public Supplier getSupplierById(int id) {
    for (Supplier supplier : supplierList) {
      if (supplier.getId() == id) {
        return supplier;
      }
    }
    return null;
  }

  //改：修改供应商信息
  public void modifySupplier(Supplier supplier) {
    synchronized (supplierList) {
      Supplier newSupplier = getSupplierById(supplier.getId());
      newSupplier.setContactPerson(supplier.getContactPerson());
      newSupplier.setName(supplier.getName());
      newSupplier.setDesc(supplier.getDesc());
      newSupplier.setPhone(supplier.getPhone());
    }
  }

  //删：根据id删除供应商
  public void deleteSupplier(int id) {
    synchronized (supplierList) {
      Supplier supplier = getSupplierById(id);
      supplierList.remove(supplier);
    }
    save();
  }

  public List<Supplier> getSupplierList() {
    return supplierList;
  }

  public static void setSupplierList(List<Supplier> supplierList) {
    SupplierService.supplierList = supplierList;
  }

  public List<Supplier> getSupplierList(Supplier supplier) {
    return findSupplierList(supplier.getName(), supplier.getDesc());
  }
}
