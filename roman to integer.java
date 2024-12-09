public class Solution {
    public int romanToInt(String s) {
        // Create a map for Roman numeral values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        
        // Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {
            // Get the value of the current Roman numeral
            int currentVal = romanMap.get(s.charAt(i));

            // Check if the next character exists and if its value is greater than the current one
            if (i + 1 < s.length() && currentVal < romanMap.get(s.charAt(i + 1))) {
                // If so, subtract the current value (e.g., IV = 5 - 1)
                total -= currentVal;
            } else {
                // Otherwise, add the current value
                total += currentVal;
            }
        }

        return total;
    }
}
