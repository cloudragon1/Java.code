package com.ruoyi.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.data.mapper.CarCleanedMapper;
import com.ruoyi.data.domain.CarCleaned;
import com.ruoyi.data.service.ICarCleanedService;

/**
 * 乘用车销售清洗后数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-10
 */
@Service
public class CarCleanedServiceImpl implements ICarCleanedService 
{
    @Autowired
    private CarCleanedMapper carCleanedMapper;

    /**
     * 查询乘用车销售清洗后数据
     * 
     * @param id 乘用车销售清洗后数据主键
     * @return 乘用车销售清洗后数据
     */
    @Override
    public CarCleaned selectCarCleanedById(Long id)
    {
        return carCleanedMapper.selectCarCleanedById(id);
    }

    /**
     * 查询乘用车销售清洗后数据列表
     * 
     * @param carCleaned 乘用车销售清洗后数据
     * @return 乘用车销售清洗后数据
     */
    @Override
    public List<CarCleaned> selectCarCleanedList(CarCleaned carCleaned)
    {
        return carCleanedMapper.selectCarCleanedList(carCleaned);
    }

    /**
     * 新增乘用车销售清洗后数据
     * 
     * @param carCleaned 乘用车销售清洗后数据
     * @return 结果
     */
    @Override
    public int insertCarCleaned(CarCleaned carCleaned)
    {
        return carCleanedMapper.insertCarCleaned(carCleaned);
    }

    /**
     * 修改乘用车销售清洗后数据
     * 
     * @param carCleaned 乘用车销售清洗后数据
     * @return 结果
     */
    @Override
    public int updateCarCleaned(CarCleaned carCleaned)
    {
        return carCleanedMapper.updateCarCleaned(carCleaned);
    }

    /**
     * 批量删除乘用车销售清洗后数据
     * 
     * @param ids 需要删除的乘用车销售清洗后数据主键
     * @return 结果
     */
    @Override
    public int deleteCarCleanedByIds(Long[] ids)
    {
        return carCleanedMapper.deleteCarCleanedByIds(ids);
    }

    /**
     * 删除乘用车销售清洗后数据信息
     * 
     * @param id 乘用车销售清洗后数据主键
     * @return 结果
     */
    @Override
    public int deleteCarCleanedById(Long id)
    {
        return carCleanedMapper.deleteCarCleanedById(id);
    }
}
