// router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import PostListView from "@/views/PostListView.vue";
import HomeView from "@/views/HomeView.vue";
import PostDetailView from "@/views/PostDetailView.vue";

const routes = [
  {
    path: '/posts',
    name: 'HomeView',
    component: HomeView,
  },
  {
    path: '/posts/list',
    name: 'PostList',
    component: PostListView
  },
  {
     path: '/posts/:id',
     name: 'PostDetail',
     component: PostDetailView
   }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
