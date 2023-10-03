import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForARange {
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (A.get(mid) == B) {
                // check for the range
                int index = mid - 1;
                while (index >= 0 && A.get(index) == B) {
                    index--;
                }
                ans.add(index + 1);
                index = mid + 1;
                while (index <= n - 1 && A.get(index) == B) {
                    index++;
                }
                ans.add(index - 1);
                return ans;
            } else if (A.get(mid) > B) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (ans.size() > 0) {
            return ans;
        }
        List<Integer> li = Arrays.asList(-1, -1);
        return new ArrayList<>(li);
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(5, 7, 7, 8, 8, 10);
        ArrayList<Integer> A = new ArrayList<>(li);
        SearchForARange sfr = new SearchForARange();
        ArrayList<Integer> ans = sfr.searchRange(A, 7);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i) + " ");
        }
    }
}
