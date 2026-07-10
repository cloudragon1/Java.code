package com.ruoyi.brand.controller;

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
import com.ruoyi.brand.domain.CarStatBrand;
import com.ruoyi.brand.service.ICarStatBrandService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌销量统计Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/brand/brand")
public class CarStatBrandController extends BaseController
{
    @Autowired
    private ICarStatBrandService carStatBrandService;

    /**
     * 查询品牌销量统计列表
     */
    @PreAuthorize("@ss.hasPermi('brand:brand:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarStatBrand carStatBrand)
    {
        startPage();
        List<CarStatBrand> list = carStatBrandService.selectCarStatBrandList(carStatBrand);
        return getDataTable(list);
    }

    /**
     * 导出品牌销量统计列表
     */
    @PreAuthorize("@ss.hasPermi('brand:brand:export')")
    @Log(title = "品牌销量统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarStatBrand carStatBrand)
    {
        List<CarStatBrand> list = carStatBrandService.selectCarStatBrandList(carStatBrand);
        ExcelUtil<CarStatBrand> util = new ExcelUtil<CarStatBrand>(CarStatBrand.class);
        util.exportExcel(response, list, "品牌销量统计数据");
    }

    /**
     * 获取品牌销量统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('brand:brand:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carStatBrandService.selectCarStatBrandById(id));
    }

    /**
     * 新增品牌销量统计
     */
    @PreAuthorize("@ss.hasPermi('brand:brand:add')")
    @Log(title = "品牌销量统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarStatBrand carStatBrand)
    {
        return toAjax(carStatBrandService.insertCarStatBrand(carStatBrand));
    }

    /**
     * 修改品牌销量统计
     */
    @PreAuthorize("@ss.hasPermi('brand:brand:edit')")
    @Log(title = "品牌销量统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarStatBrand carStatBrand)
    {
        return toAjax(carStatBrandService.updateCarStatBrand(carStatBrand));
    }

    /**
     * 删除品牌销量统计
     */
    @PreAuthorize("@ss.hasPermi('brand:brand:remove')")
    @Log(title = "品牌销量统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carStatBrandService.deleteCarStatBrandByIds(ids));
    }
}
