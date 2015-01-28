/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
        	return res;
        }

        Stack<DirectedGraphNode> st = new Stack<DirectedGraphNode>();
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
        	if (!visited.contains(node)) {
        		visit(st, node, visited);
        	}
        }

        while (!st.isEmpty()) {
        	res.add(st.pop());
        }

        return res;
    }

    public void visit(Stack<DirectedGraphNode> st, DirectedGraphNode node, Set<DirectedGraphNode> visited) {
    	visited.add(node);

    	for (DirectedGraphNode neb : node.neighbors) {
    		if (!visited.contains(neb)) {
    			visit(st, neb, visited);
    		}
    	}

    	st.push(node);
    }
}
