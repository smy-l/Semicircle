package club.banyuan.bill.dao;

import club.banyuan.bill.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillDao {
    List<Bill> getBillList();

    List<Bill> getBillListByProAndIsPay(@Param("product") String product, @Param("isPay") Integer isPay);

    int deleteByPrimaryKey(Integer id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
}