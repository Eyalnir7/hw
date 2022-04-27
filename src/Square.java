public class Square {
    private int squareNumber;
    private GameObject gameObject;

    public Square(int squareNumber, GameObject gameObject)
    {
        this.squareNumber = squareNumber;
        this.gameObject = gameObject;
    }

    public Square(int squareNumber)
    {
        this.squareNumber = squareNumber;
    }

    public int getSquareNumber() {
        return squareNumber;
    }

    public void setSquareNumber(int squareNumber) {
        this.squareNumber = squareNumber;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public boolean addGameObject(GameObject gameObject){
        if(this.gameObject!=null){
            this.gameObject.occupiedMessage();
            return false;
        }
        setGameObject(gameObject);
        return true;
    }
}
