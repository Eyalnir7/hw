public class SnakesAndLaddersGame {
    private final Die die;
    private final Player[] players = new Player[Main.PLAYER_COUNT];
    private final GameBoard gameBoard = new GameBoard(Main.BOARD_END);
    private int playerCount = 0;

    public SnakesAndLaddersGame(){
        die = new Die();
    }

    public SnakesAndLaddersGame(int lowest, int highest){
        die = new Die(lowest, highest);
    }

    public void initializeGame(){
        System.out.println("Initializing the game...");
        String input;
        String[] splitInput;
        boolean stop = false;
        while(!stop){
            input = Main.scanner.nextLine();
            if(input.equals("end")){
                if(playerCount>2) stop = true;
                else System.out.println("Cannot start the game, there are less than two players!");
            }
            splitInput = input.split(" ");
            handleInput(splitInput);
        }
    }

    private void handleInput(String[] splitInput){
        int arg1 = Integer.parseInt(splitInput[3]);
        int arg2 = Integer.parseInt(splitInput[2]);
        switch (splitInput[1]) {
            case "ladder" -> addLadder(arg1, arg2);
            case "snake" -> addSnake(arg1, arg2);
            case "player" -> addPlayer(splitInput[2], Color.valueOf(splitInput[3]));
        }
    }

    private void addLadder(int base, int length){
        Ladder ladder;
        try{
            ladder = new Ladder(base, length);
        }
        catch (Exception e){
            return;
        }
        this.gameBoard.addGameObject(ladder);
    }

    private void addSnake(int base, int length){
        Snake snake;
        try{
            snake = new Snake(base, length);
        }
        catch (Exception e){
            return;
        }
        this.gameBoard.addGameObject(snake);
    }

    private void addPlayer(String name, Color color){
        if(playerCount == Main.PLAYER_COUNT){
            System.out.println("The maximal number of playes is five!");
            return;
        }
        boolean colorExists = false;
        boolean nameExists = false;
        for (Player player :
                players) {
            if (player.getName().equals(name)) nameExists = true;
            if (player.getGamePiece().getColor() == color) colorExists = true;
        }
        if(printExists(colorExists, nameExists)) return;
        playerCount++;
        players[playerCount] = new Player(name, color);
    }

    private boolean printExists(boolean colorExists, boolean nameExists){
        if(colorExists && nameExists){
            System.out.println("The name and the color are already taken!");
            return true;
        }
        if(nameExists){
            System.out.println("The name is already taken!");
            return true;
        }
        if(colorExists){
            System.out.println("The color is already taken!");
            return true;
        }
        return false;
    }

    private void start()
    {
        boolean play = true;
        int round = 1;
        while(play)
        {
            System.out.println("------------------------- Round number " + round + " -------------------------");
            for(int i = 0; i < players.length; i++)
            {
                int rolledValue = die.roll();
                int lastLocation = players[i].getGamePiece().getLocation();
                players[i].getGamePiece().addToLocation(rolledValue);
                System.out.print(players[i].getName() + " rolled " + rolledValue + ". The path to the next square: " + lastLocation + " ->" + players[i].getGamePiece().getLocation());
                GameObject gameObject = gameBoard.getGameBoard()[players[i].getGamePiece().getLocation() - 1].getGameObject();
                if(gameObject != null) {
                    players[i].getGamePiece().setLocation(gameObject.getFinish());
                    System.out.print(" ->" + players[i].getGamePiece().getLocation());
                }
                System.out.println("");
            }
            System.out.println("");
            round++;
        }
    }

}
