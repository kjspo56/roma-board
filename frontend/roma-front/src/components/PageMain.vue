<!-- PageMain.vue -->
<template>
  <h2>Post List</h2>
  <div class="table-responsive small">
    <table class="table table-striped table-sm">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Title</th>
        <th scope="col">Writer</th>
        <th scope="col">Like</th>
        <th scope="col">Date</th>
        <th scope="col">View</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="post in result" v-bind:key="post.postId">
        <td>{{ post.postId }}</td>
        <td>{{ post.title }}</td>
        <td>{{ post.writer }}</td>
        <td>{{ post.postLike }}</td>
        <td>{{ formatDateTime(post.regDate) }}</td>
        <td>{{ post.view }}</td>
      </tr>
      </tbody>
    </table>
  </div>
  <div class="d-flex">
    <button type="button" class="btn btn-primary" >글쓰기</button>
  </div>
</template>

<script>
import axios from "axios";
import moment from "moment";
export default {
  name: "PageMain",
  data() {
    return {
      result: []
    };
  },
  created() {
    this.getListData();
  },
  methods: {
    getListData() {
      axios.post('http://localhost:9096/post/list')
          .then(res => {
            console.log(res)
            this.result = res.data.data;
          })
          .catch((error) => {
            console.log("Error fetching postList:", error);
          })
    },
    formatDateTime(dateTime) {
      return moment(dateTime).format("YYYY-MM-DD HH:mm");
    }
  },
};
</script>

<style scoped>

</style>
