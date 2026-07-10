package com.ruoyi.topone.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.topone.mapper.CarStatBrandTop1Mapper;
import com.ruoyi.topone.domain.CarStatBrandTop1;
import com.ruoyi.topone.service.ICarStatBrandTop1Service;

/**
 * 品牌销量TOP1Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class CarStatBrandTop1ServiceImpl implements ICarStatBrandTop1Service 
{
    @Autowired
    private CarStatBrandTop1Mapper carStatBrandTop1Mapper;

    /**
     * 查询品牌销量TOP1
     * 
     * @param id 品牌销量TOP1主键
     * @return 品牌销量TOP1
     */
    @Override
    public CarStatBrandTop1 selectCarStatBrandTop1ById(Long id)
    {
        return carStatBrandTop1Mapper.selectCarStatBrandTop1ById(id);
    }

    /**
     * 查询品牌销量TOP1列表
     * 
     * @param carStatBrandTop1 品牌销量TOP1
     * @return 品牌销量TOP1
     */
    @Override
    public List<CarStatBrandTop1> selectCarStatBrandTop1List(CarStatBrandTop1 carStatBrandTop1)
    {
        return carStatBrandTop1Mapper.selectCarStatBrandTop1List(carStatBrandTop1);
    }

    /**
     * 新增品牌销量TOP1
     * 
     * @param carStatBrandTop1 品牌销量TOP1
     * @return 结果
     */
    @Override
    public int insertCarStatBrandTop1(CarStatBrandTop1 carStatBrandTop1)
    {
        return carStatBrandTop1Mapper.insertCarStatBrandTop1(carStatBrandTop1);
    }

    /**
     * 修改品牌销量TOP1
     * 
     * @param carStatBrandTop1 品牌销量TOP1
     * @return 结果
     */
    @Override
    public int updateCarStatBrandTop1(CarStatBrandTop1 carStatBrandTop1)
    {
        return carStatBrandTop1Mapper.updateCarStatBrandTop1(carStatBrandTop1);
    }

    /**
     * 批量删除品牌销量TOP1
     * 
     * @param ids 需要删除的品牌销量TOP1主键
     * @return 结果
     */
    @Override
    public int deleteCarStatBrandTop1ByIds(Long[] ids)
    {
        return carStatBrandTop1Mapper.deleteCarStatBrandTop1ByIds(ids);
    }

    /**
     * 删除品牌销量TOP1信息
     * 
     * @param id 品牌销量TOP1主键
     * @return 结果
     */
    @Override
    public int deleteCarStatBrandTop1ById(Long id)
    {
        return carStatBrandTop1Mapper.deleteCarStatBrandTop1ById(id);
    }
}
