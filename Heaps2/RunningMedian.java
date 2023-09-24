import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/* Problem Statement ->
    Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
    Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

    Find and return the array C.

    NOTE:
    If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
    If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
    
    Constraints:
        1 <= length of the array <= 100000
        1 <= A[i] <= 109
*/
public class RunningMedian {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        // Create an answer array
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        // Create two heaps !! One minHeap and other MaxHeap
        // right one
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // left one
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Add the first element of A to minHeap
        maxHeap.add(A.get(0));
        ans.add(maxHeap.peek());
        // iterate on all the next elements in the array
        for (int i = 1; i < n; i++) {
            // first check in which heap we need to add
            if (maxHeap.peek() > A.get(i)) {
                // add in max Heap
                maxHeap.add(A.get(i));
            } else {
                // add in min heap
                minHeap.add(A.get(i));
            }
            // Now we need to balance the heap only when size difference is greater than 1
            balanceHeap(minHeap, maxHeap);
            // After balancing
            if (minHeap.size() > maxHeap.size()) {
                ans.add(minHeap.peek());
            } else {
                ans.add(maxHeap.peek());
            }
        }
        return ans;
    }

    public void balanceHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        // if the size differenece between them is greater than 2 than we call balance
        // heap
        if ((int) Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if (minHeap.size() > maxHeap.size()) {
                int temp = minHeap.poll();
                maxHeap.add(temp);
            } else {
                int temp = maxHeap.poll();
                minHeap.add(temp);
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        List<Integer> lsA = Arrays.asList(1, 2, 5, 4, 3);
        ArrayList<Integer> A = new ArrayList<>(lsA);
        RunningMedian rn = new RunningMedian();
        ArrayList<Integer> ans = rn.solve(A);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}