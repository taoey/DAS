package tree.trie;

public class Main {
    public static void main(String[] args) {
        String sentence = "abcdefghi"; //待过滤的句子
        String[] words = {"cd","ca","cda","hi"}; //敏感词
        //构建字典树
        TrieTree trieTree = new TrieTree();
        for(String word :words){
            trieTree.addString(trieTree.getRoot(),word);
        }
        //处理句子
        String result = trieTree.filterString(sentence);
        System.out.println(result);
    }
}
