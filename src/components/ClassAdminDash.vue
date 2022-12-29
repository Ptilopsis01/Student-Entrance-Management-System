<template>
  <div>
    <h1>辅导员页面</h1>
    <el-row style="position: relative; top: 50px;">
      <el-col :span="12"><class-enter-report></class-enter-report></el-col>
      <el-col :span="12"><class-leave-report></class-leave-report></el-col>
    </el-row>
    <el-row style="position: relative; top: 100px;">
      <el-col :span="12"><class-enter-number></class-enter-number></el-col>
      <el-col :span="12"><class-leave-time></class-leave-time></el-col>
    </el-row>
    <el-row style="position: relative; top: 150px;">
      <el-col :span="12"><class-health-report></class-health-report></el-col>
      <el-col :span="12"><class-student-leave-time></class-student-leave-time></el-col>
    </el-row>
  </div>
</template>

<script>
import ClassEnterReport from "./admin/ClassAdmin/ClassEnterReport.vue";
import ClassLeaveReport from "./admin/ClassAdmin/ClassLeaveReport.vue";
import ClassEnterNumber from "./admin/ClassAdmin/ClassEnterNumber.vue";
import ClassLeaveTime from "./admin/ClassAdmin/ClassLeaveTime.vue";
import ClassHealthReport from "./admin/ClassAdmin/ClassHealthReport.vue";
import ClassStudentLeaveTime from "./admin/ClassAdmin/ClassStudentLeaveTime.vue";
export default {
  name: "ClassAdminDash",
  components: {ClassHealthReport, ClassLeaveTime, ClassLeaveReport, ClassEnterReport, ClassEnterNumber, ClassStudentLeaveTime}
}
</script>

<style scoped>

</style>
