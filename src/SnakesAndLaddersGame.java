import java.util.Locale;

public class SnakesAndLaddersGame {
    private final Die die;
    private final Player[] players = new Player[Main.PLAYER_COUNT];
    private final GameBoard gameBoard = new GameBoard(Main.BOARD_END);
    private int playerCount = 0;

    public SnakesAndLaddersGame(){
        die = new Die();
    }

    public SnakesAndLaddersGame(int lowest, int highest){
        die = new Die(highest, lowest);
    }

    public void initializeGame(){
        System.out.println("Initializing the game...");
        String input;
        String[] splitInput;
        while(true){
            input = Main.scanner.nextLine();
            if(input.equals("end")){
                if(playerCount>=2) break;
                else {
                    System.out.println("Cannot start the game, there are less than two players!");
                    continue;
                }
            }
            splitInput = input.split(" ");
            handleInput(splitInput);
        }
    }

    private void handleInput(String[] splitInput){
        if(splitInput.length!=4) return;
        String arg1 = splitInput[3];
        String arg2 = splitInput[2];
        switch (splitInput[1]) {
            case "ladder" -> addLadder(arg1, arg2);
            case "snake" -> addSnake(arg1, arg2);
            case "player" -> addPlayer(splitInput[2], Color.valueOf(splitInput[3].toUpperCase()));
        }
    }

    private void addLadder(String baseString, String lengthString){
        int base = Integer.parseInt(baseString);
        int length = Integer.parseInt(lengthString);
        Ladder ladder;
        try{
            ladder = new Ladder(base, length);
        }
        catch (Exception e){
            return;
        }
        this.gameBoard.addGameObject(ladder);
    }

    private void addSnake(String baseString, String lengthString){
        int base = Integer.parseInt(baseString);
        int length = Integer.parseInt(lengthString);
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
        for (int i = 0; i< playerCount; i++) {
            if (players[i].getName().equals(name)) nameExists = true;
            if (players[i].getGamePiece().getColor() == color) colorExists = true;
        }
        if(printExists(colorExists, nameExists)) return;
        players[playerCount] = new Player(name, color);
        playerCount++;
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



    public String start()
    {
        String winner = "Lion";
        boolean play = true;
        int round = 1;
        while(play)
        {
            System.out.println("------------------------- Round number " + round + " -------------------------");
            for (int i = 0; i < playerCount; i++) {
                int rolledValue = die.roll();
                int lastLocation = players[i].getGamePiece().getLocation();
                players[i].getGamePiece().addToLocation(rolledValue);
                System.out.print(players[i].getName() + " rolled " + rolledValue + ". The path to the next square: "
                        + lastLocation + " -> "+ players[i].getGamePiece().getLocation());
                GameObject gameObject = gameBoard.getGameBoard()[players[i].getGamePiece().getLocation() - 1].getGameObject();
                while(gameObject != null) {
                    players[i].getGamePiece().setLocation(gameObject.getFinish());
                    System.out.print(" -> " + players[i].getGamePiece().getLocation());
                    gameObject = gameBoard.getGameBoard()[players[i].getGamePiece().getLocation() - 1].getGameObject();
                }
                System.out.println("");
                if(players[i].getGamePiece().getLocation() == Main.BOARD_END) {
                    winner = players[i].getName();
                    play = false;
                    break;
                }
            }
            System.out.println("");
            System.out.println("Players positions on the board:");
            for(int i =0; i<playerCount; i++){
                System.out.println(players[i].getName()+
                        " is in square number "
                        +players[i].getGamePiece().getLocation());
            }
            round++;
        }
        return winner;
    }

}
