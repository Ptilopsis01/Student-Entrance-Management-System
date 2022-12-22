<template>
  <div>
    <h1>学生页面</h1>
    <el-row style="position: relative; top: 50px;">
      <el-col :span="8"><student-enter></student-enter></el-col>
      <el-col :span="8"><span>当前进校权限：{{authToLabel}}</span></el-col>
      <el-col :span="8"><student-leave></student-leave></el-col>
    </el-row>
    <el-row style="position: relative; top: 100px;">
      <el-col :span="8"><student-daily-report></student-daily-report></el-col>
      <el-col :span="8"><student-enter-report></student-enter-report></el-col>
      <el-col :span="8"><student-leave-report></student-leave-report></el-col>
    </el-row>
  </div>
</template>

<script>
import {getLabel} from "../utils/methods";
import StudentEnter from "./student/StudentEnter.vue";
import StudentLeave from "./student/StudentLeave.vue";
import StudentDailyReport from "./student/StudentDailyReport.vue";
import StudentEnterReport from "./student/StudentEnterReport.vue";
import StudentLeaveReport from "./student/StudentLeaveReport.vue";
export default {
  name: "StudentDash",
  components: {StudentLeaveReport, StudentEnterReport, StudentDailyReport, StudentLeave, StudentEnter},
  data() {
    return {
      auth: 0,
      authToLabel: "",
      list: [
        {label: "无权限", value: 0},
        {label: "有权限", value: 1},
      ]
    };
  },
  mounted() {
    this.getAuth();
  },
  methods: {
    async getAuth() {
      let jsonObj = JSON.parse(window.sessionStorage.user);
      let url = "/student/auth/" + jsonObj.user.id;
      this.$axios.get(url)
        .then((response) => {
        this.auth = response.data.data;
        this.authToLabel = getLabel(this.list, this.auth, "value", "label");
      });
    },
  },
}
</script>

<style scoped>

</style>
