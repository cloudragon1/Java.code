package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.CarStatCityTop10;
import com.ruoyi.system.service.ICarStatCityTop10Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市销量TOP10排名Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/system/top10")
public class CarStatCityTop10Controller extends BaseController
{
    @Autowired
    private ICarStatCityTop10Service carStatCityTop10Service;

    /**
     * 查询城市销量TOP10排名列表
     */
    @PreAuthorize("@ss.hasPermi('system:top10:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarStatCityTop10 carStatCityTop10)
    {
        startPage();
        List<CarStatCityTop10> list = carStatCityTop10Service.selectCarStatCityTop10List(carStatCityTop10);
        return getDataTable(list);
    }

    /**
     * 导出城市销量TOP10排名列表
     */
    @PreAuthorize("@ss.hasPermi('system:top10:export')")
    @Log(title = "城市销量TOP10排名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarStatCityTop10 carStatCityTop10)
    {
        List<CarStatCityTop10> list = carStatCityTop10Service.selectCarStatCityTop10List(carStatCityTop10);
        ExcelUtil<CarStatCityTop10> util = new ExcelUtil<CarStatCityTop10>(CarStatCityTop10.class);
        util.exportExcel(response, list, "城市销量TOP10排名数据");
    }

    /**
     * 获取城市销量TOP10排名详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:top10:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carStatCityTop10Service.selectCarStatCityTop10ById(id));
    }

    /**
     * 新增城市销量TOP10排名
     */
    @PreAuthorize("@ss.hasPermi('system:top10:add')")
    @Log(title = "城市销量TOP10排名", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarStatCityTop10 carStatCityTop10)
    {
        return toAjax(carStatCityTop10Service.insertCarStatCityTop10(carStatCityTop10));
    }

    /**
     * 修改城市销量TOP10排名
     */
    @PreAuthorize("@ss.hasPermi('system:top10:edit')")
    @Log(title = "城市销量TOP10排名", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarStatCityTop10 carStatCityTop10)
    {
        return toAjax(carStatCityTop10Service.updateCarStatCityTop10(carStatCityTop10));
    }

    /**
     * 删除城市销量TOP10排名
     */
    @PreAuthorize("@ss.hasPermi('system:top10:remove')")
    @Log(title = "城市销量TOP10排名", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carStatCityTop10Service.deleteCarStatCityTop10ByIds(ids));
    }
}
