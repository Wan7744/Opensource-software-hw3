package com.example.restaurant_service.service;

import com.example.restaurant_service.entity.Product;
import com.example.restaurant_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AiStrategyService {

    private final ProductRepository productRepository;

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.openai.com/v1")
            .build();

    public String analyzeBusinessStrategy() {
        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            return "OPENAI_API_KEY 환경변수가 설정되어 있지 않습니다.";
        }

        List<Product> products = productRepository.findAll();

        String menuText = products.stream()
                .map(product -> String.format(
                        "- 메뉴명: %s / 가격: %d원 / 카테고리ID: %d / 키워드: %s / 설명: %s",
                        product.getName(),
                        product.getPrice(),
                        product.getCategoryId(),
                        product.getKeyword(),
                        product.getDescription()
                ))
                .toList()
                .toString();

        String prompt = """
                너는 식당 매출 전략 컨설턴트야.

                아래는 현재 식당의 메뉴 데이터야.
                이 데이터를 보고 식당 관리자가 바로 실행할 수 있는 영업 전략을 제안해줘.

                반드시 한국어로 답변해.
                너무 추상적으로 말하지 말고, 실제 운영자가 바로 쓸 수 있게 구체적으로 말해줘.

                분석 형식:
                1. 현재 메뉴 구성 요약
                2. 가격대 분석
                3. 잘 팔릴 가능성이 높은 메뉴
                4. 부족한 메뉴 또는 카테고리
                5. 추천 이벤트 전략
                6. 오늘 당장 할 수 있는 운영 조언 3가지

                메뉴 데이터:
                %s
                """.formatted(menuText);

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-5.5",
                "input", prompt
        );

        Map response = webClient.post()
                .uri("/responses")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (response == null) {
            return "AI 분석 결과를 가져오지 못했습니다.";
        }

        Object outputText = response.get("output_text");

        if (outputText != null) {
            return outputText.toString();
        }

        return response.toString();
    }
}