const BASE_URL = "http://localhost:8080";

export async function getCategories() {
  const response = await fetch(`${BASE_URL}/categories`);
  return await response.json();
}

export async function getProductsByCategory(categoryId) {
  const response = await fetch(`${BASE_URL}/products/category/${categoryId}`);
  return await response.json();
}

export async function getProducts() {
  const response = await fetch(`${BASE_URL}/products`);
  return await response.json();
}