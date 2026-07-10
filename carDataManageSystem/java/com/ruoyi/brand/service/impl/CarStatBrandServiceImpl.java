package com.ruoyi.brand.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.brand.mapper.CarStatBrandMapper;
import com.ruoyi.brand.domain.CarStatBrand;
import com.ruoyi.brand.service.ICarStatBrandService;

/**
 * 品牌销量统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class CarStatBrandServiceImpl implements ICarStatBrandService 
{
    @Autowired
    private CarStatBrandMapper carStatBrandMapper;

    /**
     * 查询品牌销量统计
     * 
     * @param id 品牌销量统计主键
     * @return 品牌销量统计
     */
    @Override
    public CarStatBrand selectCarStatBrandById(Long id)
    {
        return carStatBrandMapper.selectCarStatBrandById(id);
    }

    /**
     * 查询品牌销量统计列表
     * 
     * @param carStatBrand 品牌销量统计
     * @return 品牌销量统计
     */
    @Override
    public List<CarStatBrand> selectCarStatBrandList(CarStatBrand carStatBrand)
    {
        return carStatBrandMapper.selectCarStatBrandList(carStatBrand);
    }

    /**
     * 新增品牌销量统计
     * 
     * @param carStatBrand 品牌销量统计
     * @return 结果
     */
    @Override
    public int insertCarStatBrand(CarStatBrand carStatBrand)
    {
        return carStatBrandMapper.insertCarStatBrand(carStatBrand);
    }

    /**
     * 修改品牌销量统计
     * 
     * @param carStatBrand 品牌销量统计
     * @return 结果
     */
    @Override
    public int updateCarStatBrand(CarStatBrand carStatBrand)
    {
        return carStatBrandMapper.updateCarStatBrand(carStatBrand);
    }

    /**
     * 批量删除品牌销量统计
     * 
     * @param ids 需要删除的品牌销量统计主键
     * @return 结果
     */
    @Override
    public int deleteCarStatBrandByIds(Long[] ids)
    {
        return carStatBrandMapper.deleteCarStatBrandByIds(ids);
    }

    /**
     * 删除品牌销量统计信息
     * 
     * @param id 品牌销量统计主键
     * @return 结果
     */
    @Override
    public int deleteCarStatBrandById(Long id)
    {
        return carStatBrandMapper.deleteCarStatBrandById(id);
    }
}
