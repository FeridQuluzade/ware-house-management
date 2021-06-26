create table warehouse_product(
                                  productId serial,
                                  name varchar(30) not null ,
                                  count int8 ,
                                  buy_rate numeric,
                                  sell_rate numeric,
                                  created_date timestamp not null default CURRENT_TIMESTAMP,
                                  updated_date timestamp null
);