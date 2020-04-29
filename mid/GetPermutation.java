package mid;

public class GetPermutation {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new GetPermutation().getPermutation(9, 100));
    }

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        int tmp[] = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = i + 1;
        }
        while (k > 1) {
            next(tmp, n);
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            sb.append(tmp[i]);
        }
        return sb.toString();
    }

    public void next(int[] arr, int len) {
        int i = len - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, len, i + 1);
    }

    public void reverse(int[] arr, int len, int start) {
        int i = start;
        int j = len - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
