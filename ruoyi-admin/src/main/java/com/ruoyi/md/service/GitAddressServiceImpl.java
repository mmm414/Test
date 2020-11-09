package com.ruoyi.md.service;

import java.util.List;

import com.ruoyi.md.domain.GitAddress;
import com.ruoyi.md.mapper.GitAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2020-11-09
 */
@Service
public class GitAddressServiceImpl implements IGitAddressService
{
    @Autowired
    private GitAddressMapper gitAddressMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param gitAddressId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public GitAddress selectGitAddressById(Long gitAddressId)
    {
        return gitAddressMapper.selectGitAddressById(gitAddressId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param gitAddress 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GitAddress> selectGitAddressList(GitAddress gitAddress)
    {
        return gitAddressMapper.selectGitAddressList(gitAddress);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param gitAddress 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGitAddress(GitAddress gitAddress)
    {
        return gitAddressMapper.insertGitAddress(gitAddress);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param gitAddress 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGitAddress(GitAddress gitAddress)
    {
        return gitAddressMapper.updateGitAddress(gitAddress);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGitAddressByIds(String ids)
    {
        return gitAddressMapper.deleteGitAddressByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param gitAddressId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGitAddressById(Long gitAddressId)
    {
        return gitAddressMapper.deleteGitAddressById(gitAddressId);
    }
}
