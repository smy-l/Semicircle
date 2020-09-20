package club.banyuan.bill.controller;

import club.banyuan.bill.entity.Bill;
import club.banyuan.bill.service.BillService;
import club.banyuan.provider.service.ProviderService;
import cn.hutool.json.JSONObject;
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

  private static SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  @Autowired
  private BillService billService;

  @Autowired
  private ProviderService providerService;

  @RequestMapping("/list")
  @ResponseBody
  public List<Bill> getUserList(Bill bill) {
    System.out.println(bill);
    if (bill.getProduct() == null & bill.getIsPay() == null) {
      return billService.getBillList();
    } else {
      return billService.getBillListByProAndIsPay(bill.getProduct(), bill.getIsPay().toString());
    }
  }

  @RequestMapping("/get")
  @ResponseBody
  public Bill getUserById(@RequestBody JSONObject jsonObject) {
    Object idObject = jsonObject.get("id");
    int id = Integer.parseInt(idObject.toString());
    return billService.getBillById(id);
  }

  //  id=0&name=1&pwd=2&pwdConfirm=3&userType=0
  @RequestMapping("/modify")
  public String modifyUser(String id, String providerId, String money, String product, String isPay) {
    Bill bill = new Bill();
    bill.setId(Integer.parseInt(id));
    int providerIdNum = Integer.parseInt(providerId);
    bill.setProviderId(providerIdNum);
    bill.setMoney(Double.parseDouble(money));
    bill.setProduct(product);
    bill.setIsPay(Integer.parseInt(isPay));
    bill.setUpdateTime(new Date());
    bill.setIsPayStr(isPay.equals(1) ? "已付款" : "未付款");
    bill.setProviderName(providerService.getProviderById(providerIdNum).getName());
//    System.out.println(user);
    billService.saveBill(bill);
    return "redirect:/bill_list.html";
  }

  @RequestMapping("/delete")
  public String deleteUser(@RequestBody JSONObject jsonObject) {
//    System.out.println(jsonObject);
    Object idObject = jsonObject.get("id");
    int id = Integer.parseInt(idObject.toString());
    billService.deleteBillById(id);
    return "redirect:/bill_list.html";
  }

}
