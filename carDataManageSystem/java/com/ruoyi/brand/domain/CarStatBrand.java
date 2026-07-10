package com.ruoyi.brand.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 品牌销量统计对象 car_stat_brand
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public class CarStatBrand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 品牌（公司名称） */
    @Excel(name = "品牌", readConverterExp = "公=司名称")
    private String company;

    /** 总销量 */
    @Excel(name = "总销量")
    private Long sales;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }

    public void setSales(Long sales) 
    {
        this.sales = sales;
    }

    public Long getSales() 
    {
        return sales;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("company", getCompany())
            .append("sales", getSales())
            .toString();
    }
}
