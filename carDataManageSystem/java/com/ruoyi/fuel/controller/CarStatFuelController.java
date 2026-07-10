package com.ruoyi.fuel.controller;

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
import com.ruoyi.fuel.domain.CarStatFuel;
import com.ruoyi.fuel.service.ICarStatFuelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 动力类型Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/fuel/fuel")
public class CarStatFuelController extends BaseController
{
    @Autowired
    private ICarStatFuelService carStatFuelService;

    /**
     * 查询动力类型列表
     */
    @PreAuthorize("@ss.hasPermi('fuel:fuel:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarStatFuel carStatFuel)
    {
        startPage();
        List<CarStatFuel> list = carStatFuelService.selectCarStatFuelList(carStatFuel);
        return getDataTable(list);
    }

    /**
     * 导出动力类型列表
     */
    @PreAuthorize("@ss.hasPermi('fuel:fuel:export')")
    @Log(title = "动力类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarStatFuel carStatFuel)
    {
        List<CarStatFuel> list = carStatFuelService.selectCarStatFuelList(carStatFuel);
        ExcelUtil<CarStatFuel> util = new ExcelUtil<CarStatFuel>(CarStatFuel.class);
        util.exportExcel(response, list, "动力类型数据");
    }

    /**
     * 获取动力类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('fuel:fuel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carStatFuelService.selectCarStatFuelById(id));
    }

    /**
     * 新增动力类型
     */
    @PreAuthorize("@ss.hasPermi('fuel:fuel:add')")
    @Log(title = "动力类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarStatFuel carStatFuel)
    {
        return toAjax(carStatFuelService.insertCarStatFuel(carStatFuel));
    }

    /**
     * 修改动力类型
     */
    @PreAuthorize("@ss.hasPermi('fuel:fuel:edit')")
    @Log(title = "动力类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarStatFuel carStatFuel)
    {
        return toAjax(carStatFuelService.updateCarStatFuel(carStatFuel));
    }

    /**
     * 删除动力类型
     */
    @PreAuthorize("@ss.hasPermi('fuel:fuel:remove')")
    @Log(title = "动力类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carStatFuelService.deleteCarStatFuelByIds(ids));
    }
}
