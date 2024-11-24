CREATE TABLE order_created_event
(
    id           SERIAL PRIMARY KEY,
    aggregate_id INT       NOT NULL,
    customer_id  INT       NOT NULL,
    product_ids  TEXT      NOT NULL,
    occurred_on  TIMESTAMP NOT NULL
);
