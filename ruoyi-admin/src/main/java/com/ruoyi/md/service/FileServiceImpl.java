package com.ruoyi.md.service;

import java.util.Iterator;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.md.mapper.FileMapper;
import com.ruoyi.md.domain.File;
import com.ruoyi.md.service.IFileService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文件Service业务层处理
 *
 * @author xuzf
 * @date 2020-11-05
 */
@Service
public class FileServiceImpl implements IFileService
{
    @Autowired
    private FileMapper fileMapper;

    /**
     * 查询文件
     *
     * @param fileId 文件ID
     * @return 文件
     */
    @Override
    public File selectFileById(Long fileId)
    {
        return fileMapper.selectFileById(fileId);
    }

    /**
     * 查询文件列表
     *
     * @param file 文件
     * @return 文件
     */
    @Override
    public List<File> selectFileList(File file)
    {
        return fileMapper.selectFileList(file);
    }

    /**
     * 按父文件id查询子文件列表
     *
     * @param fileId 文件id
     * @return 文件集合
     */
    public List<File> selectFileListBySuperId(Long fileId) {
        return fileMapper.selectFileListBySuperId(fileId);
    }

    /**
     * 新增文件
     *
     * @param file 文件
     * @return 结果
     */
    @Override
    public int insertFile(File file)
    {
        file.setCreateTime(DateUtils.getNowDate());
        return fileMapper.insertFile(file);
    }

    /**
     * 修改文件
     *
     * @param file 文件
     * @return 结果
     */
    @Override
    public int updateFile(File file)
    {
        file.setUpdateTime(DateUtils.getNowDate());
        return fileMapper.updateFile(file);
    }

    /**
     * 批量删除文件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFileByIds(String ids)
    {
        return fileMapper.deleteFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 递归删除文件
     *
     * @param fileId 文件ID
     * @return 结果
     */
    @Override
    public int deleteFileById(Long fileId) {
        List<File> sonFiles = fileMapper.selectFileListBySuperId(fileId);
        if(sonFiles.size() > 0) {
            int count = sonFiles.size();
            Iterator<File> itr =  sonFiles.iterator();
            while(itr.hasNext()) {
                count += deleteFileById(itr.next().getFileId());
            }
            return count;
        }else {
            return fileMapper.deleteFileById(fileId);
        }
    }

}