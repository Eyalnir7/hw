public class Snake extends  GameObject {
    public Snake(int head, int len){
        super(head, head - len);
        if (getStart() > 100 || getStart() < 0)
            wrongSquareMessage();
        if (super.getFinish() > 100 || super.getFinish() < 0)
            tooLongMessage();
    }

    public void occupiedMessage() {
        System.out.println("The square already contains a head of a snake!");
    }

    public void tooLongMessage()
    {
        System.out.println("The snake is to long!");
    }
}
