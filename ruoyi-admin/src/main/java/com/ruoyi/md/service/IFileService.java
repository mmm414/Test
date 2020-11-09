package com.ruoyi.md.service;

import java.util.List;
import com.ruoyi.md.domain.File;

/**
 * 文件Service接口
 *
 * @author xuzf
 * @date 2020-11-05
 */
public interface IFileService
{
    /**
     * 查询文件
     *
     * @param fileId 文件ID
     * @return 文件
     */
    public File selectFileById(Long fileId);

    /**
     * 查询文件列表
     *
     * @param file 文件
     * @return 文件集合
     */
    public List<File> selectFileList(File file);

    /**
     * 按父文件id查询子文件列表
     *
     * @param fileId 文件id
     * @return 文件集合
     */
    public List<File> selectFileListBySuperId(Long fileId);

    /**
     * 新增文件
     *
     * @param file 文件
     * @return 结果
     */
    public int insertFile(File file);

    /**
     * 修改文件
     *
     * @param file 文件
     * @return 结果
     */
    public int updateFile(File file);

    /**
     * 批量删除文件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFileByIds(String ids);

    /**
     * 递归删除文件
     *
     * @param fileId 文件ID
     * @return 结果
     */
    public int deleteFileById(Long fileId);


}