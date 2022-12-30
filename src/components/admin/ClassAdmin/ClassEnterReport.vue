<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">查看入校申请</el-button>
    <el-dialog title="查看入校申请" :visible.sync="addFormVisible">
      <el-table
        ref="filterTable"
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
          label="状态"
          :filters="[
            { text: '未处理', value: 2 },
            { text: '已同意', value: 1 },
            { text: '已拒绝', value: 0 }
          ]"
          :filter-method="filterHandler">
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
              @click="approve(scope.row, 1)"
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
                <el-button type="primary" @click.prevent="approve(scope.row, 0)">提交</el-button>
              </div>
            </el-dialog>
            <el-button
              type="text"
              @click="getHealth(scope.row)">查看</el-button>
            <el-dialog
              title="过去7天健康报告"
              :visible.sync="view">
              <el-table
                :data="healthReportList"
                style="width: 100%"
                border>
                <el-table-column
                  prop="stuId"
                  label="学生ID"
                  fixed="left">
                </el-table-column>
                <el-table-column
                  prop="subDate"
                  label="日期">
                </el-table-column>
                <el-table-column
                  prop="health"
                  label="健康状况">
                </el-table-column>
                <el-table-column
                  prop="location"
                  label="定位">
                </el-table-column>
              </el-table>
            </el-dialog>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "ClassEnterReport",
  data () {
    return {
      visible: false,
      view: false,
      addFormVisible: false,
      enterReportList: [],
      healthReportList: [],
      refReason: ''
    }
  },
  mounted () {
    this.getEnterReportList()
  },
  methods: {
    filterHandler(value, row, column) {
      const property = column['property'];
      return row[property] === value;
    },
    getEnterReportList () {
      let jsonObj = JSON.parse(window.sessionStorage.user);
      let url = '/admin/request/enter/class/' + jsonObj.user.classId
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
    approve (row, status) {
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
    getHealth (row) {
      let params = new FormData();
      params.append('stuId', row.stuId);
      params.append('days', '7');
      this.$axios
        .post('/student/health-report/', params)
        .then(res => {
          if (res.data.code === 0) {
            this.healthReportList = res.data.data
            this.view = true
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
    }
  },
}
</script>

<style scoped>

</style>
