<template>
  <div>
    <h1>AI 영업 전략 분석</h1>
    <p>
      현재 등록된 메뉴 데이터를 바탕으로 오늘의 영업 전략을 추측합니다.
    </p>

    <button class="analyze-button" :disabled="loading" @click="analyze">
      {{ loading ? "분석 중..." : "현재 영업 전략 분석하기" }}
    </button>

    <section v-if="error" class="error-box">
      {{ error }}
    </section>

    <section v-if="result" class="result-box">
      <h2>AI 분석 결과</h2>
      <pre>{{ result }}</pre>
    </section>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { getBusinessStrategy } from "../api/aiApi";

const loading = ref(false);
const result = ref("");
const error = ref("");

async function analyze() {
  loading.value = true;
  result.value = "";
  error.value = "";

  try {
    const data = await getBusinessStrategy();
    result.value = data.result;
  } catch (err) {
    error.value = "AI 분석 중 오류가 발생했습니다.";
  } finally {
    loading.value = false;
  }
}
</script>

<style scoped>
.analyze-button {
  margin-top: 20px;
  padding: 14px 18px;
  border: none;
  border-radius: 12px;
  background: #7c3aed;
  color: white;
  font-weight: bold;
  cursor: pointer;
}

.analyze-button:disabled {
  background: #a78bfa;
  cursor: wait;
}

.result-box,
.error-box {
  margin-top: 24px;
  padding: 24px;
  border-radius: 16px;
  background: white;
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.06);
}

.error-box {
  color: #b91c1c;
}

pre {
  white-space: pre-wrap;
  line-height: 1.6;
  font-family: inherit;
}
</style>