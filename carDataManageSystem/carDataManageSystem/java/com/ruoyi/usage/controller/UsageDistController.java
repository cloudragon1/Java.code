package com.ruoyi.usage.controller;

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
import com.ruoyi.usage.domain.UsageDist;
import com.ruoyi.usage.service.IUsageDistService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆用途分布统计Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/usage/usage")
public class UsageDistController extends BaseController
{
    @Autowired
    private IUsageDistService usageDistService;

    /**
     * 查询车辆用途分布统计列表
     */
    @PreAuthorize("@ss.hasPermi('usage:usage:list')")
    @GetMapping("/list")
    public TableDataInfo list(UsageDist usageDist)
    {
        startPage();
        List<UsageDist> list = usageDistService.selectUsageDistList(usageDist);
        return getDataTable(list);
    }

    /**
     * 导出车辆用途分布统计列表
     */
    @PreAuthorize("@ss.hasPermi('usage:usage:export')")
    @Log(title = "车辆用途分布统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UsageDist usageDist)
    {
        List<UsageDist> list = usageDistService.selectUsageDistList(usageDist);
        ExcelUtil<UsageDist> util = new ExcelUtil<UsageDist>(UsageDist.class);
        util.exportExcel(response, list, "车辆用途分布统计数据");
    }

    /**
     * 获取车辆用途分布统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('usage:usage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(usageDistService.selectUsageDistById(id));
    }

    /**
     * 新增车辆用途分布统计
     */
    @PreAuthorize("@ss.hasPermi('usage:usage:add')")
    @Log(title = "车辆用途分布统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UsageDist usageDist)
    {
        return toAjax(usageDistService.insertUsageDist(usageDist));
    }

    /**
     * 修改车辆用途分布统计
     */
    @PreAuthorize("@ss.hasPermi('usage:usage:edit')")
    @Log(title = "车辆用途分布统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UsageDist usageDist)
    {
        return toAjax(usageDistService.updateUsageDist(usageDist));
    }

    /**
     * 删除车辆用途分布统计
     */
    @PreAuthorize("@ss.hasPermi('usage:usage:remove')")
    @Log(title = "车辆用途分布统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(usageDistService.deleteUsageDistByIds(ids));
    }
}
