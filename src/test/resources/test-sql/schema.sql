CREATE TABLE public.person
(
    id bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);