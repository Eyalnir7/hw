public class Square {
    private int squareNumber;
    private Snake snake;
    private Ladder ladder;

    public Square(int squareNumber, Snake snake, Ladder ladder)
    {
        this.squareNumber = squareNumber;
        this.snake = snake;
        this.ladder = ladder;
    }

    public Square(int squareNumber, Snake snake)
    {
        this.squareNumber = squareNumber;
        this.snake = snake;
    }

    public Square(int squareNumber, Ladder ladder)
    {
        this.squareNumber = squareNumber;
        this.ladder = ladder;
    }

    public Square(int squareNumber)
    {
        this.squareNumber = squareNumber;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
}
