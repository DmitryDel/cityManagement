create table person(
    id bigint primary key generated by default as identity ,
    name varchar(30) not null
);

create table passport(
    id serial primary key ,
    series varchar(20) not null ,
    issue_data date not null ,
    person_id bigint unique not null ,
    FOREIGN KEY (person_id) REFERENCES person(id)
);

create table home(
    id bigint primary key generated by default as identity ,
    street varchar(50) not null ,
    number integer not null
);

create table home_person(
    home_id bigint not null ,
    person_id bigint not null ,
    primary key (home_id, person_id),
    foreign key (home_id) references home(id),
    foreign key (person_id) references person(id)
);

create table car(
    id bigint primary key generated by default as identity ,
    model varchar(50) not null ,
    manufactured_year char(4) not null ,
    owner_id bigint not null ,
    foreign key (owner_id) references person(id)
);
