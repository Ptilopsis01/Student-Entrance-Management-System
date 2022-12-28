<template>
  <div>
    <h1>管理员页面</h1>
    <el-row style="position: relative; top: 50px;">
      <el-col :span="12"><dept-enter-report></dept-enter-report></el-col>
      <el-col :span="12"><dept-leave-report></dept-leave-report></el-col>
    </el-row>
    <el-row style="position: relative; top: 100px;">
      <el-col :span="12"><dept-enter-number></dept-enter-number></el-col>
      <el-col :span="12"><dept-leave-time></dept-leave-time></el-col>
    </el-row>
    <el-row style="position: relative; top: 150px;">
      <el-col :span="24"><dept-health-report></dept-health-report></el-col>
    </el-row>
  </div>
</template>

<script>
import DeptEnterReport from "./admin/DeptAdmin/DeptEnterReport.vue";
import DeptLeaveReport from "./admin/DeptAdmin/DeptLeaveReport.vue";
import DeptEnterNumber from "./admin/DeptAdmin/DeptEnterNumber.vue";
import DeptLeaveTime from "./admin/DeptAdmin/DeptLeaveTime.vue";
import DeptHealthReport from "./admin/DeptAdmin/DeptHealthReport.vue";
export default {
  name: "DeptAdminDash",
  components: {DeptHealthReport, DeptLeaveTime, DeptLeaveReport, DeptEnterReport, DeptEnterNumber}

}
</script>

<style scoped>

</style>
