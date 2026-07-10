package com.ruoyi.top10.mapper;

import java.util.List;
import com.ruoyi.top10.domain.CarBrandTop10;

/**
 * 品牌销量Top10Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface CarBrandTop10Mapper 
{
    /**
     * 查询品牌销量Top10
     * 
     * @param company 品牌销量Top10主键
     * @return 品牌销量Top10
     */
    public CarBrandTop10 selectCarBrandTop10ByCompany(String company);

    /**
     * 查询品牌销量Top10列表
     * 
     * @param carBrandTop10 品牌销量Top10
     * @return 品牌销量Top10集合
     */
    public List<CarBrandTop10> selectCarBrandTop10List(CarBrandTop10 carBrandTop10);

    /**
     * 新增品牌销量Top10
     * 
     * @param carBrandTop10 品牌销量Top10
     * @return 结果
     */
    public int insertCarBrandTop10(CarBrandTop10 carBrandTop10);

    /**
     * 修改品牌销量Top10
     * 
     * @param carBrandTop10 品牌销量Top10
     * @return 结果
     */
    public int updateCarBrandTop10(CarBrandTop10 carBrandTop10);

    /**
     * 删除品牌销量Top10
     * 
     * @param company 品牌销量Top10主键
     * @return 结果
     */
    public int deleteCarBrandTop10ByCompany(String company);

    /**
     * 批量删除品牌销量Top10
     * 
     * @param companys 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarBrandTop10ByCompanys(String[] companys);
}
