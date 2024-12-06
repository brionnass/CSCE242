import java.util.Scanner;

class Circle {
    double radius;
    double area;

    public Circle(double radius) {
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
    }
}

public class Homework04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int collectionSize = 0;
        Circle[] circleCollection = null;
// Display menu options to the user
        while (true) {
            System.out.println("Options:");
            System.out.println("1. Circles' Data");
            System.out.println("2. Sort and display circles' areas from smallest to largest");
            System.out.println("3. Sort and display circles' areas from largest to smallest");
            System.out.println("4. Find and display unique circles' areas");
            System.out.println("5. Quit");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                	// Allow the user to specify the size of the circle collection and create an array for storing circles
                    System.out.println("Enter the total number of circles to store in the collection: ");    // Allow the user to specify the size of the circle collection and create an array for storing circles.
                    collectionSize = input.nextInt();
                    input.nextLine();
                    circleCollection = new Circle[collectionSize];
                    // Prompt the user to enter the radius of each circle in the collection.
                    for (int i = 0; i < collectionSize; i++) {
                        System.out.println("Enter the radius of circle " + (i + 1) + ": ");
                        double radius = input.nextDouble();
                        input.nextLine();
                        circleCollection[i] = new Circle(radius);
                    }
                    break;

                case 2:
                    if (circleCollection != null) {
                    	// Sort the circles based on their areas in descending order and display the sorted areas
                        sortCircles(circleCollection, true);
                    } else {
                        System.out.println("Cannot sort an empty collection.");
                    }
                    break;

                case 3:
                    if (circleCollection != null) {
                    	// Sort the circles based on their areas in  ascending order and display the sorted areas.
                        sortCircles(circleCollection, false);
                    } else {
                        System.out.println("Cannot sort an empty collection.");
                    }
                    break;

                case 4:
                    displayUniqueAreas(circleCollection);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    input.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public static void sortCircles(Circle[] circles, boolean ascending) {
        for (int i = 0; i < circles.length - 1; i++) {
            for (int j = 0; j < circles.length - i - 1; j++) {
                if ((ascending && circles[j].area > circles[j + 1].area) ||
                    (!ascending && circles[j].area < circles[j + 1].area)) {
                    Circle temp = circles[j];
                    circles[j] = circles[j + 1];
                    circles[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted Circles' Areas:");
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Circle " + (i + 1) + " - Radius: " + circles[i].radius + ", Area: " + circles[i].area);
        }
    }

    public static void displayUniqueAreas(Circle[] circles) {
        boolean hasDuplicates = false;

        for (int i = 0; i < circles.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < circles.length; j++) {
                if (i != j && circles[i].area == circles[j].area) {
                    isUnique = false;
                    hasDuplicates = true;
                    break;
                }
            }
            if (isUnique) {
                System.out.println("Circle " + (i + 1) + " - Radius: " + circles[i].radius + ", Area: " + circles[i].area);
            }
        }

        if (hasDuplicates) {
            System.out.println("Some circles have the same area, only displaying unique areas.");
        } else {
            System.out.println("All circles have distinct areas.");
        }
    }
}