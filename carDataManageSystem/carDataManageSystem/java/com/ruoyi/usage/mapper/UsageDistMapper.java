package com.ruoyi.usage.mapper;

import java.util.List;
import com.ruoyi.usage.domain.UsageDist;

/**
 * 车辆用途分布统计Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface UsageDistMapper 
{
    /**
     * 查询车辆用途分布统计
     * 
     * @param id 车辆用途分布统计主键
     * @return 车辆用途分布统计
     */
    public UsageDist selectUsageDistById(Long id);

    /**
     * 查询车辆用途分布统计列表
     * 
     * @param usageDist 车辆用途分布统计
     * @return 车辆用途分布统计集合
     */
    public List<UsageDist> selectUsageDistList(UsageDist usageDist);

    /**
     * 新增车辆用途分布统计
     * 
     * @param usageDist 车辆用途分布统计
     * @return 结果
     */
    public int insertUsageDist(UsageDist usageDist);

    /**
     * 修改车辆用途分布统计
     * 
     * @param usageDist 车辆用途分布统计
     * @return 结果
     */
    public int updateUsageDist(UsageDist usageDist);

    /**
     * 删除车辆用途分布统计
     * 
     * @param id 车辆用途分布统计主键
     * @return 结果
     */
    public int deleteUsageDistById(Long id);

    /**
     * 批量删除车辆用途分布统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUsageDistByIds(Long[] ids);
}
