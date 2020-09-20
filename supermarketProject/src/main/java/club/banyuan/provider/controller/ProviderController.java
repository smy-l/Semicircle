package club.banyuan.provider.controller;

import club.banyuan.provider.entity.Provider;
import club.banyuan.provider.service.ProviderService;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/server/provider")
public class ProviderController {

  @Autowired
  private ProviderService providerService;

  @RequestMapping("/list")
  @ResponseBody
  public List<Provider> getUserList(Provider provider) {
    System.out.println(provider);
    if (provider.getName() == null & provider.getDesc() == null) {
      return providerService.getProviderList();
    } else {
      return providerService.getProviderListByNameAndDesc(provider.getName(), provider.getDesc());
    }
  }

  @RequestMapping("/get")
  @ResponseBody
  public Provider getUserById(@RequestBody JSONObject jsonObject) {
    Object idObject = jsonObject.get("id");
    int id = Integer.parseInt(idObject.toString());
    return providerService.getProviderById(id);
  }

  //  id=0&name=1&pwd=2&pwdConfirm=3&userType=0
  @RequestMapping("/modify")
  public String modifyUser(String id, String name, String desc, String phone, String contactPerson) {
    Provider provider = new Provider();
    provider.setId(Integer.parseInt(id));
    provider.setName(name);
    provider.setDesc(desc);
    provider.setPhone(phone);
    provider.setContactPerson(contactPerson);
//    System.out.println(user);
    providerService.saveProvider(provider);
    return "redirect:/provider_list.html";
  }

  @RequestMapping("/delete")
  public String deleteUser(@RequestBody JSONObject jsonObject) {
//    System.out.println(jsonObject);
    Object idObject = jsonObject.get("id");
    int id = Integer.parseInt(idObject.toString());
    providerService.deleteProvider(id);
    return "redirect:/provider_list.html";
  }

}
