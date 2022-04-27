public class GameBoard {
    private final Square[] gameBoard;

    public GameBoard(int len){
        this.gameBoard = new Square[len];
    }

    public void addGameObject(GameObject gameObject){
        this.gameBoard[gameObject.getStart()].addGameObject(gameObject);
    }

    public Square[] getGameBoard() {
        return gameBoard;
    }

    public Square[] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Square[] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
