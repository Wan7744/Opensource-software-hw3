const BASE_URL = "http://localhost:8080";

export async function getProducts() {
  const response = await fetch(`${BASE_URL}/products`);
  return await response.json();
}

export async function createProduct(product) {
  const response = await fetch(`${BASE_URL}/products`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(product)
  });

  return await response.json();
}