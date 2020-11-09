package com.ruoyi.md.mapper;

import java.util.List;
import com.ruoyi.md.domain.User;

/**
 * 用户Mapper接口
 *
 * @author ruoyi
 * @date 2020-11-09
 */
public interface UserMapper
{
    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return 用户
     */
    public User selectUserById(Long userId);

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除用户
     *
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserByIds(String[] userIds);
}
