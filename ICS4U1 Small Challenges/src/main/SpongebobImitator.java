package main;

public class SpongebobImitator {
	
	public static void convertToSpongebob(){
		StringBuilder convertedString = new StringBuilder();

        // Index to keep track of the character position
        int index = 0;
        
        System.out.println("Enter text to be imitated by Spongebob:");
        String input = Main.scanner.nextLine();
        
        // Iterate through each character in the input string
        for (char ch : input.toCharArray()) {
            // If the character is a letter and not 'o' or 'e'
            if (ch != 'o' && ch != 'e' && ch != ' ') {
                // Convert characters based on the index position
                if (index % 5 == 1) {
                    // Uppercase second letter
                    convertedString.append(Character.toUpperCase(ch));
                } else if (index % 5 == 4) {
                    // Uppercase fifth letter
                    convertedString.append(Character.toUpperCase(ch));
                } else {
                    // Lowercase other letters
                    convertedString.append(Character.toLowerCase(ch));
                }
                // Increment the index for the next character
                index++;
            }
            else if(ch == ' ') { // Append spaces without putting them through the algorithm
            	convertedString.append(ch);
            }
        }
        // Print the output
        System.out.println("Converted output: " + convertedString.toString());
	}
}
