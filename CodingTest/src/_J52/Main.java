package _J52;

import java.util.Scanner;

/**
 * 52. 뮤직 비디오 (결정 알고리즘) 
 * 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
 * 
 * DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
 * 
 * 순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
 * 
 * 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
 * 
 * 지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
 * 
 * 고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
 * 
 * 그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
 * 
 * 
 * [입력] 
 * 9 3
   1 2 3 4 5 6 7 8 9

 * [출력] 
 * 17
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	
	/* 
	 * ex)해당 음원을 3장의 디스크에 담아야 하는 경우를 찾을 때 
	 * 
	 * 1 2 3 4 5 6 7 8 9
	 * 가장 긴 음원: 9 (최소 설정 용량 후보) => lt
	 * 모든 음원의 합: 45 (최대 설정 용량 후보) => rt 
	 * * 결정 알고리즘은 이분 탐색을 활용하는 알고리즘 후보 군 중 사이에 무조건 답이 있는 경우에 사용 
	 * 
	 * 답안과 다른 점: Arrays 메서드 사용한 점, cnt check 메서드로 빼서 작성한 점
	 * 1. 배열 원소 중 가장 큰 값 반환: Arrays.stream(arr).max().getAsInt();
	 * 2. 배열 원소 중 가장 작은 값 반환: Arrays.stream(arr).min().getAsInt();
	 * 3. 배열 원소의 합 반환: Arrays.stream(arr).sum();
	 * 
	 */
	
	public static int solution(int m, int[] arr) {
		// 이진 탐색을 위한 변수 
		int lt = arr[arr.length-1]; // 가장 긴 음원 : 9 (최소 설정 용량 후보) => lt
		int rt = 0;
		int mid = 0;
		
		// 디스크 갯수를 카운트 하기 위한 변수
		int cnt = 1;
		int sum = 0;
		int dc = 0;
		
		for(int num : arr) {		// 모든 음원의 합: 45 (최대 설정 용량 후보) => rt 
			rt += num;
		}
		
		while(lt <= rt) {
			cnt = 1;
			sum = 0;
			mid = (lt + rt) / 2;
			
			for(int i=0; i<arr.length; i++) {
				if(mid >= sum + arr[i]) sum += arr[i]; // 누적 합이 용량을 벗어나지 않을 때 추가.
				else {                                // 벗어난다면 사용한 디스크 수를 증가 시킨 후 새로 sum
					cnt++;
					sum = arr[i];
				}
			}
			
			//해당 용량으로 설정 했을때 디스크 용량이 m개를 벗어나지 않는다면 후보 가능 
			if(cnt <= m) {  // 조건에 적합하다면 더 작은 값의 후보가 있는지 확인 
				dc = mid;
				rt = mid-1;
			}
			else {			// 조건에 부합하지 않다면 lt를 mid+1로 둬서 더 큰 숫자를 확인.
				lt = mid +1;
			}
		}
		return dc; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solution(m, arr));
	}
}
