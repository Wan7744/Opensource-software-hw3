<template>
  <div class="app">
    <AdminSidebar @change-page="currentPage = $event" />

    <main class="main">
      <AdminMenuPage v-if="currentPage === 'menu'" />
      <AdminOrderPage v-else-if="currentPage === 'orders'" />
      <AdminReviewPage v-else-if="currentPage === 'reviews'" />
      <SalesPage v-else-if="currentPage === 'sales'" />
      <AiStrategyPage v-else-if="currentPage === 'strategy'" />
    </main>
  </div>
</template>

<script setup>
import { ref } from "vue";
import AdminSidebar from "./components/AdminSidebar.vue";
import AdminMenuPage from "./pages/AdminMenuPage.vue";
import AdminOrderPage from "./pages/AdminOrderPage.vue";
import AdminReviewPage from "./pages/AdminReviewPage.vue";
import SalesPage from "./pages/SalesPage.vue";
import AiStrategyPage from "./pages/AiStrategyPage.vue";

const currentPage = ref("menu");
</script>

<style scoped>
.app {
  display: flex;
  min-height: 100vh;
  background: #f9fafb;
}

.main {
  flex: 1;
  padding: 32px;
}
</style>