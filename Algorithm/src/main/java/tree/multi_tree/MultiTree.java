package tree.multi_tree;

import java.util.*;

/**
 * 多叉树
 */
public class MultiTree {
    private TreeNode root;
    private List<String> pathList = new ArrayList<>();
    /**
     * 默认构造一棵树
     */
    public MultiTree(){
        //创建根节点
        HashMap rootChilds = new HashMap();
        this.root = new TreeNode("r",rootChilds);

        //第一层子节点
        HashMap aChilds = new HashMap();
        TreeNode aNode = new TreeNode("a",aChilds);

        HashMap bChilds = new HashMap();
        TreeNode bNode = new TreeNode("b",bChilds);

        HashMap gChilds = new HashMap();
        TreeNode gNode = new TreeNode("g",gChilds);

        //第二层结点
        HashMap dChilds = new HashMap();
        TreeNode dNode = new TreeNode("d",dChilds);

        HashMap cChilds = new HashMap();
        TreeNode cNode = new TreeNode("c",cChilds);

        HashMap eChilds = new HashMap();
        TreeNode eNode = new TreeNode("e",eChilds);

        HashMap fChilds = new HashMap();
        TreeNode fNode = new TreeNode("f",fChilds);

        //建立结点联系
        rootChilds.put("a",aNode);
        rootChilds.put("b",bNode);
        rootChilds.put("g",gNode);

        aChilds.put("d",dNode);
        aChilds.put("c",cNode);

        bChilds.put("e",eNode);
        bChilds.put("f",fNode);
    }
    /**
     * 递归方法输出所有路径
     * @return
     */
    public List<String> listAllPathByRecursion(){
        //清空路径容器
        this.pathList.clear();
        listPath(this.root,"");
        return this.pathList;
    }
    /**
     * 递归过程
     * @param root
     * @param path
     */
    public void listPath(TreeNode root,String path){

        if(root.getChilds().isEmpty()){//叶子节点
            path = path + root.getContent();
            pathList.add(path); //将结果保存在list中
            return;
        }else{ //非叶子节点
            path = path  + root.getContent() + "->";

            //进行子节点的递归
            HashMap<String, TreeNode> childs = root.getChilds();
            Iterator iterator = childs.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry)iterator.next();
                TreeNode childNode  = (TreeNode) entry.getValue();
                listPath(childNode,path);
            }
        }
    }
    /**
     * 非递归方法输出所有路径
     */
    public List<String> listAllPathByNotRecursion(){
        //清空路径容器
        this.pathList.clear();
        //主栈，用于计算处理路径
        Deque<TreeNode> majorStack = new ArrayDeque();
        //副栈，用于存储待处理节点
        Deque<TreeNode> minorStack = new ArrayDeque();
        minorStack.addLast(this.root);

        HashMap<String,Integer> popCount = new HashMap<>();
        String curString  = "";

        while(!minorStack.isEmpty()){
            //出副栈，入主栈
            TreeNode minLast = minorStack.pollLast();
            majorStack.addLast(minLast);
            curString+=minLast.getContent()+"->";
            //将该节点的子节点入副栈
            if(!minLast.getChilds().isEmpty()){
                HashMap<String, TreeNode> childs = minLast.getChilds();
                Iterator iterator = childs.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry entry = (Map.Entry)iterator.next();
                    TreeNode childNode  = (TreeNode) entry.getValue();
                    minorStack.addLast(childNode);
                }
            }
            //出主栈
            TreeNode majLast = majorStack.peekLast();
            //循环条件：栈顶为叶子节点 或 栈顶节点孩子节点遍历完了（需要注意空指针问题）
            while(majLast.getChilds().size() ==0 ||
                    (popCount.get(majLast.getContent())!=null && popCount.get(majLast.getContent()).equals(majLast.getChilds().size()))){

                TreeNode last = majorStack.pollLast();
                majLast = majorStack.peekLast();

                if(majLast == null){ //此时主栈为空，运算完毕
                    return this.pathList;
                }

                if(popCount.get(majLast.getContent())==null){//第一次弹出孩子节点，弹出次数设为1
                    popCount.put(majLast.getContent(),1);
                }else{ //非第一次弹出孩子节点，在原有基础上加1
                    popCount.put(majLast.getContent(),popCount.get(majLast.getContent())+1);
                }

                String lastContent = last.getContent();
                if(last.getChilds().isEmpty()){//如果是叶子节点才将结果加入路径集中
                    this.pathList.add(curString.substring(0,curString.length()-2));
                }
                //调整当前curString，减去2是减的“->”这个符号
                curString = curString.substring(0,curString.length()-lastContent.length()-2);

            }

        }
        return this.pathList;

    }

}
