public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {

        List<List<Pair>> result = new ArrayList<>();

        // FIX: empty input case
        if (pairs == null || pairs.isEmpty()) {
            return result;
        }

        List<Pair> arr = new ArrayList<>(pairs);

        // initial state
        result.add(copy(arr));

        for (int i = 1; i < arr.size(); i++) {
            Pair key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j).key > key.key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }

            arr.set(j + 1, key);

            result.add(copy(arr));
        }

        return result;
    }

    private List<Pair> copy(List<Pair> arr) {
        return new ArrayList<>(arr);
    }
}