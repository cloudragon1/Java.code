package com.ruoyi.city.mapper;

import java.util.List;
import com.ruoyi.city.domain.CarStatCity;

/**
 * 城市统计分析Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface CarStatCityMapper 
{
    /**
     * 查询城市统计分析
     * 
     * @param id 城市统计分析主键
     * @return 城市统计分析
     */
    public CarStatCity selectCarStatCityById(Long id);

    /**
     * 查询城市统计分析列表
     * 
     * @param carStatCity 城市统计分析
     * @return 城市统计分析集合
     */
    public List<CarStatCity> selectCarStatCityList(CarStatCity carStatCity);

    /**
     * 新增城市统计分析
     * 
     * @param carStatCity 城市统计分析
     * @return 结果
     */
    public int insertCarStatCity(CarStatCity carStatCity);

    /**
     * 修改城市统计分析
     * 
     * @param carStatCity 城市统计分析
     * @return 结果
     */
    public int updateCarStatCity(CarStatCity carStatCity);

    /**
     * 删除城市统计分析
     * 
     * @param id 城市统计分析主键
     * @return 结果
     */
    public int deleteCarStatCityById(Long id);

    /**
     * 批量删除城市统计分析
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarStatCityByIds(Long[] ids);
}
