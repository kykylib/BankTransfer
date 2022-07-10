package WorkService;

import java.util.Scanner;

public class DataInput {


    public static String stringDataInPut() {
        Scanner scanner = new Scanner(System.in);
        String dataInPut;
        dataInPut = scanner.nextLine();
        return dataInPut;
    }

    public static int intDataInPut(){
        Scanner scanner = new Scanner(System.in);
        int dataInPut;
        dataInPut = scanner.nextInt();
        return dataInPut;
    }


}
