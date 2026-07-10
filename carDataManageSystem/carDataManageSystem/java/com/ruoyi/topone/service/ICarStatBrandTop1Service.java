package com.ruoyi.topone.service;

import java.util.List;
import com.ruoyi.topone.domain.CarStatBrandTop1;

/**
 * 品牌销量TOP1Service接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface ICarStatBrandTop1Service 
{
    /**
     * 查询品牌销量TOP1
     * 
     * @param id 品牌销量TOP1主键
     * @return 品牌销量TOP1
     */
    public CarStatBrandTop1 selectCarStatBrandTop1ById(Long id);

    /**
     * 查询品牌销量TOP1列表
     * 
     * @param carStatBrandTop1 品牌销量TOP1
     * @return 品牌销量TOP1集合
     */
    public List<CarStatBrandTop1> selectCarStatBrandTop1List(CarStatBrandTop1 carStatBrandTop1);

    /**
     * 新增品牌销量TOP1
     * 
     * @param carStatBrandTop1 品牌销量TOP1
     * @return 结果
     */
    public int insertCarStatBrandTop1(CarStatBrandTop1 carStatBrandTop1);

    /**
     * 修改品牌销量TOP1
     * 
     * @param carStatBrandTop1 品牌销量TOP1
     * @return 结果
     */
    public int updateCarStatBrandTop1(CarStatBrandTop1 carStatBrandTop1);

    /**
     * 批量删除品牌销量TOP1
     * 
     * @param ids 需要删除的品牌销量TOP1主键集合
     * @return 结果
     */
    public int deleteCarStatBrandTop1ByIds(Long[] ids);

    /**
     * 删除品牌销量TOP1信息
     * 
     * @param id 品牌销量TOP1主键
     * @return 结果
     */
    public int deleteCarStatBrandTop1ById(Long id);
}
