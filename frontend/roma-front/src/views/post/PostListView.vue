<template>
  <div>
    <PageHeader/>
    <PostList/>
    <PageFooter/>
  </div>
</template>

<script>
import PageHeader from '@/components/PageHeader';
import PostList from '@/components/PostList';
import PageFooter from '@/components/PageFooter';

export default {
  components: {
    PostList,
    PageHeader,
    PageFooter
  }
};
</script>

<style scoped>
/* 뷰에 대한 스타일은 여기에 추가 */
</style>