/*
Controls all of the parts of the game.
In charge of initializing the game,
and making sure the game runs correctly.
 */
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

    //Initializes the game - creates the players, the game board and its parts.
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
        sortPlayers(players, 0 , playerCount - 1);
    }

    //Handles the given input from the user about the game
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

    //Adds a ladder to the board with a given location and length
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

    //Adds a snake to the board with a given location and length
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

    //Adds a player to the list of players with the given attributes(name, color) if possible
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

    //Prints messages to the user
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

    //Merges two sorted arrays
    void merge(Player arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Create temp arrays */
        Player L[] = new Player[n1];
        Player R[] = new Player[n2];
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getName().compareTo(R[j].getName()) < 0) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Sorts the players array alphabetically
    void sortPlayers(Player arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
            // Sort first and second halves
            sortPlayers(arr, l, m);
            sortPlayers(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    //Starts the game and plays through it
    public String start()
    {
        String winner = "Lion";
        boolean play = true;
        int round = 1;
        while(play)
        {
            System.out.println("------------------------- Round number " + round + " -------------------------");
            for (int i = 0; i < playerCount; i++) {
                //Moves the player according to the dice roll
                int rolledValue = die.roll();
                int lastLocation = players[i].getGamePiece().getLocation();
                players[i].getGamePiece().addToLocation(rolledValue);
                System.out.print(players[i].getName() + " rolled " + rolledValue + ". The path to the next square: "
                        + lastLocation + " -> "+ players[i].getGamePiece().getLocation());
                GameObject gameObject = gameBoard.getGameBoard()[players[i].getGamePiece().getLocation() - 1].getGameObject();
                //Checks if the piece reached a square that has a ladder's base or a snake's head
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
