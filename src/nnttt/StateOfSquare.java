package nnttt;

/**
 *
 * @author olindqvi
 */
public enum StateOfSquare {
    X(1, "X"), O(-1, "O"), EMPTY(0, " ");
    
    private final int value;
    private final String name;

    private StateOfSquare(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
    
    
    
    
 
    
    
}
