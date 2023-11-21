
CREATE TABLE IF NOT EXISTS public.admins
(
    id_admin character varying(20) COLLATE pg_catalog."default" NOT NULL,
    name character varying(40) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT admins_pkey PRIMARY KEY (id_admin)
)

CREATE TABLE IF NOT EXISTS public.competences
(
    id_competence integer NOT NULL DEFAULT nextval('competences_id_competence_seq'::regclass),
    category character varying(40) COLLATE pg_catalog."default" NOT NULL,
    date timestamp without time zone NOT NULL,
    period integer NOT NULL,
    validity timestamp without time zone NOT NULL,
    CONSTRAINT competences_pkey PRIMARY KEY (id_competence)
)

CREATE TABLE IF NOT EXISTS public.participants
(
    id_participant character varying(20) COLLATE pg_catalog."default" NOT NULL,
    name character varying(40) COLLATE pg_catalog."default" NOT NULL,
    codigo integer,
    course character varying(40) COLLATE pg_catalog."default",
    id_team integer,
    CONSTRAINT participants_pkey PRIMARY KEY (id_participant),
    CONSTRAINT "fk_PARTICIPANT_TEAM" FOREIGN KEY (id_team)
        REFERENCES public.teams (id_team) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE IF NOT EXISTS public.team_competence
(
    id_team integer NOT NULL,
    id_competence integer NOT NULL,
    CONSTRAINT team_competence_pkey PRIMARY KEY (id_team, id_competence),
    CONSTRAINT "fk_COMPETENCE_TEAMS" FOREIGN KEY (id_competence)
        REFERENCES public.competences (id_competence) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "fk_TEAM_COMPETENCE" FOREIGN KEY (id_team)
        REFERENCES public.teams (id_team) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE IF NOT EXISTS public.teams
(
    id_team integer NOT NULL DEFAULT nextval('teams_id_team_seq'::regclass),
    name character varying(40) COLLATE pg_catalog."default" NOT NULL,
    category character varying(40) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT teams_pkey PRIMARY KEY (id_team)
)
