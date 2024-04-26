package kr.or.ddit.study13.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample01 {
	public static void main(String[] args) {
		// 배열과 유사한 구조
		// ArrayList
		// 1. 1차원 배열 구조
		// 2. 중복을 허락하고 순서화 제공
		// 3. List 타입의 컬랙션

		// 주요 메소드
		// .add      : 데이터 삽입
		// .clear    : 모든 데이터 삭제
		// .contains : 포함 여부 확인
		// .get      : idx 자료 반환
		// .remove   : idx 자료 반환 후 삭제
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list.remove(2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
