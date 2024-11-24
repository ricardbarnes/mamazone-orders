CREATE TABLE IF NOT EXISTS order_created_events
(
    id           SERIAL PRIMARY KEY,
    aggregate_id INT       NOT NULL,
    customer_id  INT       NOT NULL,
    product_ids  TEXT      NOT NULL,
    occurred_on  TIMESTAMP NOT NULL
);