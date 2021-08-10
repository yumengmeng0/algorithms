package chapter102;

/**
 * @author: ymm
 * @date: 2021/6/26
 * @version: 1.0.0
 * @description: 为有理数不可变的数据类型
 */
public class Rational {
    private final int numberator;
    private final int denominator;


    public Rational(int numberator, int denominator) {
        this.numberator = numberator;
        this.denominator = denominator;
    }

    /**
     * 计算两个非负整数p和q的最大公约数
     *
     * @param p
     * @param q
     * @return
     */
    private static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    /**
     * 返回分子
     *
     * @return
     */
    public int numberator() {
        return numberator;
    }

    /**
     * 返回分母
     *
     * @return
     */
    public int denominator() {
        return denominator;
    }

    public Rational plus(Rational b) {
        int gcd, numberator0 = this.numberator, denominator0 = this.denominator,numberator1=b.numberator, denominator1= b.denominator;


        while (gcd(this.denominator, b.denominator()) != this.denominator
                && gcd(this.denominator, b.denominator()) != b.denominator()) {

        }

        do {
            gcd = gcd(this.numberator, b.denominator());
            if (gcd != 1) {
                numberator1 = this.numberator / gcd;
                denominator1 = this.denominator / gcd;
            }
        } while (gcd != 1);

        do {
            gcd = gcd(this.denominator, b.denominator());
            if (gcd != 1) {
                numberator1 = this.numberator / gcd;
                denominator1 = this.denominator / gcd;
            }
        } while (gcd != 1);


        return null;
    }

    public Rational minus(Rational b) {

        return null;
    }

    public Rational times(Rational b) {

        return null;
    }

    public Rational divides(Rational b) {

        return null;
    }


    @Override
    public boolean equals(Object that) {
        return super.equals(that);
    }

    @Override
    public String toString() {
        return numberator + "/" + denominator;
    }

}
