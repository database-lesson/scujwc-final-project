<template>
  <div class="wrap">
    <!-- {{msg}} -->
    <div class="topic">
      <el-button
        type="primary"
        round
        icon="el-icon-user-solid"
        class="title"
        style="animation: all 1s ease"
      >基本信息</el-button>
      <!-- <el-button
        plain
        circle
        icon="el-icon-edit-outline"
        style="animation: all 1s ease"
        @click="inOutEditMode"
      ></el-button>-->

      <div class="info-detail">
        <div class="avatar" :class="gender"></div>
        <el-divider></el-divider>
        <el-row :gutter="20" class="rowItem">
          <el-col :span="8">
            <div class="info-item">{{name}}</div>
            <!-- <el-input
              v-model="name"
              placeholder="请输入内容"
              v-if="editBasic"
              style="margin: 10 auto; width:60%;"
            ></el-input>-->
            <div class="label bottom">姓名</div>
          </el-col>
          <el-col :span="8">
            <div class="info-item">{{institue}}</div>
            <!-- <el-input
              v-model="institue"
              placeholder="请输入内容"
              v-if="editBasic"
              style="margin: 10 auto; width:60%;"
            ></el-input>-->
            <div class="label bottom">学院</div>
          </el-col>
          <el-col :span="8">
            <div class="info-item">{{gradeList[grade-1].value}}</div>
            <!-- <el-select
              v-model="grade"
              placeholder="请选择"
              v-if="editBasic"
              style="margin: 10 auto; width:60%;"
            >
              <el-option
                v-for="item in gradeList"
                :key="item.index"
                :label="item.value"
                :value="item.index"
              ></el-option>
            </el-select>-->

            <div class="label bottom">年级</div>
          </el-col>
        </el-row>
        <el-row :gutter="20" class="rowItem">
          <el-col :span="8">
            <div class="sid info-item">{{major}}</div>
            <div class="label bottom">专业</div>
          </el-col>
          <el-col :span="8">
            <div class="info-item courseplan">{{coursePlan}}</div>
            <div class="label bottom">培养方案</div>
          </el-col>
          <el-col :span="8">
            <div class="sid info-item">{{sid}}</div>
            <div class="label bottom">一卡通账号</div>
          </el-col>
        </el-row>
        <el-row :gutter="20" class="rowItem">
          <el-col :span="8">
            <div class="info-item">{{takenCourseCount}}</div>
            <div class="label bottom">已修读课程</div>
          </el-col>
          <el-col :span="8">
            <div class="info-item">{{unpassedCourseCount}}</div>
            <div class="label bottom">未通过课程</div>
          </el-col>
          <el-col :span="8">
            <div class="info-item">{{currentTermCourseCount}}</div>
            <div class="label bottom">本学期修读课程</div>
          </el-col>
        </el-row>
        <el-row :gutter="20" class="rowItem">
          <el-col :span="8" :offset="8">
            <div class="info-item">{{gpa}}</div>
            <div class="label bottom">绩点</div>
          </el-col>
        </el-row>
      </div>
    </div>
    <div class="topic">
      <el-button type="primary" round icon="el-icon-document" class="title">学籍信息</el-button>
      <!-- <el-button plain circle icon="el-icon-edit-outline"></el-button> -->

      <div class="info-detail">
        <div class="mainwrap">
          <el-row :gutter="10" class="row">
            <el-col :span="8">
              <div class="row-info-item">
                <span class="row-info-label">学制类型</span>
                <span class="row-info-detail">本科(四年制)</span>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="row-info-item">
                <span class="row-info-label">证件类型</span>
                <span class="row-info-detail">居民身份证</span>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="row-info-item">
                <span class="row-info-label">证件号码</span>
                <span class="row-info-detail">140106199909232512</span>
              </div>
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <el-row :gutter="10" class="row">
            <el-col :span="8">
              <div class="row-info-item">
                <span class="row-info-label">学籍状态</span>
                <span class="row-info-detail">在校</span>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="row-info-item">
                <span class="row-info-label">在读校区</span>
                <span class="row-info-detail">江安校区</span>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="row-info-item">
                <span class="row-info-label">民族</span>
                <span class="row-info-detail">汉族</span>
              </div>
            </el-col>
          </el-row>
          <el-divider></el-divider>

          <el-row :gutter="10" class="row">
            <el-col :span="8">
              <div class="row-info-item">
                <span class="row-info-label">政治面貌</span>
                <span class="row-info-detail">共青团员</span>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="row-info-item">
                <span class="row-info-label">高考成绩</span>
                <span class="row-info-detail">750</span>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="row-info-item">
                <span class="row-info-label">毕业中学</span>
                <span class="row-info-detail">衡水中学</span>
              </div>
            </el-col>
          </el-row>
        </div>
      </div>
    </div>
    <div class="topic" v-if="debug">
      <el-button type="primary" round icon="el-icon-message" class="title">勾搭信息</el-button>
      <el-button plain circle icon="el-icon-edit-outline" @click="inOutEditMode"></el-button>
      <el-button plain circle icon="el-icon-circle-check" v-if="editContact" @click="inOutEditMode"></el-button>
      <div class="info-detail">
        <el-divider content-position="center">自拍</el-divider>
        <div class="selfie" style="padding: 10px 0px;display:inline-block;">
          <img
            :src="imgUrl"
            object-fit="contain"
            placeholder="未加载成功"
            alt="个人自拍"
            width="200px"
            style="border-radius:5px;"
            v-if="!editContact"
          >
          <el-upload
            v-else
            action="https://jsonplaceholder.typicode.com/posts/"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeSelfieUpload"
            style="border: 1px dashed #d9d9d9;border-radius:6px;position: relative;overflow:hidden"
          >
            <img
              :src="imgUrl"
              object-fit="contain"
              placeholder="未加载成功"
              alt="个人自拍"
              width="200px"
              style="border-radius:5px;"
              v-if="imgUrl"
            >
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
          <p v-if="editContact">
            点击图片上传,
            <em>只支持JPG格式</em>
          </p>
        </div>
        <el-divider content-position="center">个人标签</el-divider>
        <div class="tags" style="clear:both;padding:0px">
          <!-- <el-divider content-position="center"></el-divider> -->

          <el-tag
            class="each-tag"
            v-for="(value,key) in tags"
            :key="key"
            :type="value.attitude==='positive'?'success':'danger'"
            :disable-transitions="false"
            :closable="editContact"
            @close="closeTag(key)"
          >{{ value.name}}</el-tag>
          <el-input
            class="input-new-tag"
            style="width:75px;"
            v-if="inputVisible&&editContact"
            v-model="inputValue"
            ref="saveTagInput"
            size="small"
            @keyup.enter.native="handleInputConfirm"
            @blur="handleInputConfirm"
          ></el-input>
          <el-button
            class="button-new-tag"
            size="small"
            v-if="editContact&&(!inputVisible)"
            @click="showInput"
          >+ New Tag</el-button>
          <!-- <el-button circle icon="el-icon-plus" v-if="editContact"></el-button> -->
        </div>
        <el-divider content-position="center">个人介绍</el-divider>
        <div v-if="!editContact" class="introduction">{{introduction}}</div>
        <el-input
          type="textarea"
          style="width:80%;margin:0 auto;"
          v-else
          autosize
          placeholder="请输入内容"
          v-model="introduction"
        ></el-input>
        <el-divider content-position="center">联系方式</el-divider>
        <div class="contact">
          <div class="contact-item">
            <el-popover placement="top" trigger="focus" title="你在想屁吃" content="梦里什么都会有的">
              <el-button type="primary" slot="reference">
                <i class="fab fa-qq"></i> QQ
              </el-button>
            </el-popover>
          </div>
          <div class="contact-item">
            <el-popover placement="top" trigger="focus" title="你在想屁吃" content="梦里什么都会有的">
              <el-button type="success" slot="reference">
                <i class="fab fa-weixin"></i> 微信
              </el-button>
            </el-popover>
          </div>
          <div class="contact-item">
            <el-popover placement="top" trigger="focus" title="你在想屁吃" content="梦里什么都会有的">
              <el-button plain slot="reference">
                <i class="fab fa-weibo"></i> 微博
              </el-button>
            </el-popover>
          </div>
        </div>
      </div>
    </div>
    <!-- <div class="topic">
      <el-link icon="el-icon-edit" style="font-size: 20px; transition: all 0.5s ease-in-out">个人详细信息</el-link>
    </div>-->
  </div>
