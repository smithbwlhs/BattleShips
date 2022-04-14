import java.util.Scanner;

public class BattleShips {

    private String[][] board = new String[10][10];
    private int[] userCoordinates = new int[2];
    private int numPlayerShips = 0;
    private int numCompShips = 0;
    private int turn = 0;


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
                if(board[row][col].equals("2"))
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
        if(board[y][x].equals("@")){
            return true;
        }
        return false;
    }

    /**
     * This method checks to see if the coordinate the user enters is valid
     * i.e. between 0 and 9
     *
     * @param x user x coordinate
     * @param y user y coordinate
     * @return true if the coordinate is in bounds, false otherwise
     */
    public boolean inBounds(int x, int y){
        if(x>=0 && x<=9 && y>=0 && y<=9){
            return true;
        }
        return false;
    }

    /*public void launchMissile(int x, int y){
        if(board[y][x] == )
    }*/


}