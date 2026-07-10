package com.ruoyi.gender.mapper;

import java.util.List;
import com.ruoyi.gender.domain.GenderRatio;

/**
 * 性别比例统计Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface GenderRatioMapper 
{
    /**
     * 查询性别比例统计
     * 
     * @param id 性别比例统计主键
     * @return 性别比例统计
     */
    public GenderRatio selectGenderRatioById(Long id);

    /**
     * 查询性别比例统计列表
     * 
     * @param genderRatio 性别比例统计
     * @return 性别比例统计集合
     */
    public List<GenderRatio> selectGenderRatioList(GenderRatio genderRatio);

    /**
     * 新增性别比例统计
     * 
     * @param genderRatio 性别比例统计
     * @return 结果
     */
    public int insertGenderRatio(GenderRatio genderRatio);

    /**
     * 修改性别比例统计
     * 
     * @param genderRatio 性别比例统计
     * @return 结果
     */
    public int updateGenderRatio(GenderRatio genderRatio);

    /**
     * 删除性别比例统计
     * 
     * @param id 性别比例统计主键
     * @return 结果
     */
    public int deleteGenderRatioById(Long id);

    /**
     * 批量删除性别比例统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGenderRatioByIds(Long[] ids);
}
