package com.ruoyi.top10.controller;

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
import com.ruoyi.top10.domain.CarBrandTop10;
import com.ruoyi.top10.service.ICarBrandTop10Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌销量Top10Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/top10/top10")
public class CarBrandTop10Controller extends BaseController
{
    @Autowired
    private ICarBrandTop10Service carBrandTop10Service;

    /**
     * 查询品牌销量Top10列表
     */
    @PreAuthorize("@ss.hasPermi('top10:top10:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarBrandTop10 carBrandTop10)
    {
        startPage();
        List<CarBrandTop10> list = carBrandTop10Service.selectCarBrandTop10List(carBrandTop10);
        return getDataTable(list);
    }

    /**
     * 导出品牌销量Top10列表
     */
    @PreAuthorize("@ss.hasPermi('top10:top10:export')")
    @Log(title = "品牌销量Top10", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarBrandTop10 carBrandTop10)
    {
        List<CarBrandTop10> list = carBrandTop10Service.selectCarBrandTop10List(carBrandTop10);
        ExcelUtil<CarBrandTop10> util = new ExcelUtil<CarBrandTop10>(CarBrandTop10.class);
        util.exportExcel(response, list, "品牌销量Top10数据");
    }

    /**
     * 获取品牌销量Top10详细信息
     */
    @PreAuthorize("@ss.hasPermi('top10:top10:query')")
    @GetMapping(value = "/{company}")
    public AjaxResult getInfo(@PathVariable("company") String company)
    {
        return success(carBrandTop10Service.selectCarBrandTop10ByCompany(company));
    }

    /**
     * 新增品牌销量Top10
     */
    @PreAuthorize("@ss.hasPermi('top10:top10:add')")
    @Log(title = "品牌销量Top10", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarBrandTop10 carBrandTop10)
    {
        return toAjax(carBrandTop10Service.insertCarBrandTop10(carBrandTop10));
    }

    /**
     * 修改品牌销量Top10
     */
    @PreAuthorize("@ss.hasPermi('top10:top10:edit')")
    @Log(title = "品牌销量Top10", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarBrandTop10 carBrandTop10)
    {
        return toAjax(carBrandTop10Service.updateCarBrandTop10(carBrandTop10));
    }

    /**
     * 删除品牌销量Top10
     */
    @PreAuthorize("@ss.hasPermi('top10:top10:remove')")
    @Log(title = "品牌销量Top10", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companys}")
    public AjaxResult remove(@PathVariable String[] companys)
    {
        return toAjax(carBrandTop10Service.deleteCarBrandTop10ByCompanys(companys));
    }
}
