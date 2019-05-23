<template>
  <div class="info-wrap">
    <!-- {{msg}}
    <p>{{$route.params.account}}</p>
    <p>{{$route.params.password}}</p>-->
    <el-row class="user-info-wrap">
      <el-col :span="18" :offset="3">
        <div class="user-info">
          <div class="avatar" :class="gender" @click="onClickAvatar"></div>
          <div class="name hidden-sm-and-down">{{name}}</div>
          <div class="sid hidden-sm-and-down">{{sid}}</div>
          <div class="institute hidden-sm-and-down">{{institute}}</div>
          <div class="year hidden-sm-and-down">{{yearToString[year]}}</div>
          <el-dropdown class="hidden-md-and-up">
            <span class="el-dropdown-link">
              学生信息
              <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>{{name}}</el-dropdown-item>
              <el-dropdown-item>{{sid}}</el-dropdown-item>
              <el-dropdown-item>{{institute}}</el-dropdown-item>
              <el-dropdown-item>{{yearToString[year]}}</el-dropdown-item>
              <!-- <el-dropdown-item divided>蚵仔煎</el-dropdown-item> -->
            </el-dropdown-menu>
          </el-dropdown>

          <el-button type="text" class="hidden-md-and-down">个人管理</el-button>
          <el-button type="text" class="hidden-md-and-down">课程管理</el-button>
          <el-button type="text" class="hidden-md-and-down">考务管理</el-button>
          <el-button type="text" class="hidden-md-and-down">成绩查询</el-button>
          <el-dropdown type="text" class="hidden-md-and-down" @command="handleCommand">
            <span class="el-dropdown-link">
              其它
              <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="其他功能1">其它功能1</el-dropdown-item>
              <el-dropdown-item command="其它功能2">其它功能2</el-dropdown-item>
              <el-dropdown-item divided command="返回首页">返回首页</el-dropdown-item>
              <!-- <el-dropdown-item divided>蚵仔煎</el-dropdown-item> -->
            </el-dropdown-menu>
          </el-dropdown>

          <div class="hidden-lg-and-up">
            <el-dropdown @command="handleCommand">
              <span class="el-dropdown-link">
                下拉菜单
                <i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="个人管理">个人管理</el-dropdown-item>
                <el-dropdown-item command="课程管理">课程管理</el-dropdown-item>
                <el-dropdown-item command="考务管理">考务管理</el-dropdown-item>
                <el-dropdown-item command="考务管理">成绩查询</el-dropdown-item>
                <el-dropdown-item command="其它" divided>
                  <el-dropdown type="text">
                    <span class="el-dropdown-link">
                      其它
                      <i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                      <el-dropdown-item>其它功能1</el-dropdown-item>
                      <el-dropdown-item>其它功能2</el-dropdown-item>
                      <el-dropdown-item divided>返回首页</el-dropdown-item>
                      <!-- <el-dropdown-item divided>蚵仔煎</el-dropdown-item> -->
                    </el-dropdown-menu>
                  </el-dropdown>
                </el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </div>
      </el-col>
      <!-- <el-col :span="8">
        <div class="operation">
          <div class="oper1">个人管理</div>
          <div class="oper2">考务管理</div>
          <div class="oper3">综合查询</div>
          <div class="oper4">图书馆借阅</div>
        </div>
      </el-col>-->
    </el-row>
    <div class="label">信息预览</div>
    <el-row class="control-pane">
      <el-col :span="18" :offset="3">
        <!-- 改写成不带循环的,每个幻灯片需求不同，同种样式无法满足需求 -->
        <el-carousel :interval="4000" type="card" height="400px" indicator-position="outside">
          <el-carousel-item v-for="(value,key,index) in previewList" :key="key" :label="key">
            <div class="itemBox" :data-index="index" @click.self="onClickItem($event)">
              <div class="title">{{key}}</div>
              <div class="infos" style="width:100%;">
                <div class="info" v-for="(v,k,idx) in value" :key="idx">
                  <div class="key">{{k}}</div>
                  <div class="value">{{v}}</div>
                </div>
              </div>
              <div class="action">
                <button
                  class="el-button el-button--primary"
                  type="primary"
                  :data-index="index"
                  @click="onClickItem($event)"
                >查看更多</button>
              </div>
            </div>
          </el-carousel-item>
        </el-carousel>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import "element-ui/lib/theme-chalk/display.css";
