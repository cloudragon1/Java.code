package com.ruoyi.usage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆用途分布统计对象 usage_dist
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public class UsageDist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 车辆用途 */
    @Excel(name = "车辆用途")
    private String useFor;

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

    public void setUseFor(String useFor) 
    {
        this.useFor = useFor;
    }

    public String getUseFor() 
    {
        return useFor;
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
            .append("useFor", getUseFor())
            .append("sales", getSales())
            .toString();
    }
}
