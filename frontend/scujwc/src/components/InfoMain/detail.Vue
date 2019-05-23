<template>
  <div class="wrap">
    <!-- 测试vuex用代码 start -->
    <!-- 这里放校徽，logo和用户头像等简单信息 -->
    <!-- <el-row>
      {{this.$route.params.title}}
      {{gettersMsg}}
      
    </el-row>-->
    <!-- <el-row>
      <el-col :span="6" :offset="9">
        <div class="cen-bar">
          <div class="cen-avatar" :class="gender"></div>
          <div class="cen-bg">
            <div class="cen-info">lorem lorem korem korem</div>
          </div>
        </div>
      </el-col>
    </el-row>-->
    <el-row class="tac" :gutter="10">
      <el-col :span="4" :offset="2">
        <el-menu class="menu" @select="handleSelect" router :default-active="active_idx">
          <el-menu-item index="1" route="/detail/userHome" class="menuitem">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span>首页</span>
            </template>
            <!-- <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>-->
            <!-- <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项1</el-menu-item>
            </el-submenu>-->
          </el-menu-item>
          <el-menu-item index="2" route="/detail/personInfo" class="menuitem">
            <i class="el-icon-user-solid"></i>
            <span slot="title">个人信息</span>
          </el-menu-item>
          <el-menu-item index="3" route="/detail/courseManagement" class="menuitem">
            <i class="el-icon-date"></i>
            <span slot="title">课程管理</span>
          </el-menu-item>
          <el-menu-item index="4" route="/detail/gradeManagement" class="menuitem">
            <i class="el-icon-document"></i>
            <span slot="title">成绩管理</span>
          </el-menu-item>
          <el-menu-item index="5" route="/detail/examinationManagement" class="menuitem">
            <i class="el-icon-setting"></i>
            <span slot="title">考务管理</span>
          </el-menu-item>
          <!-- <el-menu-item index="6" route="/detail/libraryService">
            <i class="el-icon-reading"></i>
            <span slot="title">图书馆服务</span>
          </el-menu-item>
          <el-menu-item index="7" route="/detail/teachingResource">
            <i class="el-icon-school"></i>
            <span slot="title">教学资源</span>
          </el-menu-item>-->
          <!-- <el-menu-item index="8" route="/detail/setting">
            <i class="el-icon-s-operation"></i>
            <span slot="title">设置</span>
          </el-menu-item>-->
        </el-menu>
      </el-col>
      <el-col :span="14" :offset="1">
        <transition name="fade" mode="out-in">
          <router-view/>
        </transition>
      </el-col>
    </el-row>
    <!-- 测试vuex用代码 end -->
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import api from "@/api";
export default {
  name: "detail",
  data() {
    return {
      msg: "Detail Page",
      active_idx: (parseInt(this.$route.params.title) + 1).toString(),
      gender: "boy"
    };
  },
  computed: {
    ...mapGetters(["gettersMsg"])
  },
  created() {
    console.log("created", this.$route.params.title);
    this.$router.push(api.previewToDetail[this.$route.params.title]);
    this.active_idx = (parseInt(this.$route.params.title) + 1).toString();
  },
  methods: {
    handleSelect(index, indexPath) {
      console.log("select" + index);
      if (index === "1") {
        this.active_idx = "1";
      } else if (index === "2") {
        this.active_idx = "2";
      } else if (index === "3") {
        this.active_idx = "3";
      } else if (index === "4") {
        this.active_idx = "4";
      } else if (index === "5") {
        this.active_idx = "5";
      } else if (index === "6") {
        this.active_idx = "6";
      } else if (index === "7") {
        this.active_idx = "7";
      } else if (index === "8") {
        this.active_idx = "8";
      }
    }
  }
};
</script>

<style scoped>
.wrap {
  min-width: 850px;
}
.cen-bar {
  max-width: 100%;
  /* background-color: white; */
  /* box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); */
}

.cen-bg {
  position: absolute;
  background-color: white;
  height: 70%;
  width: 25%;
  border-radius: 10px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  top: 10px;
  z-index: -1;
}
.cen-avatar:hover {
  cursor: pointer;
}
.cen-avatar {
  margin: 0 auto;
  border-radius: 50%;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.cen-avatar.boy {
  background-image: url(../../assets/boy.svg);
  width: 64px;
  height: 64px;
  background-repeat: no-repeat;
}

.cen-avatar.girl {
  background-image: url(../../assets/girl.svg);
  width: 64px;
  height: 64px;
}

.menu {
  height: calc(97vh);
}
/* 对menueitem进行了更改 */

/* .menuitem {
  height: calc(10vh);
  margin: calc(2.5vh) 0px;
  line-height: calc(10vh);
  font-weight: 600;
  font-size: 16px;
} */
</style>
