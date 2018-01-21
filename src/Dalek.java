
/** This class models a Dalek in the game. A Dalek has
 *  a position and can advance towards the Doctor.
 */
public class Dalek {
    // instance variables 
    private int row, col;
    private boolean hasCrashed;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        // assigning the variables 
        this.row = theRow; 
        this.col = theCol; 
        hasCrashed = false; 
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {
            // if the doctor's position is greater then the dalek's position... add one 
            if(doc.getRow() > this.row){
                row++; 
            // otherwise subtract one from the row     
            } else if (doc.getRow() < this.row){
                row--; 
            }
            // if the doc's position is greater than the dalek's position... add one 
            if(doc.getCol() > this.col){
                col++; 
            // otherwise subtract one from the col     
            } else if(doc.getCol() < this.col){
                col--; 
            }  
         }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        // returning...
        return this.row; 
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        // returning...
        return this.col; 
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        // returninng "hasCrashed" true
        this.hasCrashed = true; 

    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        // returning hasCrashed
        return this.hasCrashed; 
    }
}
