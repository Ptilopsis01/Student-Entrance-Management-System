<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">入校申请最多</el-button>
    <el-dialog title="入校申请最多的学生" :visible.sync="addFormVisible">
      <el-input v-model="number" placeholder="输入数量" class="input-with-select">
        <el-button slot="append" @click.prevent="getEnterReportList()">确定</el-button>
      </el-input>
      <el-table
        ref="filterTable"
        :data="enterReportList"
        style="width: 100%"
        border>
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
  name: "ClassEnterNumber",
  data () {
    return {
      addFormVisible: false,
      number: 0,
      enterReportList: [],
      enterReportListAll: []
    }
  },
  methods:{
    getEnterReportList () {
      let jsonObj = JSON.parse(window.sessionStorage.user)
      let url = "/admin/request/enter/count/class/" + jsonObj.user.classId
      this.$axios
        .get(url)
        .then(response => {
          if (response.data.code === 0) {
            this.enterReportListAll = response.data.data
            this.enterReportList = this.enterReportListAll.slice(0, this.number)
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
