<template>
  <div>
    <h1>후기 관리</h1>
    <p>후기 키워드와 식당 장점 통계를 확인합니다.</p>

    <section class="card">
      <h2>식당 장점 분석</h2>

      <div
        v-for="item in advantages"
        :key="item.label"
        class="bar-row"
      >
        <span>{{ item.label }}</span>

        <div class="bar-bg">
          <div
            class="bar"
            :style="{ width: item.percent + '%' }"
          ></div>
        </div>

        <strong>{{ item.count }}</strong>
      </div>
    </section>
  </div>
</template>

<script setup>
const advantages = [
  { label: "친절해요", count: 12, percent: 80 },
  { label: "맛있어요", count: 15, percent: 100 },
  { label: "청결해요", count: 9, percent: 60 },
  { label: "빨라요", count: 6, percent: 40 }
];
</script>

<style scoped>
.card {
  margin-top: 24px;
  padding: 24px;
  border-radius: 16px;
  background: white;
}

.bar-row {
  display: grid;
  grid-template-columns: 100px 1fr 40px;
  align-items: center;
  gap: 16px;
  margin-bottom: 16px;
}

.bar-bg {
  height: 18px;
  border-radius: 999px;
  background: #e5e7eb;
  overflow: hidden;
}

.bar {
  height: 100%;
  background: #22c55e;
}
</style>