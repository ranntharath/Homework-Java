import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row, col, option;
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
            for (int j = 0; j < col; j++) {
                cinema[i][j] = letter + "-" + (j+1) +" : AV";
            }
            letter++;
        }
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(cinema[i][j]+ " , ");
            }
            System.out.println();
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
                    boolean isFound = false;
                    System.out.println("==== [ Book the seat ] ====");
                    System.out.print("please choose you seat (A-1) : ");
                    sc.nextLine();
                    seat = sc.nextLine();

                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if (cinema[i][j].startsWith(seat) && cinema[i][j].endsWith("AV")){
                                    cinema[i][j] = seat + " : BO";
                                    System.out.println("Booked success on Seat : " + seat);
                                    break;
                            }
                        }
                    }
                    if(!isFound) System.out.println("This seat already booked");
                    break;
                }
                case 2:{
                    System.out.println("===== [ Cancel Seat ] =====");
                    System.out.print("Enter Seat to cancel : ");
                    sc.nextLine();
                    String cancelSeat = sc.nextLine();
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if (cinema[i][j].startsWith(cancelSeat) && cinema[i][j].endsWith(" BO")){
                                cinema[i][j] = cancelSeat + " AV";
                            }
                        }
                    }
                    break;
                }
                case 3:{
                    for (int i = 0; i < cinema.length; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.print(cinema[i][j]+ " ");
                        }
                        System.out.println();
                    }
                    break;
                }
            }
        }while (option !=5);


    }
}
