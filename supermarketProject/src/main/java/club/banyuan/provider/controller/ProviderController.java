package club.banyuan.provider.controller;

import club.banyuan.provider.entity.Provider;
import club.banyuan.provider.service.ProviderService;
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
  public List<Provider> getUserList(@RequestBody(required = false) Provider provider) {
    System.out.println(provider);
    if (provider == null) {
      return providerService.getProviderList();
    } else {
      return providerService.getProviderListByNameAndDesc(provider.getName(), provider.getDesc());
    }
  }

  @RequestMapping("/get")
  @ResponseBody
  public Provider getUserById(@RequestBody Provider provider) {
    return providerService.getProviderById(provider.getId());
  }

  @RequestMapping("/modify")
  public String modifyUser(String id, String name, String desc, String phone, String contactPerson) {
    Provider provider = new Provider();
    provider.setId(Integer.parseInt(id));
    provider.setName(name);
    provider.setDesc(desc);
    provider.setPhone(phone);
    provider.setContactPerson(contactPerson);
    providerService.saveProvider(provider);
    return "redirect:/provider_list.html";
  }

  @RequestMapping("/delete")
  public String deleteUser(@RequestBody Provider provider) {
    providerService.deleteProvider(provider.getId());
    return "redirect:/provider_list.html";
  }

}
