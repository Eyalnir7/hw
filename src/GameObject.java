public class GameObject {
    private int start;
    private int finish;

    public GameObject(int start, int finish){
        this.start = start;
        this.finish = finish;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public void wrongSquareMessage()
    {
        System.out.println("The square is not within the board's boundaries!")
    }
}
