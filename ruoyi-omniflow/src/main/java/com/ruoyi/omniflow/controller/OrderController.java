package com.ruoyi.omniflow.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.omniflow.domain.Order;
import com.ruoyi.omniflow.service.IOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 聚合订单Controller
 *
 * @author zhouy
 * @date 2026-01-31
 */
@RestController
@RequestMapping("/omniflow/order")
public class OrderController extends BaseController {

    @Autowired
    private IOrderService orderService;

    /**
     * 查询聚合订单列表
     */
    @RequiresPermissions("omniflow:order:list")
    @GetMapping("/list")
    public TableDataInfo list(Order order) {
        startPage();
        List<Order> list = orderService.selectOrderList(order);
        return getDataTable(list);
    }

    /**
     * 导出聚合订单列表
     */
    @RequiresPermissions("omniflow:order:export")
    @Log(title = "聚合订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Order order) {
        List<Order> list = orderService.selectOrderList(order);
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        util.exportExcel(response, list, "聚合订单数据");
    }

    /**
     * 获取聚合订单详细信息
     */
    @RequiresPermissions("omniflow:order:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(orderService.selectOrderById(id));
    }

    /**
     * 新增聚合订单
     */
    @RequiresPermissions("omniflow:order:add")
    @Log(title = "聚合订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Order order) {
        return toAjax(orderService.insertOrder(order));
    }

    /**
     * 修改聚合订单
     */
    @RequiresPermissions("omniflow:order:edit")
    @Log(title = "聚合订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Order order) {
        return toAjax(orderService.updateOrder(order));
    }

    /**
     * 删除聚合订单
     */
    @RequiresPermissions("omniflow:order:remove")
    @Log(title = "聚合订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(orderService.deleteOrderByIds(ids));
    }
}
