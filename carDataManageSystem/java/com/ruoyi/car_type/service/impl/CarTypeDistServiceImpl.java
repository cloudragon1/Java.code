package com.ruoyi.car_type.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car_type.mapper.CarTypeDistMapper;
import com.ruoyi.car_type.domain.CarTypeDist;
import com.ruoyi.car_type.service.ICarTypeDistService;

/**
 * 车型分布统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class CarTypeDistServiceImpl implements ICarTypeDistService 
{
    @Autowired
    private CarTypeDistMapper carTypeDistMapper;

    /**
     * 查询车型分布统计
     * 
     * @param id 车型分布统计主键
     * @return 车型分布统计
     */
    @Override
    public CarTypeDist selectCarTypeDistById(Long id)
    {
        return carTypeDistMapper.selectCarTypeDistById(id);
    }

    /**
     * 查询车型分布统计列表
     * 
     * @param carTypeDist 车型分布统计
     * @return 车型分布统计
     */
    @Override
    public List<CarTypeDist> selectCarTypeDistList(CarTypeDist carTypeDist)
    {
        return carTypeDistMapper.selectCarTypeDistList(carTypeDist);
    }

    /**
     * 新增车型分布统计
     * 
     * @param carTypeDist 车型分布统计
     * @return 结果
     */
    @Override
    public int insertCarTypeDist(CarTypeDist carTypeDist)
    {
        return carTypeDistMapper.insertCarTypeDist(carTypeDist);
    }

    /**
     * 修改车型分布统计
     * 
     * @param carTypeDist 车型分布统计
     * @return 结果
     */
    @Override
    public int updateCarTypeDist(CarTypeDist carTypeDist)
    {
        return carTypeDistMapper.updateCarTypeDist(carTypeDist);
    }

    /**
     * 批量删除车型分布统计
     * 
     * @param ids 需要删除的车型分布统计主键
     * @return 结果
     */
    @Override
    public int deleteCarTypeDistByIds(Long[] ids)
    {
        return carTypeDistMapper.deleteCarTypeDistByIds(ids);
    }

    /**
     * 删除车型分布统计信息
     * 
     * @param id 车型分布统计主键
     * @return 结果
     */
    @Override
    public int deleteCarTypeDistById(Long id)
    {
        return carTypeDistMapper.deleteCarTypeDistById(id);
    }
}
