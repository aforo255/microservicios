create database db_invoice;

CREATE TABLE public.customer (
                                 customer_id bigserial NOT NULL,
                                 full_name varchar(255) NULL,
                                 CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
);


CREATE TABLE public.invoice (
                                id_invoice bigserial NOT NULL,
                                amount numeric(19, 2) NULL,
                                cutomer_id int8 NULL,
                                status_id int4 NULL,
                                CONSTRAINT invoice_pkey PRIMARY KEY (id_invoice),
                                CONSTRAINT fkaiihutv2e3a7ave5666cae591 FOREIGN KEY (status_id) REFERENCES public.invoice_state(status_id),
                                CONSTRAINT fknty7l05xp7pw1rkcy8pl0fhmr FOREIGN KEY (cutomer_id) REFERENCES public.customer(customer_id)
);


CREATE TABLE public.invoice_state (
                                      status_id serial4 NOT NULL,
                                      description varchar(255) NULL,
                                      CONSTRAINT invoice_state_pkey PRIMARY KEY (status_id)
);
