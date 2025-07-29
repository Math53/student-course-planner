# Student Course Planner (Java)

A simple command-line application for managing your semester schedule. Add, view, and remove courses, track total credits, and save your plan for future use.

## Features

- Add new courses with name, code, credit hours, and meeting times
- Remove existing courses by code
- View a list of all current courses with total credits
- Save your semester to a file
- Load existing plans automatically on launch

## Project Structure

student-course-planner/
├── src/
│   ├── Course.java
│   ├── Semester.java
│   ├── FileManager.java
│   └── PlannerApp.java
├── test/
│   └── PlannerTest.java
├── planner.txt           # (auto-generated when saved)
├── README.md
└── .gitignore

## How to Run

javac src/*.java
java src.PlannerApp

## Sample Input / Output

Welcome to the Student Course Planner
Menu:
1. Add course
2. Remove course
3. View courses
4. Save planner
5. Quit

## Save File Format

Saved as planner.txt using pipe-separated fields:

Fall 2025  
Intro to CS|CSC110|3|MWF 9:00-9:50  
Calculus I|MA141|4|TTh 11:00-12:15

## Author

Amrita Pathak  
https://github.com/Math53

