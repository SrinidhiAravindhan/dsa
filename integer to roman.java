public class Solution {
    public String intToRoman(int num) {
        // Roman numeral symbols and their corresponding integer values
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder(); // To build the Roman numeral
        
        // Loop through all possible values starting from the largest
        for (int i = 0; i < values.length; i++) {
            // While num is greater than or equal to the current value, append the Roman symbol
            while (num >= values[i]) {
                result.append(romanSymbols[i]);
                num -= values[i];  // Subtract the value from num
            }
        }
        
        return result.toString(); // Return the resulting Roman numeral as a string
    }
}
