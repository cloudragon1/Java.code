package com.ruoyi.citytopone.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.citytopone.mapper.CarStatCityTop1Mapper;
import com.ruoyi.citytopone.domain.CarStatCityTop1;
import com.ruoyi.citytopone.service.ICarStatCityTop1Service;

/**
 * 城市销量TOP1Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class CarStatCityTop1ServiceImpl implements ICarStatCityTop1Service 
{
    @Autowired
    private CarStatCityTop1Mapper carStatCityTop1Mapper;

    /**
     * 查询城市销量TOP1
     * 
     * @param id 城市销量TOP1主键
     * @return 城市销量TOP1
     */
    @Override
    public CarStatCityTop1 selectCarStatCityTop1ById(Long id)
    {
        return carStatCityTop1Mapper.selectCarStatCityTop1ById(id);
    }

    /**
     * 查询城市销量TOP1列表
     * 
     * @param carStatCityTop1 城市销量TOP1
     * @return 城市销量TOP1
     */
    @Override
    public List<CarStatCityTop1> selectCarStatCityTop1List(CarStatCityTop1 carStatCityTop1)
    {
        return carStatCityTop1Mapper.selectCarStatCityTop1List(carStatCityTop1);
    }

    /**
     * 新增城市销量TOP1
     * 
     * @param carStatCityTop1 城市销量TOP1
     * @return 结果
     */
    @Override
    public int insertCarStatCityTop1(CarStatCityTop1 carStatCityTop1)
    {
        return carStatCityTop1Mapper.insertCarStatCityTop1(carStatCityTop1);
    }

    /**
     * 修改城市销量TOP1
     * 
     * @param carStatCityTop1 城市销量TOP1
     * @return 结果
     */
    @Override
    public int updateCarStatCityTop1(CarStatCityTop1 carStatCityTop1)
    {
        return carStatCityTop1Mapper.updateCarStatCityTop1(carStatCityTop1);
    }

    /**
     * 批量删除城市销量TOP1
     * 
     * @param ids 需要删除的城市销量TOP1主键
     * @return 结果
     */
    @Override
    public int deleteCarStatCityTop1ByIds(Long[] ids)
    {
        return carStatCityTop1Mapper.deleteCarStatCityTop1ByIds(ids);
    }

    /**
     * 删除城市销量TOP1信息
     * 
     * @param id 城市销量TOP1主键
     * @return 结果
     */
    @Override
    public int deleteCarStatCityTop1ById(Long id)
    {
        return carStatCityTop1Mapper.deleteCarStatCityTop1ById(id);
    }
}
