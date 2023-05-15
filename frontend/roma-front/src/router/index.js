import { createRouter, createWebHistory } from 'vue-router'
//import HomeView from '../views/HomeView.vue'
import PageHome from "@/views/PageHome";

import PostCreateView from "@/views/post/PostCreateView.vue";
import PostListView from "@/views/post/PostListView.vue";
import PostDetailView from "@/views/post/PostDetailView.vue";
import PostEditView from "@/views/post/PostEditView.vue";

const routes = [
  {
    path: '/',
    name: 'PageHome',
    component: PageHome
  },
  {
    path: '/about',
    name: 'About',
    component: () => import(/* webpackChunkName: "about" */ '../views/PageAbout.vue')
  },
  {
    path: '/post',
    name: 'PostList',
    component: PostListView
  },
  {
    path: '/post',
    name: 'PostCreate',
    component: PostCreateView
  },
  {
    path: '/post',
    name: 'PostDetail',
    component: PostDetailView
  },
  {
    path: '/post',
    name: 'PostEdit',
    component: PostEditView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
