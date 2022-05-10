//Game pieces have a color and a location on the board
public class GamePiece {
    private Color color;
    private int location;

    public GamePiece(Color color)
    {
        this.color = color;
        this.location = Main.BOARD_START;
    }

    public Color getColor()
    {
        return this.color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    /**
     * Moves the game pieces num steps forward.
     * If the piece reaches the end of the board and still has x steps to go forward
     * then it will go x steps backwards.
     * If the piece reaches the beginning of the board and still has x steps to go backward
     * then it will go x steps forward.
     * @param num
     */
    public void addToLocation(int num)
    {
        if(this.location + num > Main.BOARD_END)
            this.location = Main.BOARD_END - (this.location + num)%Main.BOARD_END;
        else if (this.location + num < Main.BOARD_START)
            this.location = 1;
        else
            this.location = this.location + num;
    }
}
