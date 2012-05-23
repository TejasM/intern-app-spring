-- This script initializes the database by creating tables and inserting data
-- Use only for a proof of concept
DROP TABLE USERS IF EXISTS CASCADE;
DROP SEQUENCE HIBERNATE_SEQUENCE IF EXISTS;

CREATE TABLE INTERNS (
  NAME VARCHAR(255) PRIMARY KEY,
  EMAIL VARCHAR(255));


INSERT INTO INTERNS (NAME, EMAIL) VALUES ('Jon Doe', 'jdoe@redhat.com');

