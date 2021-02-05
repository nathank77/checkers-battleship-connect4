package Checkers;


import javax.swing.*;

public class PlayerTurn {

    public static int friendly, enemy, friendlyKing, enemyKing;

    @SuppressWarnings("unused")
    public static void Turn(int Currentfriendly, int Currentenemy) {

        /**
         * DrawCheckerInstructions
         * Description: the turn (all logic)
         *
         * @param Currentfriendly
         * the friendly colour (black or red)
         *
         * @param Currentenemy
         * the enemy colour (black or red)
         **/

        //declaring all variables needed
        String CurrentPosition, MovePosition = null, player = null;
        int CurrentPositionX, MovePositionX = -1;
        int CurrentPositionY = 0, MovePositionY = 0;
        boolean goodCurrent = false, goodMove = false;

        friendly = Currentfriendly;
        enemy = Currentenemy;

        //objects for input dialogs
        Object[] options = {"Yes", "NO"};
        Object[] okay = {"Okay"};
        Object doubleJump, tripleJump, invalid;

        //if the friendly piece is black, initialize the variables to the following
        if (friendly == DrawGameBoard.BLACK) {

            friendly = DrawGameBoard.BLACK;
            enemy = DrawGameBoard.RED;
            friendlyKing = DrawGameBoard.BLACK_KING;
            enemyKing = DrawGameBoard.RED_KING;
            player = "Black's";
        }

        //else if the friendly piece is red, initialize the variables to the following
        else if (friendly == DrawGameBoard.RED) {

            friendly = DrawGameBoard.RED;
            enemy = DrawGameBoard.BLACK;
            friendlyKing = DrawGameBoard.RED_KING;
            enemyKing = DrawGameBoard.BLACK_KING;
            player = "Red's";
        }


        do {

            //call on GetInput methods to get the x and y of the piece the player wants to move
            CurrentPosition = GetInput.GetPositions(player);
            CurrentPositionX = GetInput.CheckersPositionX(CurrentPosition);
            CurrentPositionY = GetInput.CheckersPositionY(CurrentPosition);


            /** Basically this huge group of if statements checks to see if the current piece selected is valid
             * to be moved. They do this by using the currentX and currentY positions to see if the surrounding
             * squares are empty, and if not, if it is a piece that can be jumped. Since they move opposite ways, red
             * and black have different if blocks. Kings can move both ways, and thus have their own block as well. We
             * will leave another blue comment at the end of this so it is easy to find where it ends.
             */
            if (0 <= CurrentPositionX && CurrentPositionX <= 7) {
                if (0 <= CurrentPositionY && CurrentPositionY <= 7) {

                    //if black
                    if (DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.BLACK) {
                        if (CurrentPositionX == 0) {
                            if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                        } else if (CurrentPositionX == 7) {
                            if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                        } else if ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) || (CurrentPositionX == 0 && DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY)) {
                            goodCurrent = true;
                        } else if (CurrentPositionX == 1) {
                            if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                            break;
                        } else if (CurrentPositionX == 6) {
                            if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                            break;
                        } else if (CurrentPositionY < 6 && ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) && CurrentPositionX < 6) {
                            goodCurrent = true;
                        } else if (CurrentPositionY < 6 && ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) && CurrentPositionX > 1) {

                            goodCurrent = true;
                        }

                    }

