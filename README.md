# Opensource-software-hw3

restaurant-order-platform/

│

├─ frontend/

│  ├─ customer-web/          # 고객용 Vue3 + Vite

│  └─ restaurant-web/        # 식당 관리자용 Vue3 + Vite

│

├─ backend/

│  ├─ gateway-service/       # SpringBoot 라우팅용 메인 백엔드

│  ├─ auth-service/          # SpringBoot 인증/JWT/회원가입

│  ├─ product-service/       # SpringBoot 메뉴/카테고리 관리

│  ├─ order-service/         # SpringBoot 주문 관리

│  └─ review-ai-service/     # FastAPI 후기 자동 작성

│

├─ infra/

│  ├─ redis/

│  └─ sqlite/

│

├─ .env

└─ README.md



백앤드 명령어

gradlew bootRun



프론트앤드 명령어

npm run dev



http://localhost:5173

