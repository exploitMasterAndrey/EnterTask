package task2;

import java.util.ArrayList;
import java.util.Scanner;

public class task2 {
    public static ArrayList<Integer> getSimpleArr(int n)
    {
        ArrayList<Integer> simple = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean bool = true;
            int x = (int) Math.sqrt(i);
            for (int j = 2; j <= x; j++) {
                if ((i % j) == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool) simple.add(i);
        }
        return simple;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()) {
            int x = sc.nextInt();
            ArrayList<Integer> simple = getSimpleArr(x); //getting all simple numbers up to our number
            int it = 0;
            String res = "";
            while (x > 0 && it < simple.size())
            {
                if(x % simple.get(it) == 0)
                {
                    x = x / simple.get(it);
                    res += simple.get(it) + " ";
                }
                it++;
            }
            System.out.println("[result] " + res);
        }
        else
        {
            System.out.println("[error] unavailable input");
        }
    }
}
