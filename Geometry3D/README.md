# 3D Geometry 

It demonstrates the application of **object-oriented programming** principles such as **inheritance**, **polymorphism**, and **interfaces** by modeling geometric shapes in 3D.

Objective
To build a 3D geometry class hierarchy using Java, starting from a basic `EquilateralTriangle`, and extending it to support:
- `SquarePyramid`
- `TriangularPyramid`
- `TriangularPrism`

Each shape supports:
- Surface area calculation
- Volume calculation
- Comparison by surface area (`Comparable` interface)

Class Structure

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

You will be prompted to input the type and size of 5 3D shapes.


