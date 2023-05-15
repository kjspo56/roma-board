<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav me-auto">
    <li class="nav-item">
        <RouterLink class="nav-link" active-class="active" to="/">Home</RouterLink>
    </li>
    <li class="nav-item">
        <RouterLink class="nav-link" active-class="active" to="/about">About</RouterLink>
    </li>
    <li class="nav-item">
        <RouterLink class="nav-link" active-class="active" to="/posts">게시글</RouterLink>
    </li>
</ul>
<div class="d-flex">
    <button class="btn btn-outline-light" type="button" @click="goPage">글쓰기</button>
</div>
</div>
<script setup>
import {useRouter} from "vue-router";
const router = useRouter();
const goPage = () => {
    router.push('/post/create');
};

/*import { useRouter } from 'vue-router';

const router = useRouter();
const goPage = () => {
    router.push({
        name: 'PostCreate'
    });
};*/

</script>
