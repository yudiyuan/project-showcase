# 3D Geometry Assignment – CS6402

This project is the solution to Assignment 2 for the CS6402 Intermediate Programming module at the University of Limerick. It demonstrates the application of **object-oriented programming** principles such as **inheritance**, **polymorphism**, and **interfaces** by modeling geometric shapes in 3D.

## 📁 File
- `IDXXXXXXXX_Assignment2.java` — Replace `XXXXXXXX` with your student ID. Contains all class definitions and the main method.

## 📌 Objective
To build a 3D geometry class hierarchy using Java, starting from a basic `EquilateralTriangle`, and extending it to support:
- `SquarePyramid`
- `TriangularPyramid`
- `TriangularPrism`

Each shape supports:
- Surface area calculation
- Volume calculation
- Comparison by surface area (`Comparable` interface)

## 🧱 Class Structure

- **EquilateralTriangle**
  - Inherits from `GeometricObject`
  - Fields: `length` (protected), `texture` (private)
  - Constructors: default (`length = 1`), and parameterized
  - Methods: `get/set`, `area()`

- **Subclasses**
  - `SquarePyramid`, `TriangularPyramid`, `TriangularPrism`
  - Inherit from `EquilateralTriangle`
  - Implement `Comparable`
  - Implement `volume()`, `surfaceArea()`
  - Include default and parameterized constructors

- **Driver Class**
  - Instantiates 5 user-defined 3D shapes
  - Stores them in an array
  - Sorts and identifies the shape with the **largest** and **smallest** surface area

## ▶️ How to Run

1. Compile:
   ```bash
   javac IDXXXXXXXX_Assignment2.java
   ```

2. Run:
   ```bash
   java IDXXXXXXXX_Assignment2
   ```

   You will be prompted to input the type and size of 5 3D shapes.

## ✅ Assessment Breakdown

| Component                | Marks |
|-------------------------|-------|
| EquilateralTriangle     | 8     |
| Subclasses (3 total)    | 15    |
| Driver Class            | 7     |
| **Total**               | **30** |

## ⚠️ Notes

- Follow the naming convention: `ID########_Assignment2.java`
- Include your name and ID in a comment at the top of your file.
- Late submissions will be penalized.
- Avoid plagiarism — use your own logic and code.

## 👤 Author
[Your Name]  
Student ID: [XXXXXXXX]
