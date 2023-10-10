package main;

public class DateConverter {
    public static void convertDate() {

        // Loop until a valid date is entered
        while (true) {
            System.out.println("Enter a date in the American date format (MM/DD/YYYY):");
            String americanDate = Main.scanner.nextLine();

            // Split the input American date by '/'
            String[] parts = americanDate.split("/");

            // Check if the input has three parts (month, day, and year)
            if (parts.length == 3) {
                try {
                    // Extract month, day, and year parts
                    int month = Integer.parseInt(parts[0]);
                    int day = Integer.parseInt(parts[1]);
                    int year = Integer.parseInt(parts[2]);

                    // Validate month, day, and year
                    if (month >= 1 && month <= 12) {
                        int maxDaysInMonth = getMaxDaysInMonth(month, year);

                        if (day >= 1 && day <= maxDaysInMonth && year >= 1 && year <= 9999) {
                            // Format month and day with leading zeroes if necessary
                            String isoMonth = String.format("%02d", month);
                            String isoDay = String.format("%02d", day);
                            String isoYear = String.format("%04d", year);

                            // Convert to ISO standard format: YYYY-MM-DD
                            System.out.println("ISO Date: " + isoYear + "-" + isoMonth + "-" + isoDay);
                            break; // Exit the loop as a valid date is entered
                        } else {
                            System.out.println("Invalid date. Please enter a valid date.");
                        }
                    } else {
                        System.out.println("Invalid month. Please enter a valid month (1-12).");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numeric values for month, day, and year.");
                }
            } else {
                System.out.println("Invalid input format. Please enter the date in MM/DD/YYYY format.");
            }
        }

    }

    public static int getMaxDaysInMonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            // Check for leap year (divisible by 4 and not divisible by 100 unless divisible by 400)
            return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
        } else {
            return 31;
        }
    }
}
