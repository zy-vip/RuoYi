package com.ruoyi.omniflow.domain;

import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;

/**
 * 外卖平台配置实体 omni_platform
 *
 * @author zhouy
 * @date 2026-01-31
 */
public class Platform extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 平台ID */
    @Excel(name = "平台ID", cellType = ColumnType.NUMERIC)
    private Long id;

    /** 平台名称 */
    @Excel(name = "平台名称")
    private String name;

    /** 平台编码（meituan-eleme-douyin） */
    @Excel(name = "平台编码")
    private String code;

    /** API配置（JSON格式） */
    @Excel(name = "API配置")
    private String apiConfig;

    /** 状态（0-停用 1-正常） */
    @Excel(name = "状态", readConverterExp = "0=停用,1=正常")
    private String status;

    /** 删除标志（0-未删除 1-已删除） */
    @Excel(name = "删除标志", readConverterExp = "0=未删除,1=已删除")
    private String deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank(message = "平台名称不能为空")
    @Size(min = 2, max = 50, message = "平台名称长度必须在2到50个字符之间")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z0-9\\s\\-_]+$", message = "平台名称只能包含中文、字母、数字、空格、横线和下划线")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "平台编码不能为空")
    @Size(max = 20, message = "平台编码长度不能超过20个字符")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @NotBlank(message = "API配置不能为空")
    @Size(max = 2000, message = "API配置长度不能超过2000个字符")
    public String getApiConfig() {
        return apiConfig;
    }

    public void setApiConfig(String apiConfig) {
        this.apiConfig = apiConfig;
    }

    @NotBlank(message = "状态不能为空")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("code", getCode())
            .append("apiConfig", StringUtils.isNotEmpty(apiConfig) ? "***HIDDEN***" : null)
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .append("remark", getRemark())
            .toString();
    }

    /**
     * 验证API配置是否为有效的JSON格式
     * @return true-有效 false-无效
     */
    public boolean isApiConfigValid() {
        if (StringUtils.isEmpty(apiConfig)) {
            return false;
        }
        try {
            com.alibaba.fastjson.JSON.parse(apiConfig);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Platform other = (Platform) obj;
        return new EqualsBuilder()
            .append(id, other.id)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(id)
            .toHashCode();
    }
}
