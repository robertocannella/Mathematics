package com.robertocannella;

import java.math.BigInteger;
import java.util.*;

public class EasyMath {

    public static long binaryCounter(int countTo, int X){
        String number = "4";
        String[] splitFours;


        int start = 0;
        while (start < countTo) {
            System.out.println(number);
            BigInteger bigInteger = new BigInteger(number);
            if (bigInteger.mod(new BigInteger(String.valueOf(X))).equals(BigInteger.ZERO)){
                System.out.println("MATCH MATCH");
                System.out.println(bigInteger.divide(new BigInteger(String.valueOf(X))));
                break;
            }
            splitFours = number.split("0");
            char[] countFours = splitFours[0].toCharArray();

            int length = number.length();
            int totalFours = countFours.length;
            number = "";


            if (totalFours == length){
                number = "4";
                for (int i = 0; i < length; i++) {
                    number = number.concat("0");
                }
                continue;
            }


            if (totalFours < length){
                int zerosToAdd = length - (totalFours +1 );
                for (int i = 0; i <= totalFours; i++) {
                    number = number.concat("4");
                }
                for (int i = 0; i < zerosToAdd; i++) {
                    number = number.concat("0");
                }
            }

            //chars = number.toCharArray();
            //zeros = number.split("4");
            //System.out.println(zeros[zeros.length-1]);
//            System.out.println(Arrays.toString(splitFours));
//            System.out.println(number.length());
//            System.out.println(number);
//            System.out.println(countFours.length);
            start++;
        }
        return  Long.parseLong(number);

    }
    public static int solve(int x) {

        int[] results = {0,0};
        long ans = 4;
        int i =1;
        String binS;

        while(i < x){
            binS = Long.toBinaryString(i);
            //System.out.println("binary string: " + binS);
            long bin = Long.parseLong(binS);
            ans = 4 * bin;
            if (x%4 == 0) {
                // check sequence is correct
                // and return int[numberOf4s, numberOf0s]
                System.out.println(ans);

                results = hasRepeatingElement(ans);
                //System.out.println(Arrays.toString(results));
                if (results[1] == -1) {
                    i++;
                    continue;
                }
                break;
            }
            i++;
        }
        // challang asks us to return the sum of the array * 2
        // 2* a+b
        System.out.println(ans);
        System.out.println(Arrays.toString(results));
        if (results[1] == -1)
            return 0;
        else
            return (2 * results[0])+results[1];
    }
    public static int[] hasRepeatingElement( long number){
        int[] results = {0,0};
        long remainder;
        while (number != 0){
            remainder = number%10;
            number = number/10;
            if (remainder == 4)
                results[0]++;
            if (remainder == 0 && results[0] > 0) { // check if we already have a 4 in the number
                results[1] = -1;   // flag the array for validity
                return results;
            }
            if (remainder == 0 )
                results[1]++;

        }
        return results;
    }




    private List<Integer> validList = new ArrayList<>();
    private HashMap<Integer,Integer> map = new HashMap<>();
    private int a;
    private int b;

    public EasyMath(int a, int b) {
        this.a =a;
        this.b =b;
        validList.add(a);
        validList.add(b);
        map.put(a,0);
        map.put(b,0);
    }
    // Charlie and Johnny play a game.  For every integer X Charlie gives,
    // Johnny has to find the smallest positive integer Y, such that X*Y contains
    // only 4's and 0's and starts with one or more 4's followed by zero or more 0's
    //  i.e. 404 is an invalid number but 400 is a valid number

    // possible other valid numbers:
    // 4, 40, 44, 400, 440, 444, 4000, 4400, 4440, 4444, 40000, 44000,

    // if a is the number of 4's and b is the number of 0's, can you
    // print the value of (2*a)+b.

    // Input format:
    // The first line contains and integer T. (total)  T lines follow, each line
    // containing the integer X as stated above.

    // Output format:
    // For every X, print the output (2*a)+b in a new line as stated in the problem statement

    // constraints
    //1<=T<=10^3
    //1<=X<=1-^4

    // Sample input
    // T:3
    // X:4
    // X:5
    // X:80

    // Sample output
    // (2*a) + b = 2  1*4=4 [(2*1) + 0 = 2
    // (2*a) + b = 3  8*5=40 [(2*1) + 1) = 3
    // (2*a) + b = 4  5*80=400  [(2*1) + 2) = 4


    // 457 % 10 = 7 // last number (remainder)
    // 457 /10 = 45 // first numbers
    // 45 % 10 = 5  // last number
    // 45 / 10 = 4  // first number
    // 4 % 10 = 4  // last number
    // 4 / 10 = 0 //

    public int foursGame(int number){

        var i = 1;
        var result = i * number;
        var isValid = isValid(result);

        while (!isValid){
            isValid = isValid(number * ++i);
        }
        System.out.println(i);

        System.out.println(i*number);
        System.out.println(countFoursAndZeros(i*number));
        System.out.println(calculateResult());
        return i;
    }

    private int calculateResult(){
        // 2*a + b  // a is number of 4's  || b is number of 0's
        return (2 * map.get(this.b)+map.get(this.a));
    }
    private boolean zeroOrFour(int number){
        return validList.contains(number % 10);
    }
    private HashMap<Integer,Integer> countFoursAndZeros(int number){
        var zeroOrFour = 0;
        while(number != 0){
            zeroOrFour = number%10;
                map.put(zeroOrFour,map.get(zeroOrFour)+1);
            number = number/10;
        }
        return map;
    }

    private boolean isValid(int number){
        System.out.println(number);
        var zeroOrFour = 0;
        var temp = 0;
        while(number !=0 ){
            temp = zeroOrFour;

            zeroOrFour = number%10;
            if (!validList.contains(zeroOrFour))  // TODO: reverse this check //  check against invalid numbers
                return false;
            if (temp > zeroOrFour)  // 0 Precedes a 4
                return false;

            number = number / 10;
            System.out.println(number);
        }

        return  true;
    }


}
