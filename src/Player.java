public class Player {
    private String name;
    private GamePiece gamePiece;

    public Player(String name, GamePiece gamePiece){
        this.name = name;
        this.gamePiece = gamePiece;
    }

    public Player(String name, Color color){
        this(name, new GamePiece(color));
    }

    public GamePiece getGamePiece() {
        return gamePiece;
    }

    public void setGamePiece(GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
