import java.util.Scanner;

public class Cinema {

    public static void showSeats(char arr[][]) {
        System.out.println("Cinema:");
        System.out.print("  ");
        int numRows = arr.length;
        int numSeats = arr[0].length;
        for (int j=1; j <= numSeats; j++) {
            System.out.print(j + " ");

        }
        System.out.println();
        for (int i=0; i < numRows; i++) {
            System.out.print(i + 1 + " ");
            for (int j=0; j < numSeats; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void buyTicket(char arr[][]) {
        boolean flag2 = true;
        while (flag2) {
            Scanner scanner= new Scanner (System.in);
            System.out.println("Enter a row number:");
            int rowNum = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNum = scanner.nextInt();

            int numRows = arr.length;
            int numSeats = arr[0].length;

            if (rowNum > numRows || seatNum > numSeats) {
                System.out.println("Wrong input!");

            }
            else if (arr[rowNum - 1][seatNum - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
            } else {
                int num = numRows * numSeats;
                System.out.print("Ticket price: ");
                if(num <= 60){
                    System.out.println("$" + 10);
                } else {
                    if (numRows/2 >= rowNum) {
                        System.out.println("$" + 10);
                    } else {
                        System.out.println("$" + 8);
                    }
                }
                arr[rowNum - 1][seatNum - 1] = 'B';
                flag2 = false;
            }
        }
    }

    public static void statistics(char arr[][]) {
        int numRows = arr.length;
        int numSeats = arr[0].length;
        int numPurchasedTickets = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        for (int i=0; i < numRows; i++) {
            for (int j=0; j < numSeats; j++) {
                if (arr[i][j] == 'B') {
                    numPurchasedTickets++;
                    if (numRows * numSeats <= 60) {
                        currentIncome += 10;
                    } else {
                        if (numRows/2 > i) {
                            currentIncome += 10;
                        } else {
                            currentIncome += 8;
                        }
                    }
                }
            }
        }
        double percentage = (double)numPurchasedTickets / (numRows * numSeats) * 100;

        if (numRows * numSeats <= 60) {
            totalIncome = numRows * numSeats * 10;
        } else {
            totalIncome = (numRows / 2) * numSeats * 10 + (numRows * numSeats - (numRows / 2) * numSeats) * 8;
        }
        System.out.printf("Number of purchased tickets: %d%nPercentage: %.2f%%%nCurrent income: $%d%nTotal income: $%d\n\n",
                numPurchasedTickets, percentage, currentIncome, totalIncome);
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numSeats = scanner.nextInt();
        System.out.println();
        char[][] cinemaArr = new char[numRows][numSeats];

        for (int i=0; i < numRows; i++) {
            for (int j=0; j < numSeats; j++) {
                cinemaArr[i][j] = 'S';
            }

        }
        boolean flag = true;

        while(flag) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n){
                case 1:
                    Cinema.showSeats(cinemaArr);
                    break;
                case 2:
                    Cinema.buyTicket(cinemaArr);
                    break;
                case 3:
                    Cinema.statistics(cinemaArr);
                    break;
                case 0:
                    flag = false;
                    break;

            }
        }
    }
}
