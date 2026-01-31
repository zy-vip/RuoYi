package com.ruoyi.omniflow.service;

import com.ruoyi.omniflow.domain.Delivery;
import java.util.List;

/**
 * 配送信息Service接口
 *
 * @author zhouy
 * @date 2026-01-31
 */
public interface IDeliveryService {

    /**
     * 查询配送信息
     *
     * @param id 配送信息主键
     * @return 配送信息
     */
    public Delivery selectDeliveryById(Long id);

    /**
     * 查询配送信息列表
     *
     * @param delivery 配送信息
     * @return 配送信息集合
     */
    public List<Delivery> selectDeliveryList(Delivery delivery);

    /**
     * 新增配送信息
     *
     * @param delivery 配送信息
     * @return 结果
     */
    public int insertDelivery(Delivery delivery);

    /**
     * 修改配送信息
     *
     * @param delivery 配送信息
     * @return 结果
     */
    public int updateDelivery(Delivery delivery);

    /**
     * 批量删除配送信息
     *
     * @param ids 需要删除的配送信息主键集合
     * @return 结果
     */
    public int deleteDeliveryByIds(Long[] ids);

    /**
     * 删除配送信息信息
     *
     * @param id 配送信息主键
     * @return 结果
     */
    public int deleteDeliveryById(Long id);
}
