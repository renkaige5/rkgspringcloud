package com.rkg.entities;

import java.math.BigDecimal;
import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
       c();
    }


    public static void c(){
        int digits = 300000; // 计算1000位
        long begin = System.currentTimeMillis();
        String pi = computePi(digits).toString();
        long end = System.currentTimeMillis();
//        System.out.println(pi);
        System.out.println("计算圆周率后"+digits+"位,共耗时"+(end - begin) + "ms");
    }



    /** constants used in pi computation */
    private static final BigDecimal FOUR = BigDecimal.valueOf(4);

    /** rounding mode to use during pi computation */
    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;

    /**
     * Compute the value of pi to the specified number of digits after the
     * decimal point. The value is computed using Machin's formula:
     *
     * pi/4 = 4*arctan(1/5) - arctan(1/239)
     *
     * and a power series expansion of arctan(x) to sufficient precision.
     */
    public static BigDecimal computePi(int digits) {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).subtract(arctan1_239)
                .multiply(FOUR);
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Compute the value, in radians, of the arctangent of the inverse of the
     * supplied integer to the specified number of digits after the decimal
     * point. The value is computed using the power series expansion for the arc
     * tangent:
     *
     * arctan(x) = x - (x^3)/3 + (x^5)/5 - (x^7)/7 + (x^9)/9 ...
     */
    public static BigDecimal arctan(int inverseX, int scale) {
        BigDecimal result, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 = BigDecimal.valueOf(inverseX * inverseX);

        numer = BigDecimal.ONE.divide(invX, scale, roundingMode);

        result = numer;
        int i = 1;
        do {
            numer = numer.divide(invX2, scale, roundingMode);
            int denom = 2 * i + 1;
            term = numer.divide(BigDecimal.valueOf(denom), scale, roundingMode);
            if ((i % 2) != 0) {
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0);
        return result;
    }



    public static void a() {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入割圆次数：");
        int n=scan.nextInt();
        cut(n);

    }
    static void cut(int n){
        double y=1.0;
        for(int i=0;i<=n;i++){
            double π=3*Math.pow(2, i)*y;
            System.out.println("第"+i+"次切割,为正"+(6+6*i)+"边形，圆周率π≈"+π);
            y=Math.sqrt(2-Math.sqrt(4-y*y));
        }

    }

    public static void b(){
        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入精度：");
//        double z = scan.nextDouble();

        long start= System.currentTimeMillis();
//        BigDecimal z =1.0E-100;

        BigDecimal z = new BigDecimal(1.0E-100);

        System.out.println(z);
        BigDecimal pi= jishuPI(z);
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-start)/1000+"秒在精度为" + z + "的条件下，π约等于：\n" + pi);
    }







    static BigDecimal jishuPI(BigDecimal z) {
        BigDecimal sum = new BigDecimal(2);
        BigDecimal one = new BigDecimal(1);
        BigDecimal two = new BigDecimal(2);
        BigDecimal n = new BigDecimal(1);
        BigDecimal m = new BigDecimal(3);
        BigDecimal t = new BigDecimal(2);
        while (t.compareTo(z)>0) {
            t = t.multiply(n).divide(m) ;
            sum = sum .add(t);
            n.add(one);
            m  =m.add(two) ;


        }
        return sum;
    }




    static double jishuPI2(double z) {


        double  sum= 2;
        int n = 1;
        int m = 3;
        double t = 2;
        while (t > z) {
            t = t * n / m;
            sum = sum + t;
            n++;
            m += 2;


        }
        return sum;
    }

}
