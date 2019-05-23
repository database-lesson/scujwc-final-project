<template>
  <div class="wrap" v-loading="wrapLoading" element-loading-text="正在获取考试信息">
    <div
      class="box"
      style="box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);padding:20px;"
    >
      <el-button type="primary" round icon="el-icon-tickets">考试信息</el-button>
      <div class="examList" style="text-align:left;margin:20px 0px;" v-if="exams!=null">
        <el-timeline>
          <el-timeline-item
            v-for="(value,key) in exams"
            :timestamp="value.date"
            placement="top"
            :key="key"
          >
            <el-card>
              <div slot="header" style="clear:both;overflow:hidden;padding:0px;">
                <span>
                  <h2
                    style="display:inline-block;vertical-align:center;line-height:1.5em;"
                  >{{value.course_name}}</h2>
                </span>
                <el-popover placement="top" title="提示" content="点击查看详细考试信息" trigger="hover">
                  <el-button
                    slot="reference"
                    style="float:right;margin:12px 0px"
                    type="primary"
                    plain
                    circle
                    icon="el-icon-more"
                    @click="showMoreInfo(value)"
                  ></el-button>
                </el-popover>
              </div>
              <span style="font-weight:600;font-size:16px;">{{value.course_teachers}}</span>
              <p style="font-weight:500;font-size:14px;">{{value.startTime+" - "+value.endTime}}</p>
              <p style="font-weight:500;font-size:14px;">{{value.place}}</p>
              <!-- <el-divider
                content-position="center"
              >{{formatExamDate(value.startTime, value.endTime)}}</el-divider>-->
            </el-card>
          </el-timeline-item>
        </el-timeline>
      </div>
      <div v-else class="noExams" style="margin:20px 0px;">暂无考试信息</div>
      <el-dialog :title="currentDialogData.name" :visible.sync="detailDialogVisible">
        <el-table :data="currentDialogData.data">
          <el-table-column prop="course_no" label="课程号" width="100" show-overflow-tooltip></el-table-column>
          <el-table-column prop="course_name" label="课程名" width="125" show-overflow-tooltip></el-table-column>
          <el-table-column prop="course_teachers" label="教师" width="100" show-overflow-tooltip></el-table-column>
          <el-table-column prop="date" label="考试日期" width="125" show-overflow-tooltip></el-table-column>
          <el-table-column prop="startTime" label="考试开始时间" width="75" show-overflow-tooltip></el-table-column>
          <el-table-column prop="startTime" label="考试结束时间" width="75" show-overflow-tooltip></el-table-column>
          <el-table-column prop="duration" label="考试时长" width="75" show-overflow-tooltip></el-table-column>
          <el-table-column prop="place" label="考试地点" show-overflow-tooltip></el-table-column>
        </el-table>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { Loading } from "element-ui";
import moment from "moment";
export default {
  name: "",
  data() {
    return {
      wrapLoading: false,
      msg: "It's Examination Management Page",
      exams: null,
      detailDialogVisible: false,
      currentDialogData: {
        name: "none",
        data: null
      }
    };
  },
  created() {
    //加载
    // let loadingInstance = Loading.service({
    //   fullscreen: true,
    //   text: "正在获取考试信息"
    // });

    this.wrapLoading = true;
    //服务器拿数据
    //模拟抓取数据
    setTimeout(_ => {
      this.exams = [
        {
          course_name: "操作系统原理",
          course_no: 1234,
          course_teachers: "陈瑜 / 左航",
          date: moment("2019-05-28").format("YYYY-MM-DD"),
          startTime: moment("2019-05-28 14:00").format("HH:mm"), //最好,传一个date对象进来，或者传字符串，但是要按照 yyyy-MM-dd-hh-mm 的形式
          duration: 60,
          endTime: moment("2019-05-28 15:00").format("HH:mm"),

          place: "一教A203"
        },
        {
          course_name: "数据库系统原理",
          course_no: 187123,
          course_teachers: "刘一静 / 左航",
          date: moment("2019-06-28").format("YYYY-MM-DD"),
          startTime: moment("2019-06-28 14:00").format("HH:mm"),
          //最好,传一个date对象进来，或者传字符串，但是要按照 yyyy-MM-dd-hh-mm 的形式
          duration: 120,
          endTime: moment("2019-06-28 15:00").format("HH:mm"),
          place: "一教C203"
        }
      ];
      // loadingInstance.close();
      this.wrapLoading = false;
    }, 1000);
  },

  methods: {
    //格式化考试时间
    // 弃用
    formatExamDate(startTime, endTime) {
      //console.log("executed");
      // console.log(startTime instanceof Date);
      let sTime = moment(startTime).format("HH:mm");
      let eTime = moment(endTime).format("HH:mm");
      // let eTime = new Date(endTime);
      return sTime + " - " + eTime;
    },
    //展示更详细信息,打开一个dialog
    showMoreInfo(value) {
      console.log(value);

      this.currentDialogData = {
        name: value.course_name,
        data: new Array(value)
      };
      this.detailDialogVisible = true;
    }
  }
};
</script>

<style scoped>
</style>