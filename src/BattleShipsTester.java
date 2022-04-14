import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BattleShipsTester {
    public static void main(String[] args) {
        BattleShips game = new BattleShips();
        Scanner input = new Scanner(System.in);
        Random randInt = new Random();
        int xCoord = 0;
        int yCoord = 0;
        game.printBoard();

        //user will place their ships
        while(game.getPlayerShipCount()<5) {
            System.out.println("Enter the X coordinate for ship "+(game.getPlayerShipCount()+1)+": ");
            xCoord = input.nextInt();
            System.out.println("Enter the Y coordinate for ship "+(game.getPlayerShipCount()+1)+": ");
            yCoord = input.nextInt();
            //boolean inBounds = (xCoord>=0 && xCoord<=9 && yCoord>=0 && yCoord<=9);
            if(game.inBounds(xCoord,yCoord) && !game.checkCollision(xCoord,yCoord)){
                game.placePlayerShip(xCoord,yCoord);
            }
            else if(game.inBounds(xCoord,yCoord)&& game.checkCollision(xCoord,yCoord)){
                System.out.println("There is already a ship at this location.");
            }
            else {
                System.out.println("This is not a valid location.");
            }
        }
        //placing the computers ships
        System.out.println("Computer is deploying ships...");
        while(game.getCompShipCount()<5) {
            xCoord = randInt.nextInt(10);
            yCoord = randInt.nextInt(10);
            if(game.inBounds(xCoord,yCoord) && !game.checkCollision(xCoord,yCoord)){
                game.placeComputerShip(xCoord,yCoord);
                System.out.println("Computer ship "+(game.getCompShipCount())+" has been placed.");
                try {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("The computer has finished placing all of its ships.");
        System.out.println("The computer has "+game.getCompShipCount()+" ships.");
        game.printBoard();
        System.out.println("Let the battle begin!");
        //game.printBoardFull();
        /*while(game.getCompShipCount()>0 || game.getPlayerShipCount()>0) {
            int turn = game.getTurn();
            if(turn%2 == 0) {
                System.out.println("Enter the X coordinate: ");
                System.out.println("Enter the Y coordinate: ");
            }
            else{

            }
        }*/



    }
}
