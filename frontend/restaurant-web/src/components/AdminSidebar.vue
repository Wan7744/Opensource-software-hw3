<template>
  <aside class="sidebar">
    <h2>식당 관리자</h2>

    <button @click="$emit('change-page', 'menu')">
      메뉴 관리
    </button>

    <button @click="$emit('change-page', 'orders')">
      주문 목록
    </button>

    <button @click="$emit('change-page', 'reviews')">
      후기 관리
    </button>

    <button @click="$emit('change-page', 'sales')">
      매출 정산
    </button>

    <button @click="$emit('change-page', 'strategy')">
      AI 영업 전략
    </button>
  </aside>
</template>

<script setup>
defineEmits(["change-page"]);
</script>

<style scoped>
.sidebar {
  width: 220px;
  min-height: 100vh;
  padding: 24px;
  background: #111827;
  color: white;
}

.sidebar h2 {
  margin-bottom: 24px;
}

.sidebar button {
  display: block;
  width: 100%;
  padding: 12px;
  margin-bottom: 10px;
  border: none;
  border-radius: 10px;
  background: #374151;
  color: white;
  cursor: pointer;
  text-align: left;
}

.sidebar button:hover {
  background: #4b5563;
}
</style>