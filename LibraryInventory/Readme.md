# Library Book Inventory System

A simple command-line Java application for managing library books using CRUD operations.

## Author
Logadharani P

## Requirements
- Java 17 or higher

## How to Compile
cd src
javac Book.java BookManager.java LibraryApp.java

## How to Run
java LibraryApp

## Features
1. Add Book
2. List All Books
3. Update Book
4. Delete Book
5. Exit

## Validation Rules
- Title, author, and ISBN cannot be empty
- Year must be between 1000 and 2100
- Menu choice must be a number

## Project Structure
LibraryInventory/
├── src/
│   ├── Book.java
│   ├── BookManager.java
│   └── LibraryApp.java
├── screenshots/
└── README.md