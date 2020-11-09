package com.ruoyi.md.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文件对象 file
 *
 * @author ruoyi
 * @date 2020-11-06
 */
public class File extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件id */
    private Long fileId;

    /** 父文件id */
    @Excel(name = "父文件id")
    private Long parentId;

    /** 祖级列表 */
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 所属用户id */
    @Excel(name = "所属用户id")
    private Long userId;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 文件类型（root：根文件，user：用户文件，respository：仓库文件，folder：仓库中文件夹，md：md文件，txt：txt文件，jpg：jpg图片。。。。。。） */
    @Excel(name = "文件类型", readConverterExp = "r=oot：根文件，user：用户文件，respository：仓库文件，folder：仓库中文件夹，md：md文件，txt：txt文件，jpg：jpg图片。。。。。。")
    private String fileType;

    /** 文件描述 */
    @Excel(name = "文件类型", readConverterExp = "$column.readConverterExp()")
    private String fileDescription;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 文件状态（0未修改 1已修改） */
    @Excel(name = "文件状态", readConverterExp = "0=未修改,1=已修改")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setFileId(Long fileId)
    {
        this.fileId = fileId;
    }

    public Long getFileId()
    {
        return fileId;
    }
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return parentId;
    }
    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }

    public String getAncestors()
    {
        return ancestors;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return fileName;
    }
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    public String getFileType()
    {
        return fileType;
    }
    public void setFileDescription(String fileDescription)
    {
        this.fileDescription = fileDescription;
    }

    public String getFileDescription()
    {
        return fileDescription;
    }
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getFilePath()
    {
        return filePath;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("fileId", getFileId())
                .append("parentId", getParentId())
                .append("ancestors", getAncestors())
                .append("userId", getUserId())
                .append("fileName", getFileName())
                .append("fileType", getFileType())
                .append("fileDescription", getFileDescription())
                .append("filePath", getFilePath())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}