// File: src/main/StringCalculator.java

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int add(String input) {
        // for empty input output should be 0
        if (input.isEmpty()) {
            return 0;
        }

        // for default delimiter
        String delimiter = ",|\n";

        // for custom delimiters
        if (input.startsWith("//")) {

            // get the index of custom delimiter
            int delimiterIndex = input.indexOf("\n");

            // store the delimiter in variable
            delimiter = input.substring(2, delimiterIndex);

            // separate out remaining string for addition
            input = input.substring(delimiterIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        return calculateSum(numbers);
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;

        //for negative numbers output
        List<String> negativeNumbers = new ArrayList<>();

        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());

            if (num < 0) {

                // add negative numbers in arraylist
                negativeNumbers.add(number);
            } else{

                //not a negative number, add it to sum.
                sum += num;
            }
        }

        // throw exception for negative numbers with list of negative numbers.
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negativeNumbers));
        }

        return sum;
    }
}
