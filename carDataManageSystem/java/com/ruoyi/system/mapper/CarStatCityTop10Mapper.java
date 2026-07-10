package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CarStatCityTop10;

/**
 * 城市销量TOP10排名Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface CarStatCityTop10Mapper 
{
    /**
     * 查询城市销量TOP10排名
     * 
     * @param id 城市销量TOP10排名主键
     * @return 城市销量TOP10排名
     */
    public CarStatCityTop10 selectCarStatCityTop10ById(Long id);

    /**
     * 查询城市销量TOP10排名列表
     * 
     * @param carStatCityTop10 城市销量TOP10排名
     * @return 城市销量TOP10排名集合
     */
    public List<CarStatCityTop10> selectCarStatCityTop10List(CarStatCityTop10 carStatCityTop10);

    /**
     * 新增城市销量TOP10排名
     * 
     * @param carStatCityTop10 城市销量TOP10排名
     * @return 结果
     */
    public int insertCarStatCityTop10(CarStatCityTop10 carStatCityTop10);

    /**
     * 修改城市销量TOP10排名
     * 
     * @param carStatCityTop10 城市销量TOP10排名
     * @return 结果
     */
    public int updateCarStatCityTop10(CarStatCityTop10 carStatCityTop10);

    /**
     * 删除城市销量TOP10排名
     * 
     * @param id 城市销量TOP10排名主键
     * @return 结果
     */
    public int deleteCarStatCityTop10ById(Long id);

    /**
     * 批量删除城市销量TOP10排名
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarStatCityTop10ByIds(Long[] ids);
}
