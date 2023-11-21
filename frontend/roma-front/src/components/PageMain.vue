<!-- PageMain.vue -->
<template>
  <h2>Post List</h2>
  <div class="table-responsive small">
    <table class="table table-striped table-sm">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Title</th>
        <th scope="col">Contents</th>
        <th scope="col">Writer</th>
        <th scope="col">Like</th>
        <th scope="col">Date</th>
        <th scope="col">View</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>1</td>
        <td>제목 입니다</td>
        <td>내용 입니다</td>
        <td>작성자 입니다</td>
        <td>좋아요 수</td>
        <td>날짜</td>
        <td>조회수</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "PageMain",
}
</script>

<style scoped>

</style>
