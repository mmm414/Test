package com.ruoyi.md.service;

import java.util.List;

import com.ruoyi.md.domain.Ssh;
import com.ruoyi.md.mapper.SshMapper;
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
public class SshServiceImpl implements ISshService
{
    @Autowired
    private SshMapper sshMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param sshId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Ssh selectSshById(Long sshId)
    {
        return sshMapper.selectSshById(sshId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param ssh 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Ssh> selectSshList(Ssh ssh)
    {
        return sshMapper.selectSshList(ssh);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param ssh 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSsh(Ssh ssh)
    {
        return sshMapper.insertSsh(ssh);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param ssh 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSsh(Ssh ssh)
    {
        return sshMapper.updateSsh(ssh);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSshByIds(String ids)
    {
        return sshMapper.deleteSshByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param sshId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSshById(Long sshId)
    {
        return sshMapper.deleteSshById(sshId);
    }
}
