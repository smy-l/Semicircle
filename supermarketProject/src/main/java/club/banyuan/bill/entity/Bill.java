package club.banyuan.bill.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * t_bill
 * @author 
 */
public class Bill implements Serializable {
    private Integer id;

    private Integer isPay;

    private String isPayStr;

    private Double money;

    private String product;

    private Integer providerId;

    private String providerName;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public String getIsPayStr() {
        return isPayStr;
    }

    public void setIsPayStr(String isPayStr) {
        this.isPayStr = isPayStr;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", isPay=" + isPay +
                ", isPayStr='" + isPayStr + '\'' +
                ", money=" + money +
                ", product='" + product + '\'' +
                ", providerId=" + providerId +
                ", providerName='" + providerName + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}