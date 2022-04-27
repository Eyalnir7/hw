public class GameBoard {
    private Square[] gameBoard;

    public GameBoard(int len){
        this.gameBoard = new Square[len];
    }

    public boolean addGameObject(GameObject gameObject){
        return this.gameBoard[gameObject.getStart()].addGameObject(gameObject);
    }
}
