package com.ruoyi.omniflow.service.impl;

import com.ruoyi.omniflow.domain.Merchant;
import com.ruoyi.omniflow.mapper.MerchantMapper;
import com.ruoyi.omniflow.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 商家信息Service业务层处理
 *
 * @author zhouy
 * @date 2026-01-31
 */
@Service
public class MerchantServiceImpl implements IMerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    /**
     * 查询商家信息
     *
     * @param id 商家信息主键
     * @return 商家信息
     */
    @Override
    public Merchant selectMerchantById(Long id) {
        return merchantMapper.selectMerchantById(id);
    }

    /**
     * 查询商家信息列表
     *
     * @param merchant 商家信息
     * @return 商家信息
     */
    @Override
    public List<Merchant> selectMerchantList(Merchant merchant) {
        return merchantMapper.selectMerchantList(merchant);
    }

    /**
     * 新增商家信息
     *
     * @param merchant 商家信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertMerchant(Merchant merchant) {
        return merchantMapper.insertMerchant(merchant);
    }

    /**
     * 修改商家信息
     *
     * @param merchant 商家信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateMerchant(Merchant merchant) {
        return merchantMapper.updateMerchant(merchant);
    }

    /**
     * 批量删除商家信息
     *
     * @param ids 需要删除的商家信息主键
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteMerchantByIds(Long[] ids) {
        return merchantMapper.deleteMerchantByIds(ids);
    }

    /**
     * 删除商家信息信息
     *
     * @param id 商家信息主键
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteMerchantById(Long id) {
        return merchantMapper.deleteMerchantById(id);
    }
}
