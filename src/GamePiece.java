public class GamePiece {
    private Color color;
    private int location;

    public GamePiece(Color color)
    {
        this.color = color;
        this.location = 1;
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

    public void addToLocation(int num)
    {
        if(this.location + num > 100)
            this.location = 100 - (this.location + num)%100;
        else
            this.location = location + num;
    }
}
