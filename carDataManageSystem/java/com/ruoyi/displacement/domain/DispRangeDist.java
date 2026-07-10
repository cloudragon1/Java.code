package com.ruoyi.displacement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 排量区间分布统计对象 disp_range_dist
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public class DispRangeDist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 排量区间 */
    @Excel(name = "排量区间")
    private String displacement;

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

    public void setDisplacement(String displacement) 
    {
        this.displacement = displacement;
    }

    public String getDisplacement() 
    {
        return displacement;
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
            .append("displacement", getDisplacement())
            .append("sales", getSales())
            .toString();
    }
}
