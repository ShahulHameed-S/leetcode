import java.util.*;

class DinnerPlates {
    private List<Stack<Integer>> table;
    private TreeSet<Integer> available; // Keeps unique indices sorted in ascending order
    private int capacity;

    public DinnerPlates(int capacity) {
        this.table = new ArrayList<>();
        this.available = new TreeSet<>();
        this.capacity = capacity;
    }
    
    public void push(int val) {
        // Remove any tracking indices that point beyond our current table size
        while (!available.isEmpty() && available.first() >= table.size()) {
            available.pollFirst();
        }
        
        // If no available space in existing stacks, create a new one
        if (available.isEmpty()) {
            table.add(new Stack<>());
            available.add(table.size() - 1);
        }
        
        int index = available.first();
        table.get(index).push(val);
        
        // If this stack has reached max capacity, remove it from available indices
        if (table.get(index).size() == capacity) {
            available.pollFirst();
        }
    }
    
    public int pop() {
        return popAtStack(table.size() - 1);
    }
    
    public int popAtStack(int index) {
        if (index < 0 || index >= table.size() || table.get(index).isEmpty()) {
            return -1;
        }
        
        Stack<Integer> stack = table.get(index);
        int val = stack.pop();
        
        // TreeSet prevents duplicates automatically if index is already present
        available.add(index);
        
        // Clean up the end of the table by removing trailing empty stacks
        while (!table.isEmpty() && table.get(table.size() - 1).isEmpty()) {
            table.remove(table.size() - 1);
        }
        
        return val;
    }
}
