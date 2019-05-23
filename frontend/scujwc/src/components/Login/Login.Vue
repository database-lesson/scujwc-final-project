<template>
  <div class="login-wrap">
    <div class="bg"></div>
    <div class="logo">
      <a href="http://www.scu.edu.cn/">
        <img src="../../assets/Sculogo.png" alt="logo" width="10%">
      </a>
    </div>

    <el-row>
      <el-col
        :xs="{span:18,offset:3}"
        :sm="{span:14,offset:5}"
        :md="{span:10, offset:7}"
        :lg="{span: 8, offset:8}"
      >
        <div class="card">
          <div class="title">四川大学教务系统</div>
          <!-- <div class="line"></div> -->
          <el-tooltip class="item" effect="dark" content="点击进入教师端" placement="top">
            <a class="type" @click="onClickType('student')">学生端</a>
          </el-tooltip>
          <div class="form">
            <el-form
              ref="loginform"
              label-position="top"
              :model="loginform"
              label-width="60px"
              status-icon
              :rules="rules"
            >
              <el-form-item label="用户名" prop="account">
                <el-input v-model="loginform.account" placeholder="请输入用户名" clearable></el-input>
              </el-form-item>
              <el-form-item label="密码" prop="password">
                <el-input v-model="loginform.password" show-password placeholder="请输入密码" clearable></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit('loginform')" style="width:40%">登录</el-button>
                <el-button @click="onReset('loginform')" style="width:40%">清空</el-button>
              </el-form-item>
            </el-form>
            <div class="oper" style="overflow:hidden;margin: 10px 0">
              <el-button
                type="text"
                class="noAccount"
                style="display:inline-block;float:left;"
                @click="onNoAccount"
              >没有账号?</el-button>
              <el-button
                type="text"
                class="forgetPassword"
                style="display:inline-block;float:right;"
                @click="onForgetPassword"
              >忘记密码</el-button>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
    <div class="copyright">Frontend:AnCo Backend:Vaskka</div>
    <!-- <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>卡片名称</span>
        <el-button style="float: right;" type="text">操作按钮</el-button>
      </div>
      <div v-for="o in 4" :key="o" class="text item">{{'列表内容 ' + o }}</div>
    </el-card>-->
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    var validateAccount = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入用户名"));
      } else {
        callback();
      }
    };
    var validatePassword = (rule, value, callback) => {
      var pass = "";
      setTimeout(() => {
        pass = "525923";
        if (value === "") {
          callback(new Error("请输入密码"));
        } else if (value != pass) {
          callback(new Error("密码错误"));
        } else {
          callback();
        }
      }, 1000);
    };
    return {
      bg_list: [
        "../../assets/bg.jpg",
        "../../assets/bg.jpg",
        "../../assets/bg.jpg"
      ],
      msg: "Greeting! You are in Login",
      loginform: {
        account: "",
        password: ""
      },
      rules: {
        password: [
          {
            validator: validatePassword,
            trigger: "blur"
          }
        ],
        account: [
          {
            validator: validateAccount,
            trigger: "blur"
          }
        ]
      }
    };
  },
  created: function() {
    console.log("created");
    var _this = this;

    //绑定按键事件
    document.onkeydown = function(e) {
      console.log("bind");
      let k = window.event.keyCode;
      if (k == 13) {
        console.log("in");
        _this.onSubmit("loginform");
      }
    };
  },
  methods: {
    // validateAccount(formname) {
    //   console.log(formname);
    //   this.$refs[formname].validateField("account");
    // },
    enterKey: function() {
      this.$message({
        message: "enter key!",
        type: "success",
        showClose: true
      });
    },
    onSubmit(formname) {
      // console.log("submit");
      // console.log(this.loginform.account);
      // console.log(this.loginform.password);
      var that = this;
      this.$refs[formname].validate(valid => {
        if (valid) {
          this.$message({
            message: "submit!",
            type: "success",
            showClose: true
          });
          this.$router.push({
            name: "info",
            params: {
              account: that.loginform.account,
              password: that.loginform.password
            }
          });
        } else {
          console.log("error submit");
          this.$notify({
            title: "失败",
            message: "请检查输入",
            type: "error"
          });
          return false;
        }
      });
    },
    onReset(formname) {
      this.$refs[formname].resetFields();
      this.$message({
        message: "已清空",
        type: "success"
      });
    },
    onNoAccount() {
      this.$message("move to no account page");
    },
    onForgetPassword() {
      this.$message("move to forgetpassword page");
    },

    onClickType(type) {
      if (type === "student") {
        this.$message("move to teacher");
      }
    },
    onClickLogo() {
      this.$message("click on logo");
    }
  }
};
</script>

<style scoped>
.login-wrap {
  min-width: 500px;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB",
    "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
}
.login-wrap .bg {
  background-image: url(../../assets/bg.jpg);
  width: calc(102vw);
  height: calc(102vh);
  position: fixed;
  z-index: -1;
  margin-top: -15px;
  margin-left: -15px;
  margin-right: -15px;
  background-size: cover;
}

.login-wrap .logo {
  padding-top: 30px;
}

.login-wrap .logo .logo-text {
  color: white;
  font-family: "Courier New", Courier, monospace;
}
.login-wrap .logo .logo-text .main-text {
  font-size: 4rem;
}

.login-wrap .card {
  border-radius: 4px;
  height: auto;
  padding: 20px;
  margin-top: 30px;
  background-color: rgba(255, 255, 255, 0.9);
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.login-wrap .card .title {
  font-size: 1.5rem;
  padding-top: 20px;
  letter-spacing: 1.7px;
  font-weight: 600;
  color: #303133;
}

.login-wrap .card .type {
  font-size: 1.2rem;
  font-weight: 700;
  letter-spacing: 1.7px;
  margin-top: 10px;
  padding: 5px 10px;
  background-color: #409eff;
  color: white;
  border-radius: 4px;
  display: inline-block;
  width: auto;
  transition: background-color 0.5s;
}

.login-wrap .card .type:hover {
  background-color: #3382d1;
  cursor: pointer;
}

.login-wrap .card .form {
  width: 86%;
  margin: 10px auto;
}

.login-wrap .card .form .el-form-item .el-form-item__label {
  font-size: 26px !important;
  line-height: 20px !important;
}

.line {
  height: 2px;
  margin: 5px 0;
  background-color: #6e6e6e86;
  width: 100%;
}
.login-wrap .copyright {
  position: fixed;
  bottom: 0px;
  background-color: rgba(51, 51, 51, 0.877);
  width: 100%;
  margin-left: -15px;
  padding: 5px;
  color: rgb(163, 163, 163);
  text-align: center;
  letter-spacing: 2px;
  font-size: 12px;
  font-weight: 100;
  line-height: 20px;
}
</style>
