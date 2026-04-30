DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL DEFAULT 'CUSTOMER',
    created_at TEXT DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categories (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE products (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    category_id INTEGER NOT NULL,
    name TEXT NOT NULL,
    price INTEGER NOT NULL,
    image_url TEXT,
    keyword TEXT,
    description TEXT,
    is_available INTEGER DEFAULT 1,
    created_at TEXT DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE orders (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER,
    total_price INTEGER NOT NULL,
    status TEXT NOT NULL DEFAULT 'ORDERED',
    created_at TEXT DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_items (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    order_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    product_name TEXT NOT NULL,
    price INTEGER NOT NULL,
    quantity INTEGER NOT NULL,

    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE reviews (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER,
    rating INTEGER NOT NULL,
    content TEXT NOT NULL,
    advantages TEXT,
    created_at TEXT DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (email, password, role)
VALUES
('admin@test.com', '1234', 'ADMIN'),
('user@test.com', '1234', 'CUSTOMER');

INSERT INTO categories (name)
VALUES
('한식'),
('중식'),
('일식'),
('양식'),
('음료');

INSERT INTO products (category_id, name, price, image_url, keyword, description)
VALUES
(1, '김치찌개', 8000, 'https://placehold.co/300x200', '매운맛,한식,찌개', '칼칼한 김치찌개입니다.'),
(1, '불고기덮밥', 9000, 'https://placehold.co/300x200', '달콤한맛,한식,고기', '달콤짭짤한 불고기덮밥입니다.'),
(2, '짜장면', 7000, 'https://placehold.co/300x200', '중식,면', '기본에 충실한 짜장면입니다.'),
(2, '짬뽕', 8500, 'https://placehold.co/300x200', '매운맛,중식,국물', '얼큰한 해물 짬뽕입니다.'),
(3, '돈카츠', 10000, 'https://placehold.co/300x200', '일식,튀김', '바삭한 돈카츠입니다.'),
(4, '크림파스타', 12000, 'https://placehold.co/300x200', '양식,파스타,크림', '고소한 크림파스타입니다.'),
(5, '아이스 아메리카노', 3500, 'https://placehold.co/300x200', '음료,커피', '시원한 아메리카노입니다.');