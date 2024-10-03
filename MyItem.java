/*
 *  Desc.:    
 */

// import statements
import static java.lang.System.out;

import java.util.List;

public class MyItem implements IDedObject {
    private int itemID;
    private int itemPrice;
    private List<Integer> itemDescription;
    
    public MyItem(int itemID, int itemPrice, List<Integer> itemDescription) {
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    public MyItem(int itemPrice, List<Integer> itemDescription) {
        this(0, itemPrice, itemDescription);
    }
    
    @Override
    public int getID() {
       return itemID; 
    }
    
    @Override
    public String printID() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item ID: ").append(itemID);
        sb.append(", Price: $").append(itemPrice);
        sb.append(", Description: ");
         
        for (int desc : itemDescription) {
            sb.append(desc).append(", ");
        }
        return sb.toString().trim();
    }
}
