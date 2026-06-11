-- =========================================
-- TABLE CREATION
-- =========================================

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(100),
    price DECIMAL(10,2)
);

CREATE TABLE inventory (
    inventory_id SERIAL PRIMARY KEY,
    product_id INT REFERENCES products(product_id),
    stock_quantity INT
);

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    order_total DECIMAL(10,2),
    status VARCHAR(50),
    order_date DATE
);

CREATE TABLE order_items (
    item_id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(order_id),
    product_id INT REFERENCES products(product_id),
    quantity INT
);

CREATE TABLE coupons (
    coupon_id SERIAL PRIMARY KEY,
    coupon_code VARCHAR(50),
    expiry_date DATE,
    uses_remaining INT
);

-- =========================================
-- INSERT SAMPLE DATA
-- =========================================

INSERT INTO users(email,password)
VALUES
('kashinathparma444@gmail.com','kashinath123'),
('kashinathparma444@gmail.com','kashinath123'),
('kashinathparma444@gmail.com','kashinath123'),
('kashinathparma444@gmail.com','kashinath123');

INSERT INTO products(product_name, price)
VALUES
('Laptop',50000),
('Mobile',25000),
('Headphones',2000),
('Mouse',500),
('Keyboard',1500);

INSERT INTO inventory(product_id, stock_quantity)
VALUES
(1,5),
(2,20),
(3,8),
(4,50),
(5,7);

INSERT INTO orders(user_id, order_total, status, order_date)
VALUES
(1,52000,'Delivered','2026-06-01'),
(1,25000,'Shipped','2026-06-05'),
(1,1500,'Delivered','2026-06-07'),
(2,50000,'Delivered','2026-06-08');

INSERT INTO order_items(order_id, product_id, quantity)
VALUES
(1,1,1),
(1,3,1),
(2,2,1),
(3,5,1),
(4,1,1);

INSERT INTO coupons(coupon_code, expiry_date, uses_remaining)
VALUES
('SAVE10','2025-01-01',5),
('NEWUSER','2027-01-01',100),
('SALE50','2024-01-01',10);

-- =========================================
-- SQL_01
-- Retrieve All Users
-- =========================================

SELECT * FROM users;

-- =========================================
-- SQL_02
-- Delivered Orders Above 1000
-- =========================================

SELECT *
FROM orders
WHERE status='Delivered'
AND order_total > 1000;

-- =========================================
-- SQL_03
-- Count Orders By Status
-- =========================================

SELECT status,
COUNT(*) AS total_orders
FROM orders
GROUP BY status;

-- =========================================
-- SQL_04
-- Low Inventory Products
-- =========================================

SELECT p.product_name,
i.stock_quantity
FROM products p
JOIN inventory i
ON p.product_id=i.product_id
WHERE i.stock_quantity < 10;

-- =========================================
-- SQL_05
-- Validate Order Total
-- =========================================

SELECT
o.order_id,
o.order_total,
SUM(oi.quantity * p.price) AS calculated_total
FROM orders o
JOIN order_items oi
ON o.order_id=oi.order_id
JOIN products p
ON oi.product_id=p.product_id
GROUP BY o.order_id,o.order_total;

-- =========================================
-- SQL_06
-- Loyal Customers (>3 Orders)
-- =========================================

SELECT
u.email,
COUNT(o.order_id) AS total_orders
FROM users u
JOIN orders o
ON u.id=o.user_id
GROUP BY u.email
HAVING COUNT(o.order_id) > 3;

-- =========================================
-- SQL_07
-- Expired Coupons
-- =========================================

SELECT *
FROM coupons
WHERE expiry_date < CURRENT_DATE
AND uses_remaining > 0;

-- =========================================
-- SQL_08
-- Verify Specific Order
-- =========================================

SELECT *
FROM orders
WHERE order_id = 1;

-- =========================================
-- SQL_09
-- Duplicate Emails
-- =========================================

SELECT
email,
COUNT(*)
FROM users
GROUP BY email
HAVING COUNT(*) > 1;

-- =========================================
-- SQL_10
-- Top Ordered Products
-- =========================================

SELECT
p.product_name,
SUM(oi.quantity) AS total_quantity
FROM products p
JOIN order_items oi
ON p.product_id=oi.product_id
GROUP BY p.product_name
ORDER BY total_quantity DESC
LIMIT 5;