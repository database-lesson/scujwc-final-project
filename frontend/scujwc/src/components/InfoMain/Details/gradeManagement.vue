<template>
  <div class="wrap" v-loading="wrapLoading" element-loading-text="正在获取课程成绩">
    <div class="box" style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); padding:20px 20px;">
      <el-button type="primary" icon="el-icon-info" round style="margin: 10px 0px">课程成绩</el-button>
      <el-table :data="gradeData" style="width: 100%; ">
        <el-table-column prop="course_no" label="课程号" width="150" show-overflow-tooltip></el-table-column>
        <el-table-column prop="course_name" label="课程名" width="250" show-overflow-tooltip></el-table-column>
        <el-table-column prop="course_teachers" label="老师" width="200" show-overflow-tooltip></el-table-column>
        <el-table-column prop="credit" label="学分"></el-table-column>
        <el-table-column prop="grade" label="成绩" :formatter="gradeFormatter"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="questionGrade(scope.$index, scope.row)">质询</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { Loading } from "element-ui";
export default {
  name: "",
  data() {
    return {
      wrapLoading: false,
      msg: "It's grade management page",
      gradeData: null
    };
  },
  created() {
    // 全局加载
    // let loadingInstance = Loading.service({
    //   fullscreen: true
    // });
    //wrap 加载
    this.wrapLoading = true;
    //从服务器拿数据
    setTimeout(_ => {
      this.gradeData = [
        {
          course_no: 1,
          course_name: "操作系统",
          course_teachers: "陈瑜 / 左航 / 屈臣氏",
          credit: 4,
          grade: "89"
        },
        {
          course_no: 2,
          course_name: "操作系统",
          course_teachers: "陈瑜 / 左航 / 屈臣氏",
          credit: 4,
          grade: "89"
        },
        {
          course_no: 3,
          course_name: "操作系统",
          course_teachers: "陈瑜 / 左航 / 屈臣氏",
          credit: 4,
          grade: "89"
        },
        {
          course_no: 5,
          course_name: "操作系统",
          course_teachers: "陈瑜 / 左航 / 屈臣氏",
          credit: 4,
          grade: "89"
        }
      ];
      // loadingInstance.close();
      this.wrapLoading = false;
    }, 1000);
  },
  methods: {
    gradeFormatter(row, column) {
      return row.grade;
    },
    questionGrade(index, row) {
      this.$confirm(
        "确认提交对" + row.course_name + "/" + row.course_no + "课程成绩的质询?"
      )
        .then(res => {
          this.$notify.success({
            title: "成功",
            message: "成功提交质询"
          });
        })
        .catch(error => {
          //取消
        });
    }
  }
};
</script>

<style scoped>
</style>