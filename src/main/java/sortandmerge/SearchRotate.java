package sortandmerge;

public class SearchRotate {
    public static void main(String[] args) {
        int[] a = new int[]{6, 7, 8, 9, 10, 15, 19, 25, 2, 3, 4, 5};
        int findIndex = searchRotated(a, 18);
        System.out.println((findIndex == -1) ? "Not found" : findIndex);
    }
    
    private static int binarySearch(int[] a, int x, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (right < left) return -1;
        if (x == a[mid]) {
            return mid;
        } else if (x < a[mid]) {
            right = mid - 1;
            return binarySearch(a, x, left, right);
        } else {
            left = mid + 1;
            return binarySearch(a, x, left,right);
        }
    }

    private static int searchRotated(int[] a, int x) {
        int left = 0, right = a.length - 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i+1]) {
                continue;
            }
            left = i + 1;
            right = i;
            break;
        }
        int leftResult = binarySearch(a, x, 0, right);
        int rightResult = binarySearch(a, x, left, a.length - 1);
        if (leftResult == -1 && rightResult == -1) return -1;
        else return ((leftResult == -1) ? rightResult : leftResult);
    }
}
