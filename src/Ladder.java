public class Ladder extends GameObject{
    public Ladder(int base, int len){
        super(base, base + len);
        if (getStart() > 100 || getStart() < 0)
            wrongSquareMessage();
        if (getFinish() > 100 || getFinish() < 0)
            tooLongMessage();
    }

    public void occupiedMessage() {
        System.out.println("The square already contains a head of a snake!");
    }

    public void tooLongMessage()
    {
        System.out.println("The ladder is to long!");
    }
}