</template>

<script>
export default {
  name: "",
  data() {
    return {
      //tag添加相关
      inputVisible: false,
      inputValue: "",

      msg: "It's person info",
      name: "宋晋瑜",
      gender: "boy",
      institue: "软件学院",
      major: "软件工程专业",
      coursePlan: "软件工程培养方案",
      gpa: 3.39,
      currentTermCourseCount: 14,
      takenCourseCount: 39,
      unpassedCourseCount: 0,
      grade: "2",
      sid: "2017141463103",
      debug: true,
      editContact: false,
      introduction:
        "我是练习时长两年半的个人练习生菜徐坤，喜欢唱跳rap篮球,music~鸡你太美",

      imgUrl:
        "https://i.pinimg.com/564x/f5/fc/01/f5fc01ede5e7c45dce87e254bcaa47f3.jpg",

      tags: [
        { name: "死宅", attitude: "negative" },
        { name: "学霸", attitude: "positive" },
        { name: "手速超群", attitude: "positive" },
        { name: "长得丑", attitude: "negative" },
        { name: "没人缘", attitude: "negative" }
      ],
      gradeList: [
        { value: "大一", index: 1 },
        { value: "大二", index: 2 },
        { value: "大三", index: 3 },
        { value: "大四", index: 4 },
        { value: "研一", index: 5 },
        { value: "研二", index: 6 },
        { value: "研三", index: 7 },
        { value: "博士", index: 8 },
        { value: "外星人", index: 9 }
      ]
    };
  },

  methods: {
    inOutEditMode() {
      this.editContact = !this.editContact;
    },
    handleAvatarSuccess(res, file) {
      this.imgUrl = URL.createObjectURL(file.raw);
    },
    beforeSelfieUpload(file) {
      //验证类型
      //file.type
      //file.size
    },

    //tag相关
    closeTag(key) {
      console.log(key);
      this.tags.splice(key, 1);
    },
    showInput() {
      this.inputVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },
    handleInputConfirm() {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.tags.push({
          name: inputValue,
          attitude: Math.random() > 0.5 ? "positive" : "negative" //随机生成态度
        });
      }
      this.inputVisible = false;
      this.inputValue = "";
    }
  }
};
</script>

