create table users
(
    id                BIGSERIAL primary key,
    email             varchar(128) UNIQUE NOT NULL,
    is_email_verified boolean,
    last_login        timestamp,
    number            varchar(128) unique not null,
    password          varchar(128)        not null,
    date_registration Timestamp           not null,
    birth_date        Date                not null,
    first_name        varchar(128),
    last_name         varchar(128),
    profile_image     varchar(128),
    activity_type     varchar(128)        not null,
    role_type         varchar(128)        not null
);



create table address
(
    id               BIGSERIAL primary key,
    id_user          BIGINT       not null references users (id) not null,
    country          varchar(128) not null,
    city             varchar(128) not null,
    street           varchar(128) not null,
    house_number     int          not null,
    apartment_number int          not null
);



create table shopping_cart
(
    id            BIGSERIAL primary key,
    id_user       bigint references users (id) not null,
    order_status  varchar(128)                not null,
    creation_date Timestamp                    not null,
    status_update Timestamp
);

create table shopping_cart_product
(
    shopping_cart_id BIGSERIAL,
    product_id       BIGSERIAL,
    count_product    int not null check (count_product > 0),
    primary key (shopping_cart_id, product_id),
    FOREIGN KEY (shopping_cart_id) references shopping_cart (id),
    FOREIGN KEY (product_id) references product (id)
);

create table product
(
    id            BIGSERIAL primary key,
    price         DECIMAL check ( price > 0 ) not null,
    create_at     timestamp                   not null,
    is_available  boolean                     not null,
    description   varchar(128)                not null,
    category      varchar(128)                not null,
    count         int check ( count >= 0 )    not null,
    product_image varchar(128)

);
create table product_review
(
    id                 BIGSERIAL primary key,
    product_id         bigint references product (id)     not null,
    data_create        timestamp                          not null,
    id_user            BIGINT references users (id)       not null,
    description_review varchar(128)                       not null,
    image_product      varchar(128),
    rating             int check (rating between 1 and 5) not null

);

create table promo_code
(
    id                 BIGSERIAL primary key,
    code               varchar(128) unique                   not null,
    discount_sum       decimal check ( discount_sum >= 0 )   not null,
    remaining_quantity int check ( remaining_quantity >= 0 ) not null,
    activity_promo     boolean                               not null,
    min_order_amount   int check ( min_order_amount >= 0 )   not null,
    valid_to           timestamp                             not null,
    valid_from         timestamp                             not null
);

CREATE TABLE user_promo_code
(
    user_promo_code_id bigserial PRIMARY KEY,
    user_id            Bigint NOT NULL,
    promo_code_id      bigint NOT NULL,
    used_at            TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (promo_code_id) REFERENCES promo_code (id)
);
