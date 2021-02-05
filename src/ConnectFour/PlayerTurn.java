package ConnectFour;

/**
 * PlayerTurn.java
 * Description: All of the logic executed on each player's turn
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/

public class PlayerTurn {

    //variables for red and blue pieces locations
    public static int RedCol, RedRow, BlueCol, BlueRow;

    public static void RedTurn() {

        /**
         * RedTurn
         * Description: the red turn
         **/

        //declaring all variables needed
        String RedMove;
        int RedPosition;
        boolean RedGood = false;

        do {

            //call on GetInput methods to get column the user wants to put the piece in
            RedMove = GetInput.GetPositions("Red's Turn");
            RedPosition = GetInput.ColumnPosition(RedMove);
            RedCol = RedPosition;

        }

        //do it over and over until the piece is between 0 and 6 (a good move)
        while (RedPosition < 0 || RedPosition > 6);

        do {
            //for loop that checks places the piece at the bottom-most possible location in the column
            for (int i = 5; i >= 0 && !RedGood; i--) {

                if (DrawGameBoard.boardMap[i][RedPosition] == 0) {

                    //updates the board map to reflect the move
                    DrawGameBoard.boardMap[i][RedPosition] = 1;
                    RedGood = true;
                    RedRow = i;
                    break;

                }

                //if the column is full, ask the user to enter the column again
                else if (i == 0) {

                    do {
                        RedMove = GetInput.GetPositions("Red's Turn");
                        RedPosition = GetInput.ColumnPosition(RedMove);
                        RedCol = RedPosition;
                    } while (RedPosition < 0 || RedPosition > 6);
                }
            }

            //do until the piece has found a location
        } while (!RedGood);


    }


    public static void BlueTurn() {

        /**
         * BlueTurn
         * Description: the blue turn
         **/

        //declaring all variables needed
        String BlueMove;
        int BluePosition;
        boolean BlueGood = false;

        do {

            //call on GetInput methods to get column the user wants to put the piece in
            BlueMove = GetInput.GetPositions("Blue's Turn");
            BluePosition = GetInput.ColumnPosition(BlueMove);

            BlueCol = BluePosition;

        }
        //do it over and over until the piece is between 0 and 6 (a good move)
        while (BluePosition < 0 || BluePosition > 6);


        do {
            //for loop that checks places the piece at the bottom-most possible location in the column
            for (int i = 5; i >= 0 && !BlueGood; i--) {

                if (DrawGameBoard.boardMap[i][BluePosition] == 0) {

                    //updates the board map to reflect the move
                    DrawGameBoard.boardMap[i][BluePosition] = 2;
                    BlueGood = true;

                    BlueRow = i;
                }

                //if the column is full, ask the user to enter the column again
                else if (i == 0) {
                    do {
                        BlueMove = GetInput.GetPositions("Blue's Turn");
                        BluePosition = GetInput.ColumnPosition(BlueMove);
                        BlueCol = BluePosition;
                    } while (BluePosition < 0 || BluePosition > 6);
                }


            }
        } while (!BlueGood);
    }

    ;


}



