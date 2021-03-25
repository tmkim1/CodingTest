import java.util.ArrayList;
import java.util.Scanner;

//학생 이름을 받아 번호 찾기.
public class ExampleClass {

	public static void main(String[] args) {
		Student std1 = new Student("김태민","117");
		Student std2 = new Student("이혜영","118");
		Student std3 = new Student("돼지김태민","119");
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(std1);
		list.add(std2);
		list.add(std3);
		
		// forEach 문법 
		for (Student stu : list) {
			System.out.println(stu.getName() + "번호:" + stu.getNo());
		}
		
		Scanner scan = new Scanner(System.in);
		
		
		
		while(true) {
			System.out.println("계속 검색: y, 중단: n");
			
			String input = scan.next();
			if(input.equals("y")) {
				System.out.println("검색을 시작합니다.");
				String name = scan.next();
				Boolean flag = false;
				
				for (Student stu : list) {
					if (stu.getName().equals(name)) {
						flag = true;
						System.out.println(name+ "번호 :" + stu.getNo());
					}
				}
				
				if(!flag) {
					System.out.println("해당 하는 학생을 찾지 못했습니다.");
				}
				
			} else if (input.equals("n")) {
				break;
			}
			
		}
		
		System.out.println("종료되었습니다.");
		
	
		
	}

}