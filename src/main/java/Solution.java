import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        traversAndMap(map, node);
        for (Map.Entry<Node, Node> entry: map.entrySet()) {
            Node original = entry.getKey();
            Node clone = entry.getValue();
            for (int i = 0; i < original.neighbors.size(); i++) {
                clone.neighbors.add(map.get(original.neighbors.get(i)));
            }
        }
        return map.get(node);
    }


    private void traversAndMap(Map<Node, Node> map, Node root){
        if(root == null){
            return;
        }
        map.put(root, new Node(root.val));

        for (int i = 0; i < root.neighbors.size(); i++) {
            if(!map.containsKey(root.neighbors.get(i))){
                traversAndMap(map, root.neighbors.get(i));
            }
        }
    }

}
