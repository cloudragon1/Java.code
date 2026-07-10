package com.ruoyi.usage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.usage.mapper.UsageDistMapper;
import com.ruoyi.usage.domain.UsageDist;
import com.ruoyi.usage.service.IUsageDistService;

/**
 * 车辆用途分布统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class UsageDistServiceImpl implements IUsageDistService 
{
    @Autowired
    private UsageDistMapper usageDistMapper;

    /**
     * 查询车辆用途分布统计
     * 
     * @param id 车辆用途分布统计主键
     * @return 车辆用途分布统计
     */
    @Override
    public UsageDist selectUsageDistById(Long id)
    {
        return usageDistMapper.selectUsageDistById(id);
    }

    /**
     * 查询车辆用途分布统计列表
     * 
     * @param usageDist 车辆用途分布统计
     * @return 车辆用途分布统计
     */
    @Override
    public List<UsageDist> selectUsageDistList(UsageDist usageDist)
    {
        return usageDistMapper.selectUsageDistList(usageDist);
    }

    /**
     * 新增车辆用途分布统计
     * 
     * @param usageDist 车辆用途分布统计
     * @return 结果
     */
    @Override
    public int insertUsageDist(UsageDist usageDist)
    {
        return usageDistMapper.insertUsageDist(usageDist);
    }

    /**
     * 修改车辆用途分布统计
     * 
     * @param usageDist 车辆用途分布统计
     * @return 结果
     */
    @Override
    public int updateUsageDist(UsageDist usageDist)
    {
        return usageDistMapper.updateUsageDist(usageDist);
    }

    /**
     * 批量删除车辆用途分布统计
     * 
     * @param ids 需要删除的车辆用途分布统计主键
     * @return 结果
     */
    @Override
    public int deleteUsageDistByIds(Long[] ids)
    {
        return usageDistMapper.deleteUsageDistByIds(ids);
    }

    /**
     * 删除车辆用途分布统计信息
     * 
     * @param id 车辆用途分布统计主键
     * @return 结果
     */
    @Override
    public int deleteUsageDistById(Long id)
    {
        return usageDistMapper.deleteUsageDistById(id);
    }
}
