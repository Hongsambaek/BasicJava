package kr.or.ddit.study13.list;

public class ArrayTest {

	// 배열에서 불편한점
	// 1. 크기를 먼저 지정해야된다.
	String[] array;
	int cur;

	public ArrayTest() {
		array = new String[10];
	}

	public ArrayTest(int size) { // size 전까지 add가 안되므로 size를 정해주면 속도를 줄일 수 있다. 
		array = new String[size];
	}

	public void add(String str) {
		if (cur == array.length) {
			String[] temp = new String[array.length + 10];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		array[cur++] = str;
	}

	public String get(int index) {
		return array[index];
	}

	// 실제 값이 들어간 크기
	public int size() {
		return cur;
	}

	public String remove(int index) { // remove의 리턴(String)이 있을 수 있다.
		String result = array[index];
		String[] temp = new String[array.length];
		int add = 0;
		for (int i = 0; i < cur; i++) {
			if (i == index)
				add++;
			temp[i] = array[i + add];
		}
		cur--;
		array = temp;
		return result;
	}

	public boolean contains(String search) {
		for (String s : array) {
			if (s.equals(search))
				return true;
		}
		return false;
	}
}
