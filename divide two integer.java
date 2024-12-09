public class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: Handle overflow when dividend is Integer.MIN_VALUE and divisor is -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the result
        boolean negative = (dividend < 0) != (divisor < 0);  // XOR to check if signs are different
        
        // Work with absolute values to simplify the division process
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        
        long quotient = 0;
        
        // Subtract the divisor from dividend in large chunks (using bit shifting)
        while (dividendAbs >= divisorAbs) {
            long tempDivisor = divisorAbs, numDivisors = 1;
            
            // Try to double the divisor (left shift) until it exceeds dividend
            while (dividendAbs >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                numDivisors <<= 1;
            }
            
            // Subtract the largest chunk and add to the quotient
            dividendAbs -= tempDivisor;
            quotient += numDivisors;
        }
        
        // Apply the sign to the quotient
        if (negative) {
            quotient = -quotient;
        }
        
        // Clamp the result to the 32-bit signed integer range
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        return (int) quotient;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test example 1
        int dividend1 = 10, divisor1 = 3;
        int result1 = sol.divide(dividend1, divisor1);
        System.out.println(result1);  // Expected: 3
        
        // Test example 2
        int dividend2 = 7, divisor2 = -3;
        int result2 = sol.divide(dividend2, divisor2);
        System.out.println(result2);  // Expected: -2
        
        // Test edge case: Overflow
        int dividend3 = Integer.MIN_VALUE, divisor3 = -1;
        int result3 = sol.divide(dividend3, divisor3);
        System.out.println(result3);  // Expected: 2147483647 (max int)
    }
}
