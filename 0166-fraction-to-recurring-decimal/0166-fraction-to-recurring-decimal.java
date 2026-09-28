class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator, den = denominator;
        boolean isNegative = num!=0 && ((num < 0) ^ (den < 0));
        num = Math.abs(num);
        den = Math.abs(den);
        long integerPart = num / den;
        long remainder = num % den;
        StringBuilder result = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        if (isNegative)
            result.append('-');
        result.append(integerPart);
        if (remainder == 0) {
            return result.toString();
        }
        result.append('.');

        while (remainder != 0 && !map.containsKey(remainder)) {
            map.put(remainder, result.length());
            long value = remainder * 10;
            result.append(value / den);
            remainder = value % den;
        }
        if (remainder != 0) {
            int start = map.get(remainder);
            result.insert(start, '(');
            result.append(')');
        }
        return result.toString();
    }
}