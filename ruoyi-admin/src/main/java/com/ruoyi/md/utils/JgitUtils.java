package com.ruoyi.md.utils; /**
 * Copyright (C), 2015-2020,phy.com
 * FileName: JgitUtils
 * Author:   lingyi
 * Date:     2020/11/6 10:20
 * Description:
 * History:
 */

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lingyi
 * @create 2020/11/6
 * @since 1.0.0
 */
public class JgitUtils {

/*    public static String repoDir = "D:\\git repo";
    public static String localRepoGitConfig = "D:\\git repo\\.git";
    public static String remoteRepoURI = "git@gitlab.com:wilson/test.git";
    public static String localCodeDir = "D:/platplat";*/


    public static String remotePath = "https://github.com/Shelly-Y/m2d.git";//远程库路径
    public static String localPath = "D:\\git repo\\m2d\\";//下载已有仓库到本地路径
    public static String initPath = "D:\\test\\";//本地路径新建

    /**
     * 克隆远程库
     *
     * @throws IOException
     * @throws GitAPIException
     */

    public void testClone() throws IOException, GitAPIException {
        //设置远程服务器上的用户名和密码
        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new
                UsernamePasswordCredentialsProvider("2950001304@qq.com", "yzj123000");

        //克隆代码库命令
        CloneCommand cloneCommand = Git.cloneRepository();

        Git git = cloneCommand.setURI(remotePath) //设置远程URI
                .setBranch("master") //设置clone下来的分支
                .setDirectory(new File(localPath)) //设置下载存放路径
                .setCredentialsProvider(usernamePasswordCredentialsProvider) //设置权限验证
                .call();

        System.out.print(git.tag());
    }

    /**
     * 新建仓库
     */

    public void testCreate() throws IOException {
        //本地新建仓库地址
        Repository newRepo = FileRepositoryBuilder.create(new File(initPath + "/.git"));
        newRepo.create();
    }

    /**
     * 本地仓库新增文件
     */

    public void testAdd() throws IOException, GitAPIException {
        File myfile = new File(localPath + "/myfile.txt");
       // myfile.createNewFile();

        //git仓库地址
        Git git = new Git(new FileRepository(localPath + "/.git"));

        //添加文件
        git.add().addFilepattern(".").call();
    }

    /**
     * 本地仓库删除文件
     */

    public void deleteFiles()throws IOException, GitAPIException {

        Git git = new Git(new FileRepository(localPath + "/.git"));

        git.rm().addFilepattern("myfile.txt").call();

    }


    /**
     * 本地提交代码
     */

    public void testCommit() throws IOException, GitAPIException,
            JGitInternalException {
        //git仓库地址
        Git git = new Git(new FileRepository(localPath+"/.git"));
        //提交代码
        git.commit().setMessage("test jGit").call();
    }


    /**
     * 拉取远程仓库内容到本地
     */

    public void testPull() throws IOException, GitAPIException {

        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider =new
                UsernamePasswordCredentialsProvider("2950001304@qq.com","yzj123000");
        //git仓库地址
        Git git = new Git(new FileRepository(localPath+"/.git"));
        git.pull().setRemoteBranchName("master").
                setCredentialsProvider(usernamePasswordCredentialsProvider).call();
    }

    /**
     * push本地代码到远程仓库地址
     */

    public void testPush() throws IOException, JGitInternalException,
            GitAPIException {

        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider =new
                UsernamePasswordCredentialsProvider("2950001304@qq.com","yzj123000");
        //git仓库地址
        Git git = new Git(new FileRepository(localPath+"/.git"));
        git.push().setRemote("origin").setCredentialsProvider(usernamePasswordCredentialsProvider).call();
    }

    /**
    git differ
     */


}
