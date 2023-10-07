public class AthMagicalNumber {
    public int solve(int A, int B, int C) {
        long MOD = 1000000007;
        long left = 1;
        long right = (long) A * Math.min(B, C);
        long lcm = calculateLcm(B, C);

        while (left <= right) {
            long mid = left + (right - left) / 2; // Use this to avoid overflow

            long count = (mid / B) + (mid / C) - (mid / lcm);

            if (count == A) {
                if (mid % B == 0 || mid % C == 0) {
                    return (int) (mid % MOD);
                }
                right = mid - 1;
            } else if (count < A) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 1;
    }

    public long calculateGcd(int B, int C) {
        if (C == 0) {
            return B;
        }
        return calculateGcd(C, B % C);
    }

    public long calculateLcm(int B, int C) {
        return (long) (B / calculateGcd(B, C)) * C;
    }

    public static void main(String[] args) {
        int A=4;
        int B=2,C=3;
        AthMagicalNumber amn = new AthMagicalNumber();
        System.out.println(amn.solve(A,B,C));
    }
}
