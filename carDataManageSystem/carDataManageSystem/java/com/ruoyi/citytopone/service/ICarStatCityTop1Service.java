package com.ruoyi.citytopone.service;

import java.util.List;
import com.ruoyi.citytopone.domain.CarStatCityTop1;

/**
 * 城市销量TOP1Service接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface ICarStatCityTop1Service 
{
    /**
     * 查询城市销量TOP1
     * 
     * @param id 城市销量TOP1主键
     * @return 城市销量TOP1
     */
    public CarStatCityTop1 selectCarStatCityTop1ById(Long id);

    /**
     * 查询城市销量TOP1列表
     * 
     * @param carStatCityTop1 城市销量TOP1
     * @return 城市销量TOP1集合
     */
    public List<CarStatCityTop1> selectCarStatCityTop1List(CarStatCityTop1 carStatCityTop1);

    /**
     * 新增城市销量TOP1
     * 
     * @param carStatCityTop1 城市销量TOP1
     * @return 结果
     */
    public int insertCarStatCityTop1(CarStatCityTop1 carStatCityTop1);

    /**
     * 修改城市销量TOP1
     * 
     * @param carStatCityTop1 城市销量TOP1
     * @return 结果
     */
    public int updateCarStatCityTop1(CarStatCityTop1 carStatCityTop1);

    /**
     * 批量删除城市销量TOP1
     * 
     * @param ids 需要删除的城市销量TOP1主键集合
     * @return 结果
     */
    public int deleteCarStatCityTop1ByIds(Long[] ids);

    /**
     * 删除城市销量TOP1信息
     * 
     * @param id 城市销量TOP1主键
     * @return 结果
     */
    public int deleteCarStatCityTop1ById(Long id);
}
