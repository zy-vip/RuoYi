package com.ruoyi.omniflow.service;

import com.ruoyi.omniflow.domain.Platform;
import java.util.List;

/**
 * 外卖平台配置Service接口
 *
 * @author zhouy
 * @date 2026-01-31
 */
public interface IPlatformService {

    /**
     * 查询外卖平台配置
     *
     * @param id 外卖平台配置主键
     * @return 外卖平台配置
     */
    public Platform selectPlatformById(Long id);

    /**
     * 查询外卖平台配置列表
     *
     * @param platform 外卖平台配置
     * @return 外卖平台配置集合
     */
    public List<Platform> selectPlatformList(Platform platform);

    /**
     * 新增外卖平台配置
     *
     * @param platform 外卖平台配置
     * @return 结果
     */
    public int insertPlatform(Platform platform);

    /**
     * 修改外卖平台配置
     *
     * @param platform 外卖平台配置
     * @return 结果
     */
    public int updatePlatform(Platform platform);

    /**
     * 批量删除外卖平台配置
     *
     * @param ids 需要删除的外卖平台配置主键集合
     * @return 结果
     */
    public int deletePlatformByIds(Long[] ids);

    /**
     * 删除外卖平台配置信息
     *
     * @param id 外卖平台配置主键
     * @return 结果
     */
    public int deletePlatformById(Long id);

    /**
     * 校验平台编码是否唯一
     *
     * @param platform 外卖平台配置
     * @return 结果
     */
    public boolean checkCodeUnique(Platform platform);
}
