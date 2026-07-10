package com.ruoyi.data.mapper;

import java.util.List;
import com.ruoyi.data.domain.CarCleaned;

/**
 * 乘用车销售清洗后数据Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-10
 */
public interface CarCleanedMapper 
{
    /**
     * 查询乘用车销售清洗后数据
     * 
     * @param id 乘用车销售清洗后数据主键
     * @return 乘用车销售清洗后数据
     */
    public CarCleaned selectCarCleanedById(Long id);

    /**
     * 查询乘用车销售清洗后数据列表
     * 
     * @param carCleaned 乘用车销售清洗后数据
     * @return 乘用车销售清洗后数据集合
     */
    public List<CarCleaned> selectCarCleanedList(CarCleaned carCleaned);

    /**
     * 新增乘用车销售清洗后数据
     * 
     * @param carCleaned 乘用车销售清洗后数据
     * @return 结果
     */
    public int insertCarCleaned(CarCleaned carCleaned);

    /**
     * 修改乘用车销售清洗后数据
     * 
     * @param carCleaned 乘用车销售清洗后数据
     * @return 结果
     */
    public int updateCarCleaned(CarCleaned carCleaned);

    /**
     * 删除乘用车销售清洗后数据
     * 
     * @param id 乘用车销售清洗后数据主键
     * @return 结果
     */
    public int deleteCarCleanedById(Long id);

    /**
     * 批量删除乘用车销售清洗后数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarCleanedByIds(Long[] ids);
}
