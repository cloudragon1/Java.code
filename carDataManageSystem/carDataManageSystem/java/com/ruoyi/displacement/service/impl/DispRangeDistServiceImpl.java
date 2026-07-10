package com.ruoyi.displacement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.displacement.mapper.DispRangeDistMapper;
import com.ruoyi.displacement.domain.DispRangeDist;
import com.ruoyi.displacement.service.IDispRangeDistService;

/**
 * 排量区间分布统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class DispRangeDistServiceImpl implements IDispRangeDistService 
{
    @Autowired
    private DispRangeDistMapper dispRangeDistMapper;

    /**
     * 查询排量区间分布统计
     * 
     * @param id 排量区间分布统计主键
     * @return 排量区间分布统计
     */
    @Override
    public DispRangeDist selectDispRangeDistById(Long id)
    {
        return dispRangeDistMapper.selectDispRangeDistById(id);
    }

    /**
     * 查询排量区间分布统计列表
     * 
     * @param dispRangeDist 排量区间分布统计
     * @return 排量区间分布统计
     */
    @Override
    public List<DispRangeDist> selectDispRangeDistList(DispRangeDist dispRangeDist)
    {
        return dispRangeDistMapper.selectDispRangeDistList(dispRangeDist);
    }

    /**
     * 新增排量区间分布统计
     * 
     * @param dispRangeDist 排量区间分布统计
     * @return 结果
     */
    @Override
    public int insertDispRangeDist(DispRangeDist dispRangeDist)
    {
        return dispRangeDistMapper.insertDispRangeDist(dispRangeDist);
    }

    /**
     * 修改排量区间分布统计
     * 
     * @param dispRangeDist 排量区间分布统计
     * @return 结果
     */
    @Override
    public int updateDispRangeDist(DispRangeDist dispRangeDist)
    {
        return dispRangeDistMapper.updateDispRangeDist(dispRangeDist);
    }

    /**
     * 批量删除排量区间分布统计
     * 
     * @param ids 需要删除的排量区间分布统计主键
     * @return 结果
     */
    @Override
    public int deleteDispRangeDistByIds(Long[] ids)
    {
        return dispRangeDistMapper.deleteDispRangeDistByIds(ids);
    }

    /**
     * 删除排量区间分布统计信息
     * 
     * @param id 排量区间分布统计主键
     * @return 结果
     */
    @Override
    public int deleteDispRangeDistById(Long id)
    {
        return dispRangeDistMapper.deleteDispRangeDistById(id);
    }
}
