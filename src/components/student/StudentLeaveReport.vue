<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">离校申请</el-button>
    <el-dialog title="离校申请" :visible.sync="addFormVisible">
      <el-form :model="form" :rules="formRules" ref="formRef" label-width="80px">
        <el-form-item label="离校日期" prop="leaveTime">
          <el-date-picker
            v-model="form.leaveTime"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="返校日期" prop="backTime">
          <el-date-picker
            v-model="form.backTime"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="离校原因" prop="reason">
          <el-input type="textarea" v-model="form.reason"></el-input>
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
  name: "StudentLeaveReport",
  data () {
    return {
      addFormVisible: false,
      formRules: {
        leaveTime: [
          {required: true, message: '请选择离校日期', trigger: 'change'}
        ],
        backTime: [
          {required: true, message: '请选择返校日期', trigger: 'change'}
        ]
      },
      form: {
        stuId: 0,
        classId: 0,
        deptId: 0,
        status: 2,
        subTime: null,
        leaveTime: null,
        backTime: null,
        reason: "",
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
            .post('/student/request/leave/', this.form)
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
