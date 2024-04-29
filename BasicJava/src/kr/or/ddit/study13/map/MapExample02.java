package kr.or.ddit.study13.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MapExample02 obj = new MapExample02();
		obj.process();
	}

	public void process() {
		List<Map<String, Object>> empList = inputData();
		
		int max = getMaxSalary(empList);
		System.out.println("급여 최대값 : "+max);
		
		int min = getMinSalary(empList);
		System.out.println("급여 최소값 : "+min);
		
		printAll(empList);
		
		addDeptSal(empList);
	}
	
	
	public int getMaxSalary(List<Map<String, Object>> empList) {
		//직원중 최대 임금을 찾아서 리턴하시오.
		int max = 0;
		
		for(Map<String, Object> map : empList) {
			int sal = (int)map.get("SAL");
			if(max<sal) max = sal;
		}
	
		return max;
	}
	
	
	
	public int getMinSalary(List<Map<String, Object>> empList) {
		int min = Integer.MAX_VALUE;
		for(Map<String, Object> map : empList) {
			int sal = (int)map.get("SAL");
			if(min>sal) min = sal;
		}
		return min;
	}
	
	
	public void printAll(List<Map<String, Object>> empList) {
		//회원정보 출력
		System.out.println("EMPNO\tENAME\tJOB\tSAL\tDEPTNO\t");
		for (Map<String, Object> map : empList) {
//			EMPNO	ENAME	JOB		SAL DEPTNO
			String empno = (String) map.get("EMPNO");
			String ename = (String) map.get("ENAME");
			String job = (String) map.get("JOB");
			int sal = (int) map.get("SAL");
			int deptno = (int) map.get("DEPTNO");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+deptno+"\t");
			
		}
	}
	
	public void addDeptSal(List<Map<String, Object>> empList) {
		int sum = 0;
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		for (Map<String, Object> map : empList) {
			int deptno = (int)map.get("DEPTNO");
			int sal = (int)map.get("SAL");
			if(resultMap.containsKey(deptno)) sal+=resultMap.get(deptno);
			resultMap.put(deptno, sal);
		}
		System.out.println(resultMap);
		
	}
	
	
	
	public List<Map<String, Object>> inputData() {
//		EMPNO	ENAME	JOB		SAL DEPTNO
//		7369	장길동	프로그래머	600	50
//		7499	고영우	시장조사	550	20
//		7521	구기현	영업사원	250	30
//		7566	김동혁	관리자	375	40
//		7654	김민욱	영업사원	350	30
		
		
		Map<String, Object> map1 = new HashMap();
		map1.put("EMPNO", "7369");
		map1.put("ENAME", "장길동");
		map1.put("JOB", "프로그래머");
		map1.put("SAL", 600);
		map1.put("DEPTNO", 50);
		
		Map<String, Object> map2 = new HashMap();
		map2.put("EMPNO", "7499");
		map2.put("ENAME", "고영우");
		map2.put("JOB", "시장조사");
		map2.put("SAL", 550);
		map2.put("DEPTNO", 20);
		
		Map<String, Object> map3 = new HashMap();
		map3.put("EMPNO", "7521");
		map3.put("ENAME", "구기현");
		map3.put("JOB", "영업사원");
		map3.put("SAL", 250);
		map3.put("DEPTNO", 30);
		
		Map<String, Object> map4 = new HashMap();
		map4.put("EMPNO", "7566");
		map4.put("ENAME", "김동혁");
		map4.put("JOB", "관리자");
		map4.put("SAL", 375);
		map4.put("DEPTNO", 40);
		
		Map<String, Object> map5 = new HashMap();
		map5.put("EMPNO", "7654");
		map5.put("ENAME", "김민욱");
		map5.put("JOB", "영업사원");
		map5.put("SAL", 350);
		map5.put("DEPTNO", 30);
		
		
		List<Map<String, Object>> list = new ArrayList();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		
		return list;
	}
}
