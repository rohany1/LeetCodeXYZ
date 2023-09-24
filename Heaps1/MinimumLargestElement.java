import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumLargestElement {
    class Pair {
        int first;
        int second;

        Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    public int solve(ArrayList<Integer> A, int B) {
        // First create a priority queue of pair
        // Add all the pairs in priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k.first));
        int n = A.size();
        // create a array which will contain next state
        ArrayList<Integer> nextState = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nextState.add(A.get(i));
        }
        // add all the elements next state to pq
        for (int i = 0; i < n; i++) {
            Pair temp = new Pair(A.get(i) * 2, i);
            pq.add(temp);
        }

        while (B > 0) {
            // fetch the smallest next state from pq
            Pair curr = pq.poll();
            // now change the value in nextState of array
            nextState.set(curr.second, curr.first);
            // now add the new next state of same element in pq
            Pair newState = new Pair(curr.first + A.get(curr.second), curr.second);
            pq.add(newState);
            B--;
        }
        // after B operation fetch the minimum maximum possible
        int max = nextState.get(0);
        for (int i = 1; i < n; i++) {
            if (nextState.get(i) > max) {
                max = nextState.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> ls=Arrays.asList(1,2,3,4);
        ArrayList<Integer> A=new ArrayList<>(ls);
        int B=3;
        MinimumLargestElement mle=new MinimumLargestElement();
        System.out.println(mle.solve(A,B));        
    }
}
