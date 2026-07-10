package com.ruoyi.city.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.city.mapper.CarStatCityMapper;
import com.ruoyi.city.domain.CarStatCity;
import com.ruoyi.city.service.ICarStatCityService;

/**
 * 城市统计分析Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class CarStatCityServiceImpl implements ICarStatCityService 
{
    @Autowired
    private CarStatCityMapper carStatCityMapper;

    /**
     * 查询城市统计分析
     * 
     * @param id 城市统计分析主键
     * @return 城市统计分析
     */
    @Override
    public CarStatCity selectCarStatCityById(Long id)
    {
        return carStatCityMapper.selectCarStatCityById(id);
    }

    /**
     * 查询城市统计分析列表
     * 
     * @param carStatCity 城市统计分析
     * @return 城市统计分析
     */
    @Override
    public List<CarStatCity> selectCarStatCityList(CarStatCity carStatCity)
    {
        return carStatCityMapper.selectCarStatCityList(carStatCity);
    }

    /**
     * 新增城市统计分析
     * 
     * @param carStatCity 城市统计分析
     * @return 结果
     */
    @Override
    public int insertCarStatCity(CarStatCity carStatCity)
    {
        return carStatCityMapper.insertCarStatCity(carStatCity);
    }

    /**
     * 修改城市统计分析
     * 
     * @param carStatCity 城市统计分析
     * @return 结果
     */
    @Override
    public int updateCarStatCity(CarStatCity carStatCity)
    {
        return carStatCityMapper.updateCarStatCity(carStatCity);
    }

    /**
     * 批量删除城市统计分析
     * 
     * @param ids 需要删除的城市统计分析主键
     * @return 结果
     */
    @Override
    public int deleteCarStatCityByIds(Long[] ids)
    {
        return carStatCityMapper.deleteCarStatCityByIds(ids);
    }

    /**
     * 删除城市统计分析信息
     * 
     * @param id 城市统计分析主键
     * @return 结果
     */
    @Override
    public int deleteCarStatCityById(Long id)
    {
        return carStatCityMapper.deleteCarStatCityById(id);
    }
}
