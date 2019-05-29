package tree.multi_tree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MultiTree tree = new MultiTree();
        List<String> path1 = tree.listAllPathByRecursion();
        System.out.println("listAllPathByRecursion"+path1);
        List<String> path2 = tree.listAllPathByNotRecursion();
        System.out.println("listAllPathByNotRecursion"+path2);
    }
}
