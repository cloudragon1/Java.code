package com.ruoyi.my.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.my.mapper.BigmodelMapper;
import com.ruoyi.my.domain.Bigmodel;
import com.ruoyi.my.service.IBigmodelService;

/**
 * bigmodelService业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-04
 */
@Service
public class BigmodelServiceImpl implements IBigmodelService 
{
    @Autowired
    private BigmodelMapper bigmodelMapper;

    /**
     * 查询bigmodel
     * 
     * @param id bigmodel主键
     * @return bigmodel
     */
    @Override
    public Bigmodel selectBigmodelById(Long id)
    {
        return bigmodelMapper.selectBigmodelById(id);
    }

    /**
     * 查询bigmodel列表
     * 
     * @param bigmodel bigmodel
     * @return bigmodel
     */
    @Override
    public List<Bigmodel> selectBigmodelList(Bigmodel bigmodel)
    {
        return bigmodelMapper.selectBigmodelList(bigmodel);
    }

    /**
     * 新增bigmodel
     * 
     * @param bigmodel bigmodel
     * @return 结果
     */
    @Override
    public int insertBigmodel(Bigmodel bigmodel)
    {
        return bigmodelMapper.insertBigmodel(bigmodel);
    }

    /**
     * 修改bigmodel
     * 
     * @param bigmodel bigmodel
     * @return 结果
     */
    @Override
    public int updateBigmodel(Bigmodel bigmodel)
    {
        return bigmodelMapper.updateBigmodel(bigmodel);
    }

    /**
     * 批量删除bigmodel
     * 
     * @param ids 需要删除的bigmodel主键
     * @return 结果
     */
    @Override
    public int deleteBigmodelByIds(Long[] ids)
    {
        return bigmodelMapper.deleteBigmodelByIds(ids);
    }

    /**
     * 删除bigmodel信息
     * 
     * @param id bigmodel主键
     * @return 结果
     */
    @Override
    public int deleteBigmodelById(Long id)
    {
        return bigmodelMapper.deleteBigmodelById(id);
    }
}
