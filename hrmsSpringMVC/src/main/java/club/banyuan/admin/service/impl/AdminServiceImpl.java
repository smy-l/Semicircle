package club.banyuan.admin.service.impl;

import club.banyuan.admin.dao.AdminDao;
import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.common.ServerException;
import club.banyuan.util.CipherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// @Component、@Repository、@Service、@Controller
//              持久层        业务层     控制层
// 四个注释一样，都是给 mvc 提示，但是不同名字的原因是为了给程序员更好的注释，四个中任意一个都可以
@Service
public class AdminServiceImpl implements AdminService {

  // @Qualifier("adminDaoImpl")
  // @Qualifier 指定注入接口的实现类 bean，里面填写的是注册到spring容器中的bean的id
  // @Qualifier 如何个没有显示指定id，则为对应的类名，首字母小写

  @Autowired
  private AdminDao adminDao;

  @Override
  public Admin login(String username, String password) {
//    String passHash = CipherUtil.hmacSha256(password);
//    Admin admin = adminDao.getAdmin(username, passHash);
    System.out.println(username);
    System.out.println(password);
    Admin admin = adminDao.getAdmin(username, password);
    return admin;
  }

  @Override
  public List<Admin> getAdminList(String username) {
    if (username == null || username.trim().length() == 0) {
      return adminDao.getAdminList();
    } else {
      return adminDao.getAdminList(username);
    }
  }

  @Override
  public void addAdmin(Admin admin) {
    // 密码经过不可逆加密后保存
    admin.setPassword(CipherUtil.hmacSha256(admin.getPassword()));
    List<Admin> adminByName = adminDao.getAdminByName(admin.getUsername());
    if (adminByName.size() > 0) {
      throw new ServerException("用户名已存在");
    }
    adminDao.addAdmin(admin);
  }

  @Override
  public void updateAdmin(Admin admin) {
    Admin old = adminDao.getAdminById(admin.getId());
    if (old == null) {
      throw new ServerException("用户id不存在：" + admin.getId());
    }
    admin.setPassword((CipherUtil.hmacSha256(admin.getPassword())));
    adminDao.updateAdmin(admin);
  }

  @Override
  public void deleteAdmins(List<String> adminList) {
    // 把一个String list 转换为 Integer list
    List<Integer> idList = adminList.stream().map(t -> {
      return Integer.parseInt(t);
    }).collect(Collectors.toList());

    adminDao.deleteAdmins(idList);
  }

  @Override
  public List<Admin> getAdminList(String username, Integer page, Integer row) {
    return adminDao.getAdminListPage(username, page, row);
  }

  @Override
  public int getAdminListCount(String username) {
    return adminDao.getAdminListPageCount(username);
  }
}
