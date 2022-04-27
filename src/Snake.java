public class Snake extends  GameObject {
    public Snake(int head, int len) throws Exception{
        super(head, head - len);
        if (getStart() > Main.BOARD_END || getStart() < Main.BOARD_START)
            wrongSquareMessage();
        if (getFinish() > Main.BOARD_END || getFinish() < Main.BOARD_START)
            tooLongMessage();
        if(getFinish() == Main.BOARD_END)
            lastSquareMessage();

    }

    @Override
    public void occupiedMessage(){
        System.out.println("The square already contains a head of a snake!");
    }

    public void tooLongMessage() throws Exception {
        System.out.println("The snake is to long!");
        throw new Exception("snake too long");
    }

    public void lastSquareMessage() throws Exception{
        System.out.println("You cannot add a snake in the last square!");
        throw new Exception("last square snake");
    }
}
