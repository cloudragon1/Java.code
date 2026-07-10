package com.ruoyi.topone.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 品牌销量TOP1对象 car_stat_brand_top1
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public class CarStatBrandTop1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 销量第一品牌 */
    @Excel(name = "销量第一品牌")
    private String brand;

    /** 冠军品牌销量 */
    @Excel(name = "冠军品牌销量")
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

    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
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
            .append("brand", getBrand())
            .append("sales", getSales())
            .append("rate", getRate())
            .toString();
    }
}
