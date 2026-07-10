package com.ruoyi.gender.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.gender.mapper.GenderRatioMapper;
import com.ruoyi.gender.domain.GenderRatio;
import com.ruoyi.gender.service.IGenderRatioService;

/**
 * 性别比例统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class GenderRatioServiceImpl implements IGenderRatioService 
{
    @Autowired
    private GenderRatioMapper genderRatioMapper;

    /**
     * 查询性别比例统计
     * 
     * @param id 性别比例统计主键
     * @return 性别比例统计
     */
    @Override
    public GenderRatio selectGenderRatioById(Long id)
    {
        return genderRatioMapper.selectGenderRatioById(id);
    }

    /**
     * 查询性别比例统计列表
     * 
     * @param genderRatio 性别比例统计
     * @return 性别比例统计
     */
    @Override
    public List<GenderRatio> selectGenderRatioList(GenderRatio genderRatio)
    {
        return genderRatioMapper.selectGenderRatioList(genderRatio);
    }

    /**
     * 新增性别比例统计
     * 
     * @param genderRatio 性别比例统计
     * @return 结果
     */
    @Override
    public int insertGenderRatio(GenderRatio genderRatio)
    {
        return genderRatioMapper.insertGenderRatio(genderRatio);
    }

    /**
     * 修改性别比例统计
     * 
     * @param genderRatio 性别比例统计
     * @return 结果
     */
    @Override
    public int updateGenderRatio(GenderRatio genderRatio)
    {
        return genderRatioMapper.updateGenderRatio(genderRatio);
    }

    /**
     * 批量删除性别比例统计
     * 
     * @param ids 需要删除的性别比例统计主键
     * @return 结果
     */
    @Override
    public int deleteGenderRatioByIds(Long[] ids)
    {
        return genderRatioMapper.deleteGenderRatioByIds(ids);
    }

    /**
     * 删除性别比例统计信息
     * 
     * @param id 性别比例统计主键
     * @return 结果
     */
    @Override
    public int deleteGenderRatioById(Long id)
    {
        return genderRatioMapper.deleteGenderRatioById(id);
    }
}
