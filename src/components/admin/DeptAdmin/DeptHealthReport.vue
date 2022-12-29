<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">查看填报信息</el-button>
    <el-dialog title="查看填报信息" :visible.sync="addFormVisible">
      <el-form :model="form" :rules="formRules" ref="formRef" label-width="80px">
        <el-form-item label="学生ID" prop="stuId">
          <el-input v-model="form.stuId"></el-input>
        </el-form-item>
        <el-form-item label="天数" prop="days">
          <el-input v-model="form.days"></el-input>
        </el-form-item>
        <div class="u-form-group">
          <el-button type="primary" @click.prevent="report">确定</el-button>
        </div>
      </el-form>
      <el-table
        ref="filterTable"
        :data="healthReportList"
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
          prop="subDate"
          label="提交时间">
        </el-table-column>
        <el-table-column
          prop="health"
          label="健康状况">
        </el-table-column>
        <el-table-column
          prop="location"
          label="所在地">
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "DeptHealthReport",
  data() {
    return {
      addFormVisible: false,
      form: {
        stuId: "",
        days: ""
      },
      formRules: {
        stuId: [
          { required: true, message: "请输入学生ID", trigger: "blur" }
        ],
        days: [
          { required: true, message: "请输入天数", trigger: "blur" },
        ]
      },
      healthReportList: []
    };
  },
  methods: {
    report() {
      this.$refs.formRef.validate(valid => {
        if (valid) {
          let params = new FormData();
          params.append("stuId", this.form.stuId);
          params.append("days", this.form.days);
          this.$axios
            .post("/student/health-report/", params)
            .then(res => {
              if (res.data.code === 0) {
                this.healthReportList = res.data.data;
              } else {
                this.$message({
                  message: res.data.msg,
                  type: "error"
                });
              }
            })
            .catch(err => {
              this.$message({
                message: err,
                type: "error"
              });
            });
        } else {
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>

</style>
