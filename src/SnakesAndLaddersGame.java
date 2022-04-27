public class SnakesAndLaddersGame {
    private Die die;
    private Player[] players = new Player[Main.PLAYER_COUNT];
    private GameBoard gameBoard = new GameBoard(Main.BOARD_END);

    public SnakesAndLaddersGame(){
        die = new Die();
    }

    public SnakesAndLaddersGame(int lowest, int highest){
        die = new Die(lowest, highest);
    }

    public void initializeGame(){
        System.out.println("Initializing the game...");
        String input = Main.scanner.nextLine();
        String[] splitInput;
        while(input!="end"){
            splitInput = input.split(" ");
            handleInput(splitInput);
            input = Main.scanner.nextLine();
        }
    }

    private void handleInput(String[] splitInput){
        int arg1 = Integer.parseInt(splitInput[3]);
        int arg2 = Integer.parseInt(splitInput[2]);
        switch (splitInput[1]) {
            case "ladder" -> addLadder(arg1, arg2);
            case "snake" -> addSnake(arg1, arg2);
            case "player" -> addPlayer(arg1, arg2);
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

    private void addPlayer(int name, int color){
        int i;
        for (i=0; i<Main.PLAYER_COUNT; i++){

        }
        if(i == 5){
            System.out.println("The maximal number of players is five!");
        }
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
