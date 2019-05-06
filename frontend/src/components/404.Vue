<template>
  <div class="error">
    <div class="text">这是404页面</div>
    <div>
      <router-link to="/">返回首页</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "Error",
  data() {
    return {};
  }
};
</script>

<style scoped>
.error {
  margin-top: 60px;
  text-align: center;
  color: #303133;
}
.error .text {
  font-size: 30px;
}
</style>
