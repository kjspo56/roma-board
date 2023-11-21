<!-- PostListView.vue -->
<template>
  <div class="post-list">
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
<!--      <tr v-for="post in result" v-bind:key="post.postId" v-on:click="$event => href(post)">-->
      <tr v-for="post in result" v-bind:key="post.postId">
        <td>{{ post.postId }}</td>
        <td>{{ post.title }}</td>
        <td><router-link :to="{ name: 'PostDetail', params: { id: post.postId } }">{{ post.title }}</router-link></td>
        <td>{{ post.writer }}</td>
        <td>{{ post.postLike }}</td>
        <td>{{ post.regDate }}</td>
        <td>{{ post.view }}</td>
      </tr>
      </tbody>
    </table>
  </div>
  <div class="d-flex">
    <button type="button" class="btn btn-primary" >등록</button>
  </div>
</template>

<script>
import axios from "axios";
import store from "@/store";

export default {
  name: 'PostListView',
  data(){
    return {
      result: []
    };
  },
  created() {
    this.getData();
  },
  methods: {
    getData(){
      axios.post('http://localhost:9096/post/list')
          .then(res => {
            console.log(res)
            this.result = res.data.data;
            //여기에서 데이터 로딩 후의 처리를 수행
            console.log("Data loaded:", this.result);
          })
          .catch((error)=>{
            console.log("Error fetching postList:", error);
          })
    },
    href(post){
    //query > http://localhost:8080/user/findById?name=사용자&pwd=1
    //params > http://localhost:8080/user/findById/사용자/1
    //index.js > path: '/user/findById/:name/:pwd
    console.log(post);
    store.commit('setPost', post)
    this.$router.push({ name: 'PostDetail' })
   }
  }
};
</script>

<style scoped>
/* 컴포넌트에 대한 스타일은 여기에 추가 */
</style>
