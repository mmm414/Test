package com.ruoyi.md.contronller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.md.domain.File;
import com.ruoyi.md.service.IFileService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.websocket.server.PathParam;

/**
 * 文件Controller
 *
 * @author xuzf
 * @date 2020-11-05
 */
@Controller
@RequestMapping("/system/md/file")
public class FileController extends BaseController
{
    private String prefix = "system/md/file";

    @Autowired
    private IFileService fileService;

    @RequiresPermissions("system:file:view")
    @GetMapping()
    public String file()
    {
        return prefix + "/file";
    }

    /**
     * 查询文件列表
     */
    @RequiresPermissions("system:file:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(File file)
    {
        startPage();
        List<File> list = fileService.selectFileList(file);
        return getDataTable(list);
    }

    /**
     * 导出文件列表
     */
    @RequiresPermissions("system:file:export")
    @Log(title = "文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(File file)
    {
        List<File> list = fileService.selectFileList(file);
        ExcelUtil<File> util = new ExcelUtil<File>(File.class);
        return util.exportExcel(list, "file");
    }

    /**
     * 新增文件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文件
     */
    @RequiresPermissions("system:file:add")
    @Log(title = "文件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(File file)
    {
        return toAjax(fileService.insertFile(file));
    }

    /**
     * 修改文件
     */
    @GetMapping("/edit/{fileId}")
    public String edit(@PathVariable("fileId") Long fileId, ModelMap mmap)
    {
        File file = fileService.selectFileById(fileId);
        mmap.put("file", file);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件
     */
    @RequiresPermissions("system:file:edit")
    @Log(title = "文件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(File file)
    {
        return toAjax(fileService.updateFile(file));
    }

    /**
     * 批量删除文件
     */
    @RequiresPermissions("system:file:remove")
    @Log(title = "文件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fileService.deleteFileByIds(ids));
    }

    /**
     * 递归删除文件
     */
    @RequiresPermissions("system:file:remove")
    @Log(title = "文件", businessType = BusinessType.DELETE)
    @PostMapping( "/removes")
    @ResponseBody
    public AjaxResult removes(@RequestParam("fileId") Long fileId)
    {
        return toAjax(fileService.deleteFileById(fileId));
    }

    /**
     * 通过Id查询文件
     */
    @RequiresPermissions("system:file:list")
    @GetMapping("/find")
    @ResponseBody
    public File selectFileById(@RequestParam("fileId") Long fileId)
    {
        File file = fileService.selectFileById(fileId);
        return file;
    }

    /**
     * 按父文件id查询子文件列表
     */
    @RequiresPermissions("system:file:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam("fileId") Long fileId)
    {
        startPage();
        List<File> list = fileService.selectFileListBySuperId(fileId);
        return getDataTable(list);
    }


}
