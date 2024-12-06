/*
 * Brionna Swinton 
 */

import java.util.Scanner;

public class homework01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Accept user input for various fields
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Age (in years): ");
        int age = scanner.nextInt();

        System.out.print("Enter Phone (without dashes/parentheses): ");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Major: ");
        String major = scanner.nextLine();

        System.out.print("Enter Year (Freshman, Sophomore, Junior, or Senior): ");
        String year = scanner.nextLine();

        System.out.print("Enter Today's Date (mm/dd/yyyy): ");
        String dateOfBirthInput = scanner.nextLine();

        // Additional questions
        System.out.print("Enter Your Dream Destination: ");
        String dreamDestination = scanner.nextLine();

        System.out.print("Enter Your Lucky Number: ");
        int luckyNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Hobbies: ");
        String hobbies = scanner.nextLine();

        // Calculate birth year from age
        int birthYear = java.time.Year.now().getValue() - age;

        // Convert date to European format
        String[] dateParts = dateOfBirthInput.split("/");
        String europeanDate = dateParts[1] + "." + dateParts[0] + "." + dateParts[2];

        // Format phone number as (xxx)xxx-xxxx
        String formattedPhoneNumber = String.format("(%s)%s-%s", phoneNumber / 10000000, (phoneNumber / 10000) % 1000, phoneNumber % 10000);

        // Display user intro
        System.out.println("\nUser Intro:");
        System.out.println("--------------");
        System.out.println("Welcome " + firstName + " " + lastName+ "!");
        System.out.println("You were born in the year " + birthYear + ".");
        System.out.println("We can contact you at " + formattedPhoneNumber + ".");
        System.out.println("You've decided to major in " + major + " at USC.");
        System.out.println("You are a " + year + " at USC");
        System.out.println("Today's date is " + europeanDate);
        System.out.println("If you could travel anywhere you would go to " + dreamDestination + ".");
        System.out.println("Your lucky number is " + luckyNumber + ".");
        System.out.println("In your free time you enjoy " + hobbies + ".");
	}

}
