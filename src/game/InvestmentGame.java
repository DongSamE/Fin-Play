package game;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

import fin.FinService;

public class InvestmentGame {
	
	//콘솔 클리어
	public static void clearConsole() {
        System.out.print("\033[H\033[2J");System.out.flush();  
    }
	
	//원금 일천만원
	int money = 10000000;
	//보유 주식 어레이
	int[] stocks = {0,0,0,0,0,0,0,0,0,0};
	
	String[] stockName = {"퍼스트솔라","아마존","화이자","엔비디아","메타","테슬라","페이팔","스페이스X","알파벳","크라우드스트라이크"};
	/* 종목명과 ID
	 * 1.에너지 : 퍼스트솔라(재생에너지)
	 * 2.전자상거래플랫폼:아마존(전자상거래플랫폼)
	 * 3.바이오:화이자(바이오)
	 * 4.반도체:엔비디아(반도체)
	 * 5.메타버스:메타(메타버스)
	 * 6.전기차:테슬라(전기차)
	 * 7.핀테크:페이팔(핀테크)
	 * 8.우주:스페이스X(우주)
	 * 9.AI : 알파벳(AI)
	 * 10. 사이버보안: 크라우드스트라이크(보안)
	 */
	int[] highScore = {0,0,0};
	//주가 24-10-07 현재가
	int[][] price = {{1,311455},{2,251328},{3,38512},{4,168334},{5,803049},{6,336991},{7,106940},{8,269506},{9,227140},{10,393803}};
	//뉴스
	private String[][] news = {
						{"1","1","국제 사회, 탄소 배출 규제 강화로 재생 에너지 수요 급증","+"},
						{"2","1","태양광 및 풍력 발전 비용 감소, 그린 에너지 투자 확대 기대","+"},
						{"3","1","화석 연료 수급 안정화, 그린 에너지 경쟁력 감소 우려","-"},
						{"4","1","재생 에너지 프로젝트 허가 지연, 신재생 발전 시장 성장 둔화","-"},
						{"5","2","온라인 쇼핑 트렌드 가속화, 전자상거래 시장 성장 기대감 상승","+"},
						{"6","2","소비자 맞춤형 광고 강화, 전자상거래 기업 수익성 개선","+"},
						{"7","2","물류 대란 지속, 전자상거래 플랫폼 배송 지연으로 소비자 불만 고조","-"},
						{"9","2","소비자 경기 침체로 전자상거래 매출 감소 우려","-"},
						{"10","3","새로운 건강 이슈 확산, 백신 및 의약품 수요 증가","+"},
						{"11","3","의료 혁신에 대한 투자 증가, 생명과학 기술 성장 기대","+"},
						{"12","3","약가 인상 논란 및 규제 강화, 바이오 기업 수익성 저하","-"},
						{"13","3","임상 시험 결과 부진으로 주요 신약 출시 연기","-"},
						{"14","4","AI 기술 수요 급증, 반도체 산업 투자 증가 예상","+"},
						{"15","4","글로벌 데이터 센터 확장으로 반도체 수요 폭증","+"},
						{"16","4","반도체 공급망 차질, 주요 부품 부족으로 업계 타격","-"},
						{"17","4","미중 무역 긴장 심화, 반도체 산업 규제 강화 우려","-"},
						{"18","5","메타버스 채택 증가, 다양한 기업들이 가상 현실에 투자 확대","+"},
						{"19","5","가상 회의 및 원격 근무 확산으로 메타버스 수요 증가","+"},
						{"10","5","기술 혁신 속도 둔화와 규제 강화, 메타버스 성장 기대 감소","-"},
						{"20","5","개인 정보 보호 이슈로 메타버스 플랫폼 신뢰도 하락","-"},
						{"21","6","정부 보조금 확대와 환경 규제 강화로 전기차 시장 성장 촉진","+"},
						{"22","6","전기차 충전 인프라 확장, 수요 증가로 업계 활성화 기대","+"},
						{"23","6","배터리 원자재 가격 급등, 전기차 제조 비용 상승 우려","-"},
						{"24","6","전기차 관련 리콜 증가, 안전성 논란으로 신뢰도 하락","-"},
						{"25","7","디지털 금융 혁신 가속화, 핀테크 시장 점유율 확대","+"},
						{"26","7","암호화폐 거래 서비스 도입, 디지털 자산 접근성 향상","+"},
						{"27","7","금융 규제 강화로 핀테크 기업들 수익성 하락 가능성","-"},
						{"28","7","디지털 보안 위협 증가, 고객 신뢰 하락 우려","-"},
						{"29","8","우주 탐사 기술 발전으로 상업 우주 여행 시대 가시화","+"},
						{"30","8","위성 인터넷 프로젝트 성공, 글로벌 네트워크 확장","+"},
						{"31","8","국제 우주 규제 강화, 상업 우주 프로젝트 진입 장벽 증가","-"},
						{"32","8","로켓 발사 실패 및 재정 손실로 우주산업 불안감 고조","-"},
						{"33","9","AI 기술 상용화 가속화, 다양한 산업에 활용 확대","+"},
						{"34","9","AI 데이터 분석 서비스로 광고 매출 신기록 달성","+"},
						{"35","9","AI 윤리 및 개인정보 보호 문제로 규제 당국의 감시 강화","-"},
						{"36","9","자율 AI 오작동 사례 증가로 기술 신뢰도 하락","-"},
						{"37","10","사이버 공격 급증, 보안 솔루션 수요 증가로 성장세 기대","+"},
						{"38","10","글로벌 기업, 보안 강화에 대규모 투자 계획 발표","+"},
						{"39","10","해커 공격으로 데이터 유출 사건 발생, 사이버 보안 문제 심각성 대두","-"},
						{"40","10","보안 업계, 규제 강화로 운영 비용 증가 및 수익성 감소 우려","-"}
					  };
	String[][] preNews = new String[15][4];
	Random random = new Random();
	//게임시작 인트로
    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================모의투자게임======================");
        System.out.println("             [1] 게임 시작");
        System.out.println("             [2] 스코어보드 확인");
        System.out.println("             [3] 메인메뉴로 돌아가기");
        int choice = sc.nextInt();
        clearConsole();
        switch (choice) {
            case 1:
                newGame();
                break;
            case 2:
            	top3();
                break;
            case 3:
                System.out.println("...메인베뉴로 돌아갑니다...");
                
                break;
            default:
                System.out.println("올바른 메뉴를 선택해주세요");
                startGame();
        }
    }
    //게임진행
    private void newGame() {
        System.err.println("모의투자 게임을 시작합니다");
        Scanner sc = new Scanner(System.in);
        
        //턴 및 게임진행
    	// 턴
        int turn = 0;
        boolean ingame = true;
        while(turn < 15 && ingame) {
        	
        	
        	//의사결정 (구매, 현재 평가금 조회, 턴종료, 게임종료)
        	while (true) {
        		System.out.println("======================================================");
            	for(int i = 0 ; i < stockName.length; i++) {
            		System.out.println((i+1)+". "+stockName[i]+" :"+price[i][1]);
            	}System.out.println("======================================================");
            	
            	//매 턴 뉴스선정및 뉴스 어레이에 반영.
            	System.err.println("금주의 뉴스!");
            	int rn = random.nextInt(news.length) + 1;
            	//preNews안에 rn이 없을경우에 news[0][rn]뉴스가 금주의 뉴스로 선정
            	//previous[turn]에 rn이 저장되고 턴이 진행됨에 따라 previous[turn]에 없는 rn이 나와야만함.for 문에 if문 잘 섞어서 사용해야함
            	//뉴스 선정이 완료될 시 news[3]의 부호에 0~5 사이의 난수를 뽑아서 가걱을 증감함
            	boolean isDuplicate;
            	do {
                    // 0에서 뉴스의 길이 - 1 사이의 난수 생성
                    rn = random.nextInt(news.length);
                    isDuplicate = false;

                    // 이전 턴에서 선택된 뉴스 인덱스와 비교
                    for (int i = 0; i < turn; i++) {
                        if (Integer.parseInt(news[0][i]) == Integer.parseInt(news[rn][0])) { // 중복되는 뉴스 인덱스 발견
                            isDuplicate = true;
                            break; // 중복이면 루프 종료
                        }
                    }
                } while (isDuplicate); // 중복되지 않을 때까지 반복

                // 중복되지 않는 뉴스 인덱스가 선택되면 저장
            	preNews[turn][1] = news[rn][1];
            	preNews[turn][2] = news[rn][2];
            	preNews[turn][3] = news[rn][3];
            	preNews[turn][0] = news[rn][0];

                // 선택된 뉴스 출력
                System.out.println(preNews[turn][2]);
        	    System.err.println((turn+1)+"번쨰 턴");
        	    System.out.println("======================================================");
        	    System.out.println("현재 보유 주식 \n"+Arrays.toString(stocks));
        	    System.out.println("현재 보유 현금 : "+money);
        	    //현재 평가금
        	    System.out.println("총 평가금 : "+totalmoney(price,stocks,money));
        	    System.out.println(" [1] 구매  [2] 판매   [3] 턴종료  [4] 게임종료");

        	    String input = sc.next();
        	    switch (input) {
        	        //구매과정
        	    	case "1":
        	    		System.out.println("======================================================");
        	            System.out.println("현재 구매 가능 갯수");
        	            // 구매 가능한 주식이 있는지 확인하는 변수
        	            boolean canBuyAnyStock = false; 
        	            // 현재 구매 가능 갯수
        	            for (int i = 0; i < stockName.length; i++) {
        	                int purchasableQuantity = money / price[i][1];
        	                if (purchasableQuantity > 0) {
        	                    System.out.println(stockName[i] + " " + purchasableQuantity + "개");
        	                    // 구매 가능한 주식이 있다는 표시
        	                    canBuyAnyStock = true;
        	                }
        	            }
        	            
        	            // 구매 가능한 주식이 없는 경우 턴 종료
        	            if (!canBuyAnyStock) {
        	                System.out.println("구매 가능한 주식이 없습니다.");
        	                break; 
        	            }
        	            
        	            //
        	            for (int i = 0; i < stockName.length; i++) {
        	                System.out.println(stockName[i] + " " + (money / price[i][1]) + "개");
        	            }
        	            while (true) {
        	                System.out.println("어떤 주식을 구매하시겠습니까? :");
        	                String 구매 = sc.next();
        	                boolean validStock = false;

        	                for (int i = 0; i < stockName.length; i++) {
        	                    if (stockName[i].equals(구매)) {
        	                        validStock = true;
        	                        System.out.println("몇 주 구매하시겠습니까? :");
        	                        int 매입량 = sc.nextInt();
        	                        // 구매 성공 및 현재 평가금 보유 자산 출력 (구매 로직 추가)
        	                        money -= price[i][1]*매입량;
        	                        stocks[i] = 매입량;
        	                        System.out.println("구매에 성공했습니다!");
        	                        System.out.println("보유 현금 :"+ money);
        	                        System.out.println(Arrays.toString(stocks));
        	                        System.out.println("구매를 계속 진행할까요? (Y/N):");
        	                        String 연속의사 = sc.next();
        	                        if (연속의사.equalsIgnoreCase("Y")) {
        	                            System.out.println("구매를 계속합니다!");
        	                        } else if (연속의사.equalsIgnoreCase("N")) {
        	                            System.out.println("구매를 종료합니다!");
        	                            break;  // 내부 while 루프를 빠져나가며 switch 루프 계속
        	                        } else {
        	                            System.out.println("제대로 입력해주세요!");
        	                        }
        	                    }
        	                }
        	                
        	                // 주식명이 유효하지 않은 경우 처리
        	                if (!validStock) {
        	                    System.out.println("제대로 입력해주세요!");
        	                } else {
        	                    break; // 구매가 끝났으면 내부 while 루프 탈출
        	                }
        	            }
        	            break; // case 1을 끝내고 외부 while 반복문으로 돌아감
        	    	//판매
        	        case "2":
        	        	System.out.println("======================================================");
        	            System.out.println("현재 판매 가능 갯수");
        	            System.out.println(Arrays.toString(stocks));
        	            // 판매 가능한 주식이 없는 경우 턴 종료
        	            boolean canSellAnyStock = false; 
        	            // 현재 구매 가능 갯수
        	            for (int i = 0; i < stocks.length; i++) {
        	                if (stocks[i] > 0) {
        	                	canSellAnyStock = true;
        	                }
        	            }
        	            
        	            // 판매 가능한 주식이 없는 경우 턴 종료
        	            if (!canSellAnyStock) {
        	                System.out.println("판매 가능한 주식이 없습니다.");
        	                break; 
        	            }
        	            
        	            
        	            while (true) {
        	                System.out.println("어떤 주식을 판매하시겠습니까? :");
        	                String 판매 = sc.next();
        	                boolean validStock = false;

        	                for (int i = 0; i < stockName.length; i++) {
        	                    if (stockName[i].equals(판매)) {
        	                        validStock = true;
        	                        System.out.println("몇 주 판매하시겠습니까? :");
        	                        int 매도량 = sc.nextInt();
        	                        // 구매 성공 및 현재 평가금 보유 자산 출력 (구매 로직 추가)
        	                        money += price[i][1]*매도량;
        	                        stocks[i] -= 매도량;
        	                        if (매도량 > stocks[i]) {
        	                            System.out.println("보유한 주식보다 많이 판매할 수 없습니다.");
        	                        } else {
        	                        	System.out.println("판매에 성공했습니다!");
            	                        System.out.println("보유 현금 :"+ money);
            	                        System.out.println(Arrays.toString(stocks));
        	                        }
        	                        System.out.println("판매를 계속 진행할까요? (Y/N):");
        	                        String 연속의사 = sc.next();
        	                        if (연속의사.equalsIgnoreCase("Y")) {
        	                            System.out.println("판매를 계속합니다!");
        	                        } else if (연속의사.equalsIgnoreCase("N")) {
        	                            System.out.println("판매를 종료합니다!");
        	                            break;  // 내부 while 루프를 빠져나가며 switch 루프 계속
        	                        } else {
        	                            System.out.println("제대로 입력해주세요!");
        	                        }
        	                    }
        	                }
        	                
        	                // 주식명이 유효하지 않은 경우 처리
        	                if (!validStock) {
        	                    System.out.println("제대로 입력해주세요!");
        	                } else {
        	                    break; // 구매가 끝났으면 내부 while 루프 탈출
        	                }
        	            }
        	            break;
        	        //턴 종료 및 종가반영
        	        case "3":
        	        	//종가반영
        	        	//0~9까지 if  != rn걸어서 이번에 뉴스나온 주식 아니면, 0~5퍼 난수 가격증감
        	        	//or double난수 0.95~1.05 곱하고 다시 int화 하는법이 있음.
        	        	int stockIndex = Integer.parseInt(preNews[turn][1]) - 1; // 인덱스는 0부터 시작하므로 -1을 함
        	        	int current_news_stock_price = price[stockIndex][1];
        	            double newsranfac = 1 + (Math.random() * 0.04);
        	            if(preNews[turn][3].equals("+")){
        	            	current_news_stock_price = (int) (current_news_stock_price * newsranfac);
        	            }else {
        	            	current_news_stock_price = (int) (current_news_stock_price * newsranfac);
        	            }
        	            
        	        	System.out.println("턴을 종료합니다.");
        	            //news[turn]에따른 price를 저장해놓고 단체로 변경 한 후 따로 처리
        	            for (int i = 0; i < price.length; i++) {
        	                double randomFactor = 0.98 + (Math.random() * 0.04);  // 0.95 ~ 1.05 사이의 난수
        	                price[i][1] = (int) (price[i][1] * randomFactor);
        	            }
        	            
        	            price[Integer.parseInt(preNews[turn][1])-1][1]=current_news_stock_price;
        	            	turn++;
        	            break;
        	        //게임종료
        	        case "4":
        	            System.out.println("게임을 종료합니다.");
        	            ingame = false;
        	            break;

        	        default:
        	            System.out.println("올바른 옵션을 선택해주세요.");
        	            break;
        	    }

        	    // 게임 종료 조건 확인
        	    if (!ingame) {
        	        break;
        	    }
        	}
        	
        	
        	
        }
        
        //Top3 달성여부 조회 및 알림
        checktop3(totalmoney(price,stocks,money));
        //게임 종료 후 InvestGame의 Main UI로 이동
        startGame();
        
    }
    //스코어보드
    private void top3() {
        
    	System.out.println("스코어보드"
    			+ "\n======================================================");
    	for (int i = 0; i < highScore.length; i++) {
    	    System.out.println((i + 1) + ". " + highScore[i]);
    	}
        startGame();
    }
    
    private void checktop3(int a) {
        for(int i = 0; i < highScore.length; i++) {
        	if(highScore[i] < a) {
        		highScore[i] = a;
        		System.out.println("TOP3 달성에 성공!");
        		break;
        	}else {
        		System.out.println("TOP3 달성에 실패하셨습니다!");
        		break;
        	}
        }
        
    }
    
    private static int totalmoney(int[][] price ,int[] stock , int money) {
    	
    	for(int i = 0; i <stock.length ; i++) {
    		money += stock[i] * price[i][1];
    	}
    return money;
    }
}




