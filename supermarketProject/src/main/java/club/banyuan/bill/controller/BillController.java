package club.banyuan.bill.controller;

import club.banyuan.bill.entity.Bill;
import club.banyuan.bill.service.BillService;
import club.banyuan.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/server/bill")
public class BillController {

  private static final SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  @Autowired
  private BillService billService;

  @Autowired
  private ProviderService providerService;

  @RequestMapping("/list")
  @ResponseBody
  public List<Bill> getUserList(@RequestBody(required = false) Bill bill) {
    System.out.println(bill);
    if (bill == null || (bill.getIsPay() == -1 && "".equals(bill.getProduct().trim()))) {
      return billService.getBillList();
    } else {
      Integer isPay = bill.getIsPay();
      System.out.println("sss" + isPay);
      return billService.getBillListByProAndIsPay(bill.getProduct(), isPay);
    }
  }

  @RequestMapping("/get")
  @ResponseBody
  public Bill getUserById(@RequestBody Bill bill) {
    return billService.getBillById(bill.getId());
  }

  @RequestMapping("/modify")
  public String modifyUser(String id, String providerId, String money, String product, String isPay) {
    Bill bill = new Bill();
    bill.setId(Integer.parseInt(id));
    int providerIdNum = Integer.parseInt(providerId);
    bill.setProviderId(providerIdNum);
    bill.setMoney(Double.parseDouble(money));
    bill.setProduct(product);
    bill.setIsPay(Integer.parseInt(isPay));
    bill.setUpdateTime(time.format(new Date()));
    bill.setIsPayStr(isPay.equals("1") ? "已付款" : "未付款");
    bill.setProviderName(providerService.getProviderById(providerIdNum).getName());
    billService.saveBill(bill);
    return "redirect:/bill_list.html";
  }

  @RequestMapping("/delete")
  public String deleteUser(@RequestBody Bill bill) {
    billService.deleteBillById(bill.getId());
    return "redirect:/bill_list.html";
  }

}
