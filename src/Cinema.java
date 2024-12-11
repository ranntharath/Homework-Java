import java.time.LocalDate;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row, col, option, count=0;
        System.out.println("====== [ Please set up the seat ] ======");
        while (true){
            System.out.print("  [+] Enter row : "); row = sc.nextInt();
            System.out.print("  [+] Enter column : "); col = sc.nextInt();
            if (row<=0 && col<=0){
                System.out.println("Row and Column must bigger than 0");
            }else {
                break;
            }
        }

        String[][] cinema = new String[row][col];
        char letter = 'A';
        for (int i = 0; i < row; i++) {
            System.out.print("| ");
            for (int j = 0; j < col; j++) {
                cinema[i][j] = letter + "-" + (j+1) +" : AV";
                System.out.print(cinema[i][j] + " ");
                if (j < col - 1) {
                    System.out.print(", ");
                }
            }
            letter++;
            System.out.println(" |");
        }

        do {
            System.out.println("===========================");
            System.out.println("|     cinema Booking      |");
            System.out.println("===========================");
            System.out.println("|    1. book the seat     |");
            System.out.println("|    2. Cancel the seat   |");
            System.out.println("|    3. view history      |");
            System.out.println("|    4. Exit program      |");
            System.out.println("===========================");
            System.out.print("  Choose you option  : ");
            option = sc.nextInt();

            switch (option){
                case 1:{
                    String seat;
                    System.out.println("==== [ Book the seat ] ====");
                    sc.nextLine();
                    outerLoop:
                    while (true){
                        System.out.print("Code seat sample ( A-1 ) : ");
                        seat = sc.nextLine();
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < col; j++) {
                                if (cinema[i][j].startsWith(seat) && cinema[i][j].endsWith("BO")){
                                    System.out.println("This seat already booked");
                                    continue outerLoop;
                                }else if(cinema[i][j].startsWith(seat) && cinema[i][j].endsWith("AV")){
                                    cinema[i][j] = seat + " : BO";
                                    count++;
                                    System.out.println("Booked success on Seat : " + seat);
                                    break outerLoop;
                                }
                            }
                        }
                        System.out.println("Make sure you choose correct code seat");
                    }
                    break;
                }
                case 2:{
                    String cancelSeat;
                    boolean isCancel = false;
                    System.out.println("===== [ Cancel Seat ] =====");
                    System.out.print("Enter Seat to cancel : ");
                    sc.nextLine();
                    cancelSeat = sc.nextLine();
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if(cinema[i][j].startsWith(cancelSeat) && cinema[i][j].endsWith("BO")){
                                cinema[i][j] = cancelSeat + " : AV";
                                System.out.println("Seat "+cancelSeat+ " Cancel success");
                                isCancel = true;
                            }else if (cinema[i][j].startsWith(cancelSeat) && cinema[i][j].endsWith("AV")){
                                System.out.println("This Seat never booked");
                            }
                        }
                    }

                    break;
                }
                case 3:{
                    for (int i = 0; i < cinema.length; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < col; j++) {
                            System.out.print(cinema[i][j] + " ");
                            if (j < col - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println(" |");
                    }
                    break;
                }
                default:
                    System.out.println("Invalid option!!!"); break;
            }
        }while (option !=5);


    }
}
