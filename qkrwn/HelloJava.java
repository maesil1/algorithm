import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		
		System.out.print("예매할 최대 인원 수를 입력하세요 : ");
		int number = s.nextInt();
		int totalpayment = 0;
		//1번째 관란객
		for (int i=1; i<4; i++) {
			System.out.println("\n====["+ i + "번째 관람객] 예매 시작====");
			
			// 예매 여부
			System.out.print("예매를 계속하시겠습니까? (Y/N) : ");
			char ticket = s.next().charAt(0);
			if (ticket == 'N' || ticket == 'n') {
				System.out.println("예매를 중단합니다.");
				break;
			}
			
			//좌석 종류
			System.out.print("좌석 종류 (1: 일반석, 2:프리미엄석, 3: VIP석) : ");
			int seattype = s.nextInt();
			//나이 
			System.out.print("관람객 나이 : ");
			int age = s.nextInt();
			//장애인 또는 국가 유공자 여부 확인
			System.out.print("장애인 / 국가 유공자 여부 (Y/N) : ");
			char specialDiscount = s.next().charAt(0);
			//상영 요일 입력
			System.out.print("상영 요일 (1:월 ~ 7:일) : ");
			int dayofweek = s.nextInt();
			//상영 시간 입력 (24시간 형식)
			System.out.print("상영 시간 (24시간 형식) : ");
			int showtime = s.nextInt();
			//좌석 유형 선택
			System.out.print("좌석 유형(1 : 일반, 2 : 커플) : ");
			int seatcategory = s.nextInt();
			//기본 티켓 가격 설정
			int ticketprice = 0;
			switch (seattype) {
			case 1:
				ticketprice = 10000;
				break;
			case 2:
				ticketprice = 15000;
				break;
			case 3:
				ticketprice = 20000;
				break;
			default:
				System.out.println("잘못된 좌석 선택입니다.");
				s.close();
				return;
			}
			//연령별 할인 적용
			if(age <= 12) {
				ticketprice *= 0.7; // 30% 할인
			} else if (age <= 18) {
				ticketprice *= 0.9; // 10% 할인
			} else if (age >= 65) {
				ticketprice *= 0.5; // 50% 할인				
			}
			//장애인 및 국가 유공자 할인 적용		
			if (specialDiscount == 'Y' || specialDiscount == 'y') {
				ticketprice *= 0.8; // 20% 할인
			}
			
			//주말 및 공휴일 추가 요금 적용
			if (dayofweek ==  6 || dayofweek == 7) {
				ticketprice *= 1.1; //10% 추가 요금
				}
			//좌석 유형 추가 요금 적용
			if (seatcategory == 2) {
				ticketprice *= 1.15; //커플 좌석 15% 추가 요금
			}
			//상영 시간 할인 적용
			if (showtime >= 6 && showtime < 12) {
				ticketprice *= 0.75; // 조조 할인 25%
				} else if (showtime >= 23) {
					ticketprice *= 0.8; // 심야 할인 20%
				}
		System.out.printf(">> [" + i + "번째 관람객] 최종 티켓 가격 : %,d원\n", ticketprice);
		totalpayment += ticketprice;
		
	}
		System.out.println("\n==========================");
		System.out.printf("총 결제 금액 : %,d원", totalpayment);
		
		
		s.close();
	}
	
}
