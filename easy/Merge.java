package easy;

public class Merge {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[--len] = nums1[m--];
            } else {
                nums1[--len] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[--len] = nums2[n--];
        }
    }

}
