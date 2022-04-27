public class Snake extends  GameObject {
    public Snake(int head, int len) throws Exception{
        super(head, head - len);
        if (getStart() > 100 || getStart() < 0)
            wrongSquareMessage();
        if (getFinish() > 100 || getFinish() < 0)
            tooLongMessage();
        if(getFinish() == 100)
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
