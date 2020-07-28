import java.util.*;
import java.util.Scanner;

public class LArgetNuminArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.next()); // Number of test cases

        while(t-->0) {

            int n = Integer.parseInt(scanner.next());
            int i = 0;

            ArrayList<String> numbers = new ArrayList<>();

            for(i=0; i<n;i++) {
                numbers.add(String.valueOf(scanner.next()));
            }

            Collections.sort(numbers, (a, b) -> -Integer.compare(Integer.parseInt(a+b), Integer.parseInt(b+a)));

            // This lamba is equivalent to

//            Collections.sort(numbers, new Comparator<String>() {
//
//                @Override
//                public int compare(String a, String b) {
//                    return -Integer.compare(Integer.parseInt(a+b), Integer.parseInt(b+a));
//                }
//            });


            for(i=0; i<n;i++) {
                System.out.print(numbers.get(i));
            }

            System.out.println();
        }
    }
}
