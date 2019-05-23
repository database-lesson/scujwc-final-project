<template>
  <div class="wrap">
    <!-- {{msg}} -->
    <el-tabs
      type="border-card"
      lazy
      @tab-click="onClickTabs"
      v-loading="myCourseLoading"
      element-loading-text="正在加载课表"
    >
      <el-tab-pane>
        <span slot="label">
          <i class="el-icon-date"></i> 我的课程
        </span>

        <el-button type="primary" round style="margin-top:20px;">今日课程</el-button>
        <ul class="todayCourse">
          <li class="box" v-for="(value, key) in today_courses" :key="key">
            <div class="title">{{ value.course_name}}</div>
            <el-divider content-position="center" style="margin:10px 2px;">
              <div class="teachers">{{value.course_teachers}}</div>
            </el-divider>
            <div class="time">{{value.time}}</div>
            <div class="place">{{value.place}}</div>
          </li>
        </ul>
        <el-popover placement="top" title="根据日期查看课表" trigger="hover" content="在下方输入框选择日期即可">
          <el-button slot="reference" type="primary" round style="margin-top:20px;">日期课表</el-button>
        </el-popover>
        <el-row>
          <el-col :span="20" :offset="2">
            <div class="search">
              <el-date-picker
                v-model="selectDate"
                align="right"
                type="date"
                placeholder="选择日期以获取当天课程信息"
                :picker-options="pickerOptions"
                style="width:60%;"
                @change="handleDatePickerChange"
              ></el-date-picker>
            </div>
            <div class="result" style="text-align:left" v-if="result.length>0&&result[0]!='none'">
              <el-timeline>
                <el-timeline-item
                  :timestamp="value.time"
                  placement="top"
                  v-for="(value, key) in result"
                  :key="key"
                >
                  <el-card class="card">
                    <div style="font-size:20px;font-weight:700">{{value.course_name}}</div>
                    <div class="teachers">{{value.course_teachers}}</div>
                    <el-divider content-position="right" class="classplace">{{value.place}}</el-divider>
                  </el-card>
                </el-timeline-item>
              </el-timeline>
            </div>
            <div class="noresult" v-else-if="result>0&&result[0]=='none'">这天放假!</div>
          </el-col>
        </el-row>

        <!-- <div class="outer-container">
          <div class="inner-container">
            <div class="content">
              <div class="box"></div>
              <div class="box"></div>
              <div class="box"></div>
              <div class="box"></div>
            </div>
          </div>
        </div>-->
      </el-tab-pane>
      <el-tab-pane v-loading="chooseLoading" element-loading-text="正在加载">
        <span slot="label">
          <i class="el-icon-circle-plus-outline"></i> 选课
        </span>
        <div class="pickCourseWrap">
          <el-button type="primary" round icon="el-icon-search" class="course_search">搜索选课</el-button>

          <el-input
            placeholder="请输入内容"
            v-model="search_input"
            @keyup.enter.native="onSearch"
            class="input-with-select"
          >
            <el-select v-model="search_type" slot="prepend" placeholder="请选择" style="width:120px;">
              <el-option label="课程号" value="1"></el-option>
              <el-option label="教师名" value="2"></el-option>
              <el-option label="课程名" value="3"></el-option>
            </el-select>
            <el-button slot="append" icon="el-icon-search" @click="onSearch"></el-button>
          </el-input>
        </div>
        <div class="searchResult">
          <div class="result-line" v-if="search_result.length==0"></div>
          <div class="result-line" v-else-if="search_result[0]=='none'">没有结果</div>
          <div class="result-table" v-else>
            <!-- 结果应该是列表 -->
            <h4>结果如下</h4>
            <el-table :data="search_result">
              <!-- 通过自定义column expand 以及slot-scope的方式开启展开功能,其实也可以用tooltip展示简化，但这里还是使用这个 -->
              <el-table-column type="expand">
                <template slot-scope="props">
                  <el-form label-position="left" class="demo-table-expand">
                    <el-form-item label="课程号">
                      <span>{{ props.row.course_no }}</span>
                    </el-form-item>
                    <el-form-item label="课程名">
                      <span>{{ props.row.course_name }}</span>
                    </el-form-item>
                    <el-form-item label="教师">
                      <span>{{ props.row.course_teachers}}</span>
                    </el-form-item>
                    <el-form-item label="上课校区">
                      <span>{{ props.row.course_district }}</span>
                    </el-form-item>
                    <el-form-item label="上课地点">
                      <span>{{ props.row.course_place }}</span>
                    </el-form-item>
                    <el-form-item label="上课时间">
                      <span>{{ props.row.course_time }}</span>
                    </el-form-item>
                    <el-form-item label="学分">
                      <span>{{ props.row.credit }}</span>
                    </el-form-item>
                    <el-form-item label="操作">
                      <span>
                        <el-button type="primary">选课</el-button>
                      </span>
                    </el-form-item>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column label="课程名" prop="course_name"></el-table-column>
              <el-table-column label="教师" prop="course_teachers"></el-table-column>
              <el-table-column label="学分" prop="credit"></el-table-column>
              <el-table-column label="校区" prop="course_district"></el-table-column>
              <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button
                    v-if="scope.row.taken==false"
                    size="mini"
                    type="primary"
                    @click="chooseCourse(scope.$index, scope.row)"
                  >选课</el-button>
                  <el-button
                    v-else-if="scope.row.taken==true"
                    round
                    size="mini"
                    icon="el-icon-circle-check"
                    @click="chooseCourse(scope.$index, scope.row)"
                  >已修</el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane v-loading="quitLoading" element-loading-text="正在加载">
        <span slot="label">
          <i class="el-icon-remove-outline"></i> 退课
        </span>
        <el-button type="primary" round class="course_search" icon="el-icon-remove-outline">退课</el-button>
        <div class="quitCourse">
          <el-dialog title="警告" :visible.sync="visible" width="30%" :before-close="handleClose">
            <span>你确定删除这个课程么?</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="visible = false">取 消</el-button>
              <el-button type="primary" @click="handleDialogConfirm">确 定</el-button>
            </span>
          </el-dialog>
          <el-table
            v-loading="loadingTable"
            element-loading-text="正在删除"
            element-loading-spinner="el-icon-loading"
            :data="courseData.filter(data => !search_quitCourse || data.course_no.toLowerCase().includes(search_quitCourse.toLowerCase())
            || data.course_teachers.toLowerCase().includes(search_quitCourse.toLowerCase())
            ||data.course_name.toLowerCase().includes(search_quitCourse.toLowerCase()))"
            style="width: 100%"
          >
            <el-table-column label="课程号" prop="course_no" width="100"></el-table-column>
            <el-table-column label="课程名" prop="course_name" width="150" show-overflow-tooltip></el-table-column>
            <el-table-column label="教师姓名" prop="course_teachers" width="150" show-overflow-tooltip></el-table-column>
            <el-table-column label="上课信息" prop="course_info" width="250" show-overflow-tooltip></el-table-column>

            <el-table-column align="right">
              <template slot="header">
                <el-input v-model="search_quitCourse" size="mini" placeholder="输入关键字搜索"/>
              </template>
              <template slot-scope="scope">
                <!-- <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button> -->

                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)"
                >删除该课程</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import { Loading } from "element-ui";
