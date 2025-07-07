package Geometry3D;

import java.util.Date;

class GeometricObject {
    private String color;
    private boolean filled;
    private Date dateCreated;

    public GeometricObject(){
        this.dateCreated=new Date();
    }

    public GeometricObject(String color, boolean filled, Date dateCreated) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = dateCreated;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String toString(){
        return "Geometry3D.GeometricObject{color='"+color+'\''+", filled="+filled+", dateCreated="+dateCreated+'}';
    }
}




class EquilateralTriangle extends GeometricObject {
    private String texture;
    protected int length;

    public EquilateralTriangle() {
        this.length = 1;
        this.texture = "default";
    }

    public EquilateralTriangle(int length) {
        this.length = length;
        this.texture="default";
    }

    public EquilateralTriangle(String color, boolean filled, Date dateCreated, int length) {
        super(color, filled, dateCreated);
        this.length = length;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getArea(){
        return (Math.sqrt(3)/4.0)*length*length;
    }


}


/*

interface ThreeDshape extends Comparable<ThreeDshape> {
    double getVolume();
    double getSurfaceArea();
}


 */


class SquarePyramid extends EquilateralTriangle implements Comparable<SquarePyramid> {
    private double height;

    public SquarePyramid() {
        super(1);
        this.height = 1.0;
    }

    public SquarePyramid(int length, double height) {
        super(length);
        this.height = height;
    }

    public double getVolume() {
        return (1.0 / 3) * length * length * height;
    }

    public double getSurfaceArea() {
        double slantHeight = Math.sqrt((length / 2.0) * (length / 2.0) + height * height);
        double lateralArea = 2 * length * slantHeight;
        double baseArea = length * length;
        return baseArea + lateralArea;
    }

    @Override
    public int compareTo(SquarePyramid other) {
        return Double.compare(this.getSurfaceArea(), other.getSurfaceArea());
    }

    @Override
    public String toString() {
        return "Geometry3D.SquarePyramid{length=" + length + ", height=" + height + "}";
    }
}



/*
class Geometry3D.SquarePyramid extends Geometry3D.EquilateralTriangle implements ThreeDshape {
    private double height;

    public Geometry3D.SquarePyramid() {
        super(1); // default length is 1
        this.height = 1.0;
    }

    public Geometry3D.SquarePyramid(int length, double height) {
        super(length);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3) * length * length * height;
    }

    @Override
    public double getSurfaceArea() {
        double slantHeight = Math.sqrt((length / 2.0) * (length / 2.0) + height * height);
        double lateralArea = 2 * length * slantHeight;
        double baseArea = length * length;
        return baseArea + lateralArea;
    }

    @Override
    public int compareTo(ThreeDshape other) {
        return Double.compare(this.getSurfaceArea(), other.getSurfaceArea());
    }

    @Override
    public String toString() {
        return "Geometry3D.SquarePyramid{length=" + length + ", height=" + height + "}";
    }
}

 */

class TriangularPrism extends EquilateralTriangle implements Comparable<TriangularPrism> {
    private double lengthPrism;

    public TriangularPrism() {
        super(1);
        this.lengthPrism = 1.0;
    }

    public TriangularPrism(int length, double lengthPrism) {
        super(length);
        this.lengthPrism = lengthPrism;
    }

   
    public double getVolume() {
        return getArea() * lengthPrism;
    }

    public double getSurfaceArea() {
        double baseArea = getArea();
        double sideArea = 3 * length * lengthPrism;
        return 2 * baseArea + sideArea;
    }

    @Override
    public int compareTo(TriangularPrism other) {
        return Double.compare(this.getSurfaceArea(), other.getSurfaceArea());
    }

