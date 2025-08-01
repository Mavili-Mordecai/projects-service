--liquibase formatted sql

--changeset ElyzianZephyr:005-create-boards-table
CREATE SEQUENCE boards_seq INCREMENT BY 50;

CREATE TABLE boards(
  id BIGINT PRIMARY KEY DEFAULT nextval('boards_seq'),
  name VARCHAR(255) NOT NULL,
  project_id BIGINT NOT NULL,
  FOREIGN KEY (project_id) REFERENCES projects (id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

ALTER SEQUENCE boards_seq OWNED BY boards.id;
--rollback DROP TABLE boards;
