package com.csupervise.modules.system.vo;

import com.csupervise.modules.system.entity.SysRole;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Project Name:csupervise
 * Package Name:com.csupervise.modules.system.vo
 *
 * @Author leiyz
 * Date:2020/5/16 19:33
 */
@Data
public class RolePermissionView implements Serializable {

    /**
     * serialVersionUID:(please write your description).
     *
     * @since JDK 1.8
     */
    private static final long serialVersionUID = 1L;
    private String roleName;
    private String roleCode;

    private String roleDesc;
    private String roleId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    /**
     * 菜单权限树
     */
    private List<PermissionView> permissionTree;
    private List<String> permissionIds;

    public  RolePermissionView(SysRole role)
    {
        this.roleCode=role.getRoleCode();
        this.roleDesc=role.getDescription();
        this.roleName=role.getRoleName();
        this.roleId=role.getId();
    }
}
