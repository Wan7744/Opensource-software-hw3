<template>
  <aside class="cart-box">
    <h2>장바구니 🛒</h2>

    <div v-if="cart.length === 0" class="empty">
      장바구니가 비어 있습니다.
    </div>

    <div
      v-for="item in cart"
      :key="item.id"
      class="cart-item"
    >
      <div>
        <strong>{{ item.name }}</strong>
        <p>{{ item.quantity }}개</p>
      </div>

      <span>{{ (item.price * item.quantity).toLocaleString() }}원</span>
    </div>

    <hr />

    <h3>총액: {{ totalPrice.toLocaleString() }}원</h3>

    <button class="order" @click="$emit('submit-order')">
      주문
    </button>

    <button class="clear" @click="$emit('clear-cart')">
      전체 해제
    </button>
  </aside>
</template>

<script setup>
import { computed } from "vue";

const props = defineProps({
  cart: {
    type: Array,
    default: () => []
  }
});

defineEmits(["submit-order", "clear-cart"]);

const totalPrice = computed(() =>
  props.cart.reduce((sum, item) => sum + item.price * item.quantity, 0)
);
</script>

<style scoped>
.cart-box {
  width: 300px;
  min-height: 100vh;
  padding: 24px;
  background: #f3f4f6;
}

.empty {
  color: #777;
  margin: 20px 0;
}

.cart-item {
  display: flex;
  justify-content: space-between;
  gap: 12px;
  padding: 12px 0;
  border-bottom: 1px solid #ddd;
}

.cart-item p {
  margin: 4px 0 0;
  color: #666;
}

button {
  width: 100%;
  padding: 12px;
  margin-top: 10px;
  border: none;
  border-radius: 10px;
  cursor: pointer;
}

.order {
  background: #16a34a;
  color: white;
}

.clear {
  background: #d1d5db;
}
</style>