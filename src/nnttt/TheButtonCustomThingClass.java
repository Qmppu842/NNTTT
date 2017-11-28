package nnttt;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor
@Data
public class TheButtonCustomThingClass extends Button {

    private int posX;
    private int posY;
//    private int posOnFlatBoard;
    private StateOfSquare square;

    public TheButtonCustomThingClass(int posOnFlatBoard, StateOfSquare square) {
        super(square.getName());
//        this.posOnFlatBoard = posOnFlatBoard;
        this.square = square;
        
        posX = Math.floorDiv(posOnFlatBoard, 3);
        posY = posOnFlatBoard % 3;
        
        System.out.println("Button things:");
        System.out.println("Button X: " + posX);
        System.out.println("Button Y: " + posY);
        System.out.println("PosOnFlatBoard: " + posOnFlatBoard);
        System.out.println();
        System.out.println();
        
    }
    
    

//    public void setXYPos() {
//        posX = Math.floorDiv(posOnFlatBoard, 3);
//        posY = posOnFlatBoard % 3;
//    }

}
