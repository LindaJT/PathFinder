
package pathFinder.util;

/**
 * Data structure to store neighboring nodes
 * @author linjokin
 */
public class NeighborsList {
    
    private Node[] nodes;
    private int size;
    
    /**
     * Maximum size is the the maximum number of neighbors
     * Size is 0 in the beginning
     */
    public NeighborsList() {
        this.nodes = new Node[8];
        this.size = 0;
    }
    
    /**
     * Method to add a node to the list
     * Increases size by one
     * @param node Node to add
     */
    public void insert(Node node) {
        this.nodes[this.size] = node;
        this.size++;
    }
    
    /**
     * Returns how many nodes inserted to the list
     * @return number of nodes
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * Returns the node of given position
     * @param pos Position of the node
     * @return Node of that position
     */
    public Node getNode(int pos) {
        return this.nodes[pos];
    }
    
}
