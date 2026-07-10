package com.ruoyi.fuel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fuel.mapper.CarStatFuelMapper;
import com.ruoyi.fuel.domain.CarStatFuel;
import com.ruoyi.fuel.service.ICarStatFuelService;

/**
 * 动力类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class CarStatFuelServiceImpl implements ICarStatFuelService 
{
    @Autowired
    private CarStatFuelMapper carStatFuelMapper;

    /**
     * 查询动力类型
     * 
     * @param id 动力类型主键
     * @return 动力类型
     */
    @Override
    public CarStatFuel selectCarStatFuelById(Long id)
    {
        return carStatFuelMapper.selectCarStatFuelById(id);
    }

    /**
     * 查询动力类型列表
     * 
     * @param carStatFuel 动力类型
     * @return 动力类型
     */
    @Override
    public List<CarStatFuel> selectCarStatFuelList(CarStatFuel carStatFuel)
    {
        return carStatFuelMapper.selectCarStatFuelList(carStatFuel);
    }

    /**
     * 新增动力类型
     * 
     * @param carStatFuel 动力类型
     * @return 结果
     */
    @Override
    public int insertCarStatFuel(CarStatFuel carStatFuel)
    {
        return carStatFuelMapper.insertCarStatFuel(carStatFuel);
    }

    /**
     * 修改动力类型
     * 
     * @param carStatFuel 动力类型
     * @return 结果
     */
    @Override
    public int updateCarStatFuel(CarStatFuel carStatFuel)
    {
        return carStatFuelMapper.updateCarStatFuel(carStatFuel);
    }

    /**
     * 批量删除动力类型
     * 
     * @param ids 需要删除的动力类型主键
     * @return 结果
     */
    @Override
    public int deleteCarStatFuelByIds(Long[] ids)
    {
        return carStatFuelMapper.deleteCarStatFuelByIds(ids);
    }

    /**
     * 删除动力类型信息
     * 
     * @param id 动力类型主键
     * @return 结果
     */
    @Override
    public int deleteCarStatFuelById(Long id)
    {
        return carStatFuelMapper.deleteCarStatFuelById(id);
    }
}
