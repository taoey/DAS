package tree.trie;

import lombok.Getter;
@Getter
public class TrieTree {
    private TrieNode root;
    private int wordCount;
    private int nodeCount;

    public TrieTree(){
        this.root = new TrieNode();
        this.nodeCount=1;
        this.wordCount=0;
    }
    /**
     * 字典树添加一个敏感词
     * @param sensitiveWord
     * @return false-添加失败 true-添加成功
     */
    public boolean addString(TrieNode root ,String sensitiveWord){
        System.out.println(String.format("当前参数信息：%s %s",root.toString(),sensitiveWord));
        if(sensitiveWord==null || sensitiveWord.trim().isEmpty()){
            System.out.println("字典值不能为空");
            return false;
        }
        if(sensitiveWord.trim().length()==1){
            root.addChild(new TrieNode(sensitiveWord,true));
            this.nodeCount++;
            this.wordCount++;
            return true;
        }
        int cur = 1;//指向字符开始向右偏移1的位置的指针
        String curString = sensitiveWord.substring(cur-1,cur);
        if(!root.getChilds().containsKey(curString)){
            //插入子结点
            root.addChild(new TrieNode(curString));
            this.nodeCount++;
            //计算下一个结点
            TrieNode newRoot = root.getChilds().get(curString);
            addString(newRoot,sensitiveWord.substring(cur));
        }else{
            TrieNode newRoot = root.getChilds().get(curString);
            addString(newRoot,sensitiveWord.substring(cur));
        }
        return true;
    }

    /**
     * //TODO 过滤一个句子
     * @param sentence 待过滤的句子
     * @return 过滤完成的句子
     */
    public String filterString(String sentence){
        char[] chars = sentence.toCharArray();

        return null;
    }
}
