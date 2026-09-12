class Solution {

    static class Interval {
        int l, r, weight, index;

        Interval(int l, int r, int weight, int index) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.index = index;
        }
    }

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            return Integer.compare(a.r, b.r);
        });

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int lo = i + 1, hi = n;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (arr[mid].l > arr[i].r) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            next[i] = lo;
        }

        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = new State(0, new ArrayList<>());

            for (int k = 1; k <= 4; k++) {
                State skip = dp[i + 1][k];
                State future = dp[next[i]][k - 1];

                List<Integer> chosen = new ArrayList<>(future.indices);
                chosen.add(arr[i].index);
                Collections.sort(chosen);

                State take = new State(
                    future.score + arr[i].weight,
                    chosen
                );

                dp[i][k] = better(skip, take);
            }
        }

        List<Integer> answer = dp[0][4].indices;
        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private State better(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        return lexicographicallySmaller(a.indices, b.indices) ? a : b;
    }

    private boolean lexicographicallySmaller(List<Integer> a, List<Integer> b) {
        int min = Math.min(a.size(), b.size());

        for (int i = 0; i < min; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}