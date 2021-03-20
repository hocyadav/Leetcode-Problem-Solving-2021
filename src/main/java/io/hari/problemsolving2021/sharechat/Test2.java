package io.hari.problemsolving2021.sharechat;

/**
 * @Author Hariom Yadav
 * @create 20-03-2021
 */
class Test2 {

    public static int findMaxGCD(int arr[], int n) {
        int highNumner = 0;
        for (int i_ = 0; i_ < n; i_++)
            highNumner = Math.max(highNumner, arr[i_]);
        int count_[] = new int[highNumner + 1];
        for (int i_ = 0; i_ < n; i_++)
            count_[arr[i_]]++;
        int counter_ = 0;
        for (int i = highNumner; i >= 1; i--) {
            int j = i;
            while (j <= highNumner) {
                if (count_[j] > 0)
                    counter_ += count_[j];
                j += i;
                if (counter_ == 2)
                    return i;
            }
            counter_ = 0;
        }
        return 1;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 8, 8, 12};
        int n = arr.length;
        System.out.println(findMaxGCD(arr, n));
    }
}
