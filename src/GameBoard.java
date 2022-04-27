public class GameBoard {
    private Square[] gameBoard;

    public GameBoard(int len){
        this.gameBoard = new Square[len];
    }

    public boolean addGameObject(GameObject gameObject){
        return this.gameBoard[gameObject.getStart()].addGameObject(gameObject);
    }

    public Square[] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Square[] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
