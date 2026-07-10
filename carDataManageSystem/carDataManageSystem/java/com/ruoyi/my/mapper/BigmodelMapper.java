package com.ruoyi.my.mapper;

import java.util.List;
import com.ruoyi.my.domain.Bigmodel;

/**
 * bigmodelMapper接口
 * 
 * @author ruoyi
 * @date 2026-06-04
 */
public interface BigmodelMapper 
{
    /**
     * 查询bigmodel
     * 
     * @param id bigmodel主键
     * @return bigmodel
     */
    public Bigmodel selectBigmodelById(Long id);

    /**
     * 查询bigmodel列表
     * 
     * @param bigmodel bigmodel
     * @return bigmodel集合
     */
    public List<Bigmodel> selectBigmodelList(Bigmodel bigmodel);

    /**
     * 新增bigmodel
     * 
     * @param bigmodel bigmodel
     * @return 结果
     */
    public int insertBigmodel(Bigmodel bigmodel);

    /**
     * 修改bigmodel
     * 
     * @param bigmodel bigmodel
     * @return 结果
     */
    public int updateBigmodel(Bigmodel bigmodel);

    /**
     * 删除bigmodel
     * 
     * @param id bigmodel主键
     * @return 结果
     */
    public int deleteBigmodelById(Long id);

    /**
     * 批量删除bigmodel
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBigmodelByIds(Long[] ids);
}
