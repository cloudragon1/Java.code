package com.ruoyi.top10.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.top10.mapper.CarBrandTop10Mapper;
import com.ruoyi.top10.domain.CarBrandTop10;
import com.ruoyi.top10.service.ICarBrandTop10Service;

/**
 * 品牌销量Top10Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class CarBrandTop10ServiceImpl implements ICarBrandTop10Service 
{
    @Autowired
    private CarBrandTop10Mapper carBrandTop10Mapper;

    /**
     * 查询品牌销量Top10
     * 
     * @param company 品牌销量Top10主键
     * @return 品牌销量Top10
     */
    @Override
    public CarBrandTop10 selectCarBrandTop10ByCompany(String company)
    {
        return carBrandTop10Mapper.selectCarBrandTop10ByCompany(company);
    }

    /**
     * 查询品牌销量Top10列表
     * 
     * @param carBrandTop10 品牌销量Top10
     * @return 品牌销量Top10
     */
    @Override
    public List<CarBrandTop10> selectCarBrandTop10List(CarBrandTop10 carBrandTop10)
    {
        return carBrandTop10Mapper.selectCarBrandTop10List(carBrandTop10);
    }

    /**
     * 新增品牌销量Top10
     * 
     * @param carBrandTop10 品牌销量Top10
     * @return 结果
     */
    @Override
    public int insertCarBrandTop10(CarBrandTop10 carBrandTop10)
    {
        return carBrandTop10Mapper.insertCarBrandTop10(carBrandTop10);
    }

    /**
     * 修改品牌销量Top10
     * 
     * @param carBrandTop10 品牌销量Top10
     * @return 结果
     */
    @Override
    public int updateCarBrandTop10(CarBrandTop10 carBrandTop10)
    {
        return carBrandTop10Mapper.updateCarBrandTop10(carBrandTop10);
    }

    /**
     * 批量删除品牌销量Top10
     * 
     * @param companys 需要删除的品牌销量Top10主键
     * @return 结果
     */
    @Override
    public int deleteCarBrandTop10ByCompanys(String[] companys)
    {
        return carBrandTop10Mapper.deleteCarBrandTop10ByCompanys(companys);
    }

    /**
     * 删除品牌销量Top10信息
     * 
     * @param company 品牌销量Top10主键
     * @return 结果
     */
    @Override
    public int deleteCarBrandTop10ByCompany(String company)
    {
        return carBrandTop10Mapper.deleteCarBrandTop10ByCompany(company);
    }
}
