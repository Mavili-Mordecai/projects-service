--liquibase formatted sql

--changeset Mavili-Mordecai:001-create-projects-table.sql
CREATE SEQUENCE projects_seq INCREMENT BY 50;

CREATE TABLE projects(
    id BIGINT PRIMARY KEY DEFAULT nextval('projects_seq'),
    name VARCHAR(255) NOT NULL,
    uuid UUID NOT NULL UNIQUE,
    owner_uuid UUID NOT NULL,
    created_at TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER SEQUENCE projects_seq OWNED BY projects.id;
--rollback DROP TABLE projects;