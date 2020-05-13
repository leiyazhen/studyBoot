
**csupervise-Boot 后台服务API接口文档**


**简介**：后台API接口

**HOST**:192.168.1.137:8080

**联系人**:csupervise

**Version**:1.0

**接口路径**：/v2/api-docs


# 用户登录

## 登录接口


**接口描述**:


**接口地址**:`/sys/login`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"captcha": "",
	"checkKey": "",
	"password": "",
	"username": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|sysLoginModel| sysLoginModel  | body | true |SysLoginModel  | SysLoginModel   |

**schema属性说明**



**SysLoginModel**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|captcha| 验证码  | body | false |string  |    |
|checkKey| 验证码key  | body | false |string  |    |
|password| 密码  | body | false |string  |    |
|username| 账号  | body | false |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": "",
	"mesg": "",
	"timestamp": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |string  |    |
|mesg|   |string  |    |
|timestamp|   |string(date-time)  | string(date-time)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result«string»|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 获取验证码


**接口描述**:


**接口地址**:`/sys/randomImage/{key}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|key| key  | path | true |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": "",
	"mesg": "",
	"timestamp": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |string  |    |
|mesg|   |string  |    |
|timestamp|   |string(date-time)  | string(date-time)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result«string»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 用户管理
## 新增用户


**接口描述**:


**接口地址**:`/system/sysUser/add`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"avatar": "",
	"createBy": "",
	"createTime": "",
	"delFlag": "",
	"departs": [
		{
			"createBy": "",
			"createTime": "",
			"delFlag": "",
			"departName": "",
			"departOrder": 0,
			"id": "",
			"orgCategory": "",
			"orgCode": "",
			"orgType": "",
			"parentId": "",
			"updateBy": "",
			"updateTime": ""
		}
	],
	"email": "",
	"id": "",
	"orgCode": "",
	"password": "",
	"permissions": [
		{
			"component": "",
			"icon": "",
			"id": "",
			"menuOrder": 0,
			"menuType": "",
			"name": "",
			"parentId": "",
			"url": ""
		}
	],
	"phone": "",
	"post": "",
	"realname": "",
	"roles": [
		{
			"createBy": "",
			"createTime": "",
			"delFlag": "",
			"description": "",
			"id": "",
			"roleCode": "",
			"roleName": "",
			"updateBy": "",
			"updateTime": ""
		}
	],
	"salt": "",
	"selectDeparts": "",
	"selectRoles": "",
	"sex": "",
	"status": "",
	"telephone": "",
	"updateBy": "",
	"updateTime": "",
	"username": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|view| view  | body | true |UserView  | UserView   |

**schema属性说明**



**UserView**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|avatar|   | body | false |string  |    |
|createBy|   | body | false |string  |    |
|createTime|   | body | false |string(date-time)  |    |
|delFlag|   | body | false |string  |    |
|departs|   | body | false |array  | SysDepart   |
|email| 电子邮箱  | body | false |string  |    |
|id|   | body | false |string  |    |
|orgCode|   | body | false |string  |    |
|password| 密码  | body | false |string  |    |
|permissions|   | body | false |array  | SysPermission   |
|phone| 手机号码  | body | false |string  |    |
|post| 职务  | body | false |string  |    |
|realname| 真实姓名  | body | false |string  |    |
|roles|   | body | false |array  | SysRole   |
|salt|   | body | false |string  |    |
|selectDeparts| 添加用户选择部门id，逗号分隔  | body | false |string  |    |
|selectRoles| 添加用户选择角色id，逗号分隔  | body | false |string  |    |
|sex| 性别,0-默认未知,1-男,2-女  | body | false |string  |    |
|status|   | body | false |string  |    |
|telephone| 座机电话  | body | false |string  |    |
|updateBy|   | body | false |string  |    |
|updateTime|   | body | false |string(date-time)  |    |
|username| 登陆账号  | body | false |string  |    |

**SysDepart**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|createBy| 创建人  | body | false |string  |    |
|createTime| 创建时间  | body | false |string(date-time)  |    |
|delFlag|   | body | false |string  |    |
|departName|   | body | false |string  |    |
|departOrder|   | body | false |integer(int32)  |    |
|id| ID  | body | false |string  |    |
|orgCategory|   | body | false |string  |    |
|orgCode|   | body | false |string  |    |
|orgType|   | body | false |string  |    |
|parentId|   | body | false |string  |    |
|updateBy| 更新人  | body | false |string  |    |
|updateTime| 更新时间  | body | false |string(date-time)  |    |

**SysPermission**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|component|   | body | false |string  |    |
|icon|   | body | false |string  |    |
|id|   | body | false |string  |    |
|menuOrder|   | body | false |integer(int32)  |    |
|menuType|   | body | false |string  |    |
|name|   | body | false |string  |    |
|parentId|   | body | false |string  |    |
|url|   | body | false |string  |    |

**SysRole**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|createBy| 创建人  | body | false |string  |    |
|createTime| 创建时间  | body | false |string(date-time)  |    |
|delFlag|   | body | false |string  |    |
|description|   | body | false |string  |    |
|id| ID  | body | false |string  |    |
|roleCode|   | body | false |string  |    |
|roleName|   | body | false |string  |    |
|updateBy| 更新人  | body | false |string  |    |
|updateTime| 更新时间  | body | false |string(date-time)  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"mesg": "",
	"timestamp": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|mesg|   |string  |    |
|timestamp|   |string(date-time)  | string(date-time)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||

