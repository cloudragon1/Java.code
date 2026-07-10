package com.ruoyi.displacement.mapper;

import java.util.List;
import com.ruoyi.displacement.domain.DispRangeDist;

/**
 * 排量区间分布统计Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface DispRangeDistMapper 
{
    /**
     * 查询排量区间分布统计
     * 
     * @param id 排量区间分布统计主键
     * @return 排量区间分布统计
     */
    public DispRangeDist selectDispRangeDistById(Long id);

    /**
     * 查询排量区间分布统计列表
     * 
     * @param dispRangeDist 排量区间分布统计
     * @return 排量区间分布统计集合
     */
    public List<DispRangeDist> selectDispRangeDistList(DispRangeDist dispRangeDist);

    /**
     * 新增排量区间分布统计
     * 
     * @param dispRangeDist 排量区间分布统计
     * @return 结果
     */
    public int insertDispRangeDist(DispRangeDist dispRangeDist);

    /**
     * 修改排量区间分布统计
     * 
     * @param dispRangeDist 排量区间分布统计
     * @return 结果
     */
    public int updateDispRangeDist(DispRangeDist dispRangeDist);

    /**
     * 删除排量区间分布统计
     * 
     * @param id 排量区间分布统计主键
     * @return 结果
     */
    public int deleteDispRangeDistById(Long id);

    /**
     * 批量删除排量区间分布统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDispRangeDistByIds(Long[] ids);
}
