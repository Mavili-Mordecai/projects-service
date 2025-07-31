--liquibase formatted sql

--changeset Mavili-Mordecai:002-create-project-users-table.sql
CREATE SEQUENCE project_users_seq INCREMENT BY 50;

CREATE TABLE project_users(
    id BIGINT PRIMARY KEY DEFAULT nextval('project_users_seq'),
    project_id BIGINT NOT NULL,
    user_uuid UUID NOT NULL,
    created_at TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (project_id, user_uuid),
    FOREIGN KEY (project_id) REFERENCES projects (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

ALTER SEQUENCE project_users_seq OWNED BY project_users.id;
--rollback DROP TABLE project_users