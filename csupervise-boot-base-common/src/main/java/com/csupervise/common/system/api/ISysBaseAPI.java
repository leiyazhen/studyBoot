package com.csupervise.common.system.api;

import com.csupervise.common.system.vo.DictModel;
import com.csupervise.common.system.vo.LoginUser;
import com.csupervise.common.system.vo.SysCategoryModel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Description: 底层共通业务API，提供其他独立模块调用
 * @Author: leiyz
 * @Date:2019-4-20
 * @Version:V1.0
 */
public interface ISysBaseAPI {



    /**
     * 根据用户账号查询用户信息
     *
     * @param username
     * @return
     */
    public LoginUser getUserByName(String username);

    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    public LoginUser getUserById(String id);

    /**
     * 通过用户账号查询角色集合
     *
     * @param username
     * @return
     */
    public List<String> getRolesByUsername(String username);

    /**
     * 通过用户账号查询部门集合
     *
     * @param username
     * @return 部门 id
     */
    List<String> getDepartIdsByUsername(String username);

    /**
     * 通过用户账号查询部门 name
     *
     * @param username
     * @return 部门 name
     */
    List<String> getDepartNamesByUsername(String username);



    /**
     * 获取数据字典
     *
     * @param code
     * @return
     */
    public List<DictModel> queryDictItemsByCode(String code);

    /**
     * 查询所有的父级字典，按照create_time排序
     */
    public List<DictModel> queryAllDict();

    /**
     * 查询所有分类字典
     *
     * @return
     */
    public List<SysCategoryModel> queryAllDSysCategory();



    /**
     * 发送系统消息
     *
     * @param fromUser   发送人(用户登录账户)
     * @param toUser     发送给(用户登录账户)
     * @param title      消息主题
     * @param msgContent 消息内容
     */
    public void sendSysAnnouncement(String fromUser, String toUser, String title, String msgContent);

    /**
     * 发送系统消息
     *
     * @param fromUser     发送人(用户登录账户)
     * @param toUser       发送给(用户登录账户)
     * @param title        通知标题
     * @param map          模板参数
     * @param templateCode 模板编码
     */
    public void sendSysAnnouncement(String fromUser, String toUser, String title, Map<String, String> map, String templateCode);

    /**
     * @param fromUser     发送人(用户登录账户)
     * @param toUser       发送给(用户登录账户)
     * @param title        通知标题
     * @param map          模板参数
     * @param templateCode 模板编码
     * @param busType      业务类型
     * @param busId        业务id
     */
    public void sendSysAnnouncement(String fromUser, String toUser, String title, Map<String, String> map, String templateCode, String busType, String busId);

    /**
     * 通过消息中心模板，生成推送内容
     *
     * @param templateCode 模板编码
     * @param map          模板参数
     * @return
     */
    public String parseTemplateByCode(String templateCode, Map<String, String> map);


    /**
     * 发送系统消息
     *
     * @param fromUser       发送人(用户登录账户)
     * @param toUser         发送给(用户登录账户)
     * @param title          消息主题
     * @param msgContent     消息内容
     * @param setMsgCategory 消息类型 1:消息2:系统消息
     */
    public void sendSysAnnouncement(String fromUser, String toUser, String title, String msgContent, String setMsgCategory);

    /**
     * queryTableDictByKeys
     * 发送系统消息
     *
     * @param fromUser       发送人(用户登录账户)
     * @param toUser         发送给(用户登录账户)
     * @param title          消息主题
     * @param msgContent     消息内容
     * @param setMsgCategory 消息类型 1:消息2:系统消息
     * @param busType        业务类型
     * @param busId          业务id
     */
    public void sendSysAnnouncement(String fromUser, String toUser, String title, String msgContent, String setMsgCategory, String busType, String busId);

    /**
     * 根据业务类型及业务id修改消息已读
     *
     * @param busType
     * @param busId
     */
    public void updateSysAnnounReadFlag(String busType, String busId);

    /**
     * 文件上传
     *
     * @param file       文件
     * @param bizPath    自定义路径
     * @param uploadType 上传方式
     * @return
     */
    public String upload(MultipartFile file, String bizPath, String uploadType);



    /**
     * 文档管理文件下载预览
     *
     * @param filePath
     * @param uploadpath
     * @param response
     */
    public void viewAndDownload(String filePath, String uploadpath, String uploadType, HttpServletResponse response);


    /**
     * 给指定用户发消息
     *
     * @param userIds
     * @param cmd
     */
    public void sendWebSocketMsg(String[] userIds, String cmd);

}
