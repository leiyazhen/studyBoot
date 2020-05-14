/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : duty_db

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 14/05/2020 18:01:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for biz_daily_report_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_daily_report_info`;
CREATE TABLE `biz_daily_report_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作情况描述',
  `charge_by` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  `attend` int(10) NULL DEFAULT NULL COMMENT '工作人员出勤数',
  `car` int(10) NULL DEFAULT NULL COMMENT '工作车辆出勤数',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人名称，填表人名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期，上报时间',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人登录名称，签收人名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期，签收时间',
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在单位',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '知识库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_duty_details_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_duty_details_info`;
CREATE TABLE `biz_duty_details_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `duty_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'duty_info id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `duty_date` date NULL DEFAULT NULL COMMENT '值班日期',
  `duty_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1-值班领导；2-主值班员;3-白班岗位；4-夜班岗位',
  `duty_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值班人员名称',
  `duty_uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值班人员用户表id',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '排班详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_duty_equipment_log_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_duty_equipment_log_info`;
CREATE TABLE `biz_duty_equipment_log_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `log_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'duty_log_info id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `equipment_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备检查情况',
  `elecpower_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电力设备电源关闭情况',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '值班日志对讲机' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_duty_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_duty_info`;
CREATE TABLE `biz_duty_info`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人登录名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人登录名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班表名称',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '排班基本信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_duty_intercom_log_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_duty_intercom_log_info`;
CREATE TABLE `biz_duty_intercom_log_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `log_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'duty_log_info id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `roll_call` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市应急中心对讲机点名',
  `arearoll_call` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '各区对讲机点名',
  `report` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '各区对讲机上报',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '值班日志对讲机' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_duty_log_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_duty_log_info`;
CREATE TABLE `biz_duty_log_info`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人登录名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人登录名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值班日志名称',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  `duty_order` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班次',
  `weather` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '天气',
  `duty_leader` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值班领导',
  `duty_respon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值班负责人',
  `duty_person` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值班员',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '值班日志基本信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_duty_other_log_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_duty_other_log_info`;
CREATE TABLE `biz_duty_other_log_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `log_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'duty_log_info id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `main_work` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重点工作',
  `leader_assigned` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '领导交办',
  `check_report` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '巡查上报',
  `reg_report` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '跟进登记上报信息',
  `vidio_case` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频监控案件',
  `case12345` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '12345案件',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '值班日志其他工作' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_duty_telephone_log_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_duty_telephone_log_info`;
CREATE TABLE `biz_duty_telephone_log_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `log_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'duty_log_info id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `central_tele` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城管局总值电话',
  `gas_alarm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '110转办瓶装煤气警情',
  `complain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扫黑除恶专项斗争投诉',
  `sysadvice_tele` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统咨询电话',
  `fax_report` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真查收上报',
  `defense3_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收三防信息',
  `mesg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信、qq、短信其他信息',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '值班日志电话信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_fax_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_fax_info`;
CREATE TABLE `biz_fax_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主题',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `receive_time` datetime(0) NULL DEFAULT NULL COMMENT '接收日期',
  `receive_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收人',
  `receive_unit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收单位',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  `attachment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件物理路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '值班日志对讲机' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_incident_report_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_incident_report_info`;
CREATE TABLE `biz_incident_report_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息通知内容',
  `has_report` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报送次数1-首报,2-续报',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人名称，填表人名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期，上报时间',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人登录名称，签收人名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期，签收时间',
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在单位',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '知识库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_knowledge_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_knowledge_info`;
CREATE TABLE `biz_knowledge_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '知识主题',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人登录名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人登录名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `share_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分享来源ID',
  `is_shared` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0-未分享；1-已分享',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '知识库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_notice_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_notice_info`;
CREATE TABLE `biz_notice_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息通知主题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息通知内容',
  `notice_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息通知类别1-通知公告,2-用户消息',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人名称，发送人名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期，发送日期',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人登录名称，签收人名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期，签收时间',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送状态0-失败，1-成功',
  `area_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '知识库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_shortmsg_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_shortmsg_info`;
