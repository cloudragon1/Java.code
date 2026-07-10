package com.ruoyi.car_type.mapper;

import java.util.List;
import com.ruoyi.car_type.domain.CarTypeDist;

/**
 * 车型分布统计Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface CarTypeDistMapper 
{
    /**
     * 查询车型分布统计
     * 
     * @param id 车型分布统计主键
     * @return 车型分布统计
     */
    public CarTypeDist selectCarTypeDistById(Long id);

    /**
     * 查询车型分布统计列表
     * 
     * @param carTypeDist 车型分布统计
     * @return 车型分布统计集合
     */
    public List<CarTypeDist> selectCarTypeDistList(CarTypeDist carTypeDist);

    /**
     * 新增车型分布统计
     * 
     * @param carTypeDist 车型分布统计
     * @return 结果
     */
    public int insertCarTypeDist(CarTypeDist carTypeDist);

    /**
     * 修改车型分布统计
     * 
     * @param carTypeDist 车型分布统计
     * @return 结果
     */
    public int updateCarTypeDist(CarTypeDist carTypeDist);

    /**
     * 删除车型分布统计
     * 
     * @param id 车型分布统计主键
     * @return 结果
     */
    public int deleteCarTypeDistById(Long id);

    /**
     * 批量删除车型分布统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarTypeDistByIds(Long[] ids);
}
