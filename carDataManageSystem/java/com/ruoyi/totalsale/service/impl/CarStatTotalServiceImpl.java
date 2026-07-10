package com.ruoyi.totalsale.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.totalsale.mapper.CarStatTotalMapper;
import com.ruoyi.totalsale.domain.CarStatTotal;
import com.ruoyi.totalsale.service.ICarStatTotalService;

/**
 * 总销量统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@Service
public class CarStatTotalServiceImpl implements ICarStatTotalService 
{
    @Autowired
    private CarStatTotalMapper carStatTotalMapper;

    /**
     * 查询总销量统计
     * 
     * @param id 总销量统计主键
     * @return 总销量统计
     */
    @Override
    public CarStatTotal selectCarStatTotalById(Long id)
    {
        return carStatTotalMapper.selectCarStatTotalById(id);
    }

    /**
     * 查询总销量统计列表
     * 
     * @param carStatTotal 总销量统计
     * @return 总销量统计
     */
    @Override
    public List<CarStatTotal> selectCarStatTotalList(CarStatTotal carStatTotal)
    {
        return carStatTotalMapper.selectCarStatTotalList(carStatTotal);
    }

    /**
     * 新增总销量统计
     * 
     * @param carStatTotal 总销量统计
     * @return 结果
     */
    @Override
    public int insertCarStatTotal(CarStatTotal carStatTotal)
    {
        return carStatTotalMapper.insertCarStatTotal(carStatTotal);
    }

    /**
     * 修改总销量统计
     * 
     * @param carStatTotal 总销量统计
     * @return 结果
     */
    @Override
    public int updateCarStatTotal(CarStatTotal carStatTotal)
    {
        return carStatTotalMapper.updateCarStatTotal(carStatTotal);
    }

    /**
     * 批量删除总销量统计
     * 
     * @param ids 需要删除的总销量统计主键
     * @return 结果
     */
    @Override
    public int deleteCarStatTotalByIds(Long[] ids)
    {
        return carStatTotalMapper.deleteCarStatTotalByIds(ids);
    }

    /**
     * 删除总销量统计信息
     * 
     * @param id 总销量统计主键
     * @return 结果
     */
    @Override
    public int deleteCarStatTotalById(Long id)
    {
        return carStatTotalMapper.deleteCarStatTotalById(id);
    }
}
