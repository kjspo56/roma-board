<script setup>
defineProps({
    title: {
        type: String,
        required: true // 필수 값
    },
    content: {
        type: String,
        required: true
    },
    createdAt: {
        type: [String, Date, Number] // String, Date, Number 중 들어오는 타입 허용
    }
});
</script>

<template>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">{{ title }}</h5>
            <p class="card-text">{{ content }}</p>
            <p class="text-muted">
                {{ createdAt }}
            </p>
        </div>
    </div>
</template>

<style scoped></style>
