package service;

import com.alibaba.fastjson.JSONObject;
import entity.Supplier;
import exception.FormPostException;
import myUtil.PropUtil;
import myUtil.ValidationUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SupplierService {
  private static int supplierId;
  private static final String SUPPLIER_STORE_PATH = "supplier.store.path";
  private static List<Supplier> supplierList;

  static {
    load();
    Optional<Supplier> max = supplierList.stream().max(Comparator.comparingInt(Supplier::getId));
    supplierId = max.map(supplier -> supplier.getId() + 1).orElse(1);

  }

  //加载load(), 保存save(), 增, 删, 改, 查
  public static void load() {
    File file = new File(PropUtil.getProp(SUPPLIER_STORE_PATH));
    if (file.exists()) {
      try (FileInputStream fileInputStream = new FileInputStream(file)) {
        byte[] bytes = fileInputStream.readAllBytes();
        supplierList = JSONObject.parseArray(new String(bytes), Supplier.class);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.err.println("供应商文件不存在");
      supplierList = new ArrayList<>();
    }
  }

  //保存
  public static void save(){
   File file = new File(PropUtil.getProp(SUPPLIER_STORE_PATH));
    try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
      String jsonStr = JSONObject.toJSONString(supplierList);
      fileOutputStream.write(jsonStr.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //增
  public void addSupplier(Supplier supplier){
    try {
      ValidationUtil.validate(supplier);
    } catch (Exception e) {
      throw new FormPostException(e.getMessage());
    }
    synchronized (supplierList){
      supplier.setId(supplierId++);
      supplierList.add(supplier);
    }
    save();
  }

  //删
  public void deleteSupplier(Supplier supplier){
    synchronized (supplierList){
      Supplier supplierId = getSupplierById(supplier.getId());
      supplierList.remove(supplierId);
    }
    save();
  }

  //改
  public void modifySupplier(Supplier supplier){
    synchronized (supplierList){
      Supplier newSupplier = getSupplierById(supplier.getId());
      newSupplier.setPhone(supplier.getPhone());
      newSupplier.setName(supplier.getName());
      newSupplier.setDesc(supplier.getDesc());
      newSupplier.setContactPerson(supplier.getContactPerson());
    }
  }

  //查(组合查询)，根据name和desc查询
  public List<Supplier> findSupplier(String name, String desc){
    List<Supplier> list = new ArrayList<>();
    for (Supplier supplier : supplierList) {
      if(supplier.getName().contains(name.trim()) && supplier.getDesc().contains(desc.trim())){
        list.add(supplier);
      }
    }
    return list;
  }

  public Supplier getSupplierById(int id){
    for (Supplier supplier : supplierList) {
      if(supplier.getId() == id){
        return supplier;
      }
    }
    return null;
  }

  public List<Supplier> getSupplierList(){
    return supplierList;
  }

  public List<Supplier> getSupplierList(Supplier supplier){
    return findSupplier(supplier.getName(), supplier.getDesc());
  }

}
