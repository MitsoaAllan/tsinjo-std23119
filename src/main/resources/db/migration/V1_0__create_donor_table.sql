CREATE TABLE if not exists donor (
                       id BIGSERIAL PRIMARY KEY,
                       email VARCHAR NOT NULL UNIQUE,
                       full_name VARCHAR NOT NULL,
                       creation_instant timestamp with time zone default now()
);
create index if not exists donor_full_name_index on donor (full_name);
