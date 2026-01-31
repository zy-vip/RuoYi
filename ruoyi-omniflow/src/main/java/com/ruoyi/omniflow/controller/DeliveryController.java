package com.ruoyi.omniflow.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.omniflow.domain.Delivery;
import com.ruoyi.omniflow.service.IDeliveryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 配送信息Controller
 *
 * @author zhouy
 * @date 2026-01-31
 */
@RestController
@RequestMapping("/omniflow/delivery")
public class DeliveryController extends BaseController {

    @Autowired
    private IDeliveryService deliveryService;

    /**
     * 查询配送信息列表
     */
    @RequiresPermissions("omniflow:delivery:list")
    @GetMapping("/list")
    public TableDataInfo list(Delivery delivery) {
        startPage();
        List<Delivery> list = deliveryService.selectDeliveryList(delivery);
        return getDataTable(list);
    }

    /**
     * 导出配送信息列表
     */
    @RequiresPermissions("omniflow:delivery:export")
    @Log(title = "配送信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Delivery delivery) {
        List<Delivery> list = deliveryService.selectDeliveryList(delivery);
        ExcelUtil<Delivery> util = new ExcelUtil<Delivery>(Delivery.class);
        util.exportExcel(response, list, "配送信息数据");
    }

    /**
     * 获取配送信息详细信息
     */
    @RequiresPermissions("omniflow:delivery:query")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(deliveryService.selectDeliveryById(id));
    }

    /**
     * 新增配送信息
     */
    @RequiresPermissions("omniflow:delivery:add")
    @Log(title = "配送信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Delivery delivery) {
        return toAjax(deliveryService.insertDelivery(delivery));
    }

    /**
     * 修改配送信息
     */
    @RequiresPermissions("omniflow:delivery:edit")
    @Log(title = "配送信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Delivery delivery) {
        return toAjax(deliveryService.updateDelivery(delivery));
    }

    /**
     * 删除配送信息
     */
    @RequiresPermissions("omniflow:delivery:remove")
    @Log(title = "配送信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(deliveryService.deleteDeliveryByIds(ids));
    }
}
