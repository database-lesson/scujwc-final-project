<template>
  <div class="warp">
    <el-tabs @tab-click="handleTabClick">
      <el-tab-pane label="学生信息">
        <el-row>
          <el-col
            :lg="{span:12,offset:6}"
            :md="{span:16,offset:4}"
            :sm="{span:20, offset:2}"
            :xs="{span:24,offset:0}"
          >
            <el-card style="margin:40px 0px;">
              <div slot="header" style="overflow:hidden">
                <span style="float:left;">学生名片</span>
                <el-link icon="el-icon-view" style="float:right;margin:0 5px">查看详细</el-link>
              </div>
              <!-- <el-image
              src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
              :fit="cover"
              ></el-image>-->
              <!-- <i class="fas fa-user" style="font-size:100px;margin-top:10px;color:#409EFF"></i> -->
              <div class="avatar" :class="gender"></div>

              <div style="margin: 5px;overflow:hidden;clear:both">
                <el-divider content-position="center" style="font-size:20px">{{name}}</el-divider>
                <div style="float: left;">
                  <span class="institute" style="display:inline-block;">{{institue}}</span>
                  <el-divider direction="vertical"></el-divider>
                  <span class="grade" style="display:inline-block;">{{gradeToHuman[grade]}}</span>
                </div>
                <div style="float:right">
                  <span class="sid">{{sid}}</span>
                </div>
              </div>
              <el-divider content-position="center" style="font-size:20px">个人标签</el-divider>
              <div class="tags" style="clear:both;padding:0px">
                <!-- <el-divider content-position="center"></el-divider> -->

                <span class="each-tag" v-for="(value,key) in tags" :key="key">
                  <el-tag :type="value.attitude==='positive'?'success':'danger'">{{ value.name}}</el-tag>
                </span>
              </div>
              <el-divider content-position="center" style="font-size:20px"></el-divider>

              <div class="oper" style="clear:both;overflow:hidden;margin-top:5px;">
                <div class="item">
                  <el-button plain circle>
                    <i class="far fa-thumbs-up"></i>
                  </el-button>

                  <el-button type="primary" icon="el-icon-star-off" circle></el-button>
                  <el-button type="danger" circle>
                    <i class="far fa-thumbs-down"></i>
                  </el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="通知">
        <div class="notifictionList">
          <el-card v-for="(value, key) in drawList" :key="key" style="width:80%;margin:30px auto;">
            <div slot="header">
              <span>{{value.title}}</span>
            </div>
            <div class="content" style="margin-top:10px;margin-bottom:30px">{{value.content}}</div>
            <el-divider content-position="right">{{value.author}}</el-divider>
          </el-card>
          <el-pagination
            layout="prev, pager, next"
            :total="notifictionList1.length+notifictionList2.length"
            :page-size="drawSize"
            @current-change="handleCurrentChange"
          ></el-pagination>
        </div>
      </el-tab-pane>
      <el-tab-pane>
        <span slot="label">
          待办事项
          <div
            class="point"
            v-if="hasMessage"
            style="position:absolute;top:3px; right:-5px;background-color:#ff6644;
          border-radius:50%;width:7px;height:7px;blur(3px);"
          ></div>
        </span>
        <div class="todoList">
          <div class="item" v-for="(value,key) in todos" :key="key">
            <div class="todoWrap">
              <div class="blueBlockLeft"></div>
              <div class="title">{{value.title}}</div>
              <div class="date">
                <el-divider content-position="center">{{value.date}}</el-divider>
              </div>

              <!-- 后期步骤条 -->
              <!-- <div class="steps" style="width:50%;margin:0 auto;margin-top:30px;text-align:left;">
                <el-steps :active="active" finish-status="success" align-center>
                  <el-step title="步骤 1"></el-step>
                  <el-step title="步骤 2"></el-step>
                  <el-step title="步骤 3"></el-step>
                </el-steps>
              </div>-->

              <!-- 后期步骤条 -->

              <!-- <div class="status">当前进度: {{value.status}}</div> -->
              <div class="operation">
                <el-button type="primary" icon="el-icon-check" circle></el-button>
                <el-button type="danger" icon="el-icon-close" circle></el-button>
              </div>
              <div class="blueBlockRight"></div>
            </div>
          </div>
        </div>
        <el-button type="primary">添加待办</el-button>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "userHome",
  data() {
    return {
      msg: "it's userhome",
      hasMessage: true,
      name: "宋晋瑜",
      gender: "boy",
      institue: "软件学院",
      grade: "2",
      sid: "2017141463103",
      tags: [
        { name: "死宅", attitude: "negative" },
        { name: "学霸", attitude: "positive" },
        { name: "手速超群", attitude: "positive" },
        { name: "长得丑", attitude: "negative" },
        { name: "没人缘", attitude: "negative" }
      ],
      //渲染列表
      drawList: [],
      //渲染个数
      drawSize: 4,
      //全部个数
      allSize: 0,
      //测试列表1
      notifictionList1: [
        {
          title: "样例通知1",
          author: "四川大学教务处",
          content:
            "Labore necessitatibus qui quibusdam recusandae facere praesentium rem qui."
        },
        {
          title: "样例通知2",
          author: "四川大学教务处",
          content:
            "Labore necessitatibus qui quibusdam recusandae facere praesentium rem qui."
        },
        {
          title: "样例通知3",
          author: "四川大学教务处",
          content:
            "Labore necessitatibus qui quibusdam recusandae facere praesentium rem qui."
        },
        {
          title: "样例通知4",
          author: "四川大学教务处",
          content:
            "Labore necessitatibus qui quibusdam recusandae facere praesentium rem qui."
        }
      ],
      //测试列表2
      notifictionList2: [
        {
          title: "样例通知5",
          author: "四川大学教务处",
          content:
            "Labore necessitatibus qui quibusdam recusandae facere praesentium rem qui."
        },
        {
          title: "样例通知6",
          author: "四川大学教务处",
          content:
            "Labore necessitatibus qui quibusdam recusandae facere praesentium rem qui."
        },
        {
          title: "样例通知7",
          author: "四川大学教务处",
          content:
            "Labore necessitatibus qui quibusdam recusandae facere praesentium rem qui."
        },
        {
          title: "样例通知8",
          author: "四川大学教务处",
          content:
            "Labore necessitatibus qui quibusdam recusandae facere praesentium rem qui."
        }
      ],

      todos: [
        {
          title: "提交职业生涯规划论文",
          date: "2019年5月31日",
          status: "正在进行"
        },
        {
          title: "做小游戏",
          date: "2019年5月31日",
          status: "未开始"
        }
      ],
      gradeToHuman: {
        1: "大一",
        2: "大二",
        3: "大三",
        4: "大四",
        5: "研一",
        6: "研二",
        7: "研三",
        8: "博士",
        9: "外星人"
      }
    };
  },
  created() {
    console.log("created");
    //将数据放入渲染表里
    this.drawList = this.notifictionList1;
  },
  methods: {
    handleTabClick(tab) {
      console.log(tab);
    },
    handleCurrentChange(currentPage) {
      console.log(currentPage);
      //更新当前drawList

      //服务器获取当前页面数据

      //赋值给drawList
      //测试赋值
      switch (currentPage) {
        case 1:
          this.drawList = this.notifictionList1;
          break;
        case 2:
          this.drawList = this.notifictionList2;
          break;
      }
      // for (let i = 0; i < this.drawSize; i++) {
      //   console.log(
      //     this.notifictionList[(currentPage - 1) * this.drawSize + i]
      //   );
      //   if (
      //     this.notifictionList[(currentPage - 1) * this.drawSize + i] != null
      //   ) {
      //     this.drawList[i] = this.notifictionList[
      //       (currentPage - 1) * this.drawSize + i
      //     ];
      //   }
      //   console.log("drawList", this.drawList);
      // }
    }
  }
};
</script>

<style scoped>
.tags {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
.tags .each-tag {
  margin: 0 5px;
}

.todoList .item {
  position: relative;
  margin: 20px 2px;
  padding: 10px 2px;
  border-top: 2px solid #6c93c754;
  border-bottom: 2px solid #6c93c755;
}

.todoList .item .title {
  font-size: 30px;
  font-weight: 700;
}

.todoList .item .date {
  width: 90%;
  margin: 0 auto;
}

.todoList .item .operation {
  margin-top: 10px;
}

.todoList .item .blueBlockLeft {
  background: #6ebbe7;
  position: absolute;
  top: -2px;
  left: 0px;
  height: 102%;
  width: 15px;
  z-index: 10;
}
.todoList .item .blueBlockRight {
  background: #6ebbe7;
  position: absolute;
  top: -2px;
  right: 0px;
  height: 102%;
  width: 15px;
  z-index: 10;
}

.avatar {
  background-repeat: no-repeat;
  background-size: 100%;
  height: 128px;
  width: 128px;
  margin: 20px auto;
}

.avatar.boy {
  background-image: url(../../../assets/boy.svg);
}

.avatar.girl {
  background-image: url(../../../assets/girl.svg);
}
</style>
