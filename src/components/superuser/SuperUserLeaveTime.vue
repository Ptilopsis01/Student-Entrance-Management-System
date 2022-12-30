<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">离校时间最长</el-button>
    <el-dialog title="离校时间最长的学生" :visible.sync="addFormVisible">
      <el-row>
        <el-col :span="12"><el-button type="primary" @click="getLeaveReportList('all')">获取所有</el-button></el-col>
        <el-col :span="12">
          <el-input v-model="number" placeholder="输入数量"></el-input>
        </el-col>
      </el-row>
      <el-input v-model="classId" class="input-with-select" placeholder="搜索班级">
        <el-button slot="append" @click.prevent="getLeaveReportList('class')">确定</el-button>
      </el-input>
      <el-input v-model="deptId" class="input-with-select" placeholder="搜索院系">
        <el-button slot="append" @click.prevent="getLeaveReportList('dept')">确定</el-button>
      </el-input>
      <el-table
        ref="filterTable"
        :data="leaveReportList.slice(0, this.number)"
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
  name: "SuperUserLeaveTime",
  data () {
    return {
      addFormVisible: false,
      leaveReportList: [],
      number: 0,
      classId: '',
      deptId: ''
    }
  },
  methods:{
    getLeaveReportList (type) {
      let url = '';
      switch (type) {
        case 'all':
          url = "/admin/leave-time/all/"
          break
        case 'class':
          url = "/admin/leave-time/class/" + this.classId
          break
        case 'dept':
          url = "/admin/leave-time/dept/" + this.deptId
          break
      }
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
