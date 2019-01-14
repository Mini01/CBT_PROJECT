package com.biz.MavenCBT.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.MavenCBT.DB.Factory;
import com.biz.MavenCBT.vo.CBTVO;

public class CBTService {
	
	Scanner scan;
	Factory factory;
	
	List<Integer> answerList;
	List<Integer> noList;
	public CBTService(){
		
		scan = new Scanner(System.in);
		factory = new Factory();	
		answerList = new ArrayList();
		noList = new ArrayList();
	}
	
	
	
	public void Menu() {
		
		while(true) {
			System.out.println("==========================================================");
			System.out.println("==============정보 처리 기사 시험 연습시스템==============");
			System.out.println("=================1.관리 2.문제풀기 0.종료=================");
			System.out.println("==========================================================");
			System.out.print("선택 >>");
			String strM = scan.nextLine();
			int intM = Integer.valueOf(strM);
			
			if(intM == 0)break;
			if(intM ==1) management();
			if(intM ==2) goQ();
			
			
			break;	
		}
		
		
	}



	public void management() {
		// TODO 관리 세부메뉴
		while (true) {
			System.out.println("===================================================================");
			System.out.println("=================정보 처리 기사 시험 문제관리======================");
			System.out.println("==============1.문제추가 2.문제수정 3.문제삭제 0.종료==============");
			System.out.println("===================================================================");

			String strM = scan.nextLine();
			int intM = Integer.valueOf(strM);

			if (intM == 0)break;
			if (intM == 1)insert();
			if (intM == 2)updateQ();
			if (intM == 3)deleteQ();
				

		}
		
	}
	public CBTVO addQ(){
		
		System.out.println("문제를 입력하세요");
		String Question = scan.nextLine();
		String bogi = "";
	
		for(int i = 0 ; i < 4 ; i++) {
			System.out.println((i+1)+ "번 보기를 입력하세요");
			System.out.print(">>");
			bogi += scan.nextLine() + "/";
		}
		System.out.println("정답번호를 입력하세요");
		String answer =scan.nextLine();
		
		try {
			String[] bogi2 = bogi.split("/");
			answer=bogi2 [(Integer.valueOf(answer))-1];
			CBTVO vo = new CBTVO(Question,bogi,answer);
			return vo;
		} catch (Exception e) {
			
			// TODO: handle exception
		}
		return null;

		
	}
	
	public void insert() {
		
		CBTVO vo =addQ();
		if(vo ==null) return;
		factory.insert(vo);
		System.out.println("입력완료");
	
	}



	public void deleteQ() {
		System.out.println("삭제할 ID를 입력하십시오");
		String strM = scan.nextLine();
			long cb_id = Long.valueOf(strM);
			factory.delete(cb_id);
			System.out.println("삭제 완료");
		
		
	}



	public void updateQ() {
		
		System.out.println("수정할 ID를 입력하십시오");
		String strM = scan.nextLine();
			long cb_id = Long.valueOf(strM);
			CBTVO vo1 = factory.findById(cb_id);
			CBTVO vo2 = addQ();
			vo2.setCb_id(vo1.getCb_id());
			factory.update(vo2);
			System.out.println("수정 완료");
		
	}
	
	



	public void goQ() {

		
     	List<CBTVO> vo =  factory.CBTAll();
		System.out.println(">> 문제풀이를 시작합니다.");
		Collections.shuffle(vo);
		
		int score =0;
		for(int i = 0; i<19; i++) {

			int no =1;
			System.out.print((i+1)+".");
			System.out.println(vo.get(i).getCb_Question());
			String bogi[] = vo.get(i).getCb_bogi().split("/");
			Collections.shuffle(Arrays.asList(bogi));
			System.out.println();
			for(String s:bogi) {
				System.out.println((no++)+"."+s);
			}
			System.out.println();
		for(int j =0; j<2; j++) {
			System.out.println("정답을 고르세요.");
			String strM = scan.nextLine();
			int intM = Integer.valueOf(strM);
			String strbogi = vo.get(i).getCb_answer();
			
			if(bogi[intM -1].equals(strbogi)) {
				System.out.println("정답입니다");
				answerList.add(i+1);
				score +=1;
				break;
			}else {
				System.out.println("오답입니다");
				if(j ==1) break;
				noList.add(i+1);
				System.out.println("한번 더 다시풀어보시겠습니까?");
				System.out.println();
				System.out.print("다시푼다 (0을입력) 넘어간다(Enter)");
				String strRet = scan.nextLine();
				if (strRet.equals("0")) {
		    	}else {
		    		break;
		    	}
				
				
				
				
		}
			
				
		}
			
			
		
	
		
		if ((i+1) % 5 == 0) {
			System.out.print("정답 문항 : ");
			for (int yes : answerList) {
				System.out.print(yes + ", ");
			}
			answerList.clear();
			System.out.println("총점 :"+(score*5));
			
			System.out.print("오답 문항 : ");
			for (int no1 : noList) {
				System.out.print(no1 + ", ");
				
			}
			noList.clear();
			System.out.println();
			

		}
		System.out.println();
		System.out.println("다음문제를푸시려면 Enter 그만두려면 0을 입력하세요");
		String Stop = scan.nextLine();
		if (Stop.equals("0")) {
			System.out.println("종료합니다");
			
			System.out.println("총점수 :" + (score*5));
			System.out.println("맞은 문항" + answerList);
			System.out.println("틀린 문항" + noList);
			return;
			
		}
		
}
		

	
	
//	public void inserttext() {
//		
//		String file="src/main/java/com/biz/MavenCBT/service/question2.txt";
//		
//		FileReader fr;
//		BufferedReader br;
//		
//		List<CBTVO> insertList=new ArrayList();
//		
//		try {
//			fr=new FileReader(file);
//			br=new BufferedReader(fr);
//			while(true) {
//				String reader=buffer.readLine();
//				if(reader==null) break;
//				String[] bogi=reader.split(":");
//				CBTVO vo=new CBTVO();
//				vo.setCb_Question(bogi[0]);
//				vo.setCb_bogi(bogi[1]);
//				vo.setCb_answer(bogi[2]);
//				insertList.add(vo);
//			}
//			br.close();
//			fr.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		for(CBTVO v:insertList) {
//			factory.insert(v);
//		}
//	}
		
}
	}

