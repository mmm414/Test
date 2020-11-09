package com.ruoyi.md.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 ssh
 *
 * @author ruoyi
 * @date 2020-11-09
 */
public class Ssh extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ssh-key id 对应用户表中的ssh字段 */
    private Long sshId;

    /** ssh-key值 */
    @Excel(name = "ssh-key值")
    private String sshKey;

    public void setSshId(Long sshId)
    {
        this.sshId = sshId;
    }

    public Long getSshId()
    {
        return sshId;
    }
    public void setSshKey(String sshKey)
    {
        this.sshKey = sshKey;
    }

    public String getSshKey()
    {
        return sshKey;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("sshId", getSshId())
                .append("sshKey", getSshKey())
                .toString();
    }
}
