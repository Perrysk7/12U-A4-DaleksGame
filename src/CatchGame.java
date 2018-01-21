
import java.awt.Color;


/** This class manages the interactions between the different pieces of
 *  the game: the Board, the Daleks, and the Doctor. It determines when
 *  the game is over and whether the Doctor won or lost.
 */
public class CatchGame {
    /**
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */
    private Board b = new Board(12, 12);  
    private Doctor doc = new Doctor ((int)(Math.random()*12), (int)(Math.random()*12));
    private Dalek d1, d2, d3;
    

    /**
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
        // randomly generate the daleks on the board
        this.d1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        this.d2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        this.d3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        // drawing the doctor and the daleks 
        b.putPeg(Color.green, doc.getRow(), doc.getCol());
        b.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
        b.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
        b.putPeg(Color.BLACK, d3.getRow(), d3.getCol());
    }
    
    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        
        // Doctor and Dalek 1
        while (doc.getRow() == d1.getRow() && doc.getCol() == d1.getCol()) {
            // Remove the Doctor peg
            b.removePeg(doc.getRow(), doc.getCol());
            // Create a new location for the doctor
            doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // Doctor and Dalek 2
        while (doc.getRow() == d2.getRow() && doc.getCol() == d2.getCol()) {
            // Remove the Doctor peg
            b.removePeg(doc.getRow(), doc.getCol());
            // Create a new location for the doctor
            doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // Doctor and Dalek 3
        while (doc.getRow() == d3.getRow() && doc.getCol() == d3.getCol()) {
            // Remove the Doctor peg
            b.removePeg(doc.getRow(), doc.getCol());
            // Create a new location for the doctor
            doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // If the daleks land on each other, then respawn
        // Dalek 1 and Dalek 2
        while (d1.getRow() == d2.getRow() && d1.getCol() == d2.getCol()) {
            // Remove Dalek 1 peg
            b.removePeg(d1.getRow(), d1.getCol());
            // Create a new location for the Dalek 1
            d1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // Dalek 1 and Dalek 3
        while (d1.getRow() == d3.getRow() && d1.getRow() == d3.getCol()) {
            // Remove Dalek 1 peg
            b.removePeg(d1.getRow(), d1.getCol());
            // Create a new location for the Dalek 1
            d1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // Dalek 2 and Dalek 3
        while (d2.getRow() == d3.getRow() && d2.getCol() == d3.getCol()) {
            // Remove Dalek 2 peg
            b.removePeg(d2.getRow(), d2.getCol());
            // Create a new location for Dalek 2
            d2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        
         while (true) {
            // when the Doctor is captured
            // Crash check 
            if (d1.getRow() == doc.getRow() && d1.getCol() == doc.getCol()
                    || d2.getRow() == doc.getRow() && d2.getCol() == doc.getCol()
                    || d3.getRow() == doc.getRow() && d3.getCol() == doc.getCol()) {
                // Place a peg where the doctor was captured
                b.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                // Tell the player that they have failed!
                b.displayMessage(" GAME OVER! YOU LOST!");
                // End the game if the doctor is captured
                break;
            }

            // Crash check
            // If all the daleks colliede with each other 
            if (d1.getRow() == d2.getRow() && d1.getRow() == d3.getRow()
                    && d1.getCol() == d2.getCol() && d1.getCol() == d3.getCol()
                    && d2.getRow() == d3.getRow() && d2.getCol() == d3.getCol()) {
                // All three Daleks crash
                d1.crash();
                d2.crash();
                d3.crash();
                // Put a red peg where all three have collided
                b.putPeg(Color.RED, d1.getRow(), d1.getCol());
                // Tell the player/user that they have successfully completed the mission! 
                b.displayMessage("CONGRATULATIONS! YOU WON!");
                // End the game if all three Daleks have crashed
                break;
            }
            // If Dalek 1 has crashed with Dalek 2
            if (d1.getRow() == d2.getRow() && d1.getCol() == d2.getCol()) {
                // Both Daleks have crashed
                d1.crash();
                d2.crash();
                // Put a red peg where the two crashed
                b.putPeg(Color.RED, d1.getRow(), d1.getCol());
            }
            // If Dalek 1 has crashed with Dalek 3
            if (d1.getRow() == d3.getRow() && d1.getCol() == d3.getCol()) {
                // Both Daleks have crashed
                d1.crash();
                d3.crash();
                // Put a red peg where the two crashed
                b.putPeg(Color.RED, d3.getRow(), d3.getCol());
            }
            // If Dalek 2 has crashed with Dalek 3
            if (d2.getRow() == d3.getRow() && d2.getCol() == d3.getCol()) {
                // Both Daleks have crashed
                d2.crash();
                d3.crash();
                // Put a red peg where the two have crashed
                b.putPeg(Color.RED, d2.getRow(), d2.getCol());
            }

            // Coordinates of the user's click
            Coordinate click = b.getClick();
            // Remove the old doctor peg
            b.removePeg(doc.getRow(), doc.getCol());
            // Move the doctor peg to new location where the player clicked
            doc.move(click.getRow(), click.getCol());
            // Place the doctor peg!
            b.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

            // More Dalek actions
            // Make Dalek 1 move towards the doctor
            if (d1.hasCrashed() == false) {
                // Remove the Dalek's peg
                b.removePeg(d1.getRow(), d1.getCol());
                // Have Dalek 1 move towards the doctor
                d1.advanceTowards(doc);
            }
            // Make Dalek 2 move towards the doctor
            if (d2.hasCrashed() == false) {
                // Remove the Dalek's peg
                b.removePeg(d2.getRow(), d2.getCol());
                // Have Dalek 2 move towards the doctor
                d2.advanceTowards(doc);
            }
            // Make Dalek 3 move towards the doctor
            if (d3.hasCrashed() == false) {
                // Remove the Dalek's peg               
                b.removePeg(d3.getRow(), d3.getCol());
                // Have Dalek 3 move towards the doctor
                d3.advanceTowards(doc);
            }
            // Place the new pegs which were removed
            b.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
            b.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
            b.putPeg(Color.BLACK, d3.getRow(), d3.getCol());
        }
    }
}