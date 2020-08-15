package club.banyuan.dao.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    public UserDaoImpl(Connection conn){
        super(conn);
    }

    @Override
    public User getUserByUserNameAndPwd(String username, String password) throws Exception {
        User user = null;
        String sql = "select * from user where loginName=? and password=?";
        ResultSet rs = executeQuery(sql,new Object[]{username,password});
        if (rs.next()) {
            user = tableToClass(rs);
        }
        this.closeResource(rs);
        return user;
    }

    @Override
    public User AddUser(User user) {
        String sql = "insert into student values(?,?,?,?,?,?,?,?,?)";
        Object[] parm = new Object[9];
        parm[0] = null;
        parm[1] = user.getLoginName();
        parm[2] = user.getUserName();
        parm[3] = user.getPassword();
        parm[4] = user.getSex();
        parm[5] = user.getIdentityCode();
        parm[6] = user.getEmail();
        parm[7] = user.getMobile();
        parm[8] = user.getType();
        int id = executeInsert(sql, parm);
        user.setId(id);
        closeResource();
        return user;
    }

    @Override
    public User tableToClass(ResultSet rs) throws Exception {
        User user = new User();
        user.setId(rs.getInt(1));
        user.setLoginName(rs.getString(2));
        user.setUserName(rs.getString(3));
        user.setPassword(rs.getString(4));
        user.setSex(rs.getInt(5));
        user.setIdentityCode(rs.getString(6));
        user.setEmail(rs.getString(7));
        user.setMobile(rs.getString(8));
        user.setType(rs.getInt(9));
        return user;
    }
}
