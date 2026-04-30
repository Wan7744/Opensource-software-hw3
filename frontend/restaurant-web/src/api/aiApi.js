const BASE_URL = "http://localhost:8080";

export async function getBusinessStrategy() {
  const response = await fetch(`${BASE_URL}/ai/business-strategy`);

  if (!response.ok) {
    throw new Error("AI 전략 분석 요청에 실패했습니다.");
  }

  return await response.json();
}