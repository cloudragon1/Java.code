package com.ruoyi.brand.mapper;

import java.util.List;
import com.ruoyi.brand.domain.CarStatBrand;

/**
 * 品牌销量统计Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface CarStatBrandMapper 
{
    /**
     * 查询品牌销量统计
     * 
     * @param id 品牌销量统计主键
     * @return 品牌销量统计
     */
    public CarStatBrand selectCarStatBrandById(Long id);

    /**
     * 查询品牌销量统计列表
     * 
     * @param carStatBrand 品牌销量统计
     * @return 品牌销量统计集合
     */
    public List<CarStatBrand> selectCarStatBrandList(CarStatBrand carStatBrand);

    /**
     * 新增品牌销量统计
     * 
     * @param carStatBrand 品牌销量统计
     * @return 结果
     */
    public int insertCarStatBrand(CarStatBrand carStatBrand);

    /**
     * 修改品牌销量统计
     * 
     * @param carStatBrand 品牌销量统计
     * @return 结果
     */
    public int updateCarStatBrand(CarStatBrand carStatBrand);

    /**
     * 删除品牌销量统计
     * 
     * @param id 品牌销量统计主键
     * @return 结果
     */
    public int deleteCarStatBrandById(Long id);

    /**
     * 批量删除品牌销量统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarStatBrandByIds(Long[] ids);
}