    @Override
    public String toString() {
        return "Geometry3D.TriangularPrism{length=" + length + ", prismLength=" + lengthPrism + "}";
    }
}


/*
class Geometry3D.TriangularPrism extends Geometry3D.EquilateralTriangle implements ThreeDshape {
    private double lengthPrism;

    public Geometry3D.TriangularPrism() {
        super(1);
        this.lengthPrism = 1.0;
    }

    public Geometry3D.TriangularPrism(int length, double lengthPrism) {
        super(length);
        this.lengthPrism = lengthPrism;
    }

    @Override
    public double getVolume() {
        return getArea() * lengthPrism;
    }

    @Override
    public double getSurfaceArea() {
        double baseArea = getArea();
        double sideArea = 3 * length * lengthPrism;
        return 2 * baseArea + sideArea;
    }

    @Override
    public int compareTo(ThreeDshape other) {
        return Double.compare(this.getSurfaceArea(), other.getSurfaceArea());
    }

    @Override
    public String toString() {
        return "Geometry3D.TriangularPrism{length=" + length + ", prismLength=" + lengthPrism + "}";
    }
}


 */

class TriangularPyramid extends EquilateralTriangle implements Comparable<TriangularPyramid> {
    private double height;

    public TriangularPyramid() {
        super(1);
        this.height = 1.0;
    }

    public TriangularPyramid(int length, double height) {
        super(length);
        this.height = height;
    }

    public double getVolume() {
        return (1.0 / 3) * getArea() * height;
    }

    public double getSurfaceArea() {
        double baseArea = getArea();
        double slantHeight = Math.sqrt(height * height + (length * length) / 12.0);
        double lateralArea = 3 * 0.5 * length * slantHeight;
        return baseArea + lateralArea;
    }

    @Override
    public int compareTo(TriangularPyramid other) {
        return Double.compare(this.getSurfaceArea(), other.getSurfaceArea());
    }

    @Override
    public String toString() {
        return "Geometry3D.TriangularPyramid{length=" + length + ", height=" + height + "}";
    }
}

/*
class Geometry3D.TriangularPyramid extends Geometry3D.EquilateralTriangle implements ThreeDshape {
    private double height;

    public Geometry3D.TriangularPyramid() {
        super(1);
        this.height = 1.0;
    }

    public Geometry3D.TriangularPyramid(int length, double height) {
        super(length);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3) * getArea() * height;
    }

    @Override
    public double getSurfaceArea() {
        double baseArea = getArea();
        double slantHeight = Math.sqrt(height * height + (length * length) / 12.0);
        double lateralArea = 3 * 0.5 * length * slantHeight;
        return baseArea + lateralArea;
    }

    @Override
    public int compareTo(ThreeDshape other) {
        return Double.compare(this.getSurfaceArea(), other.getSurfaceArea());
    }

    @Override
    public String toString() {
        return "Geometry3D.TriangularPyramid{length=" + length + ", height=" + height + "}";
    }
}

*/


/*
public class Geometry3DShapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThreeDshape[] shapes = new ThreeDshape[5];

        for (int i = 0; i < shapes.length; ) {
            System.out.println("Choose shape (1=Geometry3D.SquarePyramid, 2=Geometry3D.TriangularPyramid, 3=Geometry3D.TriangularPrism): ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
                continue;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            int len;
            while (true) {
                System.out.print("Enter side length (must be a positive integer): ");
                try {
                    len = Integer.parseInt(scanner.nextLine());
                    if (len <= 0) {
                        System.out.println("Length must be greater than zero. Please try again.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("That's not a valid integer. Please try again.");
                }
            }

            double height;
            while (true) {
                System.out.print("Enter height (must be a positive number): ");
                try {
                    height = Double.parseDouble(scanner.nextLine());
                    if (height <= 0) {
                        System.out.println("Height must be greater than zero. Please try again.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("That's not a valid number. Please try again.");
                }
            }

            switch (choice) {
                case 1 -> shapes[i] = new Geometry3D.SquarePyramid(len, height);
                case 2 -> shapes[i] = new Geometry3D.TriangularPyramid(len, height);
                case 3 -> shapes[i] = new Geometry3D.TriangularPrism(len, height); // height 代表棱柱长度
            }

            i++;
        }

        Arrays.sort(shapes);

        for (ThreeDshape shape : shapes) {
            System.out.println(shape + ", volume=" + shape.getVolume() + ", surfaceArea=" + shape.getSurfaceArea());
        }

        System.out.println("\nSmallest (by surface area): " + shapes[0]);
        System.out.println("Largest (by surface area): " + shapes[shapes.length - 1]);

        scanner.close();




    }
}

 */


