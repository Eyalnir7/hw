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
    public void occupiedMessage() {
        System.out.println("The square already contains a head of a snake!");
    }

    //Sends a message because the ladder is too long
    public void tooLongMessage() throws Exception {
        System.out.println("The ladder is to long!");
        throw new Exception("ladder too long");
    }
}
