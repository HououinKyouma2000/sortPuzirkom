import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int a;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    count++;
                    a = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = a;
                }


                /*v1 bestVersion
                if (arr[j] > arr[n - i - 1]) {


                     count++;
                    a = arr[j];
                    arr[j] = arr[n - i - 1];
                    arr[n - i - 1] = a;
                }*/
            }
        }
        //for (int i = 0; i < n; i++)
        //    System.out.println(arr[i]);
        System.out.println(count);
    }
}
