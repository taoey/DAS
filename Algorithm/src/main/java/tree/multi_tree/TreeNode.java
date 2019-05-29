package tree.multi_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TreeNode {
    private String content;
    private HashMap<String,TreeNode> childs;

}
