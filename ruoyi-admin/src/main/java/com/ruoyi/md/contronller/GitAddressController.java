package com.ruoyi.md.contronller;

import java.util.List;

import com.ruoyi.md.domain.GitAddress;
import com.ruoyi.md.service.IGitAddressService;
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
@RequestMapping("/system/address")
public class GitAddressController extends BaseController
{
    private String prefix = "system/address";

    @Autowired
    private IGitAddressService gitAddressService;

    @RequiresPermissions("system:address:view")
    @GetMapping()
    public String address()
    {
        return prefix + "/address";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:address:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GitAddress gitAddress)
    {
        startPage();
        List<GitAddress> list = gitAddressService.selectGitAddressList(gitAddress);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:address:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GitAddress gitAddress)
    {
        List<GitAddress> list = gitAddressService.selectGitAddressList(gitAddress);
        ExcelUtil<GitAddress> util = new ExcelUtil<GitAddress>(GitAddress.class);
        return util.exportExcel(list, "address");
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
    @RequiresPermissions("system:address:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GitAddress gitAddress)
    {
        return toAjax(gitAddressService.insertGitAddress(gitAddress));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{gitAddressId}")
    public String edit(@PathVariable("gitAddressId") Long gitAddressId, ModelMap mmap)
    {
        GitAddress gitAddress = gitAddressService.selectGitAddressById(gitAddressId);
        mmap.put("gitAddress", gitAddress);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:address:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GitAddress gitAddress)
    {
        return toAjax(gitAddressService.updateGitAddress(gitAddress));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:address:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gitAddressService.deleteGitAddressByIds(ids));
    }
}
