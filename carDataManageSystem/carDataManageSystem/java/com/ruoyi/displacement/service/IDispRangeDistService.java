package com.ruoyi.displacement.service;

import java.util.List;
import com.ruoyi.displacement.domain.DispRangeDist;

/**
 * 排量区间分布统计Service接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface IDispRangeDistService 
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
     * 批量删除排量区间分布统计
     * 
     * @param ids 需要删除的排量区间分布统计主键集合
     * @return 结果
     */
    public int deleteDispRangeDistByIds(Long[] ids);

    /**
     * 删除排量区间分布统计信息
     * 
     * @param id 排量区间分布统计主键
     * @return 结果
     */
    public int deleteDispRangeDistById(Long id);
}
