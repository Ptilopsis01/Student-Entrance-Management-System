<template>
  <div>
    <el-button type="plain" @click.prevent="login">超级用户</el-button>
  </div>
</template>

<script>
export default {
  name: "SuperUserLogin",
  data () {
    return {
    }
  },
  methods: {
    login() {
      this.$store.commit('login', {
        user: {
          role: 'superuser',
        },
      })
      this.$router.push('/superuser')
      }
  }
}
</script>

<style scoped>

</style>
