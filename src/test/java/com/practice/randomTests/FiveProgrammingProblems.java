package com.practice.randomTests;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by rbarthel on 9/18/16.
 */
public class FiveProgrammingProblems {

    @Test
    public void testForLoop() {
        List<Integer> list = createLongList(100) ;
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        assertEquals(sum, 100);
    }

    @Test
    public void testWhileLoop() {
        List<Integer> list = createLongList(100) ;
        int sum = 0;
        int count = 0;
        while (count < list.size()) {
            sum+= list.get(count);
            count++;
        }
        assertEquals(sum, 100);
    }

    @Test
    public void testRecursion() {
        List<Integer> list = createLongList(102) ;
        assertEquals(createSum(list, 0, 0), 102);
    }

    @Test
    public void testListMerge() {
        List<String> one = Arrays.asList("1","2","3");
        List<String> two = Arrays.asList("a","b","c","d","e");
        assertEquals(mergeTwoLists(one,two), Arrays.asList("1","a", "2", "b", "3","c","d","e"));
    }

    @Test
    public void testFib() {
        int fibNum = 10;
        BigDecimal[] fibs = new BigDecimal[fibNum+1];
        List<BigDecimal> record = new ArrayList<>();
        System.out.println(fib(fibs,BigDecimal.valueOf(fibNum), record)) ;
        for (BigDecimal bd : record) {
            System.out.println(bd.toPlainString());
        }
    }

    private int createSum(List<Integer> list, int index, int sum) {
        if (index == list.size()-1) {
            return list.get(index) + sum;
        }
        sum += list.get(index);
        return createSum(list, index + 1, sum);
    }

    private List<String> mergeTwoLists(List<String> one, List<String> two) {
        List<String> retval = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        int max = one.size() + two.size();
        for (int i = 0; i < max; i++) {
            if (index1 >= one.size()) {
                retval.add(two.get(index2));
                index2++;
                continue;
            }
            if (index2 >= two.size()) {
                retval.add(one.get(index1));
                index1++;
                continue;
            }
            if (index1 == index2) {
                retval.add(one.get(index1));
                index1++;
            } else {
                retval.add(two.get(index2));
                index2++;

            }
        }

        return retval;
    }

    private BigDecimal fib(BigDecimal[] fibs, BigDecimal i, List<BigDecimal> rec) {
        if (i.equals(BigDecimal.ZERO)) {
            rec.add(BigDecimal.ZERO);
            return BigDecimal.ZERO;
        }
        if (i.equals(BigDecimal.ONE)){
            rec.add(BigDecimal.ONE);
            return BigDecimal.ONE;
        }
        if (fibs[i.intValue()] != null) {
            rec.add(fibs[i.intValue()]);
            return fibs[i.intValue()];
        }
        fibs[i.intValue()] = fib(fibs, i.subtract(BigDecimal.ONE), rec).add(fib(fibs, i.subtract(BigDecimal.valueOf(2)), rec));
        return fibs[i.intValue()];


    }

    private List<Integer> createLongList(int totalSum) {
        List<Integer> retval = new ArrayList<>();
        int runningTotal = totalSum;
        for (int i = 0; i < 20; i++) {
            if (runningTotal < 5) {
                retval.add(runningTotal);
                runningTotal = 0;
                break;
            } else {
                if (runningTotal % 3 == 0) {
                    runningTotal -= 4;
                    retval.add(4);
                } else if (runningTotal % 2 == 0) {
                    runningTotal -= 3;
                    retval.add(3);
                } else {
                    runningTotal -= 2;
                    retval.add(2);
                }
            }
        }
        if (runningTotal != 0) {
            retval.add(runningTotal);
        }
        return retval;
    }

    @Test
    public void testGetLargestNumber() {
        List<Integer> list = Arrays.asList(50, 9,2,1);
        assertEquals(getLargestPossibleNumber(list), 95021);
    }

    private int getLargestPossibleNumber(List<Integer> input) {
        Deque<Integer> stack = new ArrayDeque<>() ;
        for (int i = 0; i < input.size(); i++) {
            String num = "";
            if (i == 0) {
                for (Integer n: input) {
                    num += n.toString();
                }
                stack.push(Integer.valueOf(num));
                System.out.println("count == 0 number:" +  Integer.valueOf(num));
            } else {
                for (int j = i; j< input.size(); j++) {

                    num += input.get(j).toString();
                    System.out.println("number: " +  Integer.valueOf(num) + " i == " + i + " j == " + j );
                }

                for (int k = 0 ; k<i; k++) {
                    num+= input.get(k).toString();
                    System.out.println("number: " +  Integer.valueOf(num) + " i == " + i + " k == " + k );
                }
                if (Integer.valueOf(num) > stack.peek()) {
                    stack.push(Integer.valueOf(num));
                }
            }

        }
        return stack.pop();
    }

    @Test
    public void testAngles() {
        System.out.println(getAngle(15, 3));
        System.out.println(getAngle(47, 6));
        System.out.println(getAngle(15, 9));
        System.out.println(getAngle(30, 9));
        System.out.println(getAngle(02, 11));
    }

    public static void main(String[] args) {
        for (int i=1;i<=100;i++) {
            if (i%15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }


    private double getAngle(double minute, double hour) {
        double degreePerMinute = 6;
        double degreePerHour = 30;

        double minuteHand = degreePerMinute * minute;
        double hourHand = ((minuteHand % 5)/5) *degreePerHour + hour * degreePerHour;
        return Math.abs(hourHand - minuteHand);
    }

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        System.out.println("l: " + l + " number: " + number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
    @Test
    public void testRomanConversion() {

        for (int i = 1; i<= 100; i++) {
            System.out.println(i+"\t =\t "+toRoman(i));
        }

    }

}
