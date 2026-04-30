<template>
  <div class="page">
    <header>
      <h1>메뉴 관리</h1>
      <p>식당 메뉴를 등록하고 현재 메뉴 목록을 확인합니다.</p>
    </header>

    <div class="grid">
      <ProductForm @submit-product="handleCreateProduct" />
      <ProductList :products="products" />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import ProductForm from "../components/ProductForm.vue";
import ProductList from "../components/ProductList.vue";
import { getProducts, createProduct } from "../api/productApi";

const products = ref([]);

onMounted(() => {
  loadProducts();
});

async function loadProducts() {
  products.value = await getProducts();
}

async function handleCreateProduct(product) {
  await createProduct(product);
  alert("메뉴가 등록되었습니다.");
  await loadProducts();
}
</script>

<style scoped>
.page {
  width: 100%;
}

header {
  margin-bottom: 24px;
}

header h1 {
  margin: 0;
}

header p {
  color: #6b7280;
}

.grid {
  display: grid;
  grid-template-columns: 360px 1fr;
  gap: 24px;
}
</style>