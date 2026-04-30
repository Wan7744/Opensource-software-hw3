<template>
  <section class="menu-list">
    <div
      v-for="product in products"
      :key="product.id"
      class="menu-card"
    >
      <img :src="product.imageUrl" :alt="product.name" />

      <div class="info">
        <h3>{{ product.name }}</h3>
        <p>{{ product.description }}</p>
        <strong>{{ product.price.toLocaleString() }}원</strong>

        <button @click="$emit('add-cart', product)">
          장바구니 담기
        </button>
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

defineEmits(["add-cart"]);
</script>

<style scoped>
.menu-list {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  gap: 20px;
}

.menu-card {
  border-radius: 16px;
  overflow: hidden;
  background: white;
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08);
}

.menu-card img {
  width: 100%;
  height: 140px;
  object-fit: cover;
}

.info {
  padding: 16px;
}

.info h3 {
  margin: 0 0 8px;
}

.info p {
  min-height: 44px;
  color: #666;
}

.info button {
  width: 100%;
  margin-top: 12px;
  padding: 10px;
  border: none;
  border-radius: 10px;
  background: #2563eb;
  color: white;
  cursor: pointer;
}

.info button:hover {
  background: #1d4ed8;
}
</style>