package com.ruoyi.data.controller;

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
import com.ruoyi.data.domain.CarCleaned;
import com.ruoyi.data.service.ICarCleanedService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 乘用车销售清洗后数据Controller
 * 
 * @author ruoyi
 * @date 2026-06-10
 */
@RestController
@RequestMapping("/base/base")
public class CarCleanedController extends BaseController
{
    @Autowired
    private ICarCleanedService carCleanedService;

    /**
     * 查询乘用车销售清洗后数据列表
     */
    @PreAuthorize("@ss.hasPermi('base:base:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarCleaned carCleaned)
    {
        startPage();
        List<CarCleaned> list = carCleanedService.selectCarCleanedList(carCleaned);
        return getDataTable(list);
    }

    /**
     * 导出乘用车销售清洗后数据列表
     */
    @PreAuthorize("@ss.hasPermi('base:base:export')")
    @Log(title = "乘用车销售清洗后数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarCleaned carCleaned)
    {
        List<CarCleaned> list = carCleanedService.selectCarCleanedList(carCleaned);
        ExcelUtil<CarCleaned> util = new ExcelUtil<CarCleaned>(CarCleaned.class);
        util.exportExcel(response, list, "乘用车销售清洗后数据数据");
    }

    /**
     * 获取乘用车销售清洗后数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:base:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carCleanedService.selectCarCleanedById(id));
    }

    /**
     * 新增乘用车销售清洗后数据
     */
    @PreAuthorize("@ss.hasPermi('base:base:add')")
    @Log(title = "乘用车销售清洗后数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarCleaned carCleaned)
    {
        return toAjax(carCleanedService.insertCarCleaned(carCleaned));
    }

    /**
     * 修改乘用车销售清洗后数据
     */
    @PreAuthorize("@ss.hasPermi('base:base:edit')")
    @Log(title = "乘用车销售清洗后数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarCleaned carCleaned)
    {
        return toAjax(carCleanedService.updateCarCleaned(carCleaned));
    }

    /**
     * 删除乘用车销售清洗后数据
     */
    @PreAuthorize("@ss.hasPermi('base:base:remove')")
    @Log(title = "乘用车销售清洗后数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carCleanedService.deleteCarCleanedByIds(ids));
    }
}
