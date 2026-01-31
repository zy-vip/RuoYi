package com.ruoyi.omniflow.service.impl;

import com.ruoyi.omniflow.domain.Order;
import com.ruoyi.omniflow.mapper.OrderMapper;
import com.ruoyi.omniflow.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 聚合订单Service业务层处理
 *
 * @author zhouy
 * @date 2026-01-31
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询聚合订单
     *
     * @param id 聚合订单主键
     * @return 聚合订单
     */
    @Override
    public Order selectOrderById(Long id) {
        return orderMapper.selectOrderById(id);
    }

    /**
     * 查询聚合订单列表
     *
     * @param order 聚合订单
     * @return 聚合订单
     */
    @Override
    public List<Order> selectOrderList(Order order) {
        return orderMapper.selectOrderList(order);
    }

    /**
     * 新增聚合订单
     *
     * @param order 聚合订单
     * @return 结果
     */
    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    /**
     * 修改聚合订单
     *
     * @param order 聚合订单
     * @return 结果
     */
    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    /**
     * 批量删除聚合订单
     *
     * @param ids 需要删除的聚合订单主键
     * @return 结果
     */
    @Override
    public int deleteOrderByIds(Long[] ids) {
        return orderMapper.deleteOrderByIds(ids);
    }

    /**
     * 删除聚合订单信息
     *
     * @param id 聚合订单主键
     * @return 结果
     */
    @Override
    public int deleteOrderById(Long id) {
        return orderMapper.deleteOrderById(id);
    }
}
