--liquibase formatted sql

--changeset Mavili-Mordecai:004-drop-owner-uuid-column-project.sql
ALTER TABLE projects DROP COLUMN owner_uuid;