const BASE_URL = "http://localhost:8080";

export async function getOrders() {
  const response = await fetch(`${BASE_URL}/orders`);
  return await response.json();
}