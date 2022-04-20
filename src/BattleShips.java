import java.util.Random;

public class BattleShips {

    private String[][] board = new String[10][10];
    private int[] userCoordinates = new int[2];
    private int numPlayerShips = 0;
    private int numCompShips = 0;
    private int turn = 0; //even numbers are player's turn
    private Random randInt = new Random();


    /**
     * Constructor
     */
    public BattleShips(){
        board = new String[][] {
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "}
        };
    }

    public void printBoardFull(){
        System.out.println("   0123456789");
        for(int row = 0; row<board.length;row++){
            System.out.print(row+" |");
            for(int col = 0; col<board[row].length; col++){
                    System.out.print(board[row][col]);
            }
            System.out.println("| "+row);
        }
        System.out.println("   0123456789");
    }
    /**
     * Prints the formatted board
     */
    public void printBoard(){
        System.out.println("   0123456789");
        for(int row = 0; row<board.length;row++){
            System.out.print(row+" |");
            for(int col = 0; col<board[row].length; col++){
                if(board[row][col].equals("2") /*|| board[row][col].equals("+")*/)
                    System.out.print(" ");
                else if(board[row][col].equals("1")) {
                    System.out.print("@");
                }
                else{
                    System.out.print(board[row][col]);
                }
            }
            System.out.println("| "+row);
        }
        System.out.println("   0123456789");
    }

    /**
     * Getter for the board
     * @return returns a 2D array representing the battelship board
     */
    public String[][] getBoard(){
        return board;
    }
    /**
     * Places a player ship in the board at the specified coordinate.
     * @param x x coordinate of ship
     * @param y y coordinate of ship
     */
    public void placePlayerShip(int x, int y){
        board[y][x] = "1"; //had to switch row, column to match x being horizontal and y being vertical
        this.printBoard();
        System.out.println("You placed a ship at "+"("+x+" , "+y+").");
        numPlayerShips++;
    }

    /**
     * This method places the computers ships on the board at the provided x and y coordinates.
     * Note that we have to switch x,y in the array to account for x being horizontal and y
     * being vertical
     * @param x x coordinate of computer ship
     * @param y y coordinate of computer ship
     */
    public void placeComputerShip(int x, int y){
        board[y][x] = "2";
        numCompShips++;
    }
    /**
     * Getter method for player ships
     * @return the number of ships the player has placed
     */
    public int getPlayerShipCount(){
        return numPlayerShips;
    }

    /**
     * Getter that returns the number of ships the computer has placed
     * @return the number of ships the computer has placed
     */
    public int getCompShipCount(){ return numCompShips;}

    /**
     * Getter method to return the number of turns that have taken place. Used to
     * track whose turn it is. Even is player, odd is computer.
     *
     * @return number of turns
     */
    public int getTurn(){return turn;}
    /**
     *
     * This method checks to see if a user has entered a coordinate that
     * already has a ship
     * @param x x coordinate
     * @param y y coordinate
     * @return true is there is a ship already there, false if not
     */
    public boolean checkCollision(int x, int y){
        if(board[y][x].equals("1")||board[y][x].equals("2")){
            return true;
        }
        return false;
    }

    /**
     * This method checks to see if the coordinate the user enters is valid
     * i.e. between 0 and 9. It was merged into the validMove method
     *
     * @param x user x coordinate
     * @param y user y coordinate
     * @return true if the coordinate is in bounds, false otherwise
     */
    /*public boolean inBounds(int x, int y){
        if(x>=0 && x<=9 && y>=0 && y<=9){
            return true;
        }
        return false;
    }*/

    public boolean validMove(int x, int y){
        if(board[y][x].equals("-")||board[y][x].equals("+")||board[y][x].equals("!")||board[y][x].equals("x")){
            if(turn%2 == 0){
                System.out.println("This is not a valid move.");
                return false;
            }
        }
        if(x<0 || x>9 || y<0 || y>9){
            return true;
        }
        return false;
    }

    public void launchPlayerMissile(int x, int y){
        if(board[y][x].equals("1")){
            System.out.println("Oh no, you sunk your own ship :(");
            board[y][x] = "x";
            numPlayerShips--;
            turn++;
        }
        else if(board[y][x].equals("2")){
            System.out.println("Boom! You sunk the ship");
            board[y][x] = "!";
            numCompShips--;
            turn++;
        }
        else{
            System.out.println("Sorry, you missed");
            board[y][x] = "-";
            turn++;
        }
    }

    public void launchComputerMissile(int x, int y){
        if(board[y][x].equals("2")){
            System.out.println("The computer sunk one of its own ships");
            board[y][x] = "!";
            numCompShips--;
            turn++;
        }
        else if(board[y][x].equals("1")){
            System.out.println("The computer sunk your ship");
            board[y][x] = "x";
            numPlayerShips--;
            turn++;
        }
        else if(board[y][x].equals("+")){
            launchComputerMissile(randInt.nextInt(10),randInt.nextInt(10));
        }
        else{
            System.out.println("Computer missed");
            board[y][x] = "+";
            turn++;
        }
    }


}
