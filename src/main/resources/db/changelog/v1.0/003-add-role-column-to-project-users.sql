--liquibase formatted sql

--changeset Mavili-Mordecai:003-add-role-column-to-project-users.sql
ALTER TABLE project_users ADD COLUMN role VARCHAR(32) NOT NULL DEFAULT 'MEMBER';

ALTER TABLE project_users ADD CONSTRAINT role_check
CHECK(
   (role = 'MEMBER') OR
   (role = 'MODERATOR') OR
   (role = 'OWNER')
);