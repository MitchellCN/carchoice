--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: car_info; Type: TABLE; Schema: public; Owner: cmitchell
--

CREATE TABLE car_info (
    carid integer NOT NULL,
    carmodel character varying(40),
    caryear character varying(40),
    carmake character varying(40)
);


ALTER TABLE car_info OWNER TO cmitchell;

--
-- Name: car_info_carid_seq; Type: SEQUENCE; Schema: public; Owner: cmitchell
--

CREATE SEQUENCE car_info_carid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE car_info_carid_seq OWNER TO cmitchell;

--
-- Name: car_info_carid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cmitchell
--

ALTER SEQUENCE car_info_carid_seq OWNED BY car_info.carid;


--
-- Name: table_name_carid_seq; Type: SEQUENCE; Schema: public; Owner: cmitchell
--

CREATE SEQUENCE table_name_carid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE table_name_carid_seq OWNER TO cmitchell;

--
-- Name: table_name_carid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cmitchell
--

ALTER SEQUENCE table_name_carid_seq OWNED BY car_info.carid;


--
-- Name: car_info carid; Type: DEFAULT; Schema: public; Owner: cmitchell
--

ALTER TABLE ONLY car_info ALTER COLUMN carid SET DEFAULT nextval('car_info_carid_seq'::regclass);


--
-- Data for Name: car_info; Type: TABLE DATA; Schema: public; Owner: cmitchell
--

COPY car_info (carid, carmodel, caryear, carmake) FROM stdin;
1	A5	2017	Audi
2	Civic	2017	Honda
3	Model S	2017	Tesla
\.


--
-- Name: car_info_carid_seq; Type: SEQUENCE SET; Schema: public; Owner: cmitchell
--

SELECT pg_catalog.setval('car_info_carid_seq', 3, true);


--
-- Name: table_name_carid_seq; Type: SEQUENCE SET; Schema: public; Owner: cmitchell
--

SELECT pg_catalog.setval('table_name_carid_seq', 6, true);


--
-- Name: car_info table_name_pkey; Type: CONSTRAINT; Schema: public; Owner: cmitchell
--

ALTER TABLE ONLY car_info
    ADD CONSTRAINT table_name_pkey PRIMARY KEY (carid);


--
-- PostgreSQL database dump complete
--

