<!-- PostList.vue -->
<template>
  <div>
    <h2>게시글 목록</h2>
    <ul>
      <li v-for="post in postList" :key="post.postId">
        ID값 : {{ post.postId }}
        제목 : <router-link :to="{ name: 'PostDetail', params: { id: post.postId }}">{{ post.title }}</router-link>
        작성자 : {{ post.writer }}
      </li>
    </ul>
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
