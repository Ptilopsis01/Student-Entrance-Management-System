<template>
  <div>
    <el-button type="primary" @click="addFormVisible=true">未处理入校/出校申请</el-button>
    <el-dialog title="未审核入校出校申请" :visible.sync="addFormVisible">
      <el-input v-model="days1" class="input-with-select">
        <el-button slot="append" @click.prevent="getEnterReportList">确定</el-button>
      </el-input>
      <el-table
        title="入校申请"
        :data="enterReportList"
        style="width: 100%"
        border>
        <el-table-column
          prop="stuId"
          label="学生ID"
          fixed="left">
        </el-table-column>
        <el-table-column
          prop="classId"
          label="班级ID">
        </el-table-column>
        <el-table-column
          prop="deptId"
          label="院系ID">
        </el-table-column>
        <el-table-column
          prop="subTime"
          label="提交时间">
        </el-table-column>
        <el-table-column
          prop="reason"
          label="理由">
        </el-table-column>
        <el-table-column
          prop="region"
          label="途径地区">
        </el-table-column>
        <el-table-column
          prop="status"
          label="状态">
        </el-table-column>
        <el-table-column
          prop="refReason"
          label="拒绝理由">
        </el-table-column>
        <el-table-column
          label="操作"
          fixed="right">
          <template v-slot="scope">
            <el-button
              type="text"
              @click="approveEnter(scope.row, 1)"
              :disabled="scope.row.status !== 2">同意</el-button>
            <el-button
              type="text"
              @click="visible=true"
              :disabled="scope.row.status !== 2">拒绝</el-button>
            <el-dialog
              title="请填写理由"
              :visible.sync="visible">
              <el-input
                type="textarea"
                v-model="refReason"
                placeholder="请输入内容">
              </el-input>
              <div class="u-form-group">
                <el-button type="primary" @click.prevent="approveEnter(scope.row, 0)">提交</el-button>
              </div>
            </el-dialog>
          </template>
        </el-table-column>
      </el-table>

      <el-divider></el-divider>

      <el-input v-model="days2" class="input-with-select">
        <el-button slot="append" @click.prevent="getLeaveReportList">确定</el-button>
      </el-input>
      <el-table
        title="出校申请"
        :data="leaveReportList"
        style="width: 100%"
        border>
        <el-table-column
          prop="stuId"
          label="学生ID"
          fixed="left">
        </el-table-column>
        <el-table-column
          prop="classId"
          label="班级ID">
        </el-table-column>
        <el-table-column
          prop="deptId"
          label="院系ID">
        </el-table-column>
        <el-table-column
          prop="subTime"
          label="提交时间">
        </el-table-column>
        <el-table-column
          prop="reason"
          label="理由">
        </el-table-column>
        <el-table-column
          prop="leaveTime"
          label="离校时间">
        </el-table-column>
        <el-table-column
          prop="backTime"
          label="返校时间">
        </el-table-column>
        <el-table-column
          prop="status"
          label="状态">
        </el-table-column>
        <el-table-column
          prop="refReason"
          label="拒绝理由">
        </el-table-column>
        <el-table-column
          label="操作"
          fixed="right">
          <template v-slot="scope">
            <el-button
              type="text"
              @click="approveLeave(scope.row, 1)"
              :disabled="scope.row.status !== 2">同意</el-button>
            <el-button
              type="text"
              @click="visible=true"
              :disabled="scope.row.status !== 2">拒绝</el-button>
            <el-dialog
              title="请填写理由"
              :visible.sync="visible">
              <el-input
                type="textarea"
                v-model="refReason"
                placeholder="请输入内容">
              </el-input>
              <div class="u-form-group">
                <el-button type="primary" @click.prevent="approveLeave(scope.row, 0)">提交</el-button>
              </div>
            </el-dialog>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "SuperUserUnapprovedRequest",
  data () {
    return {
      visible: false,
      addFormVisible: false,
      days1: 0,
      days2: 0,
      enterReportList: [],
      leaveReportList: [],
      refReason: ''
    }
  },
  methods: {
    getEnterReportList () {
      let url = '/admin/request/enter/un/' + this.days1
      this.$axios
        .get(url)
        .then(res => {
          if (res.data.code === 0) {
            this.enterReportList = res.data.data
          } else {
            this.$message({
              message: res.data.msg,
              type: 'error'
            })
          }
        })
        .catch(err => {
          this.$message({
            message: err,
            type: 'error'
          })
        })
    },
    getLeaveReportList () {
      let url = '/admin/request/leave/un/' + this.days2
      this.$axios
        .get(url)
        .then(res => {
          if (res.data.code === 0) {
            this.leaveReportList = res.data.data
          } else {
            this.$message({
              message: res.data.msg,
              type: 'error'
            })
          }
        })
        .catch(err => {
          this.$message({
            message: err,
            type: 'error'
          })
        })
    },
    approveEnter (row, status) {
      let params = new FormData();
      params.append('status', status);
      params.append('reason', this.refReason);
      params.append('id', row.id);
      this.$axios
        .post('/admin/request/enter/approve/', params)
        .then(res => {
          if (res.data.code === 0) {
            this.$message({
              message: res.data.msg,
              type: 'success'
            })
            this.refReason = ''
            this.getEnterReportList()
            this.visible = false
          } else {
            this.$message({
              message: res.data.msg,
              type: 'error'
            })
            this.refReason = ''
          }
        })
        .catch(err => {
          this.$message({
            message: err,
            type: 'error'
          })
        })
    },
    approveLeave (row, status) {
      let params = new FormData();
      params.append('status', status);
      params.append('reason', this.refReason);
      params.append('id', row.id);
      this.$axios
        .post('/admin/request/leave/approve/', params)
        .then(res => {
          if (res.data.code === 0) {
            this.$message({
              message: res.data.msg,
              type: 'success'
            })
            this.refReason = ''
            this.getLeaveReportList()
            this.visible = false
          } else {
            this.$message({
              message: res.data.msg,
              type: 'error'
            })
            this.refReason = ''
          }
        })
        .catch(err => {
          this.$message({
            message: err,
            type: 'error'
          })
        })
    },
  },
}
</script>

<style scoped>

</style>
