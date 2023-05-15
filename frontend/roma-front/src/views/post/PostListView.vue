<script setup>
import PostItem from '@/components/post/PostItem.vue';
import { getPosts } from '@/api/post';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
const posts = ref([]);
const router = useRouter();

const fetchPosts = () => {
    posts.value = getPosts();
};
fetchPosts();

const goPage = id => {
    // router.push(`/posts/${id}`);
    // 다른 방법
    router.push({
        // 이름을 가진 라우터는 이렇게
        name: 'PostDetail',
        params: {
            id
        }
    });
};
</script>

<template>
    <div>
        <h2>게시글 리스트</h2>
        <hr class="my-4" />
        <div class="row g-3">
            <div class="col-4" v-for="post in posts" :key="post.id">
                <PostItem :title="post.title" :content="post.content" :created-at="post.createdAt" @click="goPage(post.id)" />
            </div>
        </div>
    </div>
</template>

<style scoped></style>
