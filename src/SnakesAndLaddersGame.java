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

}
