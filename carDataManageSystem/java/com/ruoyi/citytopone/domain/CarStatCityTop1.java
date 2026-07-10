package com.ruoyi.citytopone.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 城市销量TOP1对象 car_stat_city_top1
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public class CarStatCityTop1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 销量第一城市 */
    @Excel(name = "销量第一城市")
    private String city;

    /** 冠军城市销量 */
    @Excel(name = "冠军城市销量")
    private Long sales;

    /** 占全部总销量百分比 */
    @Excel(name = "占全部总销量百分比")
    private BigDecimal rate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
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
            .append("city", getCity())
            .append("sales", getSales())
            .append("rate", getRate())
            .toString();
    }
}
