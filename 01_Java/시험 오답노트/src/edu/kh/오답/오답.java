package edu.kh.오답;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 오답 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<IPInfo> ipInfoList = new ArrayList<IPInfo>(); 
//		List<IPInfo> ipInfoList = null; -> inInfoList에 null값을 대입해서 예외 NullPointerException이 발생
//										-> null값은 아예 존재하지 않는다는 의미라 비어있는 리스트를 만들어야 함 
//										->  null값 대신에 IPInfo를 참조하는 객체List를 하나 생성하는 코드를 작성해야함
//										-> List<IPInfo> inInfoList = new ArrayList<IPInfo>;
										
		
		ipInfoList.add(new IPInfo("123.123.123.123", "홍길동"));
		ipInfoList.add(new IPInfo("212.133.7.8", "갑을병"));
		//ipInfoList.add(new IPInfo("212.133.7.8")); -> ip값,user값이 입력되어야 하는데 ip값만 입력됨  -> user값에 빈 값을 넣고 싶다면 " "를 사용, new IPInfo("212.133.7.8," ")
		ipInfoList.add(new IPInfo("177.233.111.222", "고길순"));
		
		System.out.println("ip 입력 : ");
		String ip = sc.next();
		
		for(int i=0; i<ipInfoList.size(); i++) {
//			if(ipInfoList.get(i) == ip) { -> ipInfoList.get(i) 는 IPInfo 타입이지만 ip는 String타입으로 서로 자료형이 달라서 비교가 안될뿐더러 ip는 String 타입이라 
//												"==" 을 사용해서 비교하면 안됨
//											-> 우선 같은 String 자료형끼리 비교하기 위해서 getIp를 사용해서 String 자료형을 불러오고
//												String 자료형끼리 비교할려면 "=="을 사용하는것이 아닌 equals()를 사용해야한다.
//											-> if(ipInfoList.get(i).getIp().equals(ip))
				if(ipInfoList.get(i).getIp().equals(ip)) { 
				System.out.println(ipInfoList.get(i));
				return;
//				break; ->  찾으려는 ip가 일치해서 break문을 실행되면 바로 for반복문 밖으로 나와서 "일치하는 ip 사용자가 없습니다."라는 println구문이 실행됨
//						-> ip가 일치하면 "일치하는 ip 사용자가 없습니다."라는 println구문 실행되지 않게 수정해야함
//						-> break가 아닌 return을 사용해서 아예 함수를 빠져나가는 형태로 만들어야 한다.
//						-> return;
			}
		}
		System.out.println("일치하는 ip 사용자가 없습니다.");
	}
}
