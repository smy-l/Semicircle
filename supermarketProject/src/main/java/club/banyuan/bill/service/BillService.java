package club.banyuan.bill.service;

import club.banyuan.bill.entity.Bill;

import java.util.List;

public interface BillService {

  List<Bill> getBillList();

  List<Bill> getBillListByProAndIsPay(String product, String isPay);

  Bill getBillById(Integer id);

  void saveBill(Bill bill);

  void deleteBillById(Integer id);
}
