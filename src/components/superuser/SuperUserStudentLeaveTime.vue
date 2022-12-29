<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">查看学生离校时间</el-button>
    <el-dialog title="查看填报信息" :visible.sync="addFormVisible">
      <el-input v-model="stuId" class="input-with-select">
        <el-button slot="append" @click.prevent="search">确定</el-button>
      </el-input>
      <el-descriptions direction="vertical" :column="2" border>
        <el-descriptions-item label="学生ID">{{ stuId }}</el-descriptions-item>
        <el-descriptions-item label="离校时长(min)">{{ leaveTime }}</el-descriptions-item>
      </el-descriptions>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "SuperUserStudentLeaveTime",
  data() {
    return {
      addFormVisible: false,
      stuId: "",
      leaveTime: "",
    };
  },
  methods: {
    search() {
      let url2 = "/admin/leave-time/student/" + this.stuId
      this.$axios
        .get(url2)
        .then(res => {
          if (res.data.code === 0) {
            this.leaveTime = res.data.data
          } else {
            this.$message.error(res.data.msg)
          }
        })
        .catch(err => {
          this.$message.error(err)
        });
    }
  }
}
</script>

<style scoped>

</style>
