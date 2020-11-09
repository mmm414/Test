package com.ruoyi.md.service;

import java.util.List;

import com.ruoyi.md.contronller.GitAddressController;
import com.ruoyi.md.domain.GitAddress;
import com.ruoyi.md.domain.User;
import com.ruoyi.md.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 用户Service业务层处理
 *
 * @author ruoyi
 * @date 2020-11-09
 */
@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GitAddressController gitAddressController;

    @Autowired
    private GitAddress gitAddress;

    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return 用户
     */
    @Override
    public User selectUserById(Long userId)
    {
        return userMapper.selectUserById(userId);
    }

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户
     */
    @Override
    public List<User> selectUserList(User user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
    @Override
    public int insertUser(User user)
    {
        gitAddressController.add();
        return userMapper.insertUser(user);
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    @Override
    public int updateUser(User user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 删除用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserByIds(String ids)
    {
        return userMapper.deleteUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteUserById(Long userId)
    {
        return userMapper.deleteUserById(userId);
    }
}
