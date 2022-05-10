public class GameBoard {
    private Square[] gameBoard;

    public GameBoard(int len){
        this.gameBoard = new Square[len];
        for(int i =0; i<len; i++){
            gameBoard[i] = new Square(i+1);
        }
    }

    /**
     * Adds a game object to the game
     * @param gameObject
     */
    public void addGameObject(GameObject gameObject){
        this.gameBoard[gameObject.getStart()-1].addGameObject(gameObject);
    }

    public Square[] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Square[] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
