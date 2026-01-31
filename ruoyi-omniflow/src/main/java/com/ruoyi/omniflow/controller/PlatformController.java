package com.ruoyi.omniflow.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.omniflow.domain.Platform;
import com.ruoyi.omniflow.service.IPlatformService;

/**
 * 外卖平台配置Controller
 *
 * @author zhouy
 * @date 2026-01-31
 */
@RestController
@RequestMapping("/omniflow/platform")
public class PlatformController extends BaseController {

    @Autowired
    private IPlatformService platformService;

    /**
     * 查询外卖平台配置列表
     */
    @RequiresPermissions("omniflow:platform:list")
    @GetMapping("/list")
    public TableDataInfo list(Platform platform) {
        startPage();
        List<Platform> list = platformService.selectPlatformList(platform);
        return getDataTable(list);
    }

    /**
     * 导出外卖平台配置列表
     */
    @RequiresPermissions("omniflow:platform:export")
    @Log(title = "外卖平台配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Platform platform) {
        List<Platform> list = platformService.selectPlatformList(platform);
        ExcelUtil<Platform> util = new ExcelUtil<Platform>(Platform.class);
        util.exportExcel(response, list, "外卖平台配置数据");
    }

    /**
     * 获取外卖平台配置详细信息
     */
    @RequiresPermissions("omniflow:platform:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(platformService.selectPlatformById(id));
    }

    /**
     * 新增外卖平台配置
     */
    @RequiresPermissions("omniflow:platform:add")
    @Log(title = "外卖平台配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Valid @RequestBody Platform platform, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getValidationErrorResult(bindingResult);
        }

        // 业务校验：平台编码唯一性
        if (!platformService.checkCodeUnique(platform)) {
            return error("新增平台'" + platform.getCode() + "'失败，平台编码已存在");
        }

        // 业务校验：API配置JSON格式
        if (!platform.isApiConfigValid()) {
            return error("API配置格式错误，请输入有效的JSON");
        }

        return toAjax(platformService.insertPlatform(platform));
    }

    /**
     * 修改外卖平台配置
     */
    @RequiresPermissions("omniflow:platform:edit")
    @Log(title = "外卖平台配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Valid @RequestBody Platform platform, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getValidationErrorResult(bindingResult);
        }

        // 业务校验：平台编码唯一性
        if (!platformService.checkCodeUnique(platform)) {
            return error("修改平台'" + platform.getCode() + "'失败，平台编码已存在");
        }

        // 业务校验：API配置JSON格式
        if (!platform.isApiConfigValid()) {
            return error("API配置格式错误，请输入有效的JSON");
        }

        return toAjax(platformService.updatePlatform(platform));
    }

    /**
     * 删除外卖平台配置
     */
    @RequiresPermissions("omniflow:platform:remove")
    @Log(title = "外卖平台配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(platformService.deletePlatformByIds(ids));
    }

    /**
     * 获取验证错误结果
     * @param bindingResult 绑定结果
     * @return 错误结果
     */
    private AjaxResult getValidationErrorResult(BindingResult bindingResult) {
        FieldError fieldError = bindingResult.getFieldError();
        if (fieldError != null) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            return error(StringUtils.nvl(message, "参数验证失败"));
        }
        return error("参数验证失败");
    }
}
