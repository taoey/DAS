package tujia.P3;

import java.util.Scanner;

/**
 * Created by tao on 2018/9/10.
 */


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int i=0;i<count;i++) {
            int sum = in.nextInt();
            int max = in.nextInt();
            if (sum % (max + 1) == 0) {
                System.out.println("B");
            } else {
                System.out.println("A");
            }
        }
    }
}