package com.ruoyi.city.controller;

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
import com.ruoyi.city.domain.CarStatCity;
import com.ruoyi.city.service.ICarStatCityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市统计分析Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/city/city")
public class CarStatCityController extends BaseController
{
    @Autowired
    private ICarStatCityService carStatCityService;

    /**
     * 查询城市统计分析列表
     */
    @PreAuthorize("@ss.hasPermi('city:city:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarStatCity carStatCity)
    {
        startPage();
        List<CarStatCity> list = carStatCityService.selectCarStatCityList(carStatCity);
        return getDataTable(list);
    }

    /**
     * 导出城市统计分析列表
     */
    @PreAuthorize("@ss.hasPermi('city:city:export')")
    @Log(title = "城市统计分析", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarStatCity carStatCity)
    {
        List<CarStatCity> list = carStatCityService.selectCarStatCityList(carStatCity);
        ExcelUtil<CarStatCity> util = new ExcelUtil<CarStatCity>(CarStatCity.class);
        util.exportExcel(response, list, "城市统计分析数据");
    }

    /**
     * 获取城市统计分析详细信息
     */
    @PreAuthorize("@ss.hasPermi('city:city:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carStatCityService.selectCarStatCityById(id));
    }

    /**
     * 新增城市统计分析
     */
    @PreAuthorize("@ss.hasPermi('city:city:add')")
    @Log(title = "城市统计分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarStatCity carStatCity)
    {
        return toAjax(carStatCityService.insertCarStatCity(carStatCity));
    }

    /**
     * 修改城市统计分析
     */
    @PreAuthorize("@ss.hasPermi('city:city:edit')")
    @Log(title = "城市统计分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarStatCity carStatCity)
    {
        return toAjax(carStatCityService.updateCarStatCity(carStatCity));
    }

    /**
     * 删除城市统计分析
     */
    @PreAuthorize("@ss.hasPermi('city:city:remove')")
    @Log(title = "城市统计分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carStatCityService.deleteCarStatCityByIds(ids));
    }
}
