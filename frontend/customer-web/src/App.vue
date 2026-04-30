<template>
  <div class="app">
    <CategoryNav
      :categories="categories"
      @select-category="loadProducts"
    />

    <main class="main">
      <header>
        <h1>식당 메뉴 주문</h1>
        <p>카테고리를 선택하고 메뉴를 장바구니에 담아보세요.</p>
      </header>

      <MenuList
        :products="products"
        @add-cart="addToCart"
      />
    </main>

    <CartBox
      :cart="cart"
      @clear-cart="clearCart"
      @submit-order="submitOrder"
    />
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import CategoryNav from "./components/CategoryNav.vue";
import MenuList from "./components/MenuList.vue";
import CartBox from "./components/CartBox.vue";
import { getCategories, getProductsByCategory } from "./api/productApi";

const categories = ref([]);
const products = ref([]);
const cart = ref(JSON.parse(localStorage.getItem("cart")) || []);

onMounted(async () => {
  categories.value = await getCategories();

  if (categories.value.length > 0) {
    await loadProducts(categories.value[0].id);
  }
});

async function loadProducts(categoryId) {
  products.value = await getProductsByCategory(categoryId);
}

function addToCart(product) {
  const found = cart.value.find(item => item.id === product.id);

  if (found) {
    found.quantity += 1;
  } else {
    cart.value.push({
      ...product,
      quantity: 1
    });
  }

  localStorage.setItem("cart", JSON.stringify(cart.value));
}

function clearCart() {
  cart.value = [];
  localStorage.removeItem("cart");
}

function submitOrder() {
  if (cart.value.length === 0) {
    alert("장바구니가 비어 있습니다.");
    return;
  }

  alert("주문 기능은 다음 단계에서 서버와 연결합니다!");
}
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

header {
  margin-bottom: 24px;
}

header h1 {
  margin: 0;
}

header p {
  color: #666;
}
</style>