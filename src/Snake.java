/*
Snakes have heads and tails, whenever a player lands on a snake's head they fall to its tail.
A snake's head and tail cannot be located outside the board's bounds.
Moreover, a snake's head cannot be located on the last square.
 */
public class Snake extends  GameObject {
    public Snake(int head, int len) throws Exception{
        super(head, head - len);
        if (getStart() > Main.BOARD_END || getStart() < Main.BOARD_START)
            wrongSquareMessage();
        if (getFinish() > Main.BOARD_END || getFinish() < Main.BOARD_START)
            tooLongMessage();
        if(getStart() == Main.BOARD_END)
            lastSquareMessage();

    }

    @Override
    public void occupiedMessage(){
        System.out.println("This square contains a head of a snake!");
    }

    //Sends a message because the snake is too long
    public void tooLongMessage() throws Exception {
        System.out.println("The snake is too long!");
        throw new Exception("snake too long");
    }

    //Sends a message because a snake cannot be added on the last square
    public void lastSquareMessage() throws Exception{
        System.out.println("You cannot add a snake in the last square!");
        throw new Exception("last square snake");
    }
}
