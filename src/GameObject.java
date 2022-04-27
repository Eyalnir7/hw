/*A general blueprint for a game object.
It contains a starting point and a finishing point.
 */
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

    //Sends a message because the square is outside the board's boundaries
    public void wrongSquareMessage() throws Exception{
        System.out.println("The square is not within the board's boundaries!");
        throw new Exception("square out of bounds");
    }

    //Sends a message because the square already contains a snake's head or a ladder's base
    public void occupiedMessage()
    {
        System.out.println("not supposed to be here :)");
    }
}
