<!-- views/PostDetailView.vue -->
<template>
  <div>
    <h2>게시글 상세보기</h2>
    <p>ID: {{ postId }}</p>
    <!-- 상세 정보 표시 등 -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      postId: null
    };
  },
  mounted() {
    // 뷰가 마운트되면 postId를 라우터에서 받아와서 설정
    this.postId = this.$route.params;
  }
};
</script>

<style scoped>
/* 컴포넌트에 대한 스타일은 여기에 추가 */
</style>
