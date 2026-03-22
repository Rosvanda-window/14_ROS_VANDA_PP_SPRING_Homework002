CREATE DATABASE my_batis_homework;

CREATE TABLE instructors (
    instructor_id SERIAL PRIMARY KEY ,
    instructor_name VARCHAR(30),
    email TEXT
);

CREATE TABLE courses(
    course_id SERIAL PRIMARY KEY ,
    course_name VARCHAR(30),
    description TEXT,
    instructor_id INTEGER,
    FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
);

CREATE TABLE students(
    student_id SERIAL PRIMARY KEY ,
    student_name VARCHAR(30),
    email TEXT,
    phone_number NUMERIC
);

CREATE TABLE student_course(
    student_id INTEGER,
    course_id INTEGER
)