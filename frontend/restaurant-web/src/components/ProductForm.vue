<template>
  <section class="form-box">
    <h2>메뉴 등록</h2>

    <form @submit.prevent="submitForm">
      <input v-model="form.name" placeholder="메뉴 이름" />

      <input
        v-model.number="form.price"
        type="number"
        placeholder="가격"
      />

      <input
        v-model.number="form.categoryId"
        type="number"
        placeholder="카테고리 ID 예: 1"
      />

      <input v-model="form.imageUrl" placeholder="이미지 URL" />

      <input v-model="form.keyword" placeholder="키워드 예: 매운맛,한식" />

      <textarea
        v-model="form.description"
        placeholder="메뉴 설명"
      ></textarea>

      <button>등록하기</button>
    </form>
  </section>
</template>

<script setup>
import { ref } from "vue";

const emit = defineEmits(["submit-product"]);

const form = ref({
  name: "",
  price: 0,
  categoryId: 1,
  imageUrl: "https://placehold.co/300x200",
  keyword: "",
  description: "",
  isAvailable: 1
});

function submitForm() {
  if (!form.value.name || form.value.price <= 0) {
    alert("메뉴 이름과 가격을 입력해주세요.");
    return;
  }

  emit("submit-product", { ...form.value });

  form.value = {
    name: "",
    price: 0,
    categoryId: 1,
    imageUrl: "https://placehold.co/300x200",
    keyword: "",
    description: "",
    isAvailable: 1
  };
}
</script>

<style scoped>
.form-box {
  padding: 20px;
  border-radius: 16px;
  background: white;
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.06);
}

form {
  display: grid;
  gap: 12px;
}

input,
textarea {
  padding: 12px;
  border: 1px solid #d1d5db;
  border-radius: 10px;
}

textarea {
  min-height: 90px;
}

button {
  padding: 12px;
  border: none;
  border-radius: 10px;
  background: #2563eb;
  color: white;
  cursor: pointer;
}
</style>