package com.ruoyi.citytopone.controller;

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
import com.ruoyi.citytopone.domain.CarStatCityTop1;
import com.ruoyi.citytopone.service.ICarStatCityTop1Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市销量TOP1Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/citytopone/citytopone")
public class CarStatCityTop1Controller extends BaseController
{
    @Autowired
    private ICarStatCityTop1Service carStatCityTop1Service;

    /**
     * 查询城市销量TOP1列表
     */
    @PreAuthorize("@ss.hasPermi('citytopone:citytopone:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarStatCityTop1 carStatCityTop1)
    {
        startPage();
        List<CarStatCityTop1> list = carStatCityTop1Service.selectCarStatCityTop1List(carStatCityTop1);
        return getDataTable(list);
    }

    /**
     * 导出城市销量TOP1列表
     */
    @PreAuthorize("@ss.hasPermi('citytopone:citytopone:export')")
    @Log(title = "城市销量TOP1", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarStatCityTop1 carStatCityTop1)
    {
        List<CarStatCityTop1> list = carStatCityTop1Service.selectCarStatCityTop1List(carStatCityTop1);
        ExcelUtil<CarStatCityTop1> util = new ExcelUtil<CarStatCityTop1>(CarStatCityTop1.class);
        util.exportExcel(response, list, "城市销量TOP1数据");
    }

    /**
     * 获取城市销量TOP1详细信息
     */
    @PreAuthorize("@ss.hasPermi('citytopone:citytopone:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carStatCityTop1Service.selectCarStatCityTop1ById(id));
    }

    /**
     * 新增城市销量TOP1
     */
    @PreAuthorize("@ss.hasPermi('citytopone:citytopone:add')")
    @Log(title = "城市销量TOP1", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarStatCityTop1 carStatCityTop1)
    {
        return toAjax(carStatCityTop1Service.insertCarStatCityTop1(carStatCityTop1));
    }

    /**
     * 修改城市销量TOP1
     */
    @PreAuthorize("@ss.hasPermi('citytopone:citytopone:edit')")
    @Log(title = "城市销量TOP1", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarStatCityTop1 carStatCityTop1)
    {
        return toAjax(carStatCityTop1Service.updateCarStatCityTop1(carStatCityTop1));
    }

    /**
     * 删除城市销量TOP1
     */
    @PreAuthorize("@ss.hasPermi('citytopone:citytopone:remove')")
    @Log(title = "城市销量TOP1", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carStatCityTop1Service.deleteCarStatCityTop1ByIds(ids));
    }
}
