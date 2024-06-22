-- Table: public.question

-- DROP TABLE IF EXISTS public.question;

CREATE TABLE IF NOT EXISTS public.question
(
    id bigint NOT NULL DEFAULT nextval('question_id_seq'::regclass),
    category bigint NOT NULL,
    parent bigint,
    question_text text COLLATE pg_catalog."default" NOT NULL,
    answer text COLLATE pg_catalog."default" NOT NULL,
    option1 text COLLATE pg_catalog."default",
    option2 text COLLATE pg_catalog."default",
    option3 text COLLATE pg_catalog."default",
    default_grade integer NOT NULL,
    penalty integer NOT NULL,
    created_by character varying COLLATE pg_catalog."default" NOT NULL,
    modified_by character varying COLLATE pg_catalog."default",
    time_created timestamp with time zone NOT NULL,
    time_modified timestamp with time zone,
    CONSTRAINT question_pkey PRIMARY KEY (id),
    CONSTRAINT "category_FK" FOREIGN KEY (category)
        REFERENCES public.category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.question
    OWNER to postgres;