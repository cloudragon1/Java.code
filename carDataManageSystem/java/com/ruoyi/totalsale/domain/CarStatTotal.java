package com.ruoyi.totalsale.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 总销量统计对象 car_stat_total
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public class CarStatTotal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 平台全部车辆总销量 */
    @Excel(name = "平台全部车辆总销量")
    private Long totalSales;

    /** 统计时间区间，如2013-2014 */
    @Excel(name = "统计时间区间，如2013-2014")
    private String yearRange;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTotalSales(Long totalSales) 
    {
        this.totalSales = totalSales;
    }

    public Long getTotalSales() 
    {
        return totalSales;
    }

    public void setYearRange(String yearRange) 
    {
        this.yearRange = yearRange;
    }

    public String getYearRange() 
    {
        return yearRange;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("totalSales", getTotalSales())
            .append("yearRange", getYearRange())
            .toString();
    }
}
