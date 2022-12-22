<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">入校申请</el-button>
    <el-dialog title="入校申请" :visible.sync="addFormVisible">
      <el-form :model="form" :rules="formRules" ref="formRef" label-width="80px">
        <el-form-item label="申请原因" prop="reason">
          <el-input v-model="form.reason"
                    placeholder="请输入"/>
        </el-form-item>
        <el-form-item label="所到地区" prop="region">
          <el-input v-model="form.region"
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
  name: "StudentEnterReport",
  data () {
    return {
      addFormVisible: false,
      formRules: {
        reason: [
          {required: true, message: '请输入健康状况', trigger: 'blur'}
        ],
        region: [
          {required: true, message: '请输入所在地点', trigger: 'blur'}
        ]
      },
      form: {
        stuId: 0,
        classId: 0,
        deptId: 0,
        status: 2,
        subTime: null,
        reason: "",
        region: "",
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
            .post('/student/request/enter/', this.form)
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
