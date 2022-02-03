package task3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task3 {
    public static int getCount(String str)
    {
        Pattern glasn = Pattern.compile("(?iu)[aeiouyауоыиэяюёе]");
        Matcher m = glasn.matcher(str);
        int cnt = 0;
        while (m.find()) cnt++;
        return cnt;
    }
    public static void getCountArr(String[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print("[result 1] "); System.out.println(arr[i] + " - " + getCount(arr[i]));
        }
    }
    public static void getSortedStrings(String[] arr)
    {
        System.out.print("[result 2] initial array: "); System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new SortByCount());
        System.out.print("[result 2] sorted array: "); System.out.println(Arrays.toString(arr));
    }
    public static void makeFirstVocalBigger(String[] arr)
    {
        System.out.print("[result 3] initial array: "); System.out.println(Arrays.toString(arr));
        Pattern firstGlasn = Pattern.compile("(?u)^[aeiouyауоыиэяюёе]");
        for(int i = 0; i < arr.length; i++) {
            Matcher m = firstGlasn.matcher(arr[i]);
            if(m.find())
            {
                arr[i] = arr[i].substring(0,1).toUpperCase()+arr[i].substring(1);
            }
        }
        System.out.print("[result 3] final array: "); System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[input] ");
        String[] arr = sc.nextLine().split(" ");
        getCountArr(arr);
        getSortedStrings(arr);
        makeFirstVocalBigger(arr);
    }
}
