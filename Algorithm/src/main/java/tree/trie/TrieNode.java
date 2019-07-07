package tree.trie;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class TrieNode {
    private HashMap<String, TrieNode> childs;
    private String content;
    private boolean flag;

    public TrieNode(){
        this.childs = new HashMap<>();
        this.content = null;
        this.flag = false;
    }
    public TrieNode(String content){
        this.childs = new HashMap<>();
        this.content = content;
        this.flag = false;
    }
    public TrieNode(String content,boolean flag){
        this.childs = new HashMap<>();
        this.content = content;
        this.flag = flag;
    }
    public void addChild(TrieNode node){
        childs.put(node.getContent(),node);
    }
}
