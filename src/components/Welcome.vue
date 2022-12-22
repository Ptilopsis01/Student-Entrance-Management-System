<template>
  <div id="bg">
    <div>
      <h1 class="text">{{ msg }}</h1>
      <el-row style="position: absolute; top: 50%; left: 25%; width: 50%">
        <el-col :span="8"><student-login></student-login></el-col>
        <el-col :span="8"><admin-login></admin-login></el-col>
        <el-col :span="8"><super-user-login></super-user-login></el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import AdminLogin from "./admin/AdminLogin.vue";
import StudentLogin from "./student/StudentLogin.vue";
import SuperUserLogin from "./superuser/SuperUserLogin.vue";
export default {
  name: 'Welcome',
  components: {SuperUserLogin, StudentLogin, AdminLogin},
  data () {
    return {
      msg: 'Welcome to the Student Entrance Management System',
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#bg {
  background:url("~@/assets/bg005all.jpg");
  width:100%;
  height:100%;
  background-size: cover;
  position: fixed;
}
.text {
  text-shadow: ghostwhite 0 0 10px;
  position: absolute;
  transform: translate(-50%,-50%);
  top: 40%;
  left: 50%;
  color: #001006;
  font-family: 'Futura', sans-serif;
}
</style>
