# RoboRally by team R.T.I.T.N.E.404.T.N.N.F [![CI](https://github.com/inf112-v21/Runtime-Terror-Import-Team_Name-Error-404-Team-Name-Not-Found/actions/workflows/maven.yml/badge.svg)](https://github.com/inf112-v21/Runtime-Terror-Import-Team_Name-Error-404-Team-Name-Not-Found/actions/workflows/maven.yml)
This is a student project in the class INF 112 where we are set to make a digital version of the board-game RoboRally.
To do this we are using libgdx and Tilded.


## Build and run

Follow these steps to run the game.

1. Clone the repository: ```git clone https://github.com/inf112-v21/Runtime-Terror-Import-Team_Name-Error-404-Team-Name-Not-Found.git```
2. Open the project in IntelliJ or similar program.
3. Run the program from the main methode in the Main class using the play-button in the top right or to the left of the methode.

## How to play
To play the game you press the "play" button on the title screen that comes up after you have built the game.

You move around by using the arrow keys or A,W,S,D keys

You can use the game cards by using the number row from 1-7

The goal is at this moment in development to get to any flag to win, but be careful if you set on a hole you die.

## Known bugs
When you resize the window from the default 1000x1000 pixels the buttons don't work as expected.
The click handler for the buttons are defined absolutely with regard to the windows origin and
therefore don't resize properly. See issue [#41](https://github.com/inf112-v21/Runtime-Terror-Import-Team_Name-Error-404-Team-Name-Not-Found/issues/41).

## Fixed bugs
nullpointerexception bug when closing the program, cant dispose properly (Fixed 2021-03-05) 
