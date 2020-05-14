<template>
  <div class="avue-sidebar">
    <logo></logo>
    <el-scrollbar style="height:100%">
      <div v-if="validatenull(menu)" class="avue-sidebar--tip">没有发现菜单</div>
      <el-menu
        unique-opened
        :default-active="nowTagValue"
        mode="vertical"
        :show-timeout="200"
        :collapse="keyCollapse"
      >
        <sidebar-item
          :menu="menu"
          :screen="screen"
          first
          :props="website.menu.props"
          :collapse="keyCollapse"
        ></sidebar-item>
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import logo from "../logo";
import sidebarItem from "./sidebarItem";

export default {
  name: "sidebar",
  components: { sidebarItem, logo },
  data() {
    return {
      menu: [
        {
          id: 1,
          parentId: -1,
          children: [
            // {
            //   id: 1500,
            //   parentId: 1000,
            //   children: [],
            //   icon: "icon-erji-zuhushouye",
            //   name: "租户管理",
            //   spread: false,
            //   path: "/admin/tenant/index",
            //   keepAlive: "0",
            //   permission: "",
            //   type: "0",
            //   label: "租户管理",
            //   sort: 5,
            //   hasChildren: null
            // }
          ],
          icon: "el-icon-s-home",
          name: "首页",
          spread: false,
          path: "/wel",
          keepAlive: "0",
          permission: null,
          type: "2",
          label: "首页",
          sort: 0,
          hasChildren: null
        },
        {
          id: 2,
          parentId: -1,
          children: [
            // {
            //   id: 2100,
            //   parentId: 2000,
            //   children: [],
            //   icon: "icon-rizhiguanli",
            //   name: "日志管理",
            //   spread: false,
            //   path: "/admin/log/index",
            //   keepAlive: "0",
            //   permission: null,
            //   type: "0",
            //   label: "日志管理",
            //   sort: 5,
            //   hasChildren: null
            // },
            // {
            //   id: 10000,
            //   parentId: 2000,
            //   children: [],
            //   icon: "icon-wenjianguanli",
            //   name: "文件管理",
            //   spread: false,
            //   path: "/admin/file/index",
            //   keepAlive: "1",
            //   permission: null,
            //   type: "0",
            //   label: "文件管理",
            //   sort: 6,
            //   hasChildren: null
            // },
            // {
            //   id: 2200,
            //   parentId: 2000,
            //   children: [],
            //   icon: "icon-navicon-zdgl",
            //   name: "字典管理",
            //   spread: false,
            //   path: "/admin/dict/index",
            //   keepAlive: "0",
            //   permission: null,
            //   type: "0",
            //   label: "字典管理",
            //   sort: 6,
            //   hasChildren: null
            // },
            // {
            //   id: 2210,
            //   parentId: 2000,
            //   children: [],
            //   icon: "icon-canshu",
            //   name: "参数管理",
            //   spread: false,
            //   path: "/admin/param/index",
            //   keepAlive: "1",
            //   permission: null,
            //   type: "0",
            //   label: "参数管理",
            //   sort: 7,
            //   hasChildren: null
            // },
            // {
            //   id: 2800,
            //   parentId: 2000,
            //   children: [],
            //   icon: "icon-guanwangfangwen",
            //   name: "Quartz管理",
            //   spread: false,
            //   path: "/daemon/job-manage/index",
            //   keepAlive: "0",
            //   permission: "",
            //   type: "0",
            //   label: "Quartz管理",
            //   sort: 8,
            //   hasChildren: null
            // },
            // {
            //   id: 2400,
            //   parentId: 2000,
            //   children: [],
            //   icon: "icon-shouji",
            //   name: "终端管理",
            //   spread: false,
            //   path: "/admin/client/index",
            //   keepAlive: "0",
            //   permission: "",
            //   type: "0",
            //   label: "终端管理",
            //   sort: 9,
            //   hasChildren: null
            // },
            // {
            //   id: 2500,
            //   parentId: 2000,
            //   children: [],
            //   icon: "icon-miyue",
            //   name: "密钥管理",
            //   spread: false,
            //   path: "/admin/social/index",
            //   keepAlive: "0",
            //   permission: "",
            //   type: "0",
            //   label: "密钥管理",
            //   sort: 10,
            //   hasChildren: null
            // },
            // {
            //   id: 2600,
            //   parentId: 2000,
            //   children: [],
            //   icon: "icon-denglvlingpai",
            //   name: "令牌管理",
            //   spread: false,
            //   path: "/admin/token/index",
            //   keepAlive: "0",
            //   permission: null,
            //   type: "0",
            //   label: "令牌管理",
            //   sort: 11,
            //   hasChildren: null
            // },
            // {
            //   id: 2700,
            //   parentId: 2000,
            //   children: [],
            //   icon: "icon-luyou",
            //   name: "动态路由",
            //   spread: false,
            //   path: "/admin/route/index",
            //   keepAlive: "0",
            //   permission: null,
            //   type: "0",
            //   label: "动态路由",
            //   sort: 12,
            //   hasChildren: null
            // }
          ],
          icon: "el-icon-date",
          name: "排班管理",
          spread: false,
          path: "/admin",
          keepAlive: "0",
          permission: null,
          type: "0",
          label: "排班管理",
          sort: 1,
          hasChildren: null
        },
        {
          id: 3,
          parentId: -1,
          children: [
            // {
            //   id: 3100,
            //   parentId: 3000,
            //   children: [],
            //   icon: "icon-server",
            //   name: "服务监控",
            //   spread: false,
            //   path: "/monitor/monitor",
            //   keepAlive: "0",
            //   permission: null,
            //   type: "0",
            //   label: "服务监控",
            //   sort: 0,
            //   hasChildren: null
            // },
            // {
            //   id: 3500,
            //   parentId: 3000,
            //   children: [],
            //   icon: "icon-guanwangfangwen",
            //   name: "流量监控",
            //   spread: false,
            //   path: "/monitor/sentient",
            //   keepAlive: "0",
            //   permission: null,
            //   type: "0",
            //   label: "流量监控",
            //   sort: 0,
            //   hasChildren: null
            // },
            // {
            //   id: 3110,
            //   parentId: 3000,
            //   children: [],
            //   icon: "icon-qingchuhuancun",
            //   name: "缓存监控",
            //   spread: false,
            //   path: "/monitor/redis/index",
            //   keepAlive: "1",
            //   permission: null,
            //   type: "0",
            //   label: "缓存监控",
            //   sort: 1,
            //   hasChildren: null
            // },
            // {
            //   id: 3200,
            //   parentId: 3000,
            //   children: [],
            //   icon: "icon-wendang",
            //   name: "接口文档",
            //   spread: false,
            //   path: "/monitor/doc1",
            //   keepAlive: "0",
            //   permission: null,
            //   type: "0",
            //   label: "接口文档",
            //   sort: 1,
            //   hasChildren: null
            // },
            // {
            //   id: 3300,
            //   parentId: 3000,
            //   children: [],
            //   icon: "icon-gtsquanjushiwufuwuGTS",
            //   name: "事务监控",
            //   spread: false,
            //   path: "/tx/index",
            //   keepAlive: "0",
            //   permission: null,
            //   type: "0",
            //   label: "事务监控",
            //   sort: 5,
            //   hasChildren: null
            // },
            // {
            //   id: 3400,
            //   parentId: 3000,
            //   children: [],
            //   icon: "icon-online",
            //   name: "在线事务",
            //   spread: false,
            //   path: "/tx/model",
            //   keepAlive: "0",
            //   permission: null,
            //   type: "0",
            //   label: "在线事务",
            //   sort: 6,
            //   hasChildren: null
            // },
            // {
            //   id: 3600,
            //   parentId: 3000,
            //   children: [],
            //   icon: "icon-gtsquanjushiwufuwuGTS",
            //   name: "Quartz日志",
            //   spread: false,
            //   path: "/daemon/job-log/index",
            //   keepAlive: "0",
            //   permission: "",
            //   type: "0",
            //   label: "Quartz日志",
            //   sort: 8,
            //   hasChildren: null
            // }
          ],
          icon: "el-icon-postcard",
          name: "值班日志管理",
          spread: false,
          path: "/daemon",
          keepAlive: "0",
          permission: null,
          type: "0",
          label: "值班日志管理",
          sort: 2,
          hasChildren: null
        },
        {
          id: 4,
          parentId: -1,
          children: [
            {
              id: 41,
              parentId: 4,
              children: [],
              icon: "",
              name: "我发送的",
              spread: false,
              path: "/activiti/index",
              keepAlive: "0",
              permission: null,
              type: "0",
              label: "我发送的",
              sort: 1,
              hasChildren: null
            },
            {
              id: 42,
              parentId: 4,
              children: [],
              icon: "",
              name: "我收到的",
              spread: false,
              path: "/activiti/process",
              keepAlive: "0",
              permission: "/activiti/process",
              type: "0",
              label: "我收到的",
              sort: 2,
              hasChildren: null
            }
            // {
            //   id: 4300,
            //   parentId: 4000,
            //   children: [],
            //   icon: "icon-qingjia",
            //   name: "请假管理",
            //   spread: false,
            //   path: "/activiti/leave",
            //   keepAlive: "0",
            //   permission: "/activiti/leave",
            //   type: "0",
            //   label: "请假管理",
            //   sort: 3,
            //   hasChildren: null
            // },
            // {
            //   id: 4400,
            //   parentId: 4000,
            //   children: [],
            //   icon: "icon-renwu",
            //   name: "待办任务",
            //   spread: false,
            //   path: "/activiti/task",
            //   keepAlive: "0",
            //   permission: "/activiti/task",
            //   type: "0",
            //   label: "待办任务",
            //   sort: 4,
            //   hasChildren: null
            // }
          ],
          icon: "el-icon-news",
          name: "通知公告",
          spread: false,
          path: "/activti",
          keepAlive: "0",
          permission: null,
          type: "0",
          label: "通知公告",
          sort: 3,
          hasChildren: null
        },
        {
          id: 5,
          parentId: -1,
          children: [
            {
              id: 51,
              parentId: 5,
              children: [],
              icon: "",
              name: "我发送的",
              spread: false,
              path: "/mp/wxmenu/index",
              keepAlive: "1",
              permission: null,
              type: "0",
              label: "我发送的",
              sort: 6,
              hasChildren: null
            },
            {
              id: 52,
              parentId: 5,
              children: [],
              icon: "",
              name: "我收到的",
              spread: false,
              path: "/mp/wxstatistics/index",
              keepAlive: "1",
              permission: null,
              type: "0",
              label: "我收到的",
              sort: 7,
              hasChildren: null
            }
            // {
            //   id: 6200,
            //   parentId: 6000,
            //   children: [],
            //   icon: "icon-fensiguanli",
            //   name: "粉丝管理",
            //   spread: false,
            //   path: "/mp/wxaccountfans/index",
            //   keepAlive: "0",
            //   permission: "",
            //   type: "0",
            //   label: "粉丝管理",
            //   sort: 8,
            //   hasChildren: null
            // },
            // {
            //   id: 6300,
            //   parentId: 6000,
            //   children: [],
            //   icon: "icon-xiaoxiguanli",
            //   name: "消息管理",
            //   spread: false,
            //   path: "/mp/wxfansmsg/index",
            //   keepAlive: "0",
            //   permission: "",
            //   type: "0",
            //   label: "消息管理",
            //   sort: 8,
            //   hasChildren: null
            // },
            // {
            //   id: 6100,
            //   parentId: 6000,
            //   children: [],
            //   icon: "icon-weixincaidan",
            //   name: "账号管理",
            //   spread: false,
            //   path: "/mp/wxaccount/index",
            //   keepAlive: "0",
            //   permission: "",
            //   type: "0",
            //   label: "账号管理",
            //   sort: 8,
            //   hasChildren: null
            // }
          ],
          icon: "el-icon-bell",
          name: "系统消息",
          spread: false,
          path: "/mp",
          keepAlive: "0",
          permission: null,
          type: "0",
          label: "系统消息",
          sort: 4,
          hasChildren: null
        },
        {
          id: 6,
          parentId: -1,
          children: [
            {
              id: 61,
              parentId: 6,
              children: [],
              icon: "",
              name: "日常专项上报",
              spread: false,
              path: "/pay/cd/index",
              keepAlive: "1",
              permission: null,
              type: "0",
              label: "日常专项上报",
              sort: 0,
              hasChildren: null
            },
            {
              id: 62,
              parentId: 6,
              children: [],
              icon: "",
              name: "突发事件上报",
              spread: false,
              path: "/pay/paychannel/index",
              keepAlive: "1",
              permission: null,
              type: "0",
              label: "突发事件上报",
              sort: 1,
              hasChildren: null
            },
            {
              id: 63,
              parentId: 6,
              children: [],
              icon: "",
              name: "突发事件上报接收",
              spread: false,
              path: "/pay/goods/index",
              keepAlive: "0",
              permission: "",
              type: "0",
              label: "突发事件上报接收",
              sort: 2,
              hasChildren: null
            },
            {
              id: 64,
              parentId: 6,
              children: [],
              icon: "",
              name: "日常出勤专项上报接收",
              spread: false,
              path: "/pay/orders/index",
              keepAlive: "0",
              permission: "",
              type: "0",
              label: "日常出勤专项上报接收",
              sort: 3,
              hasChildren: null
            }
            // {
            //   id: 5500,
            //   parentId: 5000,
            //   children: [],
            //   icon: "icon-huitiao",
            //   name: "回调记录",
            //   spread: false,
            //   path: "/pay/notify/index",
            //   keepAlive: "0",
            //   permission: "",
            //   type: "0",
            //   label: "回调记录",
            //   sort: 4,
            //   hasChildren: null
            // }
          ],
          icon: "el-icon-document-checked",
          name: "登记上报",
          spread: false,
          path: "/pay",
          keepAlive: "1",
          permission: null,
          type: "0",
          label: "登记上报",
          sort: 5,
          hasChildren: null
        },
        {
          id: 7,
          parentId: -1,
          children: [
            {
              id: 71,
              parentId: 7,
              children: [],
              icon: "",
              name: "发件箱",
              spread: false,
              path: "/gen/datasource",
              keepAlive: "1",
              permission: null,
              type: "0",
              label: "发件箱",
              sort: 0,
              hasChildren: null
            },
            {
              id: 72,
              parentId: 7,
              children: [],
              icon: "",
              name: "垃圾箱",
              spread: false,
              path: "/gen/index",
              keepAlive: "0",
              permission: "",
              type: "0",
              label: "垃圾箱",
              sort: 1,
              hasChildren: null
            },
            {
              id: 73,
              parentId: 7,
              children: [],
              icon: "",
              name: "草稿箱",
              spread: false,
              path: "/gen/design",
              keepAlive: "1",
              permission: null,
              type: "0",
              label: "草稿箱",
              sort: 2,
              hasChildren: null
            },
            {
              id: 74,
              parentId: 7,
              children: [],
              icon: "",
              name: "收件箱",
              spread: false,
              path: "/gen/form",
              keepAlive: "0",
              permission: "",
              type: "0",
              label: "收件箱",
              sort: 3,
              hasChildren: null
            }
          ],
          icon: "el-icon-chat-dot-square",
          name: "短信管理",
          spread: false,
          path: "/dx",
          keepAlive: "1",
          permission: null,
          type: "0",
          label: "短信管理",
          sort: 6,
          hasChildren: null
        },
        {
          id: 8,
          parentId: -1,
          children: [
            {
              id: 1100,
              parentId: 1000,
              children: [],
              icon: "",
              name: "用户管理",
              spread: false,
              path: "/admin/user/index",
              keepAlive: "1",
              permission: null,
              type: "0",
              label: "用户管理",
              sort: 1,
              hasChildren: null
            },
            {
              id: 1300,
              parentId: 1000,
              children: [],
              icon: "",
              name: "角色管理",
              spread: false,
              path: "/admin/role/index",
              keepAlive: "0",
              permission: null,
              type: "0",
              label: "角色管理",
              sort: 3,
              hasChildren: null
            },
            {
              id: 1400,
              parentId: 1000,
              children: [],
              icon: "",
              name: "部门管理",
              spread: false,
              path: "/admin/dept/index",
              keepAlive: "0",
              permission: null,
              type: "0",
              label: "部门管理",
              sort: 4,
              hasChildren: null
            }
          ],
          icon: "el-icon-monitor",
          name: "后台维护管理",
          spread: false,
          path: "/ht",
          keepAlive: "1",
          permission: null,
          type: "0",
          label: "后台维护管理",
          sort: 7,
          hasChildren: null
        },
        {
          id: 9,
          parentId: -1,
          children: [],
          icon: "el-icon-guide",
          name: "值班预案管理",
          spread: false,
          path: "#",
          keepAlive: "0",
          permission: null,
          type: "0",
          label: "值班预案管理",
          sort: 8,
          hasChildren: null
        },
        {
          id: 10,
          parentId: -1,
          children: [],
          icon: "el-icon-message",
          name: "传真件管理",
          spread: false,
          path: "#",
          keepAlive: "0",
          permission: null,
          type: "0",
          label: "传真件管理",
          sort: 9,
          hasChildren: null
        },
        {
          id: 11,
          parentId: -1,
          children: [],
          icon: "el-icon-phone-outline",
          name: "电话接听管理",
          spread: false,
          path: "#",
          keepAlive: "0",
          permission: null,
          type: "0",
          label: "电话接听管理",
          sort: 10,
          hasChildren: null
        },
        {
          id: 12,
          parentId: -1,
          children: [],
          icon: "el-icon-files",
          name: "知识库管理",
          spread: false,
          path: "#",
          keepAlive: "0",
          permission: null,
          type: "0",
          label: "知识库管理",
          sort: 11,
          hasChildren: null
        }
      ]
    };
  },
  created() {
    // this.$store.dispatch("GetMenu", { type: true, id: -1 }).then(data => {
    //   if (data.length === 0) return;
    //   this.$router.$avueRouter.formatRoutes(data, true);
    // });
    this.$router.$avueRouter.formatRoutes(this.menu, true);
  },
  computed: {
    ...mapGetters(["website", "menu", "tag", "keyCollapse", "screen"]),
    nowTagValue: function() {
      return this.$router.$avueRouter.getValue(this.$route);
    }
  },
  mounted() {},
  methods: {}
};
</script>
<style lang="scss" scoped>
</style>

