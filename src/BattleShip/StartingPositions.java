package BattleShip;

/**
 * StartingPositions.java
 * Description: Gets the starting locations of the player and computer ships
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/

public class StartingPositions {


    // global variables of the ships locations and orientations to be used to check if the ships are hit or not 
    public static int BattleShipOrientation = -1;
    public static int[] CruiserOrientation = {-1, -1};
    public static int[] DestroyerOrientation = {-1, -1, -1};
    public static int SubmarineOrientation = 0;

    public static int BattleShipPositionX = -1;
    public static int[] CruiserPositionX = {-1, -1};
    public static int[] DestroyerPositionX = {-1, -1, -1};
    public static int[] SubmarinePositionX = {-1, -1, -1, -1};

    public static int BattleShipPositionY = -1;
    public static int[] CruiserPositionY = {-1, -1};
    public static int[] DestroyerPositionY = {-1, -1, -1};
    public static int[] SubmarinePositionY = {-1, -1, -1, -1};


    public static int CompBattleShipOrientation;
    public static int[] CompCruiserOrientation = {-1, -1};
    public static int[] CompDestroyerOrientation = {-1, -1, -1};

    public static int CompBattleShipPositionX;
    public static int[] CompCruiserPositionX = {-1, -1};
    public static int[] CompDestroyerPositionX = {-1, -1, -1};
    public static int[] CompSubmarinePositionX = {-1, -1, -1, -1};

    public static int CompBattleShipPositionY;
    public static int[] CompCruiserPositionY = {-1, -1};
    public static int[] CompDestroyerPositionY = {-1, -1, -1};
    public static int[] CompSubmarinePositionY = {-1, -1, -1, -1};

    public static boolean playerDone = false;

    public static void GetPLayerLoctaions() {
        /**
         * GetPLayerLoctaions Description: Gets the user to input cord and then assigns the cord on the boardMap 
         * 					               to 1 to show that a ship is there. 
         **/


        //starting variables like amount of ships and the names and defining all orientations and cords as -1 so no problems occur
        final int NUM_OF_BATTLESHIP = 1, NUM_OF_CRUISER = 2, NUM_OF_DESTRTOYER = 3, NUM_OF_SUBMARINE = 4;

        final String Submarine[] = {"Submarine 1", "Submarine 2", "Submarine 3", "Submarine 4"};
        final String Destroyer[] = {"Destroyer 1", "Destroyer 2", "Destroyer 3"};
        final String Cruiser[] = {"Cruiser 1", "Cruiser 2"};
        final String Battleship = "Battleship";

        int BattleShipO = -1;
        int[] CruiserO = {-1, -1};
        int[] DestroyerO = {-1, -1, -1};

        int BattleShipX = -1;
        int[] CruiserX = {-1, -1};
        int[] DestroyerX = {-1, -1, -1};
        int[] SubmarineX = {-1, -1, -1, -1};

        int BattleShipY = -1;
        int[] CruiserY = {-1, -1};
        int[] DestroyerY = {-1, -1, -1};
        int[] SubmarineY = {-1, -1, -1, -1};


        String Position;
        boolean enoughRoom = false;

        //runs for amount of battleships 
        for (int i = 0; i < NUM_OF_BATTLESHIP; i++) {

            //does this processes until all conditions are meet
            do {
                //gets input then converts to int
                enoughRoom = false;
                BattleShipO = GetInput.GetOrientation(Battleship);
                Position = GetInput.GetPositions(Battleship);
                BattleShipX = GetInput.BoatPositionX(Position);
                BattleShipY = GetInput.BoatPositionY(Position);

                //makes sure the x cord is between 0-9
                if (0 <= BattleShipX && BattleShipX < 10) {

                    //makes sure the y cord is between 0-9
                    if (0 <= BattleShipY && BattleShipY < 10) {

                        //makes sure there is enough room for the ship vrt
                        if (BattleShipO == 1 && (BattleShipY + 3) < 10) {

                            //makes sure the location is empty 
                            if (DrawGameBoard.boardMap[BattleShipY][BattleShipX] == 0 && DrawGameBoard.boardMap[(BattleShipY + 1)][BattleShipX] == 0 && DrawGameBoard.boardMap[(BattleShipY + 2)][BattleShipX] == 0 && DrawGameBoard.boardMap[(BattleShipY + 3)][BattleShipX] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawGameBoard.boardMap[BattleShipY][BattleShipX] = 1;
                                DrawGameBoard.boardMap[(BattleShipY + 1)][BattleShipX] = 1;
                                DrawGameBoard.boardMap[(BattleShipY + 2)][BattleShipX] = 1;
                                DrawGameBoard.boardMap[(BattleShipY + 3)][BattleShipX] = 1;
                                enoughRoom = true;
                            }
                        }
                        //makes sure there is enough room for the ship hor 
                        else if (BattleShipO == 0 && (BattleShipX + 3) < 10) {

                            //makes sure the location is empty 
                            if (DrawGameBoard.boardMap[BattleShipY][BattleShipX] == 0 && DrawGameBoard.boardMap[BattleShipY][(BattleShipX + 1)] == 0 && DrawGameBoard.boardMap[BattleShipY][(BattleShipX + 2)] == 0 && DrawGameBoard.boardMap[BattleShipY][(BattleShipX + 3)] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawGameBoard.boardMap[BattleShipY][BattleShipX] = 1;
                                DrawGameBoard.boardMap[BattleShipY][(BattleShipX + 1)] = 1;
                                DrawGameBoard.boardMap[BattleShipY][(BattleShipX + 2)] = 1;
                                DrawGameBoard.boardMap[BattleShipY][(BattleShipX + 3)] = 1;
                                enoughRoom = true;
                            }
                        }
                    }
                }
            }
            while (!enoughRoom);
        }

        Position = "";
        enoughRoom = false;


        //runs for amount of Cruiser 
        for (int i = 0; i < NUM_OF_CRUISER; i++) {

            //does this processes until all conditions are meet
            do {

                //gets input then converts to int
                enoughRoom = false;
                CruiserO[i] = GetInput.GetOrientation(Cruiser[i]);
                Position = GetInput.GetPositions(Cruiser[i]);
                CruiserX[i] = GetInput.BoatPositionX(Position);
                CruiserY[i] = GetInput.BoatPositionY(Position);

                //makes sure the x cord is between 0-9
                if (0 <= CruiserX[i] && CruiserX[i] < 10) {

                    //makes sure the y cord is between 0-9
                    if (0 <= CruiserY[i] && CruiserY[i] < 10) {

                        //makes sure there is enough room for the ship vrt
                        if (CruiserO[i] == 1 && (CruiserY[i] + 2) < 10) {

                            //makes sure the location is empty 
                            if (DrawGameBoard.boardMap[CruiserY[i]][CruiserX[i]] == 0 && DrawGameBoard.boardMap[(CruiserY[i] + 1)][CruiserX[i]] == 0 && DrawGameBoard.boardMap[(CruiserY[i] + 2)][CruiserX[i]] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawGameBoard.boardMap[CruiserY[i]][CruiserX[i]] = 1;
                                DrawGameBoard.boardMap[(CruiserY[i] + 1)][CruiserX[i]] = 1;
                                DrawGameBoard.boardMap[(CruiserY[i] + 2)][CruiserX[i]] = 1;
                                enoughRoom = true;
                            }
                        }
                        //makes sure there is enough room for the ship hor
                        else if (CruiserO[i] == 0 && (CruiserX[i] + 2) < 10) {

                            //makes sure the location is empty 
                            if (DrawGameBoard.boardMap[CruiserY[i]][CruiserX[i]] == 0 && DrawGameBoard.boardMap[CruiserY[i]][(CruiserX[i] + 1)] == 0 && DrawGameBoard.boardMap[CruiserY[i]][(CruiserX[i] + 2)] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawGameBoard.boardMap[CruiserY[i]][CruiserX[i]] = 1;
                                DrawGameBoard.boardMap[CruiserY[i]][(CruiserX[i] + 1)] = 1;
                                DrawGameBoard.boardMap[CruiserY[i]][(CruiserX[i] + 2)] = 1;
                                enoughRoom = true;
                            }
                        }
                    }
                }

                Position = "";
            }
            while (!enoughRoom);
        }

        Position = "";
        enoughRoom = false;

        //runs for amount of Destroyer 
        for (int i = 0; i < NUM_OF_DESTRTOYER; i++) {

            //does this processes until all conditions are meet
            do {

                //gets input then converts to int
                enoughRoom = false;
                DestroyerO[i] = GetInput.GetOrientation(Destroyer[i]);
                Position = GetInput.GetPositions(Destroyer[i]);
                DestroyerX[i] = GetInput.BoatPositionX(Position);
                DestroyerY[i] = GetInput.BoatPositionY(Position);

                //makes sure the x cord is between 0-9
                if (0 <= DestroyerX[i] && DestroyerX[i] < 10) {

                    //makes sure the y cord is between 0-9
                    if (0 <= DestroyerY[i] && DestroyerY[i] < 10) {

                        //makes sure there is enough room for the ship vrt
                        if (DestroyerO[i] == 1 && (DestroyerY[i] + 1) < 10) {

                            //makes sure the location is empty 
                            if (DrawGameBoard.boardMap[DestroyerY[i]][DestroyerX[i]] == 0 && DrawGameBoard.boardMap[(DestroyerY[i] + 1)][DestroyerX[i]] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawGameBoard.boardMap[DestroyerY[i]][DestroyerX[i]] = 1;
                                DrawGameBoard.boardMap[(DestroyerY[i] + 1)][DestroyerX[i]] = 1;
                                enoughRoom = true;
                            }
                        }
                        //makes sure there is enough room for the ship hor
                        else if (DestroyerO[i] == 0 && (DestroyerX[i] + 1) < 10) {

                            //makes sure the location is empty 
                            if (DrawGameBoard.boardMap[DestroyerY[i]][DestroyerX[i]] == 0 && DrawGameBoard.boardMap[DestroyerY[i]][(DestroyerX[i] + 1)] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawGameBoard.boardMap[DestroyerY[i]][DestroyerX[i]] = 1;
                                DrawGameBoard.boardMap[DestroyerY[i]][(DestroyerX[i] + 1)] = 1;
                                enoughRoom = true;
                            }
                        }
                    }
                }
                Position = "";
            }
            while (!enoughRoom);
        }

        Position = "";
        enoughRoom = false;

        //runs for amount of Submarine 
        for (int i = 0; i < NUM_OF_SUBMARINE; i++) {

            //does this processes until all conditions are meet
            do {

                //gets input then converts to int
                enoughRoom = false;
                Position = GetInput.GetPositions(Submarine[i]);
                SubmarineX[i] = GetInput.BoatPositionX(Position);
                SubmarineY[i] = GetInput.BoatPositionY(Position);

                //makes sure the x cord is between 0-9
                if (0 <= SubmarineX[i] && SubmarineX[i] < 10) {

                    //makes sure the y cord is between 0-9
                    if (0 <= SubmarineY[i] && SubmarineY[i] < 10) {

                        //makes sure the location is empty 
                        if (DrawGameBoard.boardMap[SubmarineY[i]][SubmarineX[i]] == 0) {

                            //changes boardMap to 1 to show ship is there 
                            DrawGameBoard.boardMap[SubmarineY[i]][SubmarineX[i]] = 1;
                            enoughRoom = true;
                        }
                    }
                }

                Position = "";
            }
            while (!enoughRoom);
        }

        Position = "";
        enoughRoom = false;


        //sets global variables to correct numbers for locations and orientations 
        BattleShipOrientation = BattleShipO;
        CruiserOrientation[0] = CruiserO[0];
        CruiserOrientation[1] = CruiserO[1];
        DestroyerOrientation[0] = DestroyerO[0];
        DestroyerOrientation[1] = DestroyerO[1];
        DestroyerOrientation[2] = DestroyerO[2];

        BattleShipPositionX = BattleShipX;
        CruiserPositionX[0] = CruiserX[0];
        CruiserPositionX[1] = CruiserX[1];
        DestroyerPositionX[0] = DestroyerX[0];
        DestroyerPositionX[1] = DestroyerX[1];
        DestroyerPositionX[2] = DestroyerX[2];
        SubmarinePositionX[0] = SubmarineX[0];
        SubmarinePositionX[1] = SubmarineX[1];
        SubmarinePositionX[2] = SubmarineX[2];
        SubmarinePositionX[3] = SubmarineX[3];

        BattleShipPositionY = BattleShipY;
        CruiserPositionY[0] = CruiserY[0];
        CruiserPositionY[1] = CruiserY[1];
        DestroyerPositionY[0] = DestroyerY[0];
        DestroyerPositionY[1] = DestroyerY[1];
        DestroyerPositionY[2] = DestroyerY[2];
        SubmarinePositionY[0] = SubmarineY[0];
        SubmarinePositionY[1] = SubmarineY[1];
        SubmarinePositionY[2] = SubmarineY[2];
        SubmarinePositionY[3] = SubmarineY[3];

        playerDone = true;
    }

    public static void GetCompLoctaions() {
        /**
         * GetCompLoctaions Description: it gets two random numbers between 0-9 and uses one as the x and y cord to assign ships locations.  
         **/

        //starting variables like amount of ships
        final int NUM_OF_BATTLESHIP = 1, NUM_OF_CRUISER = 2, NUM_OF_DESTRTOYER = 3, NUM_OF_SUBMARINE = 4;
        boolean enoughRoom = false;

        //runs for amount of battleship 
        for (int i = 0; i < NUM_OF_BATTLESHIP; i++) {

            //does this processes until all conditions are meets
            do {

                //gets random numbers to use for orientation and x/y cords 
                enoughRoom = false;
                CompBattleShipOrientation = (int) (Math.random() * 2);
                CompBattleShipPositionX = (int) (Math.random() * 10);
                CompBattleShipPositionY = (int) (Math.random() * 10);

                //makes sure the x cord is between 0-9
                if (0 <= CompBattleShipPositionX && CompBattleShipPositionX < 10) {

                    //makes sure the y cord is between 0-9
                    if (0 <= CompBattleShipPositionY && CompBattleShipPositionY < 10) {

                        //makes sure there is enough room for the ship vrt
                        if (CompBattleShipOrientation == 1 && (CompBattleShipPositionY + 3) < 10) {

                            //makes sure the location is empty 
                            if (DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][CompBattleShipPositionX] == 0 && DrawTargetBoard.enemyboardMap[(CompBattleShipPositionY + 1)][CompBattleShipPositionX] == 0 && DrawTargetBoard.enemyboardMap[(CompBattleShipPositionY + 2)][CompBattleShipPositionX] == 0 && DrawTargetBoard.enemyboardMap[(CompBattleShipPositionY + 3)][CompBattleShipPositionX] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][CompBattleShipPositionX] = 1;
                                DrawTargetBoard.enemyboardMap[(CompBattleShipPositionY + 1)][CompBattleShipPositionX] = 1;
                                DrawTargetBoard.enemyboardMap[(CompBattleShipPositionY + 2)][CompBattleShipPositionX] = 1;
                                DrawTargetBoard.enemyboardMap[(CompBattleShipPositionY + 3)][CompBattleShipPositionX] = 1;
                                enoughRoom = true;

                            }
                        }
                        //makes sure there is enough room for the ship hor
                        else if (CompBattleShipOrientation == 0 && (CompBattleShipPositionX + 3) < 10) {

                            //makes sure the location is empty 
                            if (DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][CompBattleShipPositionX] == 0 && DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][(CompBattleShipPositionX + 1)] == 0 && DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][(CompBattleShipPositionX + 2)] == 0 && DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][(CompBattleShipPositionX + 3)] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][CompBattleShipPositionX] = 1;
                                DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][(CompBattleShipPositionX + 1)] = 1;
                                DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][(CompBattleShipPositionX + 2)] = 1;
                                DrawTargetBoard.enemyboardMap[CompBattleShipPositionY][(CompBattleShipPositionX + 3)] = 1;
                                enoughRoom = true;
                            }
                        }
                    }
                }
            }
            while (!enoughRoom);
        }


        enoughRoom = false;

        //runs for amount of cruisers 
        for (int i = 0; i < NUM_OF_CRUISER; i++) {

            //does this processes until all conditions are meets
            do {

                //gets random numbers to use for orientation and x/y cords 
                enoughRoom = false;
                CompCruiserOrientation[i] = (int) (Math.random() * 2);
                CompCruiserPositionX[i] = (int) (Math.random() * 10);
                CompCruiserPositionY[i] = (int) (Math.random() * 10);

                //makes sure the x cord is between 0-9
                if (0 <= CompCruiserPositionX[i] && CompCruiserPositionX[i] < 10) {

                    //makes sure the y cord is between 0-9
                    if (0 <= CompCruiserPositionY[i] && CompCruiserPositionY[i] < 10) {

                        //makes sure there is enough room for the ship vrt
                        if (CompCruiserOrientation[i] == 1 && (CompCruiserPositionY[i] + 2) < 10) {

                            //makes sure the location is empty 
                            if (DrawTargetBoard.enemyboardMap[CompCruiserPositionY[i]][CompCruiserPositionX[i]] == 0 && DrawTargetBoard.enemyboardMap[(CompCruiserPositionY[i] + 1)][CompCruiserPositionX[i]] == 0 && DrawTargetBoard.enemyboardMap[(CompCruiserPositionY[i] + 2)][CompCruiserPositionX[i]] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawTargetBoard.enemyboardMap[CompCruiserPositionY[i]][CompCruiserPositionX[i]] = 1;
                                DrawTargetBoard.enemyboardMap[(CompCruiserPositionY[i] + 1)][CompCruiserPositionX[i]] = 1;
                                DrawTargetBoard.enemyboardMap[(CompCruiserPositionY[i] + 2)][CompCruiserPositionX[i]] = 1;
                                enoughRoom = true;
                            }
                        }
                        //makes sure there is enough room for the ship hor
                        else if (CompCruiserOrientation[i] == 0 && (CompCruiserPositionX[i] + 2) < 10) {

                            //makes sure the location is empty 
                            if (DrawTargetBoard.enemyboardMap[CompCruiserPositionY[i]][CompCruiserPositionX[i]] == 0 && DrawTargetBoard.enemyboardMap[CompCruiserPositionY[i]][(CompCruiserPositionX[i] + 1)] == 0 && DrawTargetBoard.enemyboardMap[CompCruiserPositionY[i]][(CompCruiserPositionX[i] + 2)] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawTargetBoard.enemyboardMap[CompCruiserPositionY[i]][CompCruiserPositionX[i]] = 1;
                                DrawTargetBoard.enemyboardMap[CompCruiserPositionY[i]][(CompCruiserPositionX[i] + 1)] = 1;
                                DrawTargetBoard.enemyboardMap[CompCruiserPositionY[i]][(CompCruiserPositionX[i] + 2)] = 1;
                                enoughRoom = true;
                            }
                        }
                    }
                }
            }
            while (!enoughRoom);
        }

        enoughRoom = false;

        //runs for amount of Destroyer 
        for (int i = 0; i < NUM_OF_DESTRTOYER; i++) {

            //does this processes until all conditions are meets
            do {
                //gets random numbers to use for orientation and x/y cords 
                enoughRoom = false;
                CompDestroyerOrientation[i] = (int) (int) (Math.random() * 2);
                CompDestroyerPositionX[i] = (int) (Math.random() * 10);
                CompDestroyerPositionY[i] = (int) (Math.random() * 10);

                //makes sure the x cord is between 0-9
                if (0 <= CompDestroyerPositionX[i] && CompDestroyerPositionX[i] < 10) {

                    //makes sure the y cord is between 0-9
                    if (0 <= CompDestroyerPositionY[i] && CompDestroyerPositionY[i] < 10) {

                        //makes sure there is enough room for the ship vrt
                        if (CompDestroyerOrientation[i] == 1 && (CompDestroyerPositionY[i] + 1) < 10) {

                            //makes sure the location is empty 
                            if (DrawTargetBoard.enemyboardMap[CompDestroyerPositionY[i]][CompDestroyerPositionX[i]] == 0 && DrawTargetBoard.enemyboardMap[(CompDestroyerPositionY[i] + 1)][CompDestroyerPositionX[i]] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawTargetBoard.enemyboardMap[CompDestroyerPositionY[i]][CompDestroyerPositionX[i]] = 1;
                                DrawTargetBoard.enemyboardMap[(CompDestroyerPositionY[i] + 1)][CompDestroyerPositionX[i]] = 1;
                                enoughRoom = true;
                            }
                        }
                        //makes sure there is enough room for the ship hor
                        else if (CompDestroyerOrientation[i] == 0 && (CompDestroyerPositionX[i] + 1) < 10) {

                            //makes sure the location is empty 
                            if (DrawTargetBoard.enemyboardMap[CompDestroyerPositionY[i]][CompDestroyerPositionX[i]] == 0 && DrawTargetBoard.enemyboardMap[CompDestroyerPositionY[i]][(CompDestroyerPositionX[i] + 1)] == 0) {

                                //changes boardMap to 1 to show ship is there 
                                DrawTargetBoard.enemyboardMap[CompDestroyerPositionY[i]][CompDestroyerPositionX[i]] = 1;
                                DrawTargetBoard.enemyboardMap[CompDestroyerPositionY[i]][(CompDestroyerPositionX[i] + 1)] = 1;
                                enoughRoom = true;
                            }
                        }
                    }
                }
            }
            while (!enoughRoom);
        }

        enoughRoom = false;

        //runs for amount of Submarine 
        for (int i = 0; i < NUM_OF_SUBMARINE; i++) {

            //does this processes until all conditions are meets
            do {
                //gets random numbers to use for orientation and x/y cords 
                enoughRoom = false;
                CompSubmarinePositionX[i] = (int) (Math.random() * 10);
                CompSubmarinePositionY[i] = (int) (Math.random() * 10);

                //makes sure the x cord is between 0-9
                if (0 <= CompSubmarinePositionX[i] && CompSubmarinePositionX[i] < 10) {

                    //makes sure the y cord is between 0-9
                    if (0 <= CompSubmarinePositionY[i] && CompSubmarinePositionY[i] < 10) {

                        //makes sure the location is empty 
                        if (DrawTargetBoard.enemyboardMap[CompSubmarinePositionY[i]][CompSubmarinePositionX[i]] == 0) {

                            //changes boardMap to 1 to show ship is there 
                            DrawTargetBoard.enemyboardMap[CompSubmarinePositionY[i]][CompSubmarinePositionX[i]] = 1;
                            enoughRoom = true;
                        }
                    }
                }
            }
            while (!enoughRoom);
        }
    }
}