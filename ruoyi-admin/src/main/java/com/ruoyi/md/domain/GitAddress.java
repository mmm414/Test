package com.ruoyi.md.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 git_address
 *
 * @author ruoyi
 * @date 2020-11-09
 */
public class GitAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** git仓库地址Id，对应用户表中的git_adderss_id字段 */
    private Long gitAddressId;

    /** git仓库地址值 */
    @Excel(name = "git仓库地址值")
    private String gitAddress;

    public void setGitAddressId(Long gitAddressId)
    {
        this.gitAddressId = gitAddressId;
    }

    public Long getGitAddressId()
    {
        return gitAddressId;
    }
    public void setGitAddress(String gitAddress)
    {
        this.gitAddress = gitAddress;
    }

    public String getGitAddress()
    {
        return gitAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("gitAddressId", getGitAddressId())
                .append("gitAddress", getGitAddress())
                .toString();
    }
}
