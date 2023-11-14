import java.util.Arrays;


public class ThreeSum {
    public int threeSumClosest(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        //for every value we will search for min target value
        int difference=Integer.MAX_VALUE;
        int targetSum=0;
        for(int i=0;i<n;i++){
            int left=i+1;
            int right=n-1;
            int target =B-A[i];
            while(left<right){
                int tempSum=A[left]+A[right];
                int currSum=tempSum+A[i];
                if(Math.abs(currSum-B)<=difference){
                    difference=Math.abs(currSum-B);
                    targetSum=currSum;
                }
                if(tempSum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return targetSum;
    }

    public static void main(String[] args) {
        int[] A= {-4,1,2,-1};
        ThreeSum ts = new ThreeSum();
        int ans=ts.threeSumClosest(A, 1);
        System.out.println(ans);
    }
}
