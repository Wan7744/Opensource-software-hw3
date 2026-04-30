<template>
  <aside class="category-nav">
    <h2>카테고리</h2>

    <button
      v-for="category in categories"
      :key="category.id"
      class="category-button"
      @click="$emit('select-category', category.id)"
    >
      {{ category.name }}
    </button>
  </aside>
</template>

<script setup>
defineProps({
  categories: {
    type: Array,
    default: () => []
  }
});

defineEmits(["select-category"]);
</script>

<style scoped>
.category-nav {
  width: 220px;
  min-height: 100vh;
  padding: 24px;
  background: #1f2937;
  color: white;
}

.category-nav h2 {
  margin-bottom: 20px;
}

.category-button {
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

.category-button:hover {
  background: #4b5563;
}
</style>