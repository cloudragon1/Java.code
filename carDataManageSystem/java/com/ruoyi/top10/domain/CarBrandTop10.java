package com.ruoyi.top10.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 品牌销量Top10对象 car_brand_top10
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public class CarBrandTop10 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 品牌 */
    @Excel(name = "品牌")
    private String company;

    /** 总销量 */
    @Excel(name = "总销量")
    private Long sales;

    /** 排名 */
    @Excel(name = "排名")
    private Long rankNum;

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

    public void setRankNum(Long rankNum) 
    {
        this.rankNum = rankNum;
    }

    public Long getRankNum() 
    {
        return rankNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("company", getCompany())
            .append("sales", getSales())
            .append("rankNum", getRankNum())
            .toString();
    }
}