export default {
  name: "",
  data() {
    return {
      //页面加载相关
      quitLoading: false,
      chooseLoading: false,
      myCourseLoading: false,

      //退课表格测试
      loadingTable: false,
      visible: false,
      //退课相关
      deleteID: -1,
      search_quitCourse: "",
      //courseData其实就是全部课程信息，只是不全部拿，拿部分信息就OK
      courseData: [
        {
          course_no: "1",
          course_name: "微积分",
          course_teachers: "刘刘" + "/张张" + "/宋宋",
          course_info:
            "星期二 8:15-9:55 一教A203" + "/星期三 8:15-9:55 一教A303"
        },
        {
          course_no: "2",
          course_name: "数字图像与CNN卷积神经网络算法",
          course_teachers: "刘刘" + "/张张" + "/宋宋",
          course_info:
            "星期二 8:15-9:55 一教A203" + "/星期三 8:15-9:55 一教A303"
        },
        {
          course_no: "3",
          course_name: "诗朗诵",
          course_teachers: "刘刘" + "/张张" + "/宋宋",
          course_info:
            "星期二 8:15-9:55 一教A203" + "/星期三 8:15-9:55 一教A303"
        },
        {
          course_no: "4",
          course_name: "学习",
          course_teachers: "刘刘" + "/张张" + "/宋宋",
          course_info:
            "星期二 8:15-9:55 一教A203" + "/星期三 8:15-9:55 一教A303"
        }
      ],

      //选课搜索相关data
      search_type: "",
      search_result: [],
      search_input: "",

      //默认data
      msg: "It's Course Management Page",
      //我的课表相关data

      today_courses: [],
      selectDate: "",
      result: [],
      pickerOptions: {
        //禁止选中的天
        // disabledDate(time) {
        //   return time.getTime() > Date.now();
        // },
        shortcuts: [
          {
            text: "今天",
            onClick(picker) {
              picker.$emit("pick", new Date());
            }
          },
          {
            text: "昨天",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit("pick", date);
            }
          },
          {
            text: "一周前",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", date);
            }
          }
        ]
      }
    };
  },
  created() {
    //一打开肯定是在我的课表页面
    //因此只加载我的课表页面信息

    this.myCourseLoading = true;
    setTimeout(_ => {
      this.today_courses = [
        {
          course_name: "微积分",
          course_teachers: "王鹏 / 左航",
          time: "8:15 - 9:55",
          place: "一教A203"
        },
        {
          course_name: "微积分",
          course_teachers: "王鹏 / 左航",
          time: "8:15 - 9:55",
          place: "一教A203"
        },
        {
          course_name: "微积分",
          course_teachers: "王鹏 / 左航",
          time: "8:15 - 9:55",
          place: "一教A203"
        },
        {
          course_name: "微积分",
          course_teachers: "王鹏 / 左航",
          time: "8:15 - 9:55",
          place: "一教A203"
        }
      ];
      this.myCourseLoading = false;
    }, 1000);
  },
  methods: {
    handleClose(done) {
      //通过这种方式快速打开一个messagebox
      this.$confirm("确认关闭？")
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },

    //对话框确认
    handleDialogConfirm() {
      this.visible = false;
      this.deleteCourse(this.deleteID);
    },

    //显示删除对话框并拿到本行参数
    handleDelete(index, row) {
      console.log(index, row);
      //验证用户确认逻辑

      this.visible = true;
      this.deleteID = row.course_no;
      //在对话框确认后删除
    },

    //删除接受课程ID,遍历找到正确的index再删掉
    deleteCourse(id) {
      this.loadingTable = true;
      let index = -1;
      for (let i = 0; i < this.courseData.length; i++) {
        if (this.courseData[i].course_no === id) {
          index = i;
          break;
        }
      }

      //同步服务器删除之后拿到success再本地删除
      setTimeout(() => {
        this.courseData.splice(index, 1);
        this.loadingTable = false;
        //成功提示
        this.$notify({
          title: "成功",
          message: "成功删除该课程",
          type: "success"
        });
      }, 2000);
    },
    //日期课表获取
    handleDatePickerChange(value) {
      console.log(value);
      let month = value.getMonth();
      let day = value.getDate();
      let year = value.getFullYear();

      //全局加载
      // let loadingInstance = Loading.service({
      //   fullscreen: true
      // });
      //只有我的课程tab-pane加载
      this.myCourseLoading = true;
      setTimeout(() => {
        if (month == 4 && year == 2019 && day == 22) {
          this.result = [
            {
              course_name: "微积分",
              course_teachers: " 王鹏 / 左航", //格式化之后的字符串
              place: "一教A203", //字符串
              time: "8:15 - 12:00" //字符串
            },
            {
              course_name: "CNN Analysis",
              course_teachers: "Any Shed",
              place: "综C 105",
              time: "16:00-17:30"
            }
          ];
        } else {
          this.result[0] = "none";
        }
        // loadingInstance.close();
        this.myCourseLoading = false;
      }, 2000);
    },
    //搜索选课
    onSearch() {
      let sInput = this.search_input;
      let sType = this.search_type;
      console.log("search" + sType + sInput);

      if (sType == "") {
        //提醒用户选择搜索类型
        this.$notify({
          title: "警告",
          message: "请选择搜索类型",
          type: "warning"
        });
      } else if (sInput == "") {
        this.$notify({
          title: "警告",
          message: "请填写搜索内容",
          type: "warning"
        });
      } else {
        //提交服务器搜索

        //进入loading状态

        //Promise拿到数据

        //开始Json赋值
        if (sInput == "数学" && sType == 3) {
          this.search_result = ["none"];
        } else {
          this.chooseLoading = true;
          setTimeout(() => {
            this.search_result = [
              {
                course_no: 1,
                course_name: "C语言与头秃疗法",
                course_teachers: "Nathanial/Myra/Miller",
                course_district: "江安校区",
                course_time: "星期二 8:15-9:55 / 星期三 15:30-16:25",
                course_place: "一教A303 / 一教B307 ",
                credit: 4, //学分
                taken: false
              }
            ];
            this.chooseLoading = false;
          }, 1000);
        }
      }

      console.log(this.search_result);
    },
    chooseCourse(index, row) {
      console.log(index);
      console.log(row);
      if (row.taken) {
        this.$notify.success({
          title: "提示",
          message: "你已经选修了这门课"
        });
      } else {
        this.$confirm("确定选修这门课?")
          .then(res => {
            console.log(res);
            if (res == "confirm") {
              row.taken = true;
            }
          })
          .catch(error => {
            console.log(error);
          });
      }
      //通过row拿到course_no，通过course_no调用后台接口
      //进行选课
    },

    onClickTabs(tab) {
      console.log(tab.index);
      switch (tab.index) {
        case "0":
          //课程页

          //检测有无课表，无则加载课表

          //拿到课表，退出加载
          this.myCourseLoading = true;
          setTimeout(_ => {
            // loadingInstance.close();
            this.myCourseLoading = false;
          }, 1000);
          break;
        case "1":
          //选课
          this.chooseLoading = true;
          setTimeout(_ => {
            // loadingInstance.close();
            this.chooseLoading = false;
          }, 1000);
          break;
        case "2": //退课\
          //等待加载学生课表

          //拿到课表赋值退课页的courseData

          //退出loading
          // let loadingInstance = Loading.service({
          //   fullscreen: true
          // });

          this.quitLoading = true;
          setTimeout(_ => {
            // loadingInstance.close();
            this.quitLoading = false;
          }, 1000);
          break;
      }
    }
  }
};
</script>

