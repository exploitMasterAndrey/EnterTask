package task1;

import java.text.NumberFormat;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(char c : str.toCharArray())
        {
            if(Character.isDigit(c))
                cnt += c - '0';
        }
        System.out.println("[result] " + cnt);
    }
}
