package com.ruoyi.omniflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.omniflow.domain.Platform;
import com.ruoyi.omniflow.mapper.PlatformMapper;
import com.ruoyi.omniflow.service.IPlatformService;

/**
 * 外卖平台配置Service业务层处理
 *
 * @author zhouy
 * @date 2026-01-31
 */
@Service
public class PlatformServiceImpl implements IPlatformService {

    @Autowired
    private PlatformMapper platformMapper;

    /**
     * 查询外卖平台配置
     *
     * @param id 外卖平台配置主键
     * @return 外卖平台配置
     */
    @Override
    public Platform selectPlatformById(Long id) {
        return platformMapper.selectPlatformById(id);
    }

    /**
     * 查询外卖平台配置列表
     *
     * @param platform 外卖平台配置
     * @return 外卖平台配置
     */
    @Override
    public List<Platform> selectPlatformList(Platform platform) {
        return platformMapper.selectPlatformList(platform);
    }

    /**
     * 新增外卖平台配置
     *
     * @param platform 外卖平台配置
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPlatform(Platform platform) {
        return platformMapper.insertPlatform(platform);
    }

    /**
     * 修改外卖平台配置
     *
     * @param platform 外卖平台配置
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePlatform(Platform platform) {
        return platformMapper.updatePlatform(platform);
    }

    /**
     * 批量删除外卖平台配置（逻辑删除）
     *
     * @param ids 需要删除的外卖平台配置主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deletePlatformByIds(Long[] ids) {
        return platformMapper.deletePlatformByIds(ids);
    }

    /**
     * 删除外卖平台配置信息（逻辑删除）
     *
     * @param id 外卖平台配置主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deletePlatformById(Long id) {
        return platformMapper.deletePlatformById(id);
    }

    /**
     * 校验平台编码是否唯一
     *
     * @param platform 外卖平台配置
     * @return true-唯一 false-不唯一
     */
    @Override
    public boolean checkCodeUnique(Platform platform) {
        Long platformId = StringUtils.isNull(platform.getId()) ? -1L : platform.getId();
        Platform info = platformMapper.selectPlatformByCode(platform.getCode());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != platformId.longValue()) {
            return false;
        }
        return true;
    }
}
