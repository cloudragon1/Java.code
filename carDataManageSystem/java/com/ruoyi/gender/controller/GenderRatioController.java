package com.ruoyi.gender.controller;

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
import com.ruoyi.gender.domain.GenderRatio;
import com.ruoyi.gender.service.IGenderRatioService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 性别比例统计Controller
 * 
 * @author ruoyi
 * @date 2026-06-17
 */
@RestController
@RequestMapping("/gender/gender")
public class GenderRatioController extends BaseController
{
    @Autowired
    private IGenderRatioService genderRatioService;

    /**
     * 查询性别比例统计列表
     */
    @PreAuthorize("@ss.hasPermi('gender:gender:list')")
    @GetMapping("/list")
    public TableDataInfo list(GenderRatio genderRatio)
    {
        startPage();
        List<GenderRatio> list = genderRatioService.selectGenderRatioList(genderRatio);
        return getDataTable(list);
    }

    /**
     * 导出性别比例统计列表
     */
    @PreAuthorize("@ss.hasPermi('gender:gender:export')")
    @Log(title = "性别比例统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GenderRatio genderRatio)
    {
        List<GenderRatio> list = genderRatioService.selectGenderRatioList(genderRatio);
        ExcelUtil<GenderRatio> util = new ExcelUtil<GenderRatio>(GenderRatio.class);
        util.exportExcel(response, list, "性别比例统计数据");
    }

    /**
     * 获取性别比例统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('gender:gender:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(genderRatioService.selectGenderRatioById(id));
    }

    /**
     * 新增性别比例统计
     */
    @PreAuthorize("@ss.hasPermi('gender:gender:add')")
    @Log(title = "性别比例统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GenderRatio genderRatio)
    {
        return toAjax(genderRatioService.insertGenderRatio(genderRatio));
    }

    /**
     * 修改性别比例统计
     */
    @PreAuthorize("@ss.hasPermi('gender:gender:edit')")
    @Log(title = "性别比例统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GenderRatio genderRatio)
    {
        return toAjax(genderRatioService.updateGenderRatio(genderRatio));
    }

    /**
     * 删除性别比例统计
     */
    @PreAuthorize("@ss.hasPermi('gender:gender:remove')")
    @Log(title = "性别比例统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(genderRatioService.deleteGenderRatioByIds(ids));
    }
}