<style scoped>
.todayCourse {
  /* display: flex;
  flex-flow: row nowrap; */
  overflow-x: auto;
  list-style: none;
  width: auto;
  white-space: nowrap;
  padding-left: 0px;
}

.todayCourse::-webkit-scrollbar {
  /* display: none; */
  width: 10px;
  height: 4px;
  background-color: #f5f5f5;
}

.todayCourse::-webkit-scrollbar-track {
  box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  border-radius: 10px;
  background-color: #f5f5f5;
}

.todayCourse::-webkit-scrollbar-thumb {
  border-radius: 10px;
  box-shadow: inset 0 0 6px rgba(146, 146, 146, 0.3);
  background-color: rgb(144, 144, 144);
}

.box {
  background: #40bbff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  color: white;
  display: inline-block;
  width: 300px;
  height: 150px;
  margin: 20px;
  border-radius: 5px;
}

.box:first-child {
  margin-left: 0px;
}

.box:last-child {
  margin-right: 0px;
}

.box .title {
  font-size: 24px;
  font-weight: 600;
  margin-top: 10px;
}

.box .el-divider__text {
  background-color: #40bbff !important;
  color: white;
  font-weight: 600;
  font-size: 16px;
}

.search {
  margin: 20px auto;
  width: 90%;
}

.teachers {
  margin: 10px 0px;
}

.teachers .teacher {
  display: inline;
}

.result .el-divider.el-divider--horizontal {
  margin-top: 20px;
  margin-bottom: 10px;
}

.noresult {
  margin: 10px;
}

.course_search {
  margin: 20px 0px;
}

.searchResult .result-line {
  font-weight: 700;
  font-size: 14px;
  line-height: 20px;
  margin: 15px 0px;
}

.searchResult .result-table {
  margin: 15px 0px;
}
</style>
