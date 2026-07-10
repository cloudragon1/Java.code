package com.ruoyi.topone.controller;

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
import com.ruoyi.topone.domain.CarStatBrandTop1;
import com.ruoyi.topone.service.ICarStatBrandTop1Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌销量TOP1Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/topone/topone")
public class CarStatBrandTop1Controller extends BaseController
{
    @Autowired
    private ICarStatBrandTop1Service carStatBrandTop1Service;

    /**
     * 查询品牌销量TOP1列表
     */
    @PreAuthorize("@ss.hasPermi('topone:topone:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarStatBrandTop1 carStatBrandTop1)
    {
        startPage();
        List<CarStatBrandTop1> list = carStatBrandTop1Service.selectCarStatBrandTop1List(carStatBrandTop1);
        return getDataTable(list);
    }

    /**
     * 导出品牌销量TOP1列表
     */
    @PreAuthorize("@ss.hasPermi('topone:topone:export')")
    @Log(title = "品牌销量TOP1", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarStatBrandTop1 carStatBrandTop1)
    {
        List<CarStatBrandTop1> list = carStatBrandTop1Service.selectCarStatBrandTop1List(carStatBrandTop1);
        ExcelUtil<CarStatBrandTop1> util = new ExcelUtil<CarStatBrandTop1>(CarStatBrandTop1.class);
        util.exportExcel(response, list, "品牌销量TOP1数据");
    }

    /**
     * 获取品牌销量TOP1详细信息
     */
    @PreAuthorize("@ss.hasPermi('topone:topone:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carStatBrandTop1Service.selectCarStatBrandTop1ById(id));
    }

    /**
     * 新增品牌销量TOP1
     */
    @PreAuthorize("@ss.hasPermi('topone:topone:add')")
    @Log(title = "品牌销量TOP1", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarStatBrandTop1 carStatBrandTop1)
    {
        return toAjax(carStatBrandTop1Service.insertCarStatBrandTop1(carStatBrandTop1));
    }

    /**
     * 修改品牌销量TOP1
     */
    @PreAuthorize("@ss.hasPermi('topone:topone:edit')")
    @Log(title = "品牌销量TOP1", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarStatBrandTop1 carStatBrandTop1)
    {
        return toAjax(carStatBrandTop1Service.updateCarStatBrandTop1(carStatBrandTop1));
    }

    /**
     * 删除品牌销量TOP1
     */
    @PreAuthorize("@ss.hasPermi('topone:topone:remove')")
    @Log(title = "品牌销量TOP1", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carStatBrandTop1Service.deleteCarStatBrandTop1ByIds(ids));
    }
}
