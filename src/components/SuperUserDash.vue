<template>
  <div>
    <h1>超级用户页面</h1>
    <el-row style="position: relative; top: 50px;">
      <el-col :span="8"><super-user-enter-report></super-user-enter-report></el-col>
      <el-col :span="8"><super-user-leave-report></super-user-leave-report></el-col>
      <el-col :span="8"><super-user-health-report></super-user-health-report></el-col>
    </el-row>
    <el-row style="position: relative; top: 100px;">
      <el-col :span="8"><super-user-unapproved-request></super-user-unapproved-request></el-col>
      <el-col :span="8"><super-user-leave-time></super-user-leave-time></el-col>
      <el-col :span="8"><super-user-student-leave-time></super-user-student-leave-time></el-col>
    </el-row>
    <el-row style="position: relative; top: 150px;">
      <el-col :span="8"><super-user-enter-number></super-user-enter-number></el-col>
      <el-col :span="8"><super-user-left-student></super-user-left-student></el-col>
      <el-col :span="8"></el-col>
    </el-row>
  </div>
</template>

<script>
import SuperUserEnterReport from "./superuser/SuperUserEnterReport.vue";
import SuperUserLeaveReport from "./superuser/SuperUserLeaveReport.vue";
import SuperUserHealthReport from "./superuser/SuperUserHealthReport.vue";
import SuperUserUnapprovedRequest from "./superuser/SuperUserUnapprovedRequest.vue";
import SuperUserLeaveTime from "./superuser/SuperUserLeaveTime.vue";
import SuperUserStudentLeaveTime from "./superuser/SuperUserStudentLeaveTime.vue";
import SuperUserEnterNumber from "./superuser/SuperUserEnterNumber.vue";
import SuperUserLeftStudent from "./superuser/SuperUserLeftStudent.vue";
export default {
  name: "SuperUserDash",
  components: {
    SuperUserLeftStudent,
    SuperUserEnterNumber,
    SuperUserStudentLeaveTime,
    SuperUserLeaveTime,
    SuperUserUnapprovedRequest, SuperUserHealthReport, SuperUserLeaveReport, SuperUserEnterReport}
}
</script>

<style scoped>

</style>
