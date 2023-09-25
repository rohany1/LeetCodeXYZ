import java.util.PriorityQueue;

public class AthLargestElement {
    public int[] solve(int A, int[] B) {
        //create a min Heap and maintain its size of A
        int n=B.length;
        int[] ans= new int[n];
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int index=0;index<n;index++){
            pq.add(B[index]);
            if(pq.size()<A){
                ans[index]=-1;
            }else if(pq.size()==A){
                ans[index]=pq.peek();
            }else{
                pq.poll();
                ans[index]=pq.peek();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] B= {15,20,99,1};
        int A=2;
        AthLargestElement ale= new AthLargestElement();
        int[] ans= ale.solve(A, B);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] +" ");
        }
    }
}
