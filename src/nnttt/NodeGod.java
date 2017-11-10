
package nnttt;

import java.util.ArrayList;

/**
 *
 * @author olindqvi
 */
public class NodeGod {
    private ArrayList<StateOfSquare> inputBoard;
    private ArrayList<inputnode> inputLayer;

    public NodeGod(ArrayList<StateOfSquare> inputBoard) {
        this.inputBoard = inputBoard;
        for (StateOfSquare stateOfSquare : inputBoard) {
            inputLayer.add(new inputnode(stateOfSquare.getValue()));
        }
    }
    
    
    
    
}
