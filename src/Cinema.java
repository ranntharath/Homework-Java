import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row=0, col=0, option, count=0;

        String[][] cinema = null;
        String[][] status = null;
        LocalDateTime[][] date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        do {
            System.out.println("===========================");
            System.out.println("|     cinema Booking      |");
            System.out.println("===========================");
            System.out.println("|    1. set up the hall   |");
            System.out.println("|    2. book the seat     |");
            System.out.println("|    3. Cancel the seat   |");
            System.out.println("|    4. View Hall         |");
            System.out.println("|    5. view history      |");
            System.out.println("|    6. Exit program      |");
            System.out.println("===========================");
            System.out.print("  Choose you option  : ");
            option = sc.nextInt();

            switch (option){
                case 1:{
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
                    cinema = new String[row][col];
                    status = new String[row][col];
                    date = new LocalDateTime[row][col];
                    char letter = 'A';
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            cinema[i][j] = letter + "-" + (j+1);
                            status[i][j] = "AV";
                        }
                        letter++;
                    }
                    break;
                }
                case 2:{
                    String seat;
                    System.out.println("==== [ Book the seat ] ====");
                    sc.nextLine();
                    outerLoop:
                    while (true){
                        System.out.print("Code seat sample ( A-1 ) : ");
                        seat = sc.nextLine();
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < col; j++) {
                                if (cinema[i][j].equals(seat) && status[i][j].equals("BO")){
                                    System.out.println("This seat already booked");
                                    continue outerLoop;
                                }else if(cinema[i][j].equals(seat) && status[i][j].equals("AV")){
                                    cinema[i][j] = seat;
                                    status[i][j] = "BO";
                                    count++;
                                    date[i][j] = LocalDateTime.now();
                                    System.out.println("Booked success on Seat : " + seat);
                                    break outerLoop;
                                }
                            }
                        }
                        System.out.println("Make sure you choose correct code seat");
                    }
                    break;
                }
                case 3:{
                    String cancelSeat;
                    boolean isCancel = false;
                    System.out.println("===== [ Cancel Seat ] =====");
                    System.out.print("Enter Seat to cancel : ");
                    sc.nextLine();
                    cancelSeat = sc.nextLine();
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if(cinema[i][j].equals(cancelSeat) && status[i][j].equals("BO")){
                                cinema[i][j] = cancelSeat;
                                status[i][j] = "AV";
                                System.out.println("Seat "+cancelSeat+ " Cancel success");
                                isCancel = true;
                            }else if (cinema[i][j].equals(cancelSeat) && status[i][j].equals("AV")){
                                System.out.println("This Seat never booked");
                            }
                        }
                    }
                    if (!isCancel) System.out.println("Can't cancel seat");
                    break;
                }
                case 4:{
                    System.out.println("===== [ View hall ] =====");
                    for (int i = 0; i < row; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < col; j++) {
                            System.out.print(cinema[i][j] + " : "+status[i][j]);
                            if (j < col - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println(" |");
                    }
                    break;
                }
                case 5:{
                    System.out.println("==== [ View Hall History ] ====");
                    if (count == 0){
                        System.out.println("Seat was not booked");
                    }else {
                        System.out.println(count+" Seat has booked");
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < col; j++) {
                                if (status[i][j].equals("BO")){
                                    System.out.println("Seat : "+cinema[i][j]+" Date of book :"+date[i][j].format(formatter)
                                    );
                                }
                            }
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Invalid option!!!"); break;
            }
        }while (option !=6);


    }
}
