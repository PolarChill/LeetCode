import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : TODO
 * Created By Polar on 2017/9/11
 */
public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }


    @Test
    public void f1 () throws Exception {
        System.out.println(lexicalOrder(102));
//        f();
    }


    public void f() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (count < 10) {
                count++;
            }
        }

        System.out.println(count);
    }



}
