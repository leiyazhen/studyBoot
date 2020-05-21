import { getStore, setStore } from '@/util/store'
import { isURL, validatenull } from '@/util/validate'
import { getUserInfo, loginByUsername, logout, refreshToken } from '@/api/login'
import { deepClone, encryption } from '@/util/util'
import webiste from '@/const/website'
import { getMenu } from '@/api/admin/menu'

function addPath(ele, first) {
    const menu = webiste.menu
    const propsConfig = menu.props
    const propsDefault = {
        label: propsConfig.label || 'name',
        path: propsConfig.path || 'path',
        icon: propsConfig.icon || 'icon',
        children: propsConfig.children || 'children'
    }
    const icon = ele[propsDefault.icon]
    ele[propsDefault.icon] = validatenull(icon) ? menu.iconDefault : icon
    const isChild = ele[propsDefault.children] && ele[propsDefault.children].length !== 0 && ele[propsDefault.children][0] != 2;
    if (!isChild) ele[propsDefault.children] = []
    if (!isChild && first && !isURL(ele[propsDefault.path])) {
        ele[propsDefault.path] = ele[propsDefault.path] + '/index'
    } else {
        ele[propsDefault.children].forEach(child => {
            addPath(child)
        })
    }
}
const iconList = {
    "icon-sysmanage": "el-icon-s-tools",
    "icon-timetable": "el-icon-date",
    "icon-dutylog": "el-icon-postcard",
    "icon-regreport": "el-icon-edit-outline",
    "icon-mesg": "el-icon-message-solid",
    "icon-shortmsg": "el-icon-chat-dot-square",
    "icon-fax": "el-icon-message",
    "icon-phone": "el-icon-mobile"
}
const pageList = {
    "": "/admin",
    "/page/user": "/admin/user/index",
    "/page/role": "/admin/role/index",
    "/page/dept": "/admin/dept/index",
    "/page/dailyreceive": "/admin/dailyreceive/index",
    "/page/emergencyreceive": "/admin/emergencyreceive/index",
    "/page/dailyreport": "/admin/dailyreport/index",
    "/page/emergencyreport": "/admin/emergencyreport/index",
    "/page/mesgsend": "/admin/mesgsend/index",
    "/page/mesgreceived": "/admin/mesgreceived/index",
    "/page/shortmsgreceive": "/admin/shortmsgreceive/index",
    "/page/shortmsgdraft": "/admin/shortmsgdraft/index",
    "/page/shortmesgsend": "/admin/shortmesgsend/index",
    "/page/shotmesgbin": "/admin/shotmesgbin/index",
    "/page/fax": "/admin/fax/index",
    "/page/phone": "/admin/phone/index",
    "/page/knowledge": "/admin/knowledge/index",
    "/page/dutylog": "/admin/dutylog/index",
    "/page/timetable": "/admin/timetable/index",


}
const user = {
    state: {
        userInfo: { "userId": 2, "username": "admin", "accountName": "管理员", "password": "$2a$10$QOfWxxFyAMmEEmnuw9UI/..1s4B4eF/u9PzE2ZaGO.ij9YfmcUy.u", "newPassword": null, "salt": "", "wxOpenid": "", "qqOpenid": "", "createTime": "2020-04-27 11:51:00", "updateTime": "2020-04-27 11:51:00", "delFlag": "0", "phone": "", "avatar": "", "areaCode": "4406", "areaName": "佛山市", "tenantId": 1, "deptId": 1, "deptName": "超级管理员", "lockFlag": "0", "roleList": [{ "roleName": "管理员", "userId": null, "roleCode": "ROLE_ADMIN", "roleDesc": "管理员角色", "roleId": 4, "tenantId": null, "createTime": null, "updateTime": null, "userIdArray": null, "menuTree": null, "menuIdArray": null }], "permissions": [] },
        permissions: {},
        roles: [],
        menu: getStore({
            name: 'menu'
        }) || [],
        menuAll: [],
        expires_in: getStore({
            name: 'expires_in'
        }) || '',
        access_token: getStore({
            name: 'access_token'
        }) || '',
        refresh_token: getStore({
            name: 'refresh_token'
        }) || ''
    },
    actions: {
        // 根据用户名登录
        LoginByUsername({ commit }, userInfo) {
            // const user = encryption({
            //     data: userInfo,
            //     key: '1234567887654321',
            //     param: ['password']
            // })
            return new Promise((resolve, reject) => {
                loginByUsername(userInfo.username, userInfo.password, userInfo.code, userInfo.randomStr).then(response => {
                    const data = response.data
                    commit('SET_ACCESS_TOKEN', data.data)
                        // commit('SET_REFRESH_TOKEN', data.refresh_token)
                        // commit('SET_EXPIRES_IN', data.expires_in)
                    commit('CLEAR_LOCK')
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        },
        GetUserInfo({ commit }) {
            return new Promise((resolve, reject) => {
                resolve({})
                    // getUserInfo().then((res) => {
                    //     const data = res.data.data || {}
                    //     commit('SET_USER_INFO', data)
                    //     commit('SET_ROLES', data.roleList || [])
                    //     commit('SET_PERMISSIONS', data.permissions || [])
                    //     resolve(data)
                    // }).catch((err) => {
                    //     reject()
                    // })
            })
        },
        // 刷新token
        RefreshToken({ commit, state }) {
            return new Promise((resolve, reject) => {
                refreshToken(state.refresh_token).then(response => {
                    const data = response.data
                    commit('SET_ACCESS_TOKEN', data.access_token)
                    commit('SET_REFRESH_TOKEN', data.refresh_token)
                    commit('SET_EXPIRES_IN', data.expires_in)
                    commit('CLEAR_LOCK')
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        },
        // 登出
        LogOut({ commit }) {
            return new Promise((resolve, reject) => {
                logout().then(() => {
                    commit('SET_MENU', [])
                    commit('SET_PERMISSIONS', [])
                    commit('SET_USER_INFO', {})
                    commit('SET_ACCESS_TOKEN', '')
                    commit('SET_REFRESH_TOKEN', '')
                    commit('SET_EXPIRES_IN', '')
                    commit('SET_ROLES', [])
                    commit('DEL_ALL_TAG')
                    commit('CLEAR_LOCK')
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        },
        // 注销session
        FedLogOut({ commit }) {
            return new Promise(resolve => {
                commit('SET_MENU', [])
                commit('SET_PERMISSIONS', [])
                commit('SET_USER_INFO', {})
                commit('SET_ACCESS_TOKEN', '')
                commit('SET_REFRESH_TOKEN', '')
                commit('SET_ROLES', [])
                commit('DEL_ALL_TAG')
                commit('CLEAR_LOCK')
                resolve()
            })
        },
        // 获取系统菜单
        GetMenu({ commit }, obj) {
            return new Promise(resolve => {
                getMenu(obj.id).then((res) => {
                    const data = res.data.data
                        //递归遍历实现                   
                    var recursiveFunction = function() {
                        const getStr = function(list) {
                            list.forEach(function(row) {
                                row.spread = false;
                                row.permission = null;
                                row.label = row.name;
                                if (row.parentId != -1) {
                                    delete row.name;
                                }
                                row.icon = iconList[row.icon];
                                row.path = pageList[row.url];
                                if (row.children.length > 0 && row.children[0].menuType != 2) {
                                    getStr(row.children);
                                } else {
                                    row.hasChildren = null;
                                    delete row.children;
                                }
                            });
                        };
                        getStr(data);
                    };
                    recursiveFunction();
                    let menu = deepClone(data)
                    menu.forEach(ele => {
                        addPath(ele)
                    })
                    let type = obj.type
                    commit('SET_MENU', { type, menu })
                    resolve(menu)
                })

            })
        }

    },
    mutations: {
        SET_ACCESS_TOKEN: (state, access_token) => {
            state.access_token = access_token
            setStore({
                name: 'access_token',
                content: state.access_token,
                type: 'session'
            })
        },
        SET_EXPIRES_IN: (state, expires_in) => {
            state.expires_in = expires_in
            setStore({
                name: 'expires_in',
                content: state.expires_in,
                type: 'session'
            })
        },
        SET_REFRESH_TOKEN: (state, rfToken) => {
            state.refresh_token = rfToken
            setStore({
                name: 'refresh_token',
                content: state.refresh_token,
                type: 'session'
            })
        },
        SET_USER_INFO: (state, userInfo) => {
            state.userInfo = userInfo
        },
        SET_MENU: (state, params = {}) => {
            let { menu, type } = params;
            if (type !== false) state.menu = menu
            setStore({
                name: 'menu',
                content: menu,
                type: 'session'
            })
        },
        SET_MENU_ALL: (state, menuAll) => {
            state.menuAll = menuAll
        },
        SET_ROLES: (state, roles) => {
            state.roles = roles
        },
        SET_PERMISSIONS: (state, permissions) => {
            const list = {}
            for (let i = 0; i < permissions.length; i++) {
                list[permissions[i]] = true
            }
            state.permissions = list
        }
    }

}
export default user