<template>
  <div>
    <el-button type="primary" @click="addFormVisible = true">个人信息</el-button>
    <el-dialog title="个人信息" :visible.sync="addFormVisible">
      <el-button type="primary" size="small" @click="edit = true">编辑</el-button>
      <el-descriptions class="margin-top" border direction="vertical" :column="3"  v-if="!edit">
        <el-descriptions-item label="ID">{{ student.id }}</el-descriptions-item>
        <el-descriptions-item label="姓名">{{ student.name }}</el-descriptions-item>
        <el-descriptions-item label="手机号">{{ student.phone }}</el-descriptions-item>
        <el-descriptions-item label="邮箱">{{ student.email }}</el-descriptions-item>
        <el-descriptions-item label="住址">{{ student.address }}</el-descriptions-item>
        <el-descriptions-item label="宿舍">{{ student.home }}</el-descriptions-item>
        <el-descriptions-item label="证件类型">{{ student.idType }}</el-descriptions-item>
        <el-descriptions-item label="证件号码">{{ student.idNum }}</el-descriptions-item>
        <el-descriptions-item label="班级ID">{{ student.classId }}</el-descriptions-item>
        <el-descriptions-item label="院系ID">{{ student.deptId }}</el-descriptions-item>
      </el-descriptions>
      <el-form :model="form" :rules="formRules" ref="formRef" label-width="80px" v-if="edit">
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone"
                    :placeholder="student.phone"/>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email"
                    :placeholder="student.email"/>
        </el-form-item>
        <el-form-item label="住址" prop="address">
          <el-input v-model="form.address"
                    :placeholder="student.address"/>
        </el-form-item>
        <el-form-item label="证件类型" prop="idType">
          <el-input v-model="form.idType"
                    :placeholder="student.idType"/>
        </el-form-item>
        <el-form-item label="证件号码" prop="idNum">
          <el-input v-model="form.idNum"
                    :placeholder="student.idNum"/>
        </el-form-item>
        <div class="u-form-group" v-if="edit">
          <el-button type="primary" @click.prevent="edit=false">取消</el-button>
          <el-button type="primary" @click.prevent="editInfo()">确定</el-button>
        </div>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "StudentInfo",
  data () {
    return {
      edit: false,
      addFormVisible: false,
      form: {
        phone: '',
        email: '',
        address: '',
        idType: '',
        idNum: '',
      },
      formRules: {
        phone: [
          { required: true, message: '请输入手机号', trigger: 'blur' },
          { pattern: /^1[3456789]\d{9}$/, message: '手机号格式不正确', trigger: 'blur' }
        ],
        email: [
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { pattern: /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/,
            message: '邮箱格式不正确', trigger: 'blur' }
        ],
        address: [
          { required: true, message: '请输入住址', trigger: 'blur' },
        ],
        idType: [
          { required: true, message: '请输入证件类型', trigger: 'blur' },
        ],
        idNum: [
          { required: true, message: '请输入证件号码', trigger: 'blur' },
        ],
      },
      student: {
        id: 0,
        name: "",
        phone: "",
        email: "",
        address: "",
        home: "",
        idType: "",
        idNum: "",
        classId: 0,
        deptId: 0,
      },
    }
  },
  mounted() {
    this.getStudentInfo();
  },
  methods: {
    getStudentInfo () {
      let jsonObj = JSON.parse(window.sessionStorage.user);
      let url = '/student/info/' + jsonObj.user.id;
      this.$axios
        .get(url)
        .then(res => {
          if (res.data.code === 0) {
            this.student = res.data.data
            this.form = res.data.data
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
    editInfo () {
      this.$refs.formRef.validate((valid) => {
        if (valid) {
          this.$axios
            .post('/student/info/', this.form)
            .then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: res.data.msg,
                  type: 'success'
                })
                this.edit = false;
                this.getStudentInfo();
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
        } else {
          return false;
        }
      });
    }
  },
}
</script>

<style scoped>

</style>
