package javaminiProject_KimHyunJung_minigame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        ATM_code at = new ATM_code();
        showMainMenu(at);
      
    }

    private static void showMainMenu(ATM_code at) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int val = at.inputval();
            switch (val) {
                case 1:
                    at.outputCharge();
                    break;
                case 2:
                    at.inputCharge();
                    break;
                case 3:
                    at.now();
                    break;
                case 4:
                    showCasinoMenu(at);
                    break;
                case 5:
                    showGoodByte();
                    return;
                default:
                    printException();
                    break;
            }
        }
    }

    private static void showCasinoMenu(ATM_code at) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int col = at.Casinogame();
            switch (col) {
                case 1:
                    at.ledder();
                    break;
                case 2:
                	at.diceGame();
                    break;
                case 3: 
                	at.blackjack();
                	break;
                case 4:
                    at.RussianRoulette();
                    break;
                case 5:
                    showGoodByte();
                    return;
                default:
                    printException();
                    break;
            }
        }
    }

    private static void printException() {
        System.out.print("잘못 입력 하였습니다.");
    }

    private static void showGoodByte() {
        System.out.print("프로그램 종료.");
    }
}
