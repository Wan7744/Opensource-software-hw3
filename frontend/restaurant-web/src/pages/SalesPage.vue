<template>
  <div>
    <h1>매출 정산</h1>
    <p>판매 금액과 주문 수를 확인합니다.</p>

    <div class="cards">
      <section class="card">
        <h2>이번 달 매출</h2>
        <strong>0원</strong>
        <p>주문 API 연결 후 자동 계산됩니다.</p>
      </section>

      <section class="card">
        <h2>이번 달 주문 수</h2>
        <strong>0건</strong>
        <p>주문 데이터 기준으로 계산됩니다.</p>
      </section>
    </div>
  </div>
</template>

<style scoped>
.cards {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 24px;
  margin-top: 24px;
}

.card {
  padding: 24px;
  border-radius: 16px;
  background: white;
}

.card strong {
  display: block;
  margin: 16px 0;
  font-size: 32px;
}
</style>