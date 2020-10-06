delete from product;
delete from product_category;
alter sequence global_seq restart with 1000;

insert into product_category (category_name)
values ('BOOKS');

insert into product (sku, name, description, unit_price, image_url, active, units_in_stock, date_created, category_id)
values ('BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript', 19.99, 'assets/images/products/placeholder.png', true, 100, now(), 1000),
       ('BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring', 29.99, 'assets/images/products/placeholder.png', true, 100, now(), 1000),
       ('BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes', 24.99, 'assets/images/products/placeholder.png', true, 100, now(), 1000),
       ('BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT', 29.99, 'assets/images/products/placeholder.png', true, 100, now(), 1000),
       ('BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go', 24.99, 'assets/images/products/placeholder.png', true, 100, now(), 1000);