<!-- views/PostDetailView.vue -->
<template>
  <div>
    <h2>게시글 상세보기</h2>
    <p>ID: {{ result.postId }}</p>
    <p>제목: {{ result.title }}</p>
    <p>내용: {{ result.content }}</p>
    <p>작성자: {{ result.writer }}</p>
    <p>추천수: {{ result.postLike }}</p>
    <p>업데이트 날짜: {{ result.regDate }}</p>
    <p>업데이트 날짜: {{ result.view }}</p>
    {{ $route.params }}
    <!-- 상세 정보 표시 등 -->
  </div>
</template>

<script>
export default {
  name: 'PostDetail',
  props: {
    id: {
      type: String,
      required: true,
    },
  },
  created() {
  //  console.log(this.$store.state.post)
  //  this.result = this.$store.state.post
    console.log(this.$route);
  }
};
</script>

<style scoped>
/* 컴포넌트에 대한 스타일은 여기에 추가 */
</style>
