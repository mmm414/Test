package com.ruoyi.md.service;

import com.ruoyi.md.domain.Ssh;

import java.util.List;


/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2020-11-09
 */
public interface ISshService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param sshId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Ssh selectSshById(Long sshId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param ssh 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Ssh> selectSshList(Ssh ssh);

    /**
     * 新增【请填写功能名称】
     *
     * @param ssh 【请填写功能名称】
     * @return 结果
     */
    public int insertSsh(Ssh ssh);

    /**
     * 修改【请填写功能名称】
     *
     * @param ssh 【请填写功能名称】
     * @return 结果
     */
    public int updateSsh(Ssh ssh);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSshByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param sshId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSshById(Long sshId);
}