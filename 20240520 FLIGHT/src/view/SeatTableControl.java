package view;

import java.util.Scanner;

public class SeatTableControl {
    private static final int ROWS = 9; // 좌석의 행 수
    private static final int COLUMNS = 6; // 좌석의 열 수
    private static char[][] seats = new char[ROWS][COLUMNS]; // 좌석 배열

    public static void main(String[] args) {
        runSeatTableControl(); // SeatTableControl 실행
    }

    public static void runSeatTableControl() {
        initializeSeats(); // 좌석 초기화
        displaySeats(); // 좌석 배치도 출력

        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.print("예약할 좌석을 선택하세요 (예 : 003B) 또는 'exit' 입력: ");
//            String input = scanner.nextLine();
//            if (input.equalsIgnoreCase("exit")) {
//                break;
//            }
//
//            if (reserveSeat(input)) {
//                displaySeats(); // 좌석 배치도 다시 출력
//            } else {
//                System.out.println("잘못된 좌석 번호이거나 이미 예약된 좌석입니다. 다시 시도해주세요.");
//            }
//        }
//        scanner.close();
    }

    private static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = '□'; // O는 예약 가능한 좌석을 의미
            }
        }
    }

    private static void displaySeats() {
        System.out.println("   A B C   D E F");
        for (int i = 0; i < ROWS; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + " ");
                if (j == 2) { // 열 C 뒤에 공백 추가
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static boolean reserveSeat(String seat) {
        if (seat.length() != 2) {
            return false;
        }

        int row = seat.charAt(0) - '1';
        int column = seat.charAt(1) - 'A';

        if (row < 0 || row >= ROWS || column < 0 || column >= COLUMNS || seats[row][column] == '■') {
            return false;
        }

        seats[row][column] = '■'; // ■는 예약된 좌석을 의미
        return true;
    }
}
