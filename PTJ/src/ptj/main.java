package ptj;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		VideoDaoImpl vd = VideoDaoImpl.getInstance();
		VideoReviewDaoImpl vr = VideoReviewDaoImpl.getInstance();
		MainUi main = new MainUi();
		SsafitUtil util = new SsafitUtil();
		
		main.service();
		int no1 = sc.nextInt();
		if(no1==1) {
			while(true) {
				for(Video i : vd.selectVideo()) {
					System.out.println(i.toString());
				}
				util.printLine();
				System.out.println("영상 번호를 입력하세요 : ");
				int no2 = sc.nextInt();
				util.printLine();
				System.out.println("번호 :"+vd.selectVideoByNo(no2).getNo());
				System.out.println("제목 :"+vd.selectVideoByNo(no2).getTitle());
				System.out.println("운동 :"+vd.selectVideoByNo(no2).getPart());
				System.out.println("영상URL :"+vd.selectVideoByNo(no2).getUrl());
				util.printLine();
				if(vr.selectReview(no2) != null) {
					System.out.println("영상리뷰 : "+vr.selectReview(no2).size()+"개");
				}else {
					System.out.print("영상리뷰 : 0개"+'\n');
				}
				util.printLine();
				util.printLine();
				System.out.println("1. 리뷰등록");
				System.out.println("0. 이전으로");
				util.printLine();
				System.out.println("메뉴를 선택하세요 : ");
				int no3 = sc.nextInt();
				if(no3==1)
					break;
			}
		}
		else if(no1==2)
			main.exit();
		else
			System.out.println("보기에 없는 번호입니다. 프로그램을 다시 실행해주시기 바랍니다.");
			
		
	}

}
