package ptj;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		VideoDaoImpl vd = VideoDaoImpl.getInstance();
		VideoReviewDaoImpl vr = VideoReviewDaoImpl.getInstance();
		MainUi main = new MainUi();
		SsafitUtil util = new SsafitUtil();
		int reviewsize=0;
		
		while(true) {
		main.service();
		int no1 = sc.nextInt();
		if(no1==1) {
			loop1:
			while(true) {
				for(Video i : vd.selectVideo()) {
					System.out.println(i.toString());
				}
				util.printLine();
				System.out.println("영상 번호를 입력하세요 : ");
				int no2 = sc.nextInt();
				while(true) {
					util.printLine();
					System.out.println("번호 :"+vd.selectVideoByNo(no2).getNo());
					System.out.println("제목 :"+vd.selectVideoByNo(no2).getTitle());
					System.out.println("운동 :"+vd.selectVideoByNo(no2).getPart());
					System.out.println("영상URL :"+vd.selectVideoByNo(no2).getUrl());
					util.printLine();
					if(vr.selectReview(no2) != null) {
						System.out.println("영상리뷰 : "+vr.selectReview(no2).size()+"개");
						reviewsize=vr.selectReview(no2).size();
					}else {
						System.out.print("영상리뷰 : 0개"+'\n');
					}
					util.printLine();
					if(vr.selectReview(no2) != null) {
						for(VideoReview j : vr.selectReview(no2)) {
							System.out.println(j);
					}
					}
					util.printLine();
					System.out.println("1. 리뷰등록");
					System.out.println("0. 이전으로");
					util.printLine();
					System.out.println("메뉴를 선택하세요 : ");
					int no3 = sc.nextInt();
					if(no3==0) {
						break;
					}
					else if(no3==1) {
						System.out.println("닉네임을 입력하세요 : ");
						String nickName = sc.next();
						System.out.println("내용을 입력하세요 : ");
						String content = sc.next();
						VideoReview review = new VideoReview(no2,reviewsize+1,nickName,content);
						vr.InsertReview(review);
						break loop1;
					}
					}
				}
			}
		else if(no1==2)
			main.exit();
		else
			System.out.println("보기에 없는 번호입니다. 프로그램을 다시 실행해주시기 바랍니다.");
		}
	}

}
