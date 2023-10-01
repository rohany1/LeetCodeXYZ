
/*  Given an array of integers A. If i < j and A[i] > A[j], 
    then the pair (i, j) is called an inversion of A.
    Find the total number of inversions of A modulo (109 + 7).
*/
public class InversionCount{
    int count=0;
    public void solve(int[] A) {
        int n=A.length;
        mergeSortInversionCount(A,0,n-1);
    }
    private void mergeSortInversionCount(int[] a, int start, int end) {
        if(start>=end){
            return;
        }
        //apply merge sort on 0-mid, mid+1,end
        int mid=(start+end)/2;
        mergeSortInversionCount(a, start, mid);
        mergeSortInversionCount(a, mid+1, end);
        //now merge these array and count no of inversions
        countInversion(a,start,mid,end);
    }
    private void countInversion(int[] a, int start, int mid, int end) {
        int p1=start;
        int p2=mid+1;
        int[] temp = new int[end-start+1];
        int index=0;
        while(p1<=mid && p2<=end){
            if(a[p1]<=a[p2]){
                temp[index]=a[p1];
                p1++;
            }else{
                count+=(mid-p1+1);
                temp[index]=a[p2];
                p2++;
            }
            index++;
        }
        while(p1<=mid){
            temp[index]=a[p1];
            index++;p1++;
        }
        while(p2<=end){
            temp[index]=a[p2];
            index++;p2++;
        }
        //now change the array
        for(int i=start;i<=end;i++){
            a[i]=temp[i-start];
        }
    }
    public static void main(String[] args) {
        InversionCount ic = new InversionCount();
        int[] a= {3, 4, 1, 2};
        ic.solve(a);
        System.out.println(ic.count);
    }
}