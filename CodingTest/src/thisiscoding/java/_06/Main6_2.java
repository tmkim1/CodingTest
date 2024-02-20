package thisiscoding.java._06;

/**
 * 퀵 정렬
 */
public class Main6_2 {
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return; //원소가 1개인 경우 종료
        int pivot = start; // 첫 번쨰 원소를 pivot으로 설정
        int left = start + 1;
        int right = end;
        while(left <= right) {
            // 피벗보다 큰 데이터를 찾을때까지 반복
            while(left <= end && arr[left] <= arr[pivot]) left ++;
            while(right > start && arr[right] >= arr[pivot]) right--;
            //엇갈렸다면 작은 데이터와 피벗을 교체
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            //엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        quickSort(arr, start, right-1);
        quickSort(arr, right + 1, end);

    }
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        quickSort(arr, 0, n-1);

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
