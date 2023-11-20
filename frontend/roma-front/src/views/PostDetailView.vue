<!-- views/PostDetailView.vue -->
<template>
  <div>
    <h2>게시글 상세보기</h2>
    <p>ID: {{ id }}</p>
    <p>제목: {{ title }}</p>
    <p>내용: {{ content }}</p>
    <!-- 상세 정보 표시 등 -->
  </div>
</template>

<script>
export default {
  props: ['id', 'title', 'content'],
  mounted() {
    // 뷰가 마운트되면 props에서 전달받은 데이터를 설정
    console.log('id:', this.id);
    console.log('title:', this.title);
    console.log('content:', this.content);
  },
};
</script>

<style scoped>
/* 컴포넌트에 대한 스타일은 여기에 추가 */
</style>
