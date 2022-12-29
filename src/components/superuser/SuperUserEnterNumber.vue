<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">入校申请最多</el-button>
    <el-dialog title="入校申请最多的学生" :visible.sync="addFormVisible">
      <el-table
        ref="filterTable"
        :data="enterReportList"
        style="width: 100%"
        border
        :default-sort = "{prop: 'count', order: 'descending'}">
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
          prop="count"
          label="提交次数">
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "SuperUserEnterNumber",
  data () {
    return {
      addFormVisible: false,
      enterReportList: []
    }
  },
  mounted() {
    this.getEnterReportList();
  },
  methods:{
    getEnterReportList () {
      this.$axios
        .get("/admin/request/enter/count/all/")
        .then(response => {
          if (response.data.code === 0) {
            this.enterReportList = response.data.data
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
