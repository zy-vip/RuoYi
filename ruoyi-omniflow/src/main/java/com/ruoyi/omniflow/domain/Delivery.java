package com.ruoyi.omniflow.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 配送信息实体 omni_delivery
 *
 * @author zhouy
 * @date 2026-01-31
 */
public class Delivery extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 配送ID */
    private Long id;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 配送类型（self-self_dispatch-third_party） */
    @Excel(name = "配送类型")
    private String deliveryType;

    /** 配送平台ID */
    private Long deliveryPlatformId;

    /** 配送单号 */
    @Excel(name = "配送单号")
    private String trackingNo;

    /** 配送状态（pending-pickup-delivered-cancelled） */
    @Excel(name = "配送状态")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Long getDeliveryPlatformId() {
        return deliveryPlatformId;
    }

    public void setDeliveryPlatformId(Long deliveryPlatformId) {
        this.deliveryPlatformId = deliveryPlatformId;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
