package com.ruoyi.totalsale.controller;

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
import com.ruoyi.totalsale.domain.CarStatTotal;
import com.ruoyi.totalsale.service.ICarStatTotalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 总销量统计Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/totalsale/totalsale")
public class CarStatTotalController extends BaseController
{
    @Autowired
    private ICarStatTotalService carStatTotalService;

    /**
     * 查询总销量统计列表
     */
    @PreAuthorize("@ss.hasPermi('totalsale:totalsale:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarStatTotal carStatTotal)
    {
        startPage();
        List<CarStatTotal> list = carStatTotalService.selectCarStatTotalList(carStatTotal);
        return getDataTable(list);
    }

    /**
     * 导出总销量统计列表
     */
    @PreAuthorize("@ss.hasPermi('totalsale:totalsale:export')")
    @Log(title = "总销量统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarStatTotal carStatTotal)
    {
        List<CarStatTotal> list = carStatTotalService.selectCarStatTotalList(carStatTotal);
        ExcelUtil<CarStatTotal> util = new ExcelUtil<CarStatTotal>(CarStatTotal.class);
        util.exportExcel(response, list, "总销量统计数据");
    }

    /**
     * 获取总销量统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('totalsale:totalsale:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carStatTotalService.selectCarStatTotalById(id));
    }

    /**
     * 新增总销量统计
     */
    @PreAuthorize("@ss.hasPermi('totalsale:totalsale:add')")
    @Log(title = "总销量统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarStatTotal carStatTotal)
    {
        return toAjax(carStatTotalService.insertCarStatTotal(carStatTotal));
    }

    /**
     * 修改总销量统计
     */
    @PreAuthorize("@ss.hasPermi('totalsale:totalsale:edit')")
    @Log(title = "总销量统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarStatTotal carStatTotal)
    {
        return toAjax(carStatTotalService.updateCarStatTotal(carStatTotal));
    }

    /**
     * 删除总销量统计
     */
    @PreAuthorize("@ss.hasPermi('totalsale:totalsale:remove')")
    @Log(title = "总销量统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carStatTotalService.deleteCarStatTotalByIds(ids));
    }
}
