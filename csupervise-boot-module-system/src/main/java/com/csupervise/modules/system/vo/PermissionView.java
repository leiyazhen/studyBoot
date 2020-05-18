package com.csupervise.modules.system.vo;

import com.csupervise.modules.system.entity.SysPermission;
import com.csupervise.modules.system.model.TreeNodeModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Project Name:csupervise
 * Package Name:com.csupervise.modules.system.vo
 *
 * @Author leiyz
 * Date:2020/5/14 22:45
 */
@Data
public class PermissionView extends TreeNodeModel implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 菜单标题
     */
    private String name;

    /**
     * 路径
     */
    private String url;

    /**
     * 组件
     */
    private String component;

    /**
     * 菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     */
    private String menuType;

    /**
     * 排序
     */
    private Integer menuOrder;

    /**
     * 菜单图标
     */
    private String icon;

    public  PermissionView(SysPermission permission)
    {
        this.component=permission.getComponent();
        this.icon=permission.getIcon();
        this.menuOrder=permission.getMenuOrder();
        this.menuType=permission.getMenuType();
        this.name=permission.getName();
        this.url=permission.getUrl();
        this.id=permission.getId();
        this.parentId=permission.getParentId();
    }
}
