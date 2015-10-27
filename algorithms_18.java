public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        HashMap<Integer, ArrayList<ArrayList<Integer>>> sum2 = new HashMap<>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                ArrayList<Integer> pair = new ArrayList<>(2);
                pair.add(i);
                pair.add(j);
                if (!sum2.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> value = new ArrayList<>();
                    value.add(pair);
                    sum2.put(sum, value);
                }
                else {
                    ArrayList<ArrayList<Integer>> value = sum2.get(sum);
                    value.add(pair);
                }
            }
        }
        Set set = new HashSet<>();
        for (Integer sum : sum2.keySet()) {
            ArrayList<ArrayList<Integer>> pair = sum2.get(sum);
            if (sum2.containsKey(target - sum)) {
                if (target - sum == sum && pair.size() == 1) continue;
                ArrayList<ArrayList<Integer>> pairs = sum2.get(target - sum);
                for (ArrayList<Integer> pair1 : pair) {
                    for (ArrayList<Integer> pair2 : pairs) {
                        if (pair1 == pair2) continue;
                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1))) continue;
                        ArrayList<Integer> s = new ArrayList<>(4);
                        s.add(num[pair1.get(0)]);
                        s.add(num[pair1.get(1)]);
                        s.add(num[pair2.get(0)]);
                        s.add(num[pair2.get(1)]);
                        Collections.sort(s);
                        set.add(s);
                    }
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        result.addAll(set);
        return result;
    }
}