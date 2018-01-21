/** This class models the Doctor in the game. A Doctor has
 *  a position and can move to a new position.
 */
public class Doctor {
    // instance variables 
    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        // assigning the variables for the row and column 
        this.row = theRow; 
        this.col = theCol; 

    }
    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol){
        // Integer for a random move ((Row)
        int randomRow = (int) (Math.random() * 12);
        // Integer for a random move (Col)
        int randomCol = (int) (Math.random() * 12);
        // if it's one spot away, then move there && if the spot is more than one teloport randomly
        if (this.row - newRow <= 1 && this.row - newRow >= -1 && this.col - newCol <= 1 && this.col - newCol >= -1) {
            this.row = newRow;
            this.col = newCol;
        } else {
            // Randomize the new spot of the doctor
            this.row = randomRow;
            this.col = randomCol;

        }
    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow(){
        // returnung the row where the dictor is located 
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol(){
        // returning the column where the doc is located 
        return this.col; 
    } 
}
