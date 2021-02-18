/*
 *  Assignment Tic Tac Toe
 *  Description: X & O
 *  Name: Christian Shih
 *  ID: 921026207
 *  Class: CSC 211-04
 *  Semester: Fall 2020
 */
import java.util.Scanner;

public class TIcTacToe
{

    public static void main(String[] args)
    {

        char[][] board =
                {
                        {' ', ' ', ' '},
                        {' ', ' ', ' '},
                        {' ', ' ', ' '}
                };
        boolean gameOver = false;


        Scanner scan = new Scanner (System.in);
        int round = 0;
        while (!gameOver) {// while game is going on play rounds
            printBoard(board);
            char player = 'X';
            char player2 = 'O';

            int row = 0;
            int col = 0;
            if(round % 2 == 0)
            {
                // if even round X plays//
                System.out.println("Give me a row(0,1,2): " + player);
                row = scan.nextInt();  // row placement//

                System.out.println("Give me a col(0,1,2): " + player);
                col = scan.nextInt();  // col placement//
            }
            else
                {
                    // if odd Rounds O plays//
                System.out.println("Give me a row(0,1,2): " + player2);
                row = scan.nextInt(); // get the row from placement//

                System.out.println("Give me a col(0,1,2): " + player2);
                col = scan.nextInt(); // get the col for placement//
            }

            // check if input is valid//
            if (checkInput(board, row, col))
            {
                //put the X or O on the board//
                makeMove(board, row, col, round);
                round++; // increment round//

            }
            else
            {
                // worong placement//
                System.out.println("You've come to the wrong neighborhood");
                continue;
            }
            // check to see if game is over or not//
            gameOver = checkWinner(board, player, round);

        }
        System.out.println();
        printBoard(board);

    }


    public static void printBoard(char[][] board)
    {
// create the board//
        for (int row = 0; row < board.length; row++)
        {

            System.out.print("|");

            for (int col = 0; col < board[row].length; col++)
            {
                System.out.print(board[row][col] + " |");
            }
            System.out.println("\n---------");
        }
    }


    public static boolean checkInput(char[][] board, int row, int col)
    {
        // space=32//
        return board[row][col] == 32;
    }


    public static void makeMove(char[][] board, int row, int col, int round)
    {
        if (checkInput(board, row, col))
        {
            // if round is even X plays//
            if(round % 2 == 0) {
                board[row][col] = 'X';
            }
            else
                {
                    // round is off O plays//
                board[row][col] = 'O';
            }

        }

    }



    public static boolean checkWinner(char[][] board, char player, int round)
    {

        // Vertical Check.//
        for(int i = 0; i < board.length -2; i++)
        {
            // row - 2. to check ahead 2 more times.//
            for(int j = 0; j < board.length; j++)
            {
                if(board[i][j] == 'X' && board[i + 1][j] == 'X' && board[i + 2][j] == 'X')
                {
                    //checking all 3 vertial stops for the give col//
                    System.out.println("Player X won");
                    return true; // player won//
                }
                else if (board[i][j] == 'O' && board[i + 1][j] == 'O' && board[i + 2][j] == 'O')
                {
                    // for player O as as X//
                    System.out.println("Player O won");
                    return true; // player won//
                }
            }
        }

        // Horizontal check.//
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length -2; j++)
            {// check ahead horizontally by 2. so checking all 3 in a row.//
                if(board[i][j] == 'X' && board[i][j + 1] == 'X' && board[i][j + 2] == 'X')
                {// if 3 X in a row horizaonlly x wins.//
                    System.out.println("Player X won");
                    return true;
                }
                else if(board[i][j] == 'O' && board[i][j + 1] == 'O' && board[i][j + 2] == 'O')
                {// else O wins.//
                    System.out.println("Player O won");
                    return true;
                }
            }
        }

        // Diagonal left top to bottom right//
        if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
        {
            System.out.println("Player X won");
            return true;
        }
        if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
        {
            System.out.println("Player O won");
            return true;
        }


        // diagonal left bottom to top right.//
        if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
        {
            System.out.println("Player X won");
            return true;
        }
        if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
        {
            System.out.println("Player O won");
            return true;
        }

        if(round == 9)
        {
            // if 9 moves were made and no one wins its a tie.//
            System.out.println("Players TIE");
            return true;
        }

        return false;
    }
}