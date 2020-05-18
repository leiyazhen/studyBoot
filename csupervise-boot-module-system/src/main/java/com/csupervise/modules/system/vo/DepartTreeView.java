package com.csupervise.modules.system.vo;

import com.csupervise.modules.system.entity.SysDepart;
import com.csupervise.modules.system.model.TreeNodeModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Project Name:csupervise
 * Package Name:com.csupervise.modules.system.vo
 *
 * @Author leiyz
 * Date:2020/5/16 14:48
 */
@Data
@AllArgsConstructor
public class DepartTreeView extends TreeNodeModel implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 机构/部门名称
     */
    private String departName;

    /**
     * 排序
     */
    private Integer departOrder;

    /**
     * 机构类别 1组织机构，2岗位
     */
    private String orgCategory;

    /**
     * 机构类型 1一级部门 2子部门
     */
    private String orgType;

    /**
     * 机构编码
     */
    private String orgCode;

    public DepartTreeView(SysDepart depart) {
    this.departName=depart.getDepartName();
    this.departOrder=depart.getDepartOrder();
    this.orgCategory=depart.getOrgCategory();
    this.orgCode=depart.getOrgCode();
    this.orgType=depart.getOrgType();
    this.id=depart.getId();
    this.parentId=depart.getParentId();
    }
}
