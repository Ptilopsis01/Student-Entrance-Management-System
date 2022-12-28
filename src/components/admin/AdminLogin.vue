<template>
  <div>
    <el-button @click="addFormVisible = true" type="plain">管理员</el-button>
    <el-dialog title="管理员登录" :visible.sync="addFormVisible">
      <el-form
        :model="loginForm"
        ref="loginFormRef"
        :rules="loginFormRules">
        <el-form-item class="u-form-group" prop="id">
          <el-input
            type="text"
            v-model="loginForm.id"
            placeholder="请输入ID"/>
        </el-form-item>
        <div class="u-form-group">
          <el-button type="primary" @click.prevent="login">登录</el-button>
        </div>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "AdminLogin",
  data () {
    return {
      addFormVisible: false,
      loginForm: {
        id: '',
      },
      loginFormRules: {
        id: [
          { required: true, message: '必填', trigger: 'blur'},
        ],
      },
    }
  },
  methods: {
    login() {
      this.$refs.loginFormRef.validate((valid) => {
        if (valid) {
          const params = new FormData();
          params.append('id', this.loginForm.id);
          this.$axios
            .post('/admin/login/', params)
            .then(resp => {
              if (resp.data.code === 0) {
                this.$store.commit('login', {
                  user: {
                    id: resp.data.data.id,
                    name: resp.data.data.username,
                    classId: resp.data.data.classId,
                    deptId: resp.data.data.deptId,
                    role: resp.data.data.type,
                  }
                })
                this.$message({
                  message: resp.data.msg,
                  type: 'success'
                })
                if (resp.data.data.type === "class") {
                  this.$router.push({path: '/admin/class'})
                } else if (resp.data.data.type === "department") {
                  this.$router.push({path: '/admin/dept'})
                }
              } else {
                this.$message({
                  message: resp.data.msg,
                  type: 'error'
                })
              }
            })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
  },
}
</script>

<style scoped>

</style>
