package com.ruoyi.omniflow.service;

import com.ruoyi.omniflow.domain.Merchant;
import java.util.List;

/**
 * 商家信息Service接口
 *
 * @author zhouy
 * @date 2026-01-31
 */
public interface IMerchantService {

    /**
     * 查询商家信息
     *
     * @param id 商家信息主键
     * @return 商家信息
     */
    public Merchant selectMerchantById(Long id);

    /**
     * 查询商家信息列表
     *
     * @param merchant 商家信息
     * @return 商家信息集合
     */
    public List<Merchant> selectMerchantList(Merchant merchant);

    /**
     * 新增商家信息
     *
     * @param merchant 商家信息
     * @return 结果
     */
    public int insertMerchant(Merchant merchant);

    /**
     * 修改商家信息
     *
     * @param merchant 商家信息
     * @return 结果
     */
    public int updateMerchant(Merchant merchant);

    /**
     * 批量删除商家信息
     *
     * @param ids 需要删除的商家信息主键集合
     * @return 结果
     */
    public int deleteMerchantByIds(Long[] ids);

    /**
     * 删除商家信息信息
     *
     * @param id 商家信息主键
     * @return 结果
     */
    public int deleteMerchantById(Long id);
}
