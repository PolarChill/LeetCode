import org.junit.Test;

/**
 * 通过位操作进行四则运算
 * Created by Polar on 2017/7/19.
 */
public class BitManipuation {
    /*
    位运算二进制加法，三步走
    1 获取进位的部分
    2 无进位二进制加法
    3 进位部分左移一位后，循环123过程，直到进位部分为0
     */
    // Iterative
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {    //b不为0 代表有进位操作
            int carry = a & b;  //获取进位的数值
            a = a ^ b;      // 不进位二进制加法
            b = carry << 1; //  将进位部分的值左移后进行相加
        }

        return a;
    }
    // Iterative
    public int getSubtract2(int a, int b) {
        b = ~b + 1;
        while (b != 0) {
            int borrow = a & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }
    public int getCount2(int a) {
        // 统计负数中的二进制1 的个数 会进入死循环
        int count  = 0;
        while (a != 0) {
            if((a&1) == 1) {
                count ++;
                a = a >> 1;
            }
        }
        
        return count;
    }

    public int getCount(int a) {
        int count = 0;
        while(a != 0) {
            ++count;
            a = a & (a-1);
        }
        return count;
    }
    // re
    public int getSum2(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a&b) << 1);
    }

    // Recursive
    public int getSubtract(int a, int b) {
        return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
    }


    @Test
    public void f1() {
        int a = 2;
        int b = -8;
        System.out.println(getSum(a, b));
        System.out.println(getSum2(a, b));
        System.out.println(getSubtract(a, b));
        System.out.println(getSubtract2(a, b));
        System.out.println(b<<1);
        System.out.println(a>>1);
        System.out.println(getCount(0x7FFFFFFF));
        System.out.println(getCount(b));

    }
}
