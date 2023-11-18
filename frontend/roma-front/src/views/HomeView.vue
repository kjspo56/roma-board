<template>
  <div class="home">
    <PageHeader/>
    <img alt="Vue logo" src="../assets/logo.png">
    <PageMain msg="Welcome to MainPage"/>
    <PageFooter/>
  </div>
</template>

<script>
// @ is an alias to /src
import PageHeader from "@/components/PageHeader";
import PageMain from "@/components/PageMain";
import PageFooter from "@/components/PageFooter";

export default {
  name: 'HomeView',
  components: {
    PageHeader,
    PageMain,
    PageFooter
  }
}
</script>
