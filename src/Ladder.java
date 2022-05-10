/*
Ladders have bases and ends, whenever a player lands on a ladder's base they immediately climb to its end.
A ladder's base and end cannot be located outside the board's bounds.
 */
public class Ladder extends GameObject{
    public Ladder(int base, int len) throws Exception{
        super(base, base + len);
        if (getStart() > Main.BOARD_END || getStart() < Main.BOARD_START)
            wrongSquareMessage();
        if (getFinish() > Main.BOARD_END || getFinish() < Main.BOARD_START)
            tooLongMessage();
    }

    @Override
    /**
     * Prints a message that says the square is already occupied
     */
    public void occupiedMessage() {
        System.out.println("This square already contains a bottom of a ladder!");
    }

    /**
     * Sends a message because the ladder is too long
     * @throws Exception
     */
    public void tooLongMessage() throws Exception {
        System.out.println("The ladder is too long!");
        throw new Exception("ladder too long");
    }
}
