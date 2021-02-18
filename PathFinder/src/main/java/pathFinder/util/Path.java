
package pathFinder.util;

/**
 * Data structure to store the found path
 * @author linjokin
 */
public class Path {
    
    private Node[] nodes;
    private int size;
    
    /**
     * Constructor to create a path structure
     * Size is 0 in the beginning
     * Maximum size of the path is given as parameter
     * @param max maximum size of the path (G value of the last node)
     */
    public Path(int max) {
        this.nodes = new Node[max];
        this.size = 0;
    }
    
    /**
     * Method to add a node to the list
     * Size increases by one
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
    
    /**
     * Reverses the order of the nodes in the path
     * @return new path object that has reversed order
     */
    public Path flip() {
        Path reversed = new Path(this.size);
        for (int i = this.size - 1; i >= 0; i--) {
            reversed.insert(this.nodes[i]);
        }
        return reversed;
    }
    
}
