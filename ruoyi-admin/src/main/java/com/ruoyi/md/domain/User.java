package com.ruoyi.md.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 user
 *
 * @author ruoyi
 * @date 2020-11-09
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long userId;

    /** 登陆密码 */
    @Excel(name = "登陆密码")
    private String userPassword;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** git密码 */
    @Excel(name = "git密码")
    private String gitPassword;

    /** git用户名 */
    @Excel(name = "git用户名")
    private String gitName;

    /** git仓库地址id */
    @Excel(name = "git仓库地址id")
    private Long gitAddreddId;

    /** ssh-key id  */
    @Excel(name = "ssh-key id ")
    private Long sshId;

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    public String getUserPassword()
    {
        return userPassword;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setGitPassword(String gitPassword)
    {
        this.gitPassword = gitPassword;
    }

    public String getGitPassword()
    {
        return gitPassword;
    }
    public void setGitName(String gitName)
    {
        this.gitName = gitName;
    }

    public String getGitName()
    {
        return gitName;
    }
    public void setGitAddreddId(Long gitAddreddId)
    {
        this.gitAddreddId = gitAddreddId;
    }

    public Long getGitAddreddId()
    {
        return gitAddreddId;
    }
    public void setSshId(Long sshId)
    {
        this.sshId = sshId;
    }

    public Long getSshId()
    {
        return sshId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("userPassword", getUserPassword())
                .append("userName", getUserName())
                .append("gitPassword", getGitPassword())
                .append("gitName", getGitName())
                .append("gitAddreddId", getGitAddreddId())
                .append("sshId", getSshId())
                .toString();
    }
}
