/*
 *
 *  *
 *  *      Copyright (c) 2020-2025, leiyz All rights reserved.
 *  *
 *  *  Redistribution and use in source and binary forms, with or without
 *  *  modification, are permitted provided that the following conditions are met:
 *  *
 *  * Redistributions of source code must retain the above copyright notice,
 *  *  this list of conditions and the following disclaimer.
 *  *  Redistributions in binary form must reproduce the above copyright
 *  *  notice, this list of conditions and the following disclaimer in the
 *  *  documentation and/or other materials provided with the distribution.
 *  *  Neither the name of leiyz developer nor the names of its
 *  *  contributors may be used to endorse or promote products derived from
 *  *  this software without specific prior written permission.
 *  *  Author: leiyz (lei88119@126.com)
 *  *
 *
 *
 */

package com.csupervise.modules.system.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name:csupervise
 * Package Name:com.csupervise.modules.system.model
 *
 * @Author: leiyz
 * Date:2020/5/12 13:30
 */
@Data
public class TreeNodeModel {
    /**
     * serialVersionUID:(please write your description).
     *
     * @since JDK 1.8
     */
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String parentId;
    protected List<TreeNodeModel> children = new ArrayList<TreeNodeModel>();

    public void add(TreeNodeModel node) {
        children.add(node);
    }
}
