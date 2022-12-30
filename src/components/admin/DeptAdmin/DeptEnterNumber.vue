<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">入校申请最多</el-button>
    <el-dialog title="入校申请最多的学生" :visible.sync="addFormVisible">
      <el-row>
        <el-col :span="12"><el-button type="primary" @click="getEnterReportList('all')">获取所有</el-button></el-col>
        <el-col :span="12">
          <el-input v-model="number" placeholder="输入数量"></el-input>
        </el-col>
      </el-row>
      <el-input v-model="classId" class="input-with-select" placeholder="搜索班级">
        <el-button slot="append" @click.prevent="getEnterReportList('class')">确定</el-button>
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
  name: "DeptEnterNumber",
  data () {
    return {
      addFormVisible: false,
      number: 0,
      enterReportList: [],
      enterReportListAll: [],
      classId: '',
      classList: [],
    }
  },
  mounted() {
    this.getClassList();
  },
  methods:{
    async getClassList() {
      let jsonObj = JSON.parse(window.sessionStorage.user)
      let url = "/admin/class/list/" + jsonObj.user.deptId
      this.$axios
        .get(url)
        .then(res => {
          if (res.data.code === 0) {
            this.classList = res.data.data
          }
        else {
          this.$message.error(res.data.msg)
        }
      })
        .catch(err => {
          this.$message.error(err)
        })
    },
    getEnterReportList (type) {
      let jsonObj = JSON.parse(window.sessionStorage.user)
      let url = '';
      switch (type) {
        case 'all':
          url = "/admin/request/enter/count/dept/" + jsonObj.user.deptId
          break
        case 'class':
          url = "/admin/request/enter/count/class/" + this.classId
          break
      }
      let judge = false;
      for (let i = 0; i < this.classList.length; i++) {
        if (this.classList[i].id === parseInt(this.classId)) {
          judge = true;
          break;
        }
      }
      if (judge === false && type === 'class') {
        this.$message.error("班级超出权限范围")
      }
      else {
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
    }
  },
}
</script>

<style scoped>

</style>