                    //if red
                    else if (DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.RED) {
                        if (CurrentPositionX == 0) {
                            if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                        } else if (CurrentPositionX == 7) {
                            if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                        } else if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY || DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {

                            goodCurrent = true;
                        } else if (CurrentPositionX == 1) {
                            if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                            break;
                        } else if (CurrentPositionX == 6) {
                            if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                            break;
                        } else if (CurrentPositionY > 1 && ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) && CurrentPositionX < 6) {
                            goodCurrent = true;
                        } else if (CurrentPositionY > 1 && ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) && CurrentPositionX > 1) {

                            goodCurrent = true;
                        }
                    }

                    //if king
                    else if (DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.BLACK_KING || DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.RED_KING) {

                        //all red logic in here (in the bottom row, so can only move as a red piece)
                        if (CurrentPositionY == 7) {
                            if (CurrentPositionX == 0) {
                                if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                } else if ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                }
                            } else if (CurrentPositionX == 7) {
                                if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                } else if ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                }
                            } else if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY || DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {

                                goodCurrent = true;
                            } else if (CurrentPositionX == 1) {
                                if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                }
                                break;
                            } else if (CurrentPositionX == 6) {
                                if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                }
                                break;
                            } else if (CurrentPositionY > 1 && ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) && CurrentPositionX < 6) {
                                goodCurrent = true;
                            } else if (CurrentPositionY > 1 && ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) && CurrentPositionX > 1) {

                                goodCurrent = true;
                            }
                        }

                        //all black logic in here (in the top row, so can only move as a black piece)
                        else if (CurrentPositionY == 0) {
                            if (CurrentPositionX == 0) {
                                if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                } else if ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                }
                            } else if (CurrentPositionX == 7) {
                                if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                } else if ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                }
                            } else if ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) || (CurrentPositionX == 0 && DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY)) {
                                goodCurrent = true;
                            } else if (CurrentPositionX == 1) {
                                if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                }
                                break;
                            } else if (CurrentPositionX == 6) {
                                if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                    goodCurrent = true;
                                }
                                break;
                            } else if (CurrentPositionY < 6 && ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) && CurrentPositionX < 6) {
                                goodCurrent = true;
                            } else if (CurrentPositionY < 6 && ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) && CurrentPositionX > 1) {

                                goodCurrent = true;
                            }
                        }
                        //all the following applies to a king in the middle of the board, being able to move both ways
                        else if (CurrentPositionX == 0) {
                            if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                        } else if (CurrentPositionX == 7) {
                            if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemy || DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemyKing) && DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                        } else if ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) || (CurrentPositionX == 0 && DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY)) {
                            goodCurrent = true;
                        } else if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY || DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                            goodCurrent = true;
                        } else if (CurrentPositionX == 1) {
                            if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                            break;
                        } else if (CurrentPositionX == 6) {
                            if (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            } else if (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemy && DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == DrawGameBoard.EMPTY) {
                                goodCurrent = true;
                            }
                            break;
                        } else if (CurrentPositionY < 6 && ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX + 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) && CurrentPositionX < 6) {
                            goodCurrent = true;
                        } else if (CurrentPositionY < 6 && ((DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY + 1][CurrentPositionX - 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY + 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) && CurrentPositionX > 1) {

                            goodCurrent = true;
                        } else if (CurrentPositionY > 1 && ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX + 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX + 2] == DrawGameBoard.EMPTY) && CurrentPositionX < 6) {
                            goodCurrent = true;
                        } else if (CurrentPositionY > 1 && ((DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemy) || (DrawGameBoard.boardMap[CurrentPositionY - 1][CurrentPositionX - 1] == enemyKing)) && (DrawGameBoard.boardMap[CurrentPositionY - 2][CurrentPositionX - 2] == DrawGameBoard.EMPTY) && CurrentPositionX > 1) {

                            goodCurrent = true;
                        }

                    }
                }
            }

            /**
             * END IF STATEMENTS
             *
             */

            /*
             * do all of the above while the goodCurrent has not been set to true (if EVERY if statement is false, do it all again,
             * and ask for new coordinates.
             */
        } while (!goodCurrent);

        goodCurrent = false;


        do {
            goodMove = false;

            try {

                //call on GetInput methods to get the x and y of the square the player wants to move to
                MovePosition = GetInput.MovePositions(player);
                MovePositionX = GetInput.CheckersPositionX(MovePosition);
                MovePositionY = GetInput.CheckersPositionY(MovePosition);

                if (0 <= MovePositionX && MovePositionX <= 7) {

                    if (0 <= MovePositionY && MovePositionY <= 7) {

                        //this is the first of two conditions that is a valid move
                        if ((MovePositionX - CurrentPositionX == 1 || MovePositionX - CurrentPositionX == -1) && (MovePositionY - CurrentPositionY == 1 || MovePositionY - CurrentPositionY == -1)) {
                        }

                        //this is the second of two conditions that is a valid move
                        else if ((MovePositionX - CurrentPositionX == 2 || MovePositionX - CurrentPositionX == -2) && (MovePositionY - CurrentPositionY == 2 || MovePositionY - CurrentPositionY == -2)
                                && (DrawGameBoard.boardMap[(MovePositionY + CurrentPositionY) / 2][(MovePositionX + CurrentPositionX) / 2] == enemy || DrawGameBoard.boardMap[(MovePositionY + CurrentPositionY) / 2][(MovePositionX + CurrentPositionX) / 2] == enemyKing)
                        ) {
                        }

                        //else, there will be an exception thrown
                        else {
                            throw new InvalidMoveException("Not a vaild move");
                        }

                    } else {
                        throw new InvalidMoveException("Not a vaild move");
                    }
                } else {

                    throw new InvalidMoveException("Not a vaild move");
                }


                //BLACK AND KINGS
                //this if determines if there is piece in the square the user wants to move to
                if (DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.BLACK || (DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.RED_KING && (MovePositionY - CurrentPositionY > 0)) || (DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.BLACK_KING && (MovePositionY - CurrentPositionY > 0))) {

                    //same colour piece
                    if (DrawGameBoard.boardMap[MovePositionY][MovePositionX] == friendly || DrawGameBoard.boardMap[MovePositionY][MovePositionX] == friendlyKing) {
                        throw new SquareOccupiedException("Same color piece");

                    }

                    //if empty
                    else if (DrawGameBoard.boardMap[MovePositionY][MovePositionX] == DrawGameBoard.EMPTY) {

                        if ((MovePositionY - CurrentPositionY) == 1 && (((MovePositionX - CurrentPositionX) == 1) || ((MovePositionX - CurrentPositionX) == -1))) {

                            //changing the squares to represent the new state of the gameboard, and checking to see if the piece has become a king
                            DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX];
                            DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] = DrawGameBoard.EMPTY;
                            ChangeToKing.ToKing();
                            goodMove = true;
                        } else if (((MovePositionY - CurrentPositionY) == 2 && (MovePositionX - CurrentPositionX) == 2) || ((MovePositionY - CurrentPositionY) == 2 && (MovePositionX - CurrentPositionX) == -2)) {

                            //first jump to the right
                            if ((MovePositionX - CurrentPositionX) == 2) {

                                if (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX - 1] == enemy || DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX - 1] == enemyKing) {

                                    //changing the squares to represent the new state of the gameboard, and checking to see if the piece has become a king
                                    DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX];
                                    DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX - 1] = DrawGameBoard.EMPTY;
                                    DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] = DrawGameBoard.EMPTY;

