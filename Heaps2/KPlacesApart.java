import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*Problem Statement
 *  N people having different priorities are standing in a queue.

    The queue follows the property that each person is standing at most B places away from its position in the sorted queue.

    Your task is to sort the queue in the increasing order of priorities.

    NOTE:

    No two persons can have the same priority.
    Use the property of the queue to sort the queue with complexity O(NlogB).

    Contraints
    1 <= N <= 100000
    0 <= B <= N
 */
public class KPlacesApart{
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        //first we know that correct position of element is B places far
        //first create a min Heap of Size B+1
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n=A.size();
        for(int index=0;index<B+1;index++){
            pq.add(A.get(index));
        }
        for(int index=B+1;index<n;index++){
            ans.add(pq.poll());
            pq.add(A.get(index));
        }
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> lsA= Arrays.asList(1,40,2,3);
        ArrayList<Integer> A= new ArrayList<>(lsA);
        KPlacesApart kpa=new KPlacesApart();
        ArrayList<Integer> ans = kpa.solve(A, 2);
        for(int index=0;index<ans.size();index++){
            System.out.print(ans.get(index)+" ");
        }
    }
}