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
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "SuperUserEnterReport",
  data () {
    return {
      visible: false,
      addFormVisible: false,
      enterReportList: [],
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
    getEnterReportList() {
      this.$axios
        .get("/admin/request/enter/all/")
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
  }
}
</script>

<style scoped>

</style>
