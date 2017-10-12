import org.junit.Test;

import java.util.*;

/**
 * Created by Polar on 2017/7/15.
 * 二叉树的先序遍历 带有括号的  显示二叉树的子结构
 * 递归方法 与 非递归方法
 */
public class Tree2String {
    /*
    非递归方法
     */
    public static String tree2String(TreeNode t) {
        if (t == null)
            return "";
        // 在非递归方法中，需要一个栈来记录当前节点，以便在完成左子树后能返回到右子树进行遍历。
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);

        Set<TreeNode> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            // 查看栈顶得第一个元素，不弹栈
            t = stack.peek();
            if (!visited.contains(t)) {
                // 每当一个节点被处理一次，它就被标记为访问
                visited.add(t);
                sb.append("(" + t.val);
                if ((t.left == null && t.right != null)) {
                    sb.append("()");
                }
                // 首先将不为空的右子树压入栈中
                if (t.right != null) {
                    stack.push(t.right);
                }
                // 再将不为空的左子树压入栈中
                if (t.left != null) {
                    stack.push(t.left);
                }
            } else {
                // 被访问过时，将其弹栈，并以")"标记结束
                stack.pop();
                sb.append(")");
            }

        }
        return sb.toString().substring(1, sb.length() - 1);
    }


    /*
    递归方法优化版 针对反复创建字符串对象
     */
    public static String tree2str(TreeNode t) {
        // 使用StringBuilder 只创建一个字符串对象
        StringBuilder sb = new StringBuilder();
        helper(sb, t);
        return sb.toString();
    }

    public static void helper(StringBuilder sb, TreeNode t) {
        if (t != null) {
            sb.append(t.val);
            if (t.left != null || t.right != null) {
                sb.append("(");
                helper(sb, t.left);
                sb.append(")");

                if (t.right != null) {
                    sb.append("(");
                    helper(sb, t.right);
                    sb.append(")");
                }
            }
        }

    }

    /*
    递归方法
     */
    public static String tree2String2(TreeNode t) {
        if (t == null) {
            return "";
        }
        // 当前节点的左右子树都不存在时 直接返回结果
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        // 只存在左子树时，右子树括号可省略
        // 只存在右子树时，左子树括号需保留，用来表示下一个节点为右子树
        return t.val + "(" + tree2String2(t.left) + ")" + (t.right == null ? "" : "(" + tree2String2(t.right) + ")");
    }

    public static void preorderTree(TreeNode t) {

        // 在非递归方法中，需要一个栈来记录当前节点，以便在完成左子树后能返回到右子树进行遍历。
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        while (true) {
            while (t != null) {
                sb.append("(" + t.val);
                stack.push(t);
                if (t.left == null && t.right != null) {
                    sb.append("(");
                }

                t = t.left;

            }

            if (stack.isEmpty()) {
                // 栈为空时 二叉树已经遍历结束，跳出循环
                break;
            }
            t = stack.pop();
            t = t.right;
            sb.append(")");


        }
        System.out.println(sb.toString().substring(1));
    }

    /*
    正常输出先序遍历内容
     */
    public static void preorderTreeNode(TreeNode t) {
        // 先序遍历
        if (t != null) {
            System.out.print(t.val + " ");
            preorderTreeNode(t.left);
            preorderTreeNode(t.right);
        }

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
//        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
//        t.right.right = new TreeNode(7);

//        preorderTreeNode(t);
        System.out.println(tree2String2(t));
        // System.out.println(tree2str(t));
        preorderTree(t);
        System.out.println(tree2String(t));

    }

    //
    @Test
    public void f1() {

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        Integer integer = list.removeLast();
        System.out.println(integer);
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
//        Integer pop = stack.pop();
//        System.out.println(pop);
        Integer peek = stack.peek();
        System.out.println(peek);
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void hh() throws Exception {
        boolean flag = false;
        if(flag = true) {

        }
        System.out.println(flag);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}