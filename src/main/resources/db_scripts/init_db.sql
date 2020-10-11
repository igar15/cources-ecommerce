drop table if exists product;
drop table if exists product_category;
drop table if exists state;
drop table if exists country;
drop sequence if exists global_seq;

create sequence global_seq start with 1;

create table product_category(
    id integer primary key default nextval('global_seq'),
    category_name varchar default null
);

create table product (
    id integer primary key default nextval('global_seq'),
    sku varchar default null,
    name varchar default null,
    description varchar default null,
    unit_price decimal default null,
    image_url varchar default null,
    active boolean default null,
    units_in_stock integer default null,
    date_created timestamp default null,
    last_updated timestamp default null,
    category_id integer not null,
    foreign key (category_id) references product_category (id)
);

create table country (
  id integer primary key default nextval('global_seq'),
  code varchar default null,
  name varchar default null
);

create table state (
  id integer primary key default nextval('global_seq'),
  name varchar default null,
  country_id integer not null,
  foreign key (country_id) references country (id)
);