-- create database hb_student_tracker;

-- create table if not exists student (
--     id integer primary key generated by default as identity,
--     first_name varchar(45),
--     last_name varchar(45),
--     email varchar(45)
-- );

-- create table if not exists instructor_detail (
--     id integer primary key generated by default as identity,
--     youtube_channel varchar(128),
--     hobby varchar(45)
-- );

-- create table if not exists instructor (
--     id integer primary key generated by default as identity,
--     first_name varchar(45),
--     last_name varchar(45),
--     email varchar(45),
--     instructor_detail_id integer references instructor_detail on delete no action on update no action
-- );
