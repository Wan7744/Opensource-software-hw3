<template>
  <section class="list-box">
    <h2>등록된 메뉴</h2>

    <div
      v-for="product in products"
      :key="product.id"
      class="product-card"
    >
      <img :src="product.imageUrl" :alt="product.name" />

      <div>
        <h3>{{ product.name }}</h3>
        <p>{{ product.description }}</p>
        <strong>{{ product.price.toLocaleString() }}원</strong>
        <p class="meta">카테고리 ID: {{ product.categoryId }}</p>
        <p class="meta">키워드: {{ product.keyword }}</p>
      </div>
    </div>
  </section>
</template>

<script setup>
defineProps({
  products: {
    type: Array,
    default: () => []
  }
});
</script>

<style scoped>
.list-box {
  padding: 20px;
  border-radius: 16px;
  background: white;
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.06);
}

.product-card {
  display: flex;
  gap: 16px;
  padding: 16px 0;
  border-bottom: 1px solid #e5e7eb;
}

.product-card img {
  width: 140px;
  height: 90px;
  border-radius: 12px;
  object-fit: cover;
}

.product-card h3 {
  margin: 0 0 6px;
}

.product-card p {
  margin: 4px 0;
}

.meta {
  color: #6b7280;
  font-size: 14px;
}
</style>