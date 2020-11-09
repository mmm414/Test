package com.ruoyi.md.contronller;

import java.util.List;

import com.ruoyi.md.domain.Ssh;
import com.ruoyi.md.service.ISshService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2020-11-09
 */
@Controller
@RequestMapping("/system/ssh")
public class SshController extends BaseController
{
    private String prefix = "system/ssh";

    @Autowired
    private ISshService sshService;

    @RequiresPermissions("system:ssh:view")
    @GetMapping()
    public String ssh()
    {
        return prefix + "/ssh";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:ssh:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Ssh ssh)
    {
        startPage();
        List<Ssh> list = sshService.selectSshList(ssh);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:ssh:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Ssh ssh)
    {
        List<Ssh> list = sshService.selectSshList(ssh);
        ExcelUtil<Ssh> util = new ExcelUtil<Ssh>(Ssh.class);
        return util.exportExcel(list, "ssh");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:ssh:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Ssh ssh)
    {
        return toAjax(sshService.insertSsh(ssh));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{sshId}")
    public String edit(@PathVariable("sshId") Long sshId, ModelMap mmap)
    {
        Ssh ssh = sshService.selectSshById(sshId);
        mmap.put("ssh", ssh);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:ssh:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Ssh ssh)
    {
        return toAjax(sshService.updateSsh(ssh));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:ssh:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sshService.deleteSshByIds(ids));
    }
}
