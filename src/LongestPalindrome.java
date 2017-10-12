import java.util.HashMap;
import java.util.Set;

/**
 * 最长回文串长度
 * 统计每个字符出现的次数
 * 字符中所有的偶数组成回文串
 * 所有大于2的奇数减1
 * 奇数个数大于1时 回文串长度加1
 * Created by Polar on 2017/7/14.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                Integer count = map.get(c[i]);
                map.put(c[i], ++count);

            } else {
                map.put(c[i], 1);
            }
        }
//        System.out.println(map);

        int x  = 0;
        int count  = 0;
        Set<Character> ch = map.keySet();
        for (char c1 : ch) {
            Integer i = map.get(c1);
            if(i % 2 == 0) {
                x += i;
//                System.out.print(i + " ");
            } else {
                count++;
                if(i > 2) {
                     x += i-1;
                }
            }
        }
        if(count >= 1) {
            x +=1;
        }
        return x;
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        int x = l.longestPalindrome("NTrQdQGgwtxqRTSBOitAXUkwGLgUHtQOmYMwZlUxqZysKpZxRoehgirdMUgy");
        System.out.println(x);
    }

}
