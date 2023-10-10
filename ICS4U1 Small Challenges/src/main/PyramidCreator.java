package main;

public class PyramidCreator {
	
	public static void createPyramid(){
		
		int n;
		
		// Get and error check user input
		do {
			System.out.println("Enter a size for the pyramid between 1 and 10:");
			while(!Main.scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a size for the pyramid between 1 and 10:");
				Main.scanner.next(); // Consume the invalid input
			}
			n = Main.scanner.nextInt();
			Main.scanner.nextLine();
		}while(n < 1 || n > 9);

        StringBuilder pyramid = new StringBuilder();

        // Iterate through each row of the pyramid
        for (int i = 1; i <= n; i++) {
        	// Calculate the number of spaces before and after the numbers for center alignment
            int spacesBefore = (2 * n - 1 - 2 * i + 1) / 2;
            int spacesAfter = 2 * n - 1 - spacesBefore - 2 * i;

            // Append spaces before the numbers
            for (int j = 0; j < spacesBefore; j++) {
                pyramid.append(" ");
            }

            // Append numbers for the current row
            for (int j = 1; j <= i; j++) {
                pyramid.append(i);

                // Add space between numbers (except for the last number)
                if (j < i) {
                    pyramid.append(" ");
                }
            }
            // Append spaces after the numbers
            for (int j = 0; j < spacesAfter; j++) {
                pyramid.append(" ");
            }

            // Add newline character after each row
            pyramid.append("\n");
        }

        System.out.println(pyramid.toString());
	}
}
