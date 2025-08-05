CREATE TABLE beneficiary (
                             id BIGSERIAL PRIMARY KEY,
                             email VARCHAR NOT NULL,
                             full_name VARCHAR NOT NULL,
                             creation_instant timestamp with time zone default now()
);
create index if not exists beneficiary_full_name_index on beneficiary (full_name);