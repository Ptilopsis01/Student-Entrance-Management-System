<template>
  <div>
    <el-button type="primary" @click="addFormVisible=true">查看申请未离校学生</el-button>
    <el-dialog title="查看申请未离校学生" :visible.sync="addFormVisible">
      <el-table :data="students" style="width: 100%">
        <el-table-column prop="id" label="学号" fixed="left"></el-table-column>
        <el-table-column prop="name" label="姓名"></el-table-column>
        <el-table-column prop="phone" label="电话"></el-table-column>
        <el-table-column prop="email" label="邮箱"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
        <el-table-column prop="home" label="宿舍"></el-table-column>
        <el-table-column prop="className" label="班级"></el-table-column>
        <el-table-column prop="dept" label="院系"></el-table-column>
        <el-table-column prop="idType" label="证件种类"></el-table-column>
        <el-table-column prop="idNum" label="证件号码"></el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "SuperUserNotLeftInRequest",
  data() {
    return {
      addFormVisible: false,
      students: []
    };
  },
  mounted() {
    this.getLeftStudent();
  },
  methods: {
    getLeftStudent() {
      this.$axios
        .get("/admin/student/not-leave/in-request/")
        .then(response => {
          if (response.data.code === 0) {
            this.students = response.data.data;
          } else {
            this.$message.error(response.data.msg);
          }
        })
        .catch(error => {
          this.$message.error(error);
        });
    }
  },
}
</script>

<style scoped>

</style>