export default {
  name: "Info",
  data() {
    return {
      previewList: {
        学业信息: {
          已修读课程数: 39,
          未通过课程数: 0,
          培养方案: "软件工程培养方案",
          本学期在读课程: 14,
          GPA: 3.39
        },
        今日课程: {
          微积分: "一教A203 8:15-9:55",
          时间管理: "一教A203 8:20-8:55",
          诗歌朗诵: "一教A203 8:15-9:55"
        },
        通知: {
          有未读消息: 2
        },
        选课管理: {
          提示信息: "当前不在选课时间段"
        },
        考试信息: {
          提示信息: "暂无考试信息" //有多个选课
        }
      },
      yearToString: ["大一", "大二", "大三", "大四"],
      year: 1,
      institute: "软件学院",
      name: "宋晋瑜",
      sid: "2017141463103",
      gender: "boy"
    };
  },
  methods: {
    onClickItem(e) {
      console.log(e.target.dataset);
      this.$router.push({
        name: "detail",
        params: { title: e.target.dataset.index }
      });
    },
    handleCommand(command) {
      this.$message("click on " + command);
      if (command === "返回首页") {
        this.$router.go(-1);
      }
    },
    onClickAvatar() {
      this.$message("click on avatar");
    }
  }
};
</script>

<style scoped>
.info-wrap {
  min-width: 800px;
  margin: -8px;
  height: calc(100vh);
  width: calc(100vw);
  background-color: #e3eeff85;
  position: fixed;
}

.info-wrap .user-info-wrap {
  display: flex;
  flex-direction: row;
  align-items: baseline;
  margin: 10px 0;
  margin-top: 60px;
}
.info-wrap .user-info {
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin: 20px 0;

  transition: all 0.5s;
  border-radius: 10px;
  background-color: white;
  padding: 10px;
  overflow: hidden;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  text-align: center;
}

/* .info-wrap .operation {
  display: flex;
  justify-content: space-around;
  align-items: center;

  transition: all 0.5s;
  border-radius: 10px;
  background-color: white;
  padding: 10px;
  overflow: hidden;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  text-align: center;
} */

.info-wrap .user-info .avatar:hover {
  cursor: pointer;
}

.info-wrap .user-info .avatar {
  margin-bottom: 10px;
}

.info-wrap .user-info .avatar.boy {
  border-radius: 50%;
  width: 64px;
  height: 64px;
  /* background-color: #fff; */
  background-image: url(../../assets/boy.svg);
  background-position: center center;
  background-repeat: no-repeat;
}

.info-wrap .user-info .avatar.girl {
  border-radius: 50%;
  width: 64px;
  height: 64px;
  /* background-color: #fff; */
  background-image: url(../../assets/girl.svg);
  background-position: center center;
  background-repeat: no-repeat;
}

.info-wrap .user-info .name {
  line-height: 30px;
  font-size: 1rem;
}

.el-carousel__item {
  border-radius: 10px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  background-size: cover;
  background-blend-mode: multiply;
  background-color: #686868;
  transition: all 0.75s;
}
.el-carousel__item:nth-child(3n) {
  background-image: url(../../assets/bg.jpg);
}

.el-carousel__item:nth-child(3n + 1) {
  background-image: url(../../assets/bg1.jpg);
}

.el-carousel__item:nth-child(3n + 2) {
  background-image: url(../../assets/bg2.jpg);
}

.el-carousel__item:hover {
  background-color: #474747;
}

.info-wrap .label {
  font-size: 1rem;
  background-color: #409eff;
  color: white;
  padding: 5px 15px;
  display: inline-block;
  border-radius: 4px;
  margin-bottom: 20px;
}

.control-pane .itemBox {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  /* background-image: url(../../assets/bg.jpg); */

  color: white;
}

/* .control-pane .itemBox:nth-child(3n + 1) {
  background-image: url(../../assets/bg1.jpg);
}

.control-pane .itemBox:nth-child(3n + 2) {
  background-image: url(../../assets/bg2.jpg);
}

.control-pane .itemBox:nth-child(3n) {
  background-image: url(../../assets/bg.jpg);
} */

.control-pane .itemBox .title {
  font-size: 1.3rem;
  padding: 10px;
  margin: 10px 0;
  margin-bottom: 20px;
  letter-spacing: 1.7px;
}

.control-pane .itemBox .info {
  margin: 10px 0px;
  display: inline-flex;
  min-width: 80%;
  width: 80%;
  justify-content: space-between;
  align-items: center;
}

.control-pane .itemBox .action {
  margin: 10px 0;
}
</style>
