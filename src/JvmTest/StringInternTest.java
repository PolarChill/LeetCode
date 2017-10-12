package JvmTest;

/**
 * Created by Polar on 2017/7/16.
 */
public class StringInternTest {
    public static void main(String[] args) {
        String a1 = new String("wtffff");
        String a2 = a1.intern();
        System.out.println(a1 == a2);

        System.out.println("============");
        String s1 = "sss111";
        // subString 将截取的字符存入到了常量池中
        String s2 = s1.substring(0, 3);
        String s3 = s2.intern();
        System.out.println(s2 == s3);

        System.out.println("==============");
        String b1 = new String("java");
        System.out.println(b1.intern() == b1);

        System.out.println("==============");

        String sb2 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(sb2 == sb2.intern());
        // "java"并非首次出现
        String sb1 = new StringBuilder("ja").append("va").toString();
        System.out.println(sb1.intern() == sb1);



    }
}
