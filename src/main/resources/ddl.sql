-- Table: public.nacl_data

-- DROP TABLE IF EXISTS public.nacl_data;

CREATE TABLE IF NOT EXISTS public.nacl_data
(
    order_id integer NOT NULL,
    level_id character varying(8) COLLATE pg_catalog."default" NOT NULL,
    code character varying(8) COLLATE pg_catalog."default" NOT NULL,
    parent character varying(8) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default" NOT NULL,
    this_item_includes text COLLATE pg_catalog."default",
    this_item_also_includes text COLLATE pg_catalog."default",
    rulings character varying(100) COLLATE pg_catalog."default",
    this_item_excludes text COLLATE pg_catalog."default",
    reference_to_isic character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT nacl_data_pkey PRIMARY KEY (order_id)
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.nacl_data
    OWNER to postgres;
-- Index: naclindex

-- DROP INDEX IF EXISTS public.naclindex;

CREATE UNIQUE INDEX IF NOT EXISTS naclindex
    ON public.nacl_data USING btree
    (order_id ASC NULLS LAST)
    TABLESPACE pg_default;