//checking for double and triple jumps
                                    MultipleMoves.DownRR(MovePositionX, MovePositionY);
                                    MultipleMoves.DownRL(MovePositionX, MovePositionY);


                                    ChangeToKing.ToKing();
                                    goodMove = true;
                                }
                            }
                            // first jump to the left
                            if ((MovePositionX - CurrentPositionX) == -2) {

                                if (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX + 1] == enemy || DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX + 1] == enemyKing) {

                                    //changing the squares to represent the new state of the gameboard, and checking to see if the piece has become a king
                                    DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX];
                                    DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX + 1] = DrawGameBoard.EMPTY;
                                    DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] = DrawGameBoard.EMPTY;

                                    //checking for double and triple jumps
                                    MultipleMoves.DownLR(MovePositionX, MovePositionY);
                                    MultipleMoves.DownLL(MovePositionX, MovePositionY);

                                    ChangeToKing.ToKing();
                                    goodMove = true;
                                }
                            }
                        }
                    }

                    //enemy piece
                    else if (DrawGameBoard.boardMap[MovePositionY][MovePositionX] == enemy || DrawGameBoard.boardMap[MovePositionY][MovePositionX] == enemyKing) {

                        throw new SquareOccupiedException("Red Piece there");

                    }


                }

                //RED AND KINGS
                //this if determines if there is piece in the square the user wants to move to
                else if (DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.RED || (DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.BLACK_KING && (MovePositionY - CurrentPositionY < 0)) || (DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] == DrawGameBoard.RED_KING && (MovePositionY - CurrentPositionY < -1))) {

                    //same colour piece
                    if (DrawGameBoard.boardMap[MovePositionY][MovePositionX] == friendly || DrawGameBoard.boardMap[MovePositionY][MovePositionX] == friendlyKing) {

                        throw new SquareOccupiedException("Same color piece");

                    } else if (DrawGameBoard.boardMap[MovePositionY][MovePositionX] == DrawGameBoard.EMPTY) {

                        if ((CurrentPositionY - MovePositionY) == 1 && (((CurrentPositionX - MovePositionX) == 1) || ((CurrentPositionX - MovePositionX) == -1))) {

                            //changing the squares to represent the new state of the gameboard, and checking to see if the piece has become a king
                            DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX];
                            DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] = DrawGameBoard.EMPTY;
                            ChangeToKing.ToKing();
                            goodMove = true;
                        } else if (((CurrentPositionY - MovePositionY) == 2 && (CurrentPositionX - MovePositionX) == 2) || ((CurrentPositionY - MovePositionY) == 2 && (CurrentPositionX - MovePositionX) == -2)) {

                            //first jump to the left
                            if ((CurrentPositionX - MovePositionX) == 2) {

                                if (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX + 1] == enemy || DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX + 1] == enemyKing) {

                                    //changing the squares to represent the new state of the gameboard, and checking to see if the piece has become a king
                                    DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX];
                                    DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX + 1] = DrawGameBoard.EMPTY;
                                    DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] = DrawGameBoard.EMPTY;

