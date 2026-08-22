import java.util.*;

class DinnerPlates {
    private List<Stack<Integer>> table;
    private TreeSet<Integer> available; 
    private int capacity;

    public DinnerPlates(int capacity) {
        this.table = new ArrayList<>();
        this.available = new TreeSet<>();
        this.capacity = capacity;
    }
    
    public void push(int val) {
        while (!available.isEmpty() && available.first() >= table.size()) {
            available.pollFirst();
        }
        
        if (available.isEmpty()) {
            table.add(new Stack<>());
            available.add(table.size() - 1);
        }
        
        int index = available.first();
        table.get(index).push(val);
        
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
        available.add(index);
        while (!table.isEmpty() && table.get(table.size() - 1).isEmpty()) {
            table.remove(table.size() - 1);
        }
        
        return val;
    }
}
