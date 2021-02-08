
package pathFinder.util;

import pathFinder.Node;

/**
 * Minimum heap for AStar implementation
 * 
 * @author linjokin
 */
public class MinHeap {
    
    private Node[] heap;
    private final int maxsize;
    private int size;
    private static final int FRONT = 1; 
    
    public MinHeap(int maxsize, Node now) { 
        this.maxsize = maxsize; 
        this.size = 0; 
        this.heap = new Node[this.maxsize + 1]; 
        this.heap[0] = now; 
    } 
  
    /**
     * Function to return the position of 
     * the parent for the node currently 
     * at position 
     * @param pos current position
     * @return position of the parent
     */
    private int parent(int pos) { 
        return pos / 2; 
    } 
  
    /**
     * Function to return the position of the 
     * left child for the node currently at pos 
     * @param pos current position 
     * @return position of the left child
     */
    private int leftChild(int pos) { 
        return (2 * pos); 
    } 
  
    /**
     * Function to return the position of 
     * the right child for the node currently 
     * at pos 
     * @param pos current position
     * @return position of the right child
     */
    private int rightChild(int pos) { 
        return (2 * pos) + 1; 
    } 
  
    /**
     * Function that returns true if the passed 
     * node is a leaf node 
     * @param pos position of the node
     * @return 
     */
    private boolean isLeaf(int pos) { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    /**
     * Function to swap two nodes of the heap 
     * 
     * @param fpos position of first node
     * @param spos position of second node
     */
    private void swap(int fpos, int spos) { 
        Node tmp; 
        tmp = heap[fpos]; 
        heap[fpos] = heap[spos]; 
        heap[spos] = tmp; 
    } 

    
    /**
     * Function to heapify the node at pos
     * @param pos 
     */
    private void minHeapify(int pos) { 
        if (!isLeaf(pos)) { 
            if (heap[pos].getF() > heap[leftChild(pos)].getF() 
                || heap[pos].getF() > heap[rightChild(pos)].getF()) { 
  
                if (heap[leftChild(pos)].getF() < heap[rightChild(pos)].getF()) { 
                    swap(pos, leftChild(pos)); 
                    minHeapify(leftChild(pos)); 
                } else { 
                    swap(pos, rightChild(pos)); 
                    minHeapify(rightChild(pos)); 
                }
            }
        }
    } 
  
    /**
     * Function to insert a node into the heap 
     * @param node to insert 
     */
    public void insert(Node node) { 
        if (size >= maxsize) { 
            return; 
        } 
        heap[++size] = node; 
        int current = size; 
  
        while (heap[current].getF() < heap[parent(current)].getF()) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
    /**
     * Function to build the min heap
     */
    public void minHeap() { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            minHeapify(pos); 
        } 
    } 
  
    /**
     * Function to remove and return the minimum 
     * element from the heap
     * @return minimum Node
     */
    public Node remove() { 
        Node popped = heap[FRONT]; 
        heap[FRONT] = heap[size--]; 
        minHeapify(FRONT); 
        return popped; 
    }
    
    /**
     * Function to get the size of the heap
     * @return heap size
     */
    public int getSize() {
        return size;
    }
     
}