CREATE TABLE `biz_shortmsg_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息通知内容',
  `from_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人名称，发送人名称',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期，发送日期',
  `to_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人登录名称，签收人名称',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送状态0-失败，1-成功，2-草稿',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '知识库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_depart
-- ----------------------------
DROP TABLE IF EXISTS `sys_depart`;
CREATE TABLE `sys_depart`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父机构ID',
  `depart_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构/部门名称',
  `depart_order` int(11) NULL DEFAULT 0 COMMENT '排序',
  `org_category` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1' COMMENT '机构类别 1组织机构，2岗位',
  `org_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构类型 1一级部门 2子部门',
  `org_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构编码',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_depart_parent_id`(`parent_id`) USING BTREE,
  INDEX `index_depart_org_code`(`org_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织机构表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `dict_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典编码',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除状态',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `indextable_dict_code`(`dict_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dict_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典id',
  `item_text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典项文本',
  `item_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典项值',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `sort_order` int(10) NULL DEFAULT NULL COMMENT '排序',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除状态',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_table_dict_id`(`dict_id`) USING BTREE,
  INDEX `index_table_sort_order`(`sort_order`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单标题',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件',
  `menu_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)',
  `menu_order` int(11) NULL DEFAULT NULL COMMENT '排序',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_prem_pid`(`parent_id`) USING BTREE,
  INDEX `index_menu_type`(`menu_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('00a2a0ae65cdca5e93209cdbde97cbe6', '-1', '系统管理', '', '', '0', 1, 'icon-sysmanage');
INSERT INTO `sys_permission` VALUES ('4028810971ba4d210171ba4d21d20000', '00a2a0ae65cdca5e93209cdbde97cbe6', '用户管理', '/page/user', '/page/user', '1', 1, 'icon-usermanage');
INSERT INTO `sys_permission` VALUES ('4028810971ba4e5f0171ba4e5f480000', '4028810971ba4d210171ba4d21d20000', '添加用户', '/user/add', 'sys:user:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971ba51700171ba5170cf0000', '4028810971ba4d210171ba4d21d20000', '编辑用户', '/user/edit', 'sys:user:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971ba526e0171ba526e440000', '4028810971ba4d210171ba4d21d20000', '查询用户', '/user/query', 'sys:user:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971ba53260171ba53268f0000', '4028810971ba4d210171ba4d21d20000', '删除用户', '/user/del', 'sys:user:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef30000', '00a2a0ae65cdca5e93209cdbde97cbe6', '角色管理', '/page/role', '/page/user', '1', 2, 'icon-rolemanage');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef40001', '4028810971ba546e0171ba546ef30000', '添加角色', '/role/add', 'sys:role:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef40002', '4028810971ba546e0171ba546ef30000', '编辑角色', '/role/edit', 'sys:role:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef40003', '4028810971ba546e0171ba546ef30000', '查询角色', '/role/query', 'sys:role:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef40004', '4028810971ba546e0171ba546ef30000', '删除角色', '/role/del', 'sys:role:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef40005', '00a2a0ae65cdca5e93209cdbde97cbe6', '部门管理', '/page/dept', '/page/dept', '1', 3, 'icon-deptmanage');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef40006', '4028810971ba546e0171ba546ef40005', '添加部门', '/dept/add', 'sys:dept:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef40007', '4028810971ba546e0171ba546ef40005', '编辑部门', '/dept/edit', 'sys:dept:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef40008', '4028810971ba546e0171ba546ef40005', '查询部门', '/dept/query', 'sys:dept:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971ba546e0171ba546ef40009', '4028810971ba546e0171ba546ef40005', '删除部门', '/dept/del', 'sys:dept:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40000', '-1', '班表管理', '/page/timetable', '/page/timetable', '1', 2, 'icon-timetable');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40001', '4028810971ba77110171ba7711c40000', '添加班表', '/timetable/add', 'sys:timetable:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40002', '4028810971ba77110171ba7711c40000', '编辑班表', '/timetable/edit', 'sys:timetable:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40003', '4028810971ba77110171ba7711c40000', '查询班表', '/timetable/query', 'sys:timetable:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40004', '4028810971ba77110171ba7711c40000', '删除班表', '/timetable/del', 'sys:timetable:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40005', '4028810971ba77110171ba7711c40000', '导出班表', '/timetable/export', 'sys:timetable:export', '2', 5, 'icon-export');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40006', '-1', '值班日志', '/page/dutylog', '/page/dutylog', '1', 3, 'icon-dutylog');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40007', '4028810971ba77110171ba7711c40006', '新增日志', '/dutylog/add', 'sys:dutylog:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40008', '4028810971ba77110171ba7711c40006', '编辑日志', '/dutylog/edit', 'sys:dutylog:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971ba77110171ba7711c40009', '4028810971ba77110171ba7711c40006', '查询日志', '/dutylog/query', 'sys:dutylog:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1710000', '4028810971ba77110171ba7711c40006', '删除日志', '/dutylog/del', 'sys:dutylog:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1730001', '4028810971ba77110171ba7711c40006', '导出日志', '/dutylog/export', 'sys:dutylog:export', '2', 6, 'icon-export');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1730002', '4028810971ba77110171ba7711c40006', '导出日志列表', '/dutylog/listexport', 'sys:dutylog:listexport', '2', 6, 'icon-listexport');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1730003', '-1', '登记上报', '', '', '0', 4, 'icon-regreport');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1730004', '4028810971ba89f10171ba89f1730003', '日常专项上报', '/page/dailyreport', '/page/dailyreport', '1', 1, 'icon-dailyreport');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1740005', '4028810971ba89f10171ba89f1730004', '新增上报', '/dailyreport/add', 'sys:dailyreport:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1740006', '4028810971ba89f10171ba89f1730004', '编辑上报', '/dailyreport/edit', 'sys:dailyreport:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1740007', '4028810971ba89f10171ba89f1730004', '查询上报', '/dailyreport/query', 'sys:dailyreport:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1740008', '4028810971ba89f10171ba89f1730004', '删除上报', '/dailyreport/del', 'sys:dailyreport:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971ba89f10171ba89f1740009', '4028810971ba89f10171ba89f1730003', '突发事件上报', '/page/emergencyreport', '/page/emergencyreport', '1', 2, 'icon-emergencyreport');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0000', '4028810971ba89f10171ba89f1740009', '新增上报', '/emergencyreport/add', 'sys:emergencyreport:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0001', '4028810971ba89f10171ba89f1740009', '编辑上报', '/emergencyreport/edit', 'sys:emergencyreport:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0002', '4028810971ba95040171ba95044a0005', '查询上报', '/emreportreceive/query', 'sys:emreportreceive:query', '2', 2, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0003', '4028810971ba89f10171ba89f1740009', '删除上报', '/emergencyreport/del', 'sys:emergencyreport:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0004', '4028810971ba89f10171ba89f1730003', '日常专项上报接收', '/page/dailyreceive', '/page/dailyreceive', '1', 3, 'icon-dailyreport');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0005', '4028810971ba89f10171ba89f1730003', '突发事件上报接收', '/page/emergencyreport', '/page/emreportreceive', '1', 4, 'icon-emreportreceive');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0006', '-1', '消息通知', '', '', '0', 5, 'icon-mesg');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0007', '4028810971ba95040171ba95044a0006', '我收到的', '/page/mesgreceived', '/page/mesgreceived', '1', 1, 'icon-mesgreceived');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0008', '4028810971ba95040171ba95044a0007', '签收', '/mesgreceived/claim', 'sys:mesgreceived:claim', '2', 1, 'icon-claim');
INSERT INTO `sys_permission` VALUES ('4028810971ba95040171ba95044a0009', '4028810971ba95040171ba95044a0007', '查看详情', '/mesgreceived/details', 'sys:mesgreceived:details', '2', 2, 'icon-details');
INSERT INTO `sys_permission` VALUES ('4028810971baa2b50171baa2b5230000', '4028810971ba95040171ba95044a0007', '查询列表', '/mesgreceived/query', 'sys:mesgreceived:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed10000', '4028810971ba95040171ba95044a0006', '我发送的', '/page/mesgsend', '/page/mesgsend', '1', 2, 'icon-mesgsend');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed10001', '4028810971ba95040171ba95044a0007', '发送消息', '/mesgsend/add', 'sys:mesgsend:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed10002', '4028810971ba95040171ba95044a0007', '查看详情', '/mesgsend/details', 'sys:mesgsend:details', '2', 2, 'icon-details');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed10003', '4028810971ba95040171ba95044a0007', '查询列表', '/mesgsend/query', 'sys:mesgsend:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed10004', '4028810971ba77110171ba7711c40000', '班表详情', '/timetable/details', 'sys:timetable:details', '2', 6, 'icon-details');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed10005', '4028810971ba77110171ba7711c40006', '日志详情', '/dutylog/details', 'sys:dutylog:details', '2', 5, 'icon-details');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed10006', '4028810971ba89f10171ba89f1730004', '上报详情', '/dailyreport/details', 'sys:dailyreport:details', '2', 5, 'icon-details');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed10007', '4028810971ba89f10171ba89f1740009', '上报详情', '/emergencyreport/details', 'sys:emergencyreport:details', '2', 5, 'icon-details');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed20008', '4028810971ba95040171ba95044a0005', '上报详情', '/emreportreceive/details', 'sys:emreportreceive:details', '2', 2, 'icon-details');
INSERT INTO `sys_permission` VALUES ('4028810971be5c1e0171be5c1ed20009', '-1', '手机短信', '', '', '0', 6, 'icon-shortmsg');
INSERT INTO `sys_permission` VALUES ('4028810971be81bf0171be81bf5c0000', '4028810971be5c1e0171be5c1ed20009', '收件箱', '/page/shortmsgreceive', '/page/shortmsgreceive', '1', 1, 'icon-shortmsgreceive');
INSERT INTO `sys_permission` VALUES ('4028810971be81bf0171be81bf5c0001', '4028810971be81bf0171be81bf5c0000', '删除/清空', '/shortmsgreceive/del', 'sys:shortmsgreceive:del', '2', 1, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971be81bf0171be81bf5c0002', '4028810971be81bf0171be81bf5c0000', '查看详情', '/shortmsgreceive/details', 'sys:shortmsgreceive:details', '2', 2, 'icon-details');
INSERT INTO `sys_permission` VALUES ('4028810971be81bf0171be81bf5c0003', '4028810971be81bf0171be81bf5c0000', '查询列表', '/shortmsgreceive/query', 'sys:shortmsgreceive:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971be81bf0171be81bf5c0004', '4028810971be5c1e0171be5c1ed20009', '草稿箱', '/page/shortmsgdraft', '/page/shortmsgdraft', '1', 2, 'icon-shortmsgdraft');
INSERT INTO `sys_permission` VALUES ('4028810971be81bf0171be81bf5c0005', '4028810971be81bf0171be81bf5c0008', '发送/重发消息', '/shortmesgsend/add', 'sys:shortmesgsend:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971be81bf0171be81bf5c0006', '4028810971be81bf0171be81bf5c0004', '编辑消息', '/shortmsgdraft/edit', 'sys:shortmsgdraft:edit', '2', 1, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971be81bf0171be81bf5c0007', '4028810971be81bf0171be81bf5c0008', '查询列表', '/shortmesgsend/query', 'sys:shortmesgsend:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971be81bf0171be81bf5c0008', '4028810971be5c1e0171be5c1ed20009', '发件箱', '/page/shortmesgsend', '/page/shortmesgsend', '3', 3, 'icon-shortmesgsend');
INSERT INTO `sys_permission` VALUES ('4028810971be8c310171be8c317a0000', '4028810971be81bf0171be81bf5c0004', '查询列表', '/shortmsgdraft/query', 'sys:shortmsgdraft:query', '2', 2, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971be8c310171be8c317a0001', '4028810971be81bf0171be81bf5c0004', '删除/清空', '/shortmsgdraft/del', 'sys:shortmsgdraft:del', '2', 3, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971be8c310171be8c317a0003', '4028810971be81bf0171be81bf5c0008', '编辑消息', '/shortmesgsend/edit', 'sys:shortmesgsend:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971be8c310171be8c317a0004', '4028810971be81bf0171be81bf5c0008', '删除/清空消息', '/shortmesgsend/del', 'sys:shortmesgsend:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971be8c310171be8c317a0005', '4028810971be5c1e0171be5c1ed20009', '垃圾箱', '/page/shotmesgbin', '/page/shotmesgbin', '1', 4, 'icon-bin');
INSERT INTO `sys_permission` VALUES ('4028810971be8c310171be8c317a0006', '4028810971be8c310171be8c317a0005', '查询列表', '/shotmesgbin/query', 'sys:shotmesgbin:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971be8c310171be8c317a0007', '4028810971be8c310171be8c317a0005', '删除/清空消息', '/shotmesgbin/del', 'sys:shotmesgbin:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971be8c310171be8c317b0008', '-1', '传真件管理', '/page/fax', '/page/fax', '1', 7, 'icon-fax');
INSERT INTO `sys_permission` VALUES ('4028810971be8c310171be8c317b0009', '4028810971be8c310171be8c317b0008', '查看附件', '/fax/file', 'sys:fax:file', '2', 5, 'icon-file');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0000', '4028810971be8c310171be8c317b0008', '导出列表', '/fax/export', 'sys:fax:export', '2', 6, 'icon-export');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0001', '-1', '电话接听管理', '/page/phone', '/page/phone', '1', 8, 'icon-phone');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0002', '4028810971bea9370171bea9378a0001', '新增', '/phone/add', 'sys:phone:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0003', '4028810971bea9370171bea9378a0001', '编辑', '/phone/edit', 'sys:phone:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0004', '4028810971bea9370171bea9378a0001', '查询', '/phone/query', 'sys:phone:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0005', '4028810971bea9370171bea9378a0001', '删除', '/phone/del', 'sys:phone:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0006', '4028810971bea9370171bea9378a0001', '查看附件', '/phone/file', 'sys:phone:file', '2', 5, 'icon-file');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0007', '-1', '知识库管理', '/page/knowledge', '/page/knowledge', '1', 9, 'icon-phone');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0008', '4028810971bea9370171bea9378a0007', '新增', '/knowledge/add', 'sys:knowledge:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971bea9370171bea9378a0009', '4028810971bea9370171bea9378a0007', '编辑', '/knowledge/edit', 'sys:knowledge:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971beb0890171beb0894c0000', '4028810971bea9370171bea9378a0007', '查询', '/knowledge/query', 'sys:knowledge:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971beb0890171beb0894d0001', '4028810971bea9370171bea9378a0007', '删除', '/knowledge/del', 'sys:knowledge:del', '2', 4, 'icon-del');
INSERT INTO `sys_permission` VALUES ('4028810971beb0890171beb0894d0002', '4028810971bea9370171bea9378a0007', '分享', '/knowledge/share', 'sys:knowledge:share', '2', 5, 'icon-share');
INSERT INTO `sys_permission` VALUES ('4028810971beb0890171beb0894d0003', '4028810971bea9370171bea9378a0007', '取消分享', '/knowledge/unshare', 'sys:knowledge:unshare', '2', 5, 'icon-unshare');
INSERT INTO `sys_permission` VALUES ('4028810971c0006f0171c0006ffc0000', '4028810971ba95040171ba95044a0004', '汇总导出', '/dailyreceive/export', 'sys:dailyreceive:export', '2', 1, 'icon-export');
INSERT INTO `sys_permission` VALUES ('4028810971c0006f0171c0006ffd0001', '4028810971ba95040171ba95044a0004', '查询上报', '/dailyreceive/query', 'sys:dailyreceive:query', '2', 2, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971c0006f0171c0006ffd0002', '4028810971ba95040171ba95044a0005', '导出上报', '/emergencyreport/export', 'sys:emergencyreport:export', '2', 2, 'icon-export');
INSERT INTO `sys_permission` VALUES ('4028810971c0006f0171c0006ffd0003', '4028810971ba89f10171ba89f1740009', '查询上报', '/emergencyreport/query', 'sys:emergencyreport:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971c0006f0171c0006ffd0004', '4028810971be8c310171be8c317b0008', '新增', '/fax/add', 'sys:fax:add', '2', 1, 'icon-add');
INSERT INTO `sys_permission` VALUES ('4028810971c0006f0171c0006ffd0005', '4028810971be8c310171be8c317b0008', '编辑', '/fax/edit', 'sys:fax:edit', '2', 2, 'icon-edit');
INSERT INTO `sys_permission` VALUES ('4028810971c0006f0171c0006ffd0006', '4028810971be8c310171be8c317b0008', '查询', '/fax/query', 'sys:fax:query', '2', 3, 'icon-query');
INSERT INTO `sys_permission` VALUES ('4028810971c0006f0171c0006ffd0007', '4028810971be8c310171be8c317b0008', '删除', '/fax/del', 'sys:fax:del', '2', 4, 'icon-del');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `role_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除状态',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniq_sys_role_role_code`(`role_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_group_role_per_id`(`role_id`, `permission_id`) USING BTREE,
  INDEX `index_group_role_id`(`role_id`) USING BTREE,
  INDEX `index_group_per_id`(`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `realname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'md5密码盐',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别(0-默认未知,1-男,2-女)',
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `org_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构编码',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别(1-正常,2-冻结)',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除状态(0-正常,1-已删除)',
  `post` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务，关联职务表',
  `telephone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '座机号',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_user_name`(`username`) USING BTREE,
  INDEX `index_user_status`(`status`) USING BTREE,
  INDEX `index_user_del_flag`(`del_flag`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('00a2a0ae65cdca5e93209cdbde97cbe6', 'admin', '管理员', 'cb362cfeefbf3d8d', 'RCGTeGiH', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_depart
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_depart`;
CREATE TABLE `sys_user_depart`  (
  `ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `dep_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `index_depart_groupk_userid`(`user_id`) USING BTREE,
  INDEX `index_depart_groupkorgid`(`dep_id`) USING BTREE,
  INDEX `index_depart_groupk_uidanddid`(`user_id`, `dep_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index2_groupuu_user_id`(`user_id`) USING BTREE,
  INDEX `index2_groupuu_ole_id`(`role_id`) USING BTREE,
  INDEX `index2_groupuu_useridandroleid`(`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
