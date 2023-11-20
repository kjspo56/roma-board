<!-- PostList.vue -->
<template>
  <div>
    <h2>게시글 목록</h2>
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>제목</th>
        <th>작성자</th>
        <th>추천수</th>
        <th>업데이트 날짜</th>
        <th>조회수</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="post in postList" :key="post.postId">
        <td>{{ post.postId }}</td>
        <td><router-link :to="{ name: 'PostDetail', params: { id: post.postId }}">{{ post.title }}</router-link></td>
        <td>{{ post.writer }}</td>
        <td>{{ post.postLike }}</td>
        <td>{{ post.regDate }}</td>
        <td>{{ post.view }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      postList: []
    };
  },
  mounted() {
    this.fetchPostList();
  },
  methods: {
    fetchPostList() {
      axios.post('http://localhost:9096/post/list')
          .then(response => {
            this.postList = response.data.data;
          })
          .catch(error => {
            console.error("Error fetching postList:", error);
          });
    }
  }
};
</script>

<style scoped>
/* 컴포넌트에 대한 스타일은 여기에 추가 */
</style>
