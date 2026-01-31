package com.ruoyi.omniflow.service.impl;

import com.ruoyi.omniflow.domain.Delivery;
import com.ruoyi.omniflow.mapper.DeliveryMapper;
import com.ruoyi.omniflow.service.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 配送信息Service业务层处理
 *
 * @author zhouy
 * @date 2026-01-31
 */
@Service
public class DeliveryServiceImpl implements IDeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;

    /**
     * 查询配送信息
     *
     * @param id 配送信息主键
     * @return 配送信息
     */
    @Override
    public Delivery selectDeliveryById(Long id) {
        return deliveryMapper.selectDeliveryById(id);
    }

    /**
     * 查询配送信息列表
     *
     * @param delivery 配送信息
     * @return 配送信息
     */
    @Override
    public List<Delivery> selectDeliveryList(Delivery delivery) {
        return deliveryMapper.selectDeliveryList(delivery);
    }

    /**
     * 新增配送信息
     *
     * @param delivery 配送信息
     * @return 结果
     */
    @Override
    public int insertDelivery(Delivery delivery) {
        return deliveryMapper.insertDelivery(delivery);
    }

    /**
     * 修改配送信息
     *
     * @param delivery 配送信息
     * @return 结果
     */
    @Override
    public int updateDelivery(Delivery delivery) {
        return deliveryMapper.updateDelivery(delivery);
    }

    /**
     * 批量删除配送信息
     *
     * @param ids 需要删除的配送信息主键
     * @return 结果
     */
    @Override
    public int deleteDeliveryByIds(Long[] ids) {
        return deliveryMapper.deleteDeliveryByIds(ids);
    }

    /**
     * 删除配送信息信息
     *
     * @param id 配送信息主键
     * @return 结果
     */
    @Override
    public int deleteDeliveryById(Long id) {
        return deliveryMapper.deleteDeliveryById(id);
    }
}
