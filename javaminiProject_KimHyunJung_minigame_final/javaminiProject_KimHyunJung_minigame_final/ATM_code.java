package javaminiProject_KimHyunJung_minigame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ATM_code {
	private static double sum =0;
	private static int life ;
	private static String name;
	private static Random random = new Random();
	private Scanner sc = new Scanner(System.in); 
	private List<String> deck;
    private List<String> playerHand;
    private List<String> dealerHand;
	private Casino cs = new Casino();
	public ATM_code() {
		cs = new Casino() ;
		sum = cs.getcharge();
		life = cs.getLife();
		name = cs.getname();
		deck = new ArrayList<>();
	    playerHand = new ArrayList<>();
	    dealerHand = new ArrayList<>();
	    initializeDeck();
	    shuffleDeck();
	}
	public int inputval() {
		Scanner sc = new Scanner(System.in);
		 System.out.println("1.빚 갚기");
		 System.out.println("2.노동임금입금");
		 System.out.println("3.현잔액"); 
		 System.out.println("4.카지노"); 
		 System.out.println("5.나가기");
		 System.out.print("입력:");
		int input = sc.nextInt();
		return input;
		}
	public void outputCharge( ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("빚을 얼마나 갚으시겠습니까?");
		int minus = sc.nextInt();
		if(minus>sum) {
			System.out.println(name + "님 ,현 잔액보다 많은 금액을 입금하셨군요. 불가능합니다.");
			return;
		}
		sum = sum - minus;
		System.out.println(name + "님의 현 잔액은" + sum + "입니다.");
	}
	public void inputCharge() {
		Scanner sc = new Scanner(System.in);
		System.out.println("얼마를 입금하시겠습니까?");
		int money = sc.nextInt();
		if(money > 20000 ) {
			System.out.print(name + "님 일당은 최대 20000원 이하입니다!! 초과되어 입금이 불가능합니다.");
		}else {
			sum += money; 
		}
		
	}
	public void now() {
		System.out.println(name + "님 현재 있는 잔액은 "+ sum + "입니다.");
	}
	public int Casinogame() {		
			Scanner sc = new Scanner(System.in);
			System.out.println("1.사다리"); 
			System.out.println("2.주사위게임"); 
			System.out.println("3.블랙잭"); 
			System.out.println("4.러시안 룰렛"); 
			System.out.println("5.나가기"); 
			System.out.print("Press Button :");
			int collect = sc.nextInt();
			return collect;
			}			
	public void ledder() {
    int[] ladder = {1, 2, 3, 4}; 
        
        Random random = new Random();
        int winningNumber = ladder[random.nextInt(ladder.length)]; 
        
        System.out.println("사다리 게임에 오신 것을 환영합니다!");
        System.out.print("1부터 4까지의 숫자 중 하나를 선택하세요: ");
        
        Scanner sc = new Scanner(System.in);
        int chosenNumber = sc.nextInt(); 
        
        System.out.println("사다리를 올라갑니다..!!!!!");
        
        if (chosenNumber == winningNumber) {
            System.out.println("축하합니다! 당첨되었습니다! 배당금을 받아가세요!:" + sum*1.5);
            sum = sum*1.5;
        } else {
            System.out.println("아쉽지만 당첨되지 않았습니다. 다음 기회에 도전해보세요!");
            System.out.println("당첨 번호: " + winningNumber);
        }
    }

	
		public void diceGame() {
		    System.out.println("주사위 게임에 오신 것을 환영합니다!");

		    int playerScore = rollDice();
		    int computerScore = rollDice();

		    System.out.println(name + "님의 주사위: " + playerScore);
		    System.out.println("컴퓨터의 주사위: " + computerScore);
		    
		    if (playerScore > computerScore) {
		        System.out.println("축하합니다! 당신이 이겼습니다!" +  sum*1.5);
		        sum =  sum*1.5;} else if (playerScore < computerScore) {
		        System.out.println("안됐네요, 당신이 졌습니다.");
		    } else {
		        System.out.println("동점입니다!!");
		    }
		   
		}

		private int rollDice() {
		    Random random = new Random();
		    return random.nextInt(6) + 1;
		}
		
				
		public void blackjack() {
	        dealInitialCards();
	        
	        System.out.println("당신의 패: " + playerHand);
	        System.out.println("딜러의패: " + dealerHand.get(0) + " [Hidden]");
	        
	        if (isBlackjack(playerHand)) {
	            System.out.println("블랙잭! 당신이 이겼습니다.현 잔액:" + sum*2);
	            sum = sum*2;
	            return;
	        }
	        
	        if (isBlackjack(dealerHand)) {
	            System.out.println("딜러의 블랙잭! 딜러가 이겼습니다.");
	            return;
	        }
	        
	        while (true) {
	            String choice = getPlayerChoice();
	            
	            if (choice.equalsIgnoreCase("h")) {
	                playerHand.add(dealCard());
	                System.out.println("당신의 패  " + playerHand);
	                
	                if (isBust(playerHand)) {
	                    System.out.println("버스트!!! 딜러가 이겼습니다.");
	                    return;
	                }
	            } else if (choice.equalsIgnoreCase("s")) {
	                break;
	            } else {
	                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요!");
	            }
	        }
	        
	        System.out.println("딜러의 패: " + dealerHand);
	        
	        while (calculateHandValue(dealerHand) < 17) {
	            dealerHand.add(dealCard());
	            System.out.println("딜러 히트: " + dealerHand.get(dealerHand.size() - 1));
	            
	            if (isBust(dealerHand)) {
	                System.out.println("딜러 버스트!!! 당신이 이겼습니다.");
	                return;
	            }
	        }
	        
	        System.out.println("딜러 스탠드");
	        
	        int playerValue = calculateHandValue(playerHand);
	        int dealerValue = calculateHandValue(dealerHand);
	        
	        if (playerValue > dealerValue) {
	            System.out.println("당신이 이겼습니다! 현 잔액:"+ sum*2);
	            sum = sum*2;
	        } else if (playerValue < dealerValue) {
	            System.out.println("딜러 승리!");
	        } else {
	            System.out.println("무승부 입니다 !!");
	        }
	    }
	    
	    private void initializeDeck() {
	        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	        
	        for (String suit : suits) {
	            for (String rank : ranks) {
	                deck.add(rank + " 의 " + suit);
	            }
	        }
	    }
	    
	    private void shuffleDeck() {
	        Random random = new Random();
	        
	        for (int i = 0; i < deck.size(); i++) {
	            int j = random.nextInt(deck.size());
	            String temp = deck.get(i);
	            deck.set(i, deck.get(j));
	            deck.set(j, temp);
	        }
	    }
	    
	    private void dealInitialCards() {
	        playerHand.add(dealCard());
	        dealerHand.add(dealCard());
	        playerHand.add(dealCard());
	        dealerHand.add(dealCard());
	    }
	    
	    private String dealCard() {
	        return deck.remove(0);
	    }
	    
	    private int calculateHandValue(List<String> hand) {
	        int value = 0;
	        int numAces = 0;
	        
	        for (String card : hand) {
	            String rank = card.split(" ")[0];
	            
	            if (rank.equals("Ace")) {
	                value += 11;
	                numAces++;
	            } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
	                value += 10;
	            } else {
	                value += Integer.parseInt(rank);
	            }
	        }
	        
	        while (value > 21 && numAces > 0) {
	            value -= 10;
	            numAces--;
	        }
	        
	        return value;
	    }
	    
	    private boolean isBlackjack(List<String> hand) {
	        return hand.size() == 2 && calculateHandValue(hand) == 21;
	    }
	    
	    private boolean isBust(List<String> hand) {
	        return calculateHandValue(hand) > 21;
	    }
	    
	    private String getPlayerChoice() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("히트 하시겠습니까? 아니면 스탠드 하시겠습니까?  ");
	        return scanner.nextLine();
	    }
	    
	    	   

	    public void RussianRoulette() {
	        System.out.println("러시안 룰렛에 오신 것을 환영합니다!");
	        int numChambers = 6; 
	        int bulletPosition = random.nextInt(numChambers); 
	        System.out.println("실행할 횟수를 입력하세요 (1 이상의 정수):");
	        int numAttempts = sc.nextInt();

	        boolean survived = true;

	        for (int i = 1; i <= numAttempts; i++) {
	            System.out.println(i + "번째 시도: 방아쇠를 당기세요! (1 ~ " + numChambers + ")");
	            int selectedChb = sc.nextInt();

	            if (selectedChb == bulletPosition) {
	                survived = false;
	                break;
	            } else {
	                System.out.println("살아있습니다. 계속 진행하세요.");
	            }
	        }

	        if (survived) {
	            System.out.println("축하합니다! 생존하셨습니다." +sum * 4);
	            sum = sum*4;
	        } else {
	        	sum =0;
	        	life = 0;
	            System.out.println("아쉽게도 총알이 발사되었습니다. 게임 오버입니다. 총 잔액 :" + sum + name + "님의 생명:"+life);
	        }
	    }
}	

	
	
	

