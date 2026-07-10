package com.ruoyi.totalsale.mapper;

import java.util.List;
import com.ruoyi.totalsale.domain.CarStatTotal;

/**
 * 总销量统计Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface CarStatTotalMapper 
{
    /**
     * 查询总销量统计
     * 
     * @param id 总销量统计主键
     * @return 总销量统计
     */
    public CarStatTotal selectCarStatTotalById(Long id);

    /**
     * 查询总销量统计列表
     * 
     * @param carStatTotal 总销量统计
     * @return 总销量统计集合
     */
    public List<CarStatTotal> selectCarStatTotalList(CarStatTotal carStatTotal);

    /**
     * 新增总销量统计
     * 
     * @param carStatTotal 总销量统计
     * @return 结果
     */
    public int insertCarStatTotal(CarStatTotal carStatTotal);

    /**
     * 修改总销量统计
     * 
     * @param carStatTotal 总销量统计
     * @return 结果
     */
    public int updateCarStatTotal(CarStatTotal carStatTotal);

    /**
     * 删除总销量统计
     * 
     * @param id 总销量统计主键
     * @return 结果
     */
    public int deleteCarStatTotalById(Long id);

    /**
     * 批量删除总销量统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarStatTotalByIds(Long[] ids);
}
