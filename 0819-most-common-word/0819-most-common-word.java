class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word.toLowerCase());
        }
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        int max = 0;
        for (String word : words) {
            if (bannedSet.contains(word)) {
                continue;
            }
            int frequency = map.getOrDefault(word, 0) + 1;
            map.put(word, frequency);
            if (frequency > max) {
                max = frequency;
                result = word;
            }
        }
        return result;
    }
}