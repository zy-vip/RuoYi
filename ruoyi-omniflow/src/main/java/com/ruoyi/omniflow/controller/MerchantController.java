package com.ruoyi.omniflow.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.omniflow.domain.Merchant;
import com.ruoyi.omniflow.service.IMerchantService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商家信息Controller
 *
 * @author zhouy
 * @date 2026-01-31
 */
@RestController
@RequestMapping("/omniflow/merchant")
public class MerchantController extends BaseController {

    @Autowired
    private IMerchantService merchantService;

    /**
     * 查询商家信息列表
     */
    @RequiresPermissions("omniflow:merchant:list")
    @GetMapping("/list")
    public TableDataInfo list(Merchant merchant) {
        startPage();
        List<Merchant> list = merchantService.selectMerchantList(merchant);
        return getDataTable(list);
    }

    /**
     * 导出商家信息列表
     */
    @RequiresPermissions("omniflow:merchant:export")
    @Log(title = "商家信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Merchant merchant) {
        List<Merchant> list = merchantService.selectMerchantList(merchant);
        ExcelUtil<Merchant> util = new ExcelUtil<Merchant>(Merchant.class);
        util.exportExcel(response, list, "商家信息数据");
    }

    /**
     * 获取商家信息详细信息
     */
    @RequiresPermissions("omniflow:merchant:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(merchantService.selectMerchantById(id));
    }

    /**
     * 新增商家信息
     */
    @RequiresPermissions("omniflow:merchant:add")
    @Log(title = "商家信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Merchant merchant) {
        return toAjax(merchantService.insertMerchant(merchant));
    }

    /**
     * 修改商家信息
     */
    @RequiresPermissions("omniflow:merchant:edit")
    @Log(title = "商家信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Merchant merchant) {
        return toAjax(merchantService.updateMerchant(merchant));
    }

    /**
     * 删除商家信息
     */
    @RequiresPermissions("omniflow:merchant:remove")
    @Log(title = "商家信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(merchantService.deleteMerchantByIds(ids));
    }
}
