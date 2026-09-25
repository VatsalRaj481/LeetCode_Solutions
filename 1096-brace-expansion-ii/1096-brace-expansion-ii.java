class Solution {
    int index = 0;
    public List<String> braceExpansionII(String expression) {
        Set<String> result = parseExpression(expression);
        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }
    Set<String> parseExpression(String s) {
        Set<String> result = new HashSet<>();
        result.addAll(parseTerm(s));
        while (index < s.length() && s.charAt(index) == ',') {
            index++;
            result.addAll(parseTerm(s));
        }
        return result;
    }
    Set<String> parseTerm(String s) {
        Set<String> result = new HashSet<>();
        result.add("");
        while (index < s.length()
                && s.charAt(index) != ','
                && s.charAt(index) != '}') {
            Set<String> next = parseFactor(s);
            Set<String> combined = new HashSet<>();
            for (String a : result) {
                for (String b : next) {
                    combined.add(a + b);
                }
            }
            result = combined;
        }
        return result;
    }
    Set<String> parseFactor(String s) {
        if (s.charAt(index) == '{') {
            index++;
            Set<String> result = parseExpression(s);
            index++;
            return result;
        }
        String letter = String.valueOf(s.charAt(index));
        index++;
        Set<String> result = new HashSet<>();
        result.add(letter);
        return result;
    }
}