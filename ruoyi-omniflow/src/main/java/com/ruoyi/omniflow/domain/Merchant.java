package com.ruoyi.omniflow.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 商家信息实体 omni_merchant
 *
 * @author zhouy
 * @date 2026-01-31
 */
public class Merchant extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 商家ID */
    private Long id;

    /** 商家名称 */
    @NotBlank(message = "商家名称不能为空")
    @Size(max = 100, message = "商家名称长度不能超过100个字符")
    @Excel(name = "商家名称")
    private String name;

    /** 联系电话 */
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "请输入正确的手机号码")
    @Excel(name = "联系电话")
    private String contactPhone;

    /** 商家地址 */
    @Excel(name = "商家地址")
    private String address;

    /** 外卖平台IDs（逗号分隔：1-美团,2-饿了么,3-抖音） */
    private String platformIds;

    /** 状态（0-停用 1-正常） */
    @Excel(name = "状态", readConverterExp = "0=停用,1=正常")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlatformIds() {
        return platformIds;
    }

    public void setPlatformIds(String platformIds) {
        this.platformIds = platformIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", address='" + address + '\'' +
                ", platformIds='" + platformIds + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
