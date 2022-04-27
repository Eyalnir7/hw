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

}
