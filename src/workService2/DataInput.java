package workService2;

import java.util.Scanner;

public class DataInput {

    private static final Scanner scannerString = new Scanner(System.in);
    private static final Scanner scannerInt = new Scanner(System.in);

    public static String stringDataInPut() {
        return scannerString.nextLine();
    }

    public static int intDataInPut(){
        return scannerInt.nextInt();
    }
}
