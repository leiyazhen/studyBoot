/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */
import { getDetails } from '@/api/admin/user'

var validateUsername = (rule, value, callback) => {
    getDetails(value).then(response => {
        if (window.boxType === 'edit') callback()
        let result = response.data.data
        if (result !== null) {
            callback(new Error('用户名已经存在'))
        } else {
            callback()
        }
    })
}

// 设置手机号的验证规则
const checkPhone = (rule, value, callback) => {
    if (!value) {
        callback(new Error('请输入联系方式'))
    } else {
        const reg = /^1[3|4|5|7|8][0-9]\d{8}$/
        if (reg.test(value)) {
            callback()
        } else {
            return callback(new Error('请输入正确的电话'))
        }
    }
}

export const tableOption = {
    border: true,
    index: true,
    indexLabel: '序号',
    stripe: true,
    menuAlign: 'center',
    searchMenuSpan: 8,
    editBtn: true,
    delBtn: true,
    align: 'center',
    addBtn: true,
    column: [{
        fixed: true,
        label: 'id',
        prop: 'userId',
        span: 24,
        hide: true,
        editDisabled: true,
        addDisplay: false
    }, {
        fixed: true,
        label: '用户名',
        prop: 'username',
        editDisabled: true,
        slot: true,
        search: true,
        span: 24,
        rules: [{
                required: true,
                message: '请输入用户名'
            },
            {
                min: 3,
                max: 20,
                message: '长度在 3 到 20 个字符',
                trigger: 'blur'
            },
            { validator: validateUsername, trigger: 'blur' }
        ]
    }, {
        label: '密码',
        prop: 'password',
        type: 'password',
        value: '',
        hide: true,
        span: 24,
        rules: [{
            min: 6,
            max: 20,
            message: '长度在 6 到 20 个字符',
            trigger: 'blur'
        }]
    }, {
        label: '所属部门',
        prop: 'deptId',
        formslot: true,
        slot: true,
        span: 24,
        hide: true,
        rules: [{
            required: true,
            message: '请选择部门',
            trigger: 'change'
        }]
    }, {
        label: '手机号',
        prop: 'phone',
        type: 'phone',
        value: '',
        span: 24,
        rules: [{ validator: checkPhone, trigger: 'blur' }]
    }, {
        label: '角色',
        prop: 'role',
        formslot: true,
        slot: true,
        overHidden: true,
        span: 24,
        rules: [{
            required: true,
            message: '请选择角色',
            trigger: 'blur'
        }]
    }, {
        label: '部门',
        prop: 'deptName',
        overHidden: true,
        addDisplay: false,
        editDisplay: false,
        span: 24,
    }, {
        label: '状态',
        prop: 'lockFlag',
        type: 'radio',
        slot: true,
        border: true,
        span: 24,
        rules: [{
            required: true,
            message: '请选择状态',
            trigger: 'blur'
        }],
        dicData: [{
            label: '有效',
            value: '0'
        }, {
            label: '锁定',
            value: '9'
        }]
    }, {
        width: 120,
        label: '创建时间',
        prop: 'createTime',
        type: 'datetime',
        format: 'yyyy-MM-dd',
        editDisabled: true,
        addDisplay: false,
        span: 24
    }]
}