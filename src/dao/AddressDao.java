package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dto.AddressDto;
import singleton.Singleton;


//Dao(Data Access Object)
public class AddressDao {

	//데이터를  편집하는 클래스
	//composition
	private Scanner sc = new Scanner(System.in);
	
	
	
	public AddressDao() {
		
	}
	
	public void insert() {
		//TODO:insert()
		System.out.println("데이터를 추가합니다.");
		
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 =");
		int age = sc.nextInt();
		
		System.out.print("전화번호 = ");
		String phone = sc.next();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("주소 = ");
		String address = "";
		try {
			address = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("메모 = ");
		String memo = "";
		try {
			memo = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Singleton s = Singleton.getInstance();
		s.addressBook.add(new AddressDto(name, age, phone, address, memo));
		
	}
	
	public void delete() {	// 24 -> 0 "홍길동" -> "빈문자열"
		//TODO:delete()
		System.out.print("삭제할 이름을 입력하세요");
		String name = sc.next();
		//검색
//		int index = -1;
//		for (int i = 0; i < addressBook.length; i++) {
//			if(addressBook[i] != null) {
//				if(name.equals(addressBook[i].getName())){
//					index = i;
//					break;
//				}
//			}
//		}	
		int index = search(name);
		if(index == -1) {
			System.out.println("지인정보를 찾을 수 없습니다.");
		}
		else {
			//삭제
			Singleton s = Singleton.getInstance();
			s.addressBook.remove(index);
			
			System.out.println("지인정보를 삭제했습니다.");
			
		}
	}
	
	public void select() {	//이름으로 검색
		//TODO:select()
		System.out.print("이름을 검색하세요 = ");
		String name = sc.next();
		

		Singleton s = Singleton.getInstance();
		
		List<AddressDto> findNameList = new ArrayList<AddressDto>();
		
		for (int i = 0; i < s.addressBook.size(); i++) {
			AddressDto dto = s.addressBook.get(i);
			if(name.equals(dto.getName())) {
				findNameList.add(dto);
			}
		}
		
		if(findNameList.size() == 0) {
			System.out.println("입력하신 이름을 찾을 수 없습니다.");
			return;
		}
		
		System.out.println("검색된 이름입니다.");
		for (int i = 0; i < findNameList.size(); i++) {
			System.out.println(findNameList.get(i).toString());
		}
			
	}
	
	public void update() {	//전화번호 주소 메모만 
		//TODO:update()
		
		System.out.print("삭제할 이름을 입력하세요");
		String name = sc.next();
		
		//검색
		int index = search(name);
		if(index == -1) {
			System.out.println("지인을 찾을 수 없습니다.");
			return;
		}
		//수정
		System.out.print("전화번호 >> ");
		String phone = sc.next();
		
		System.out.print("주소 >>");
		String address = sc.next();
		
		System.out.print("메모 >>");
		String memo = sc.next();
		
		Singleton s = Singleton.getInstance();
		
		s.addressBook.get(index).setPhone(phone);
		s.addressBook.get(index).setAddress(address);
		s.addressBook.get(index).setMemo(memo);
		
		System.out.println("수정을 완료했습니다.");
		
	}
	
	public int search(String name) {
		//TODO:search()
		Singleton s = Singleton.getInstance();
		
		int index = -1;
		for (int i = 0; i < s.addressBook.size(); i++) {
			AddressDto dto = s.addressBook.get(i);
			if(name.equals(dto.getName())) {
				index = i;
				break;
				
			}
		}
		return index;
	}
	//확인
	public void allDataPrint() {
		//TODO:allDataPrint()
		
		Singleton s = Singleton.getInstance();
		
		if(s.addressBook.isEmpty()) {
			System.out.println("데이터가 없습니다");
			return;
		}
		
		for (int i = 0; i < s.addressBook.size(); i++) {
			System.out.println(s.addressBook.get(i).toString());
		}
	}
}
