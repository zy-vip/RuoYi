package com.ruoyi.omniflow.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 聚合订单实体 omni_order
 *
 * @author zhouy
 * @date 2026-01-31
 */
public class Order extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private Long id;

    /** 平台ID */
    @Excel(name = "平台ID")
    private Long platformId;

    /** 平台订单号 */
    @Excel(name = "平台订单号")
    private String platformOrderNo;

    /** 商家ID */
    @Excel(name = "商家ID")
    private Long merchantId;

    /** 订单数据（JSON格式） */
    private String orderData;

    /** 订单状态（pending-paid-completed-cancelled） */
    @Excel(name = "订单状态")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getPlatformOrderNo() {
        return platformOrderNo;
    }

    public void setPlatformOrderNo(String platformOrderNo) {
        this.platformOrderNo = platformOrderNo;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
