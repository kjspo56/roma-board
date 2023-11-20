// router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import PostListView from "@/views/post/PostListView.vue";
import HomeView from "@/views/HomeView.vue";
import PostDetailView from "@/views/post/PostDetailView.vue";
import PostUpdateView from "@/views/post/PostUpdateView.vue";
import PostCreateView from "@/views/post/PostCreateView.vue";

const routes = [
  {
    path: '/main',
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
     component: PostDetailView,
   },
   {
     path: '/posts/save',
     name: 'PostCreate',
     component: PostCreateView,
   },
   {
     path: '/posts/editById',
     name: 'PostUpdate',
     component: PostUpdateView,
   },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;