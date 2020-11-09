package com.ruoyi.md.service;

import com.ruoyi.md.domain.GitAddress;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2020-11-09
 */
public interface IGitAddressService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param gitAddressId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public GitAddress selectGitAddressById(Long gitAddressId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param gitAddress 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GitAddress> selectGitAddressList(GitAddress gitAddress);

    /**
     * 新增【请填写功能名称】
     *
     * @param gitAddress 【请填写功能名称】
     * @return 结果
     */
    public int insertGitAddress(GitAddress gitAddress);

    /**
     * 修改【请填写功能名称】
     *
     * @param gitAddress 【请填写功能名称】
     * @return 结果
     */
    public int updateGitAddress(GitAddress gitAddress);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGitAddressByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param gitAddressId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGitAddressById(Long gitAddressId);
}
