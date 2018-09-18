import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Practice1 {

	/**
	 * 리스트를 사용한 이터레이션
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> list = Arrays.asList("Biran","Nate","Neal");
		
		/**
		 * 아래 방식의 문제점 d
		 * 1. for루프는 본질적으로 순차적인 방식이라 병렬화가 힘듦
		 * 2. 이러한 루프는 비다형적이여서 자바의 다형성을 활용하지 못함.
		 * 3. 내부 이터레이션에 맡기는 게 아닌 for문에서 내가 직접 구현해야함
		 */
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		/**
		 * 자바 8버전으로 바꿔보기
		 * Consumer 객체의 accept를 활용해 list의 내용을 가져올 수 있다.
		 * 즉, 어떻게 각 요소들을 이터레이션 하는지에 대해 생각할 필요 없이 각 요소에서 할 작업에만 중점을 둔다.
		 * 
		 * 하지만, Anonymous Inner Class는 좀 보기 싫게 생겼다.
		 */
		
		list.forEach(new Consumer<String>() {
			public void accept(final String name) {
				System.out.println(name);
			}
		});
		
		/**
		 * 한 줄로 짧아지고 명확해보이기까지 한다.
		 * forEach는 람다 또는 코드 블록을 인수로 받아 각 리스트 요소들을 처리한다.
		 * 그리고 이 람다식은 순서와 상관없이 lazy하게 실행되어 병렬화가 가능하다.
		 * 
		 * 하지만, 내부에서 이터레이션을 멈출 수 없는 단점이 있다.
		 * 즉, 전체를 봐야할때 유용한 케이스
		 */
		
		list.forEach((final String name)-> System.out.println(name));
		
		/**
		 * 그리고 이렇게 타입을 정하지 않고 사용이 가능하긴하다.
		 * 하지만 파라미터가 가변서을 지니게 되면 문제가 생기고 final과 같은 키워드는 컴파일러가 명시해주지 않으면 모르기 때문에
		 * final이라는 키워드를 붙혀 불변성을 유지 시켜주자.
		 */
		list.forEach(name-> System.out.println(name));

		/**
		 * 메서드 래퍼런스를 활용한 코드
		 * 
		 */
		list.forEach(System.out::println);
	}

}
