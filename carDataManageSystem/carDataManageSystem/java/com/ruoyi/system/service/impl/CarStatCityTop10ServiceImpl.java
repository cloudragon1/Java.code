package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CarStatCityTop10Mapper;
import com.ruoyi.system.domain.CarStatCityTop10;
import com.ruoyi.system.service.ICarStatCityTop10Service;

/**
 * 城市销量TOP10排名Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class CarStatCityTop10ServiceImpl implements ICarStatCityTop10Service 
{
    @Autowired
    private CarStatCityTop10Mapper carStatCityTop10Mapper;

    /**
     * 查询城市销量TOP10排名
     * 
     * @param id 城市销量TOP10排名主键
     * @return 城市销量TOP10排名
     */
    @Override
    public CarStatCityTop10 selectCarStatCityTop10ById(Long id)
    {
        return carStatCityTop10Mapper.selectCarStatCityTop10ById(id);
    }

    /**
     * 查询城市销量TOP10排名列表
     * 
     * @param carStatCityTop10 城市销量TOP10排名
     * @return 城市销量TOP10排名
     */
    @Override
    public List<CarStatCityTop10> selectCarStatCityTop10List(CarStatCityTop10 carStatCityTop10)
    {
        return carStatCityTop10Mapper.selectCarStatCityTop10List(carStatCityTop10);
    }

    /**
     * 新增城市销量TOP10排名
     * 
     * @param carStatCityTop10 城市销量TOP10排名
     * @return 结果
     */
    @Override
    public int insertCarStatCityTop10(CarStatCityTop10 carStatCityTop10)
    {
        return carStatCityTop10Mapper.insertCarStatCityTop10(carStatCityTop10);
    }

    /**
     * 修改城市销量TOP10排名
     * 
     * @param carStatCityTop10 城市销量TOP10排名
     * @return 结果
     */
    @Override
    public int updateCarStatCityTop10(CarStatCityTop10 carStatCityTop10)
    {
        return carStatCityTop10Mapper.updateCarStatCityTop10(carStatCityTop10);
    }

    /**
     * 批量删除城市销量TOP10排名
     * 
     * @param ids 需要删除的城市销量TOP10排名主键
     * @return 结果
     */
    @Override
    public int deleteCarStatCityTop10ByIds(Long[] ids)
    {
        return carStatCityTop10Mapper.deleteCarStatCityTop10ByIds(ids);
    }

    /**
     * 删除城市销量TOP10排名信息
     * 
     * @param id 城市销量TOP10排名主键
     * @return 结果
     */
    @Override
    public int deleteCarStatCityTop10ById(Long id)
    {
        return carStatCityTop10Mapper.deleteCarStatCityTop10ById(id);
    }
}
