<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">离校时间最长</el-button>
    <el-dialog title="离校时间最长的学生" :visible.sync="addFormVisible">
      <el-table
        ref="filterTable"
        :data="leaveReportList"
        style="width: 100%"
        border
        :default-sort = "{prop: 'leaveTime', order: 'descending'}">
        <el-table-column
          label="序号"
          width="50"
          fixed="left">
          <template v-slot="scope">
            <span>{{ scope.$index + 1 }}</span>
          </template>
        </el-table-column>
        <el-table-column
          prop="id"
          label="学生ID"
          fixed="left">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名">
        </el-table-column>
        <el-table-column
          prop="leaveTime"
          label="离校时长(min)">
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "DeptLeaveTime",
  data () {
    return {
      addFormVisible: false,
      leaveReportList: []
    }
  },
  mounted() {
    this.getLeaveReportList();
  },
  methods:{
    getLeaveReportList () {
      let jsonObj = JSON.parse(window.sessionStorage.user)
      let url = "/admin/leave-time/dept/" + jsonObj.user.deptId
      this.$axios
        .get(url)
        .then(response => {
          if (response.data.code === 0) {
            this.leaveReportList = response.data.data
          }
          else {
            this.$message.error(response.data.msg)
          }
        })
        .catch(err => {
          this.$message.error(err)
        })
    }
  },
}
</script>

<style scoped>

</style>
