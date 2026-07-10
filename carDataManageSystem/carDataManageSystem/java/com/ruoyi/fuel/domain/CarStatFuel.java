package com.ruoyi.fuel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动力类型对象 car_stat_fuel
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public class CarStatFuel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 燃料类型 */
    @Excel(name = "燃料类型")
    private String fuelType;

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

    public void setFuelType(String fuelType) 
    {
        this.fuelType = fuelType;
    }

    public String getFuelType() 
    {
        return fuelType;
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
            .append("fuelType", getFuelType())
            .append("sales", getSales())
            .toString();
    }
}
