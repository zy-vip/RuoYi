package com.ruoyi.omniflow.mapper;

import com.ruoyi.omniflow.domain.Order;
import java.util.List;

/**
 * 聚合订单Mapper接口
 *
 * @author zhouy
 * @date 2026-01-31
 */
public interface OrderMapper {

    /**
     * 查询聚合订单
     *
     * @param id 聚合订单主键
     * @return 聚合订单
     */
    public Order selectOrderById(Long id);

    /**
     * 查询聚合订单列表
     *
     * @param order 聚合订单
     * @return 聚合订单集合
     */
    public List<Order> selectOrderList(Order order);

    /**
     * 新增聚合订单
     *
     * @param order 聚合订单
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改聚合订单
     *
     * @param order 聚合订单
     * @return 结果
     */
    public int updateOrder(Order order);

    /**
     * 删除聚合订单
     *
     * @param id 聚合订单主键
     * @return 结果
     */
    public int deleteOrderById(Long id);

    /**
     * 批量删除聚合订单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderByIds(Long[] ids);
}
