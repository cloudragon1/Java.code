package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 城市销量TOP10排名对象 car_stat_city_top10
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public class CarStatCityTop10 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 排名1~10 */
    @Excel(name = "排名1~10")
    private Long ranke;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 销量 */
    @Excel(name = "销量")
    private Long sales;

    /** 占TOP10总销量百分比 */
    @Excel(name = "占TOP10总销量百分比")
    private BigDecimal rate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setRanke(Long ranke) 
    {
        this.ranke = ranke;
    }

    public Long getRanke() 
    {
        return ranke;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }

    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }

    public void setSales(Long sales) 
    {
        this.sales = sales;
    }

    public Long getSales() 
    {
        return sales;
    }

    public void setRate(BigDecimal rate) 
    {
        this.rate = rate;
    }

    public BigDecimal getRate() 
    {
        return rate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ranke", getRanke())
            .append("city", getCity())
            .append("province", getProvince())
            .append("sales", getSales())
            .append("rate", getRate())
            .append("remark", getRemark())
            .toString();
    }
}