<style scoped>
.topic:first-child {
  margin-top: 0px;
  margin-bottom: 20px;
}
.topic {
  margin-top: 20px;
  margin-bottom: 20px;
}
.topic:last-child {
  margin-bottom: 50px;
}

.topic .title {
  margin: 30px 0px;
}

.info-detail {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  padding: 20px 5px;
  margin: 20px 5px;
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

.info-item {
  display: inline-block;
  background: linear-gradient(rgb(190, 190, 255), 30%, rgb(168, 168, 255));
  border-radius: 50%;
  height: 100px;
  width: 100px;
  line-height: 100px;
  color: white;
  font-weight: 500;
  font-size: 16px;
  letter-spacing: 2px;
}

/* .name {
  display: inline-block;
  background: linear-gradient(rgb(190, 190, 255), 30%, rgb(168, 168, 255));
  border-radius: 50%;
  height: 100px;
  width: 100px;
  line-height: 100px;
  color: white;
  font-weight: 500;
  font-size: 16px;
  letter-spacing: 2px;
} */

.sid {
  /* background: linear-gradient(#4099ff, 59%, #a537ff); */
  border-radius: 20px;
  height: 80px;
  width: 150px;
  line-height: 80px;
  margin-top: 10px;
  letter-spacing: 1px;
}

.courseplan {
  border-radius: 20px;
  height: 80px;
  width: 150px;
  line-height: 80px;
  margin-top: 10px;
  font-size: 14px;
  letter-spacing: 1px;
}

.label.top {
  margin-bottom: 10px;
  font-weight: 500;
  font-size: 16px;
  color: #666;
  letter-spacing: 3px;
}

.label.bottom {
  margin-top: 10px;
  font-weight: 500;
  font-size: 16px;
  color: #666;
  letter-spacing: 3px;
}

.rowItem {
  margin-top: 20px;
}

.row-info-label {
  font-size: 16px;
  font-weight: 600;
}

.row-info-detail {
  background-color: rgb(190, 190, 255);
  color: white;
  margin: 10px 5px;
  padding: 5px 10px;
  border-radius: 2px;
}

.mainwrap .row {
  margin: 30px 0px;
  text-align: center;
}

.mainwrap .row:first-child {
  margin-top: 15px;
}

.mainwrap .row:last-child {
  margin-bottom: 15px;
}

.tags {
  margin: 0 auto;
  width: 80%;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
}
.tags .each-tag {
  margin: 0 5px;
}

.contact-item {
  display: inline-block;
  margin: 0px 5px;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 200px;
  height: 200px;
  line-height: 200px;
  text-align: center;
}
</style>