//checking for double and triple jumps
                                    MultipleMoves.UpLR(MovePositionX, MovePositionY);
                                    MultipleMoves.UpLL(MovePositionX, MovePositionY);

                                    ChangeToKing.ToKing();
                                    goodMove = true;

                                }
                            }

                            //first jump to the right
                            else if ((CurrentPositionX - MovePositionX) == -2) {

                                if (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX - 1] == enemy || DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX - 1] == enemyKing) {

                                    //changing the squares to represent the new state of the gameboard, and checking to see if the piece has become a king
                                    DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX];
                                    DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX - 1] = DrawGameBoard.EMPTY;
                                    DrawGameBoard.boardMap[CurrentPositionY][CurrentPositionX] = DrawGameBoard.EMPTY;

                                    //checking for double and triple jumps
                                    MultipleMoves.UpRR(MovePositionX, MovePositionY);
                                    MultipleMoves.UpRL(MovePositionX, MovePositionY);

                                    ChangeToKing.ToKing();
                                    goodMove = true;
                                }
                            }
                        }
                    }

                    //enemy piece
                    else if (DrawGameBoard.boardMap[MovePositionY][MovePositionX] == enemy || DrawGameBoard.boardMap[MovePositionY][MovePositionX] == enemyKing) {
                        throw new SquareOccupiedException("Black Piece there");

                    }
                }
            }

            //catch for invalid moves
            catch (InvalidMoveException e) {

                System.out.println(e);

                //tells the user what they did wrong
                invalid = JOptionPane.showOptionDialog(null, "Not a vaild move", "Not a vaild move", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            }

            //catch for square occupied
            catch (SquareOccupiedException f) {
                System.out.println(f);

                //tells the user what they did wrong
                invalid = JOptionPane.showOptionDialog(null, "Square Occupied!", "Square Occupied!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            }
        }

        //do all of the above while there has not been a good move made
        while (!goodMove);


        //check for kings
        ChangeToKing.ToKing();

    }
}
