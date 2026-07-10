package com.ruoyi.car_type.controller;

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
import com.ruoyi.car_type.domain.CarTypeDist;
import com.ruoyi.car_type.service.ICarTypeDistService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车型分布统计Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/car_type/car_type")
public class CarTypeDistController extends BaseController
{
    @Autowired
    private ICarTypeDistService carTypeDistService;

    /**
     * 查询车型分布统计列表
     */
    @PreAuthorize("@ss.hasPermi('car_type:car_type:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarTypeDist carTypeDist)
    {
        startPage();
        List<CarTypeDist> list = carTypeDistService.selectCarTypeDistList(carTypeDist);
        return getDataTable(list);
    }

    /**
     * 导出车型分布统计列表
     */
    @PreAuthorize("@ss.hasPermi('car_type:car_type:export')")
    @Log(title = "车型分布统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarTypeDist carTypeDist)
    {
        List<CarTypeDist> list = carTypeDistService.selectCarTypeDistList(carTypeDist);
        ExcelUtil<CarTypeDist> util = new ExcelUtil<CarTypeDist>(CarTypeDist.class);
        util.exportExcel(response, list, "车型分布统计数据");
    }

    /**
     * 获取车型分布统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('car_type:car_type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carTypeDistService.selectCarTypeDistById(id));
    }

    /**
     * 新增车型分布统计
     */
    @PreAuthorize("@ss.hasPermi('car_type:car_type:add')")
    @Log(title = "车型分布统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarTypeDist carTypeDist)
    {
        return toAjax(carTypeDistService.insertCarTypeDist(carTypeDist));
    }

    /**
     * 修改车型分布统计
     */
    @PreAuthorize("@ss.hasPermi('car_type:car_type:edit')")
    @Log(title = "车型分布统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarTypeDist carTypeDist)
    {
        return toAjax(carTypeDistService.updateCarTypeDist(carTypeDist));
    }

    /**
     * 删除车型分布统计
     */
    @PreAuthorize("@ss.hasPermi('car_type:car_type:remove')")
    @Log(title = "车型分布统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carTypeDistService.deleteCarTypeDistByIds(ids));
    }
}
