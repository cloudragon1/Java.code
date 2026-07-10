package com.ruoyi.my.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.my.domain.Bigmodel;
import com.ruoyi.my.service.IBigmodelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * bigmodelController
 * 
 * @author ruoyi
 * @date 2026-06-04
 */
@RestController
@RequestMapping("/bigmodel/bigmodel")
public class BigmodelController extends BaseController
{
    @Autowired
    private IBigmodelService bigmodelService;

    /**
     * 查询bigmodel列表
     */
    @PreAuthorize("@ss.hasPermi('bigmodel:bigmodel:list')")
    @GetMapping("/list")
    public TableDataInfo list(Bigmodel bigmodel)
    {
        startPage();
        List<Bigmodel> list = bigmodelService.selectBigmodelList(bigmodel);
        return getDataTable(list);
    }

    /**
     * 导出bigmodel列表
     */
    @PreAuthorize("@ss.hasPermi('bigmodel:bigmodel:export')")
    @Log(title = "bigmodel", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Bigmodel bigmodel)
    {
        List<Bigmodel> list = bigmodelService.selectBigmodelList(bigmodel);
        ExcelUtil<Bigmodel> util = new ExcelUtil<Bigmodel>(Bigmodel.class);
        util.exportExcel(response, list, "bigmodel数据");
    }

    /**
     * 获取bigmodel详细信息
     */
    @PreAuthorize("@ss.hasPermi('bigmodel:bigmodel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bigmodelService.selectBigmodelById(id));
    }

    /**
     * 新增bigmodel
     */
    @PreAuthorize("@ss.hasPermi('bigmodel:bigmodel:add')")
    @Log(title = "bigmodel", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Bigmodel bigmodel)
    {
        return toAjax(bigmodelService.insertBigmodel(bigmodel));
    }

    /**
     * 修改bigmodel
     */
    @PreAuthorize("@ss.hasPermi('bigmodel:bigmodel:edit')")
    @Log(title = "bigmodel", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Bigmodel bigmodel)
    {
        return toAjax(bigmodelService.updateBigmodel(bigmodel));
    }

    /**
     * 删除bigmodel
     */
    @PreAuthorize("@ss.hasPermi('bigmodel:bigmodel:remove')")
    @Log(title = "bigmodel", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bigmodelService.deleteBigmodelByIds(ids));
    }
}
