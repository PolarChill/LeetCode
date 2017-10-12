

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 循环报数
 * Created By Polar on 2017/9/7
 */
public class CycleCount {
    public void cycleCount(int m) {
        // 当前遍历的人员
        List<Integer> people = new ArrayList<Integer>();
        // 该轮未报数结束后剩余的人员
        List<Integer> remain = new ArrayList<Integer>();
        // 该轮离开的人员
        List<Integer> leave = new ArrayList<Integer>();

        for (int j = 1; j < 101; j++) {
            people.add(j);
        }
        int count = 1;  // 记录第几轮报数
        int index = 1;  // 记录总报数次数

        while (true) {


            if (remain.size() == (100 % m)) {
                System.out.println("最终剩余的人为: " + remain.toString());
                break;

            }

            if (index > 1) {

                people = remain;
                // 此处remain重新创建一个对象, people指向了reamin
                remain = new ArrayList<Integer>();
                leave.removeAll(leave);
            }

            for (int j = 0; j < people.size(); j++) {
                if (index % m != 0) {
                    System.out.println("当前报数的位置 :" + people.get(j) + "   报数: " + index);
                    remain.add(people.get(j));
                } else {
                    System.out.println("当前报数的位置 :" + people.get(j) + "   报数: " + index + "--->离开");
                    leave.add(people.get(j));
                }

                index++;
            }

            count++;
            System.out.println("第" + count + "轮报数开始");
            System.out.println("剩余的人有: " + remain.toString());
            System.out.println("此次离开的人有:" + leave.toString());

        }

    }

    @Test
    public void testF() {
        cycleCount(13);

    }
}
