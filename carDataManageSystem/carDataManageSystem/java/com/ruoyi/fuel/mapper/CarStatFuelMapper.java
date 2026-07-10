package com.ruoyi.fuel.mapper;

import java.util.List;
import com.ruoyi.fuel.domain.CarStatFuel;

/**
 * 动力类型Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
public interface CarStatFuelMapper 
{
    /**
     * 查询动力类型
     * 
     * @param id 动力类型主键
     * @return 动力类型
     */
    public CarStatFuel selectCarStatFuelById(Long id);

    /**
     * 查询动力类型列表
     * 
     * @param carStatFuel 动力类型
     * @return 动力类型集合
     */
    public List<CarStatFuel> selectCarStatFuelList(CarStatFuel carStatFuel);

    /**
     * 新增动力类型
     * 
     * @param carStatFuel 动力类型
     * @return 结果
     */
    public int insertCarStatFuel(CarStatFuel carStatFuel);

    /**
     * 修改动力类型
     * 
     * @param carStatFuel 动力类型
     * @return 结果
     */
    public int updateCarStatFuel(CarStatFuel carStatFuel);

    /**
     * 删除动力类型
     * 
     * @param id 动力类型主键
     * @return 结果
     */
    public int deleteCarStatFuelById(Long id);

    /**
     * 批量删除动力类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarStatFuelByIds(Long[] ids);
}
