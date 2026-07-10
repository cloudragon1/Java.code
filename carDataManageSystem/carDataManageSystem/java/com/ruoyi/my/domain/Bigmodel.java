package com.ruoyi.my.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * bigmodel对象 bigmodel
 * 
 * @author ruoyi
 * @date 2026-06-04
 */
public class Bigmodel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 大模型的名称 */
    @Excel(name = "大模型的名称")
    private String mname;

    /** $column.columnComment */
    @Excel(name = "id", readConverterExp = "$column.readConverterExp()")
    private String mversion;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setMname(String mname) 
    {
        this.mname = mname;
    }

    public String getMname() 
    {
        return mname;
    }

    public void setMversion(String mversion) 
    {
        this.mversion = mversion;
    }

    public String getMversion() 
    {
        return mversion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mname", getMname())
            .append("mversion", getMversion())
            .append("remark", getRemark())
            .toString();
    }
}
