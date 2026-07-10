package com.ruoyi.data.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 乘用车销售清洗后数据对象 car_cleaned
 * 
 * @author ruoyi
 * @date 2026-06-10
 */
public class CarCleaned extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 车架号（VIN） */
    @Excel(name = "车架号", readConverterExp = "V=IN")
    private String vin;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 区县 */
    @Excel(name = "区县")
    private String county;

    /** 年份 */
    @Excel(name = "年份")
    private Long year;

    /** 月份 */
    @Excel(name = "月份")
    private Long month;

    /** 公司 */
    @Excel(name = "公司")
    private String company;

    /** 车系 */
    @Excel(name = "车系")
    private String carSeries;

    /** 车型 */
    @Excel(name = "车型")
    private String carType;

    /** 商用或个人 */
    @Excel(name = "商用或个人")
    private String useKind;

    /** 用途 */
    @Excel(name = "用途")
    private String useFor;

    /** 销量 */
    @Excel(name = "销量")
    private Long sales;

    /** 发动机型号 */
    @Excel(name = "发动机型号")
    private String engine;

    /** 排量(cc) */
    @Excel(name = "排量(cc)")
    private Long displacement;

    /** 发动机参数1 */
    @Excel(name = "发动机参数1")
    private String engineParam1;

    /** 燃油类型 */
    @Excel(name = "燃油类型")
    private String fuelType;

    /** 发动机参数3 */
    @Excel(name = "发动机参数3")
    private String engineParam3;

    /** 轮胎规格 */
    @Excel(name = "轮胎规格")
    private String tireSpec;

    /** 所属企业 */
    @Excel(name = "所属企业")
    private String ownerCompany;

    /** 车属分类 */
    @Excel(name = "车属分类")
    private String carClass;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setVin(String vin) 
    {
        this.vin = vin;
    }

    public String getVin() 
    {
        return vin;
    }

    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCounty(String county) 
    {
        this.county = county;
    }

    public String getCounty() 
    {
        return county;
    }

    public void setYear(Long year) 
    {
        this.year = year;
    }

    public Long getYear() 
    {
        return year;
    }

    public void setMonth(Long month) 
    {
        this.month = month;
    }

    public Long getMonth() 
    {
        return month;
    }

    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }

    public void setCarSeries(String carSeries) 
    {
        this.carSeries = carSeries;
    }

    public String getCarSeries() 
    {
        return carSeries;
    }

    public void setCarType(String carType) 
    {
        this.carType = carType;
    }

    public String getCarType() 
    {
        return carType;
    }

    public void setUseKind(String useKind) 
    {
        this.useKind = useKind;
    }

    public String getUseKind() 
    {
        return useKind;
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

    public void setEngine(String engine) 
    {
        this.engine = engine;
    }

    public String getEngine() 
    {
        return engine;
    }

    public void setDisplacement(Long displacement) 
    {
        this.displacement = displacement;
    }

    public Long getDisplacement() 
    {
        return displacement;
    }

    public void setEngineParam1(String engineParam1) 
    {
        this.engineParam1 = engineParam1;
    }

    public String getEngineParam1() 
    {
        return engineParam1;
    }

    public void setFuelType(String fuelType) 
    {
        this.fuelType = fuelType;
    }

    public String getFuelType() 
    {
        return fuelType;
    }

    public void setEngineParam3(String engineParam3) 
    {
        this.engineParam3 = engineParam3;
    }

    public String getEngineParam3() 
    {
        return engineParam3;
    }

    public void setTireSpec(String tireSpec) 
    {
        this.tireSpec = tireSpec;
    }

    public String getTireSpec() 
    {
        return tireSpec;
    }

    public void setOwnerCompany(String ownerCompany) 
    {
        this.ownerCompany = ownerCompany;
    }

    public String getOwnerCompany() 
    {
        return ownerCompany;
    }

    public void setCarClass(String carClass) 
    {
        this.carClass = carClass;
    }

    public String getCarClass() 
    {
        return carClass;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("vin", getVin())
            .append("province", getProvince())
            .append("city", getCity())
            .append("county", getCounty())
            .append("year", getYear())
            .append("month", getMonth())
            .append("company", getCompany())
            .append("carSeries", getCarSeries())
            .append("carType", getCarType())
            .append("useKind", getUseKind())
            .append("useFor", getUseFor())
            .append("sales", getSales())
            .append("engine", getEngine())
            .append("displacement", getDisplacement())
            .append("engineParam1", getEngineParam1())
            .append("fuelType", getFuelType())
            .append("engineParam3", getEngineParam3())
            .append("tireSpec", getTireSpec())
            .append("ownerCompany", getOwnerCompany())
            .append("carClass", getCarClass())
            .append("gender", getGender())
            .toString();
    }
}
