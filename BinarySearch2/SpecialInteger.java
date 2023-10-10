public class SpecialInteger {
    public int solve(int[] A, int B) {
        //range of binary search would be max -> MaxSum
        int left = 1;
        int right = A.length;
        int mid=0;
        int ans=-1;
        while(left<=right){
            mid=(left+right)/2;
            if(check(A,mid,B)){
                //we will go right, search for bigger ans
                left=mid+1;
                ans=mid;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }

    public boolean check(int[]A, int mid, int B){
        //initial window sum
        int windowSum=0;
        for(int i=0;i<mid;i++){
            windowSum+=A[i];
        }
        if(windowSum>B){
            return false;
        }
        int n=A.length;
        int start=0;
        int end= mid;
        while(end<n){
            windowSum+=A[end];
            windowSum-=A[start];
            if(windowSum>B){
                return false;
            }
            start++;
            end++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr ={5,10,20,100,105};
        SpecialInteger si = new SpecialInteger();
        System.out.println(si.solve(arr, 130));
    }
}
