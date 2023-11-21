// router/index.js
import { createRouter, createWebHistory } from 'vue-router';

import HomeView from "@/views/HomeView.vue";
import PostListView from "@/views/post/PostListView.vue";
import PostDetailView from "@/views/post/PostDetailView.vue";
import PostCreateView from "@/views/post/PostCreateView.vue";
import PostUpdateView from "@/views/post/PostUpdateView.vue";

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
    path: '/posts/create',
    name: 'PostCreate',
    component: PostCreateView,
   },
   {
    path: '/posts/:id/edit',
    name: 'PostUpdate',
    component: PostUpdateView,
    }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;