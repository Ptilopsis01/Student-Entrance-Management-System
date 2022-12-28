<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">每日填报</el-button>
    <el-dialog title="每日填报" :visible.sync="addFormVisible">
      <el-form :model="form" :rules="formRules" ref="formRef" label-width="80px">
        <el-form-item label="健康状况" prop="health">
          <el-input v-model="form.health"
                    placeholder="请输入"/>
        </el-form-item>
        <el-form-item label="所在地点" prop="location">
          <el-input v-model="form.location"
                    placeholder="请输入"/>
        </el-form-item>
        <div class="u-form-group">
          <el-button type="primary" @click.prevent="report">提交</el-button>
        </div>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "StudentDailyReport",
  data () {
    return {
      addFormVisible: false,
      formRules: {
        health: [
          {required: true, message: '请输入健康状况', trigger: 'blur'}
        ],
        location: [
          {required: true, message: '请输入所在地点', trigger: 'blur'}
        ]
      },
      form: {
        stuId: 0,
        classId: 0,
        deptId: 0,
        sub_date: null,
        health: "",
        location: "",
      }
    }
  },
  methods: {
    report () {
      this.$refs.formRef.validate((valid) => {
        if (valid) {
          let jsonObj = JSON.parse(window.sessionStorage.user);
          this.form.stuId = jsonObj.user.id
          this.form.classId = jsonObj.user.classId
          this.form.deptId = jsonObj.user.deptId
          this.$axios
            .post('/student/health-report/add/', this.form)
            .then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: res.data.msg,
                  type: 'success'
                })
                this.addFormVisible = false
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
      })
    }
  }
}
</script>

<style scoped>

</style>
