<!-- PageHeader.vue -->
<template>
  <header>
    <div id="nav">
      <router-link to="/main">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link class="nav-link" active-class="active" to="/posts/list">게시판</router-link>
    </div>
  </header>
  <hr/>
</template>

<script>
export default {

}
</script>

<style scoped>

</style>
