public class Ladder extends GameObject{
    public Ladder(int base, int len) throws Exception{
        super(base, base + len);
        if (getStart() > 100 || getStart() < 0)
            wrongSquareMessage();
        if (getFinish() > 100 || getFinish() < 0)
            tooLongMessage();
    }

    @Override
    public void occupiedMessage() {
        System.out.println("The square already contains a head of a snake!");
    }

    public void tooLongMessage() throws Exception {
        System.out.println("The ladder is to long!");
        throw new Exception("ladder too long");
    }
}
