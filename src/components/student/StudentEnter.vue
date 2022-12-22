<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">进校</el-button>
    <el-dialog title="请输入校区ID" :visible.sync="addFormVisible">
      <el-form :model="form" :rules="formRules" ref="formRef" label-width="80px">
        <el-form-item label="校区ID" prop="id">
          <el-input v-model="form.id"
            placeholder="请输入ID"/>
        </el-form-item>
        <div class="u-form-group">
          <el-button type="primary" @click.prevent="enter">进校</el-button>
        </div>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "StudentEnter",
  data () {
    return {
      addFormVisible: false,
      form:{
        id: '',
      },
      formRules: {
        id: [
          { required: true, message: '必填', trigger: 'blur'},
        ],
      },
      log: {
        stuId: 0,
        classId: 0,
        deptId: 0,
        campId: 0,
        time: null,
        type: 0,
      }
    }
  },
  methods: {
    enter () {
      let jsonObj = JSON.parse(window.sessionStorage.user);
      this.log.stuId = jsonObj.user.id
      this.log.classId = jsonObj.user.classId
      this.log.deptId = jsonObj.user.deptId
      this.log.campId = this.form.id
      this.log.time = null
      this.log.type = 0
      this.$axios
        .post('/student/log/', this.log)
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
  }
}
</script>

<style scoped>

</style>
