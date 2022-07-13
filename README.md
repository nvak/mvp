
## Code Test: Most Valuable Player
Tucan Tournament is a tournament where several players compete in several sports. Right  
now, the sports played are basketball and handball games. They plan to add more sports in the  
future.

You have been contacted to create a program to calculate the Most Valuable Player (MVP) of  
the tournament.

You will receive a set of CSV files, each one containing the stats of one game. Each file will start  
with a row indicating the sport it refers to.

Each player is assigned a unique nickname.  
Each file represent a single game.  
The MVP is the player with the most rating points, adding the rating points in all games.

A player will receive 10 additional rating points if their team won the game.  
Every game must have a winner team.  
One player may play in different teams and positions in different games, but not in the same  
game.

The program responsible of generating the files has a bug, that can be reflected in wrong files  
format. If one file is wrong, the whole set of files is considered to be wrong and the MVP won’t  
be calculated.
#### Basketball:
Each row will represent one player stats, with the format:  
player name;nickname;number;team name;scored points;rebounds;assists  
This table details the rating points each player in a basketball game receives:  
| Scored point | Rebound | Assist |
|--|--|--|
| 2 | 1 | 1 |

E.g. a player with 10 scored points, 5 rebounds and no assists will be granted  
25 rating points (10*2 + 5*1 + 0*1 ).  
The winner team is the one with the highest scored point.

##### Example:

    BASKETBALL  
    player 1;nick1;4;Team A;10;2;7  
    player 2;nick2;8;Team A;0;10;0  
    player 3;nick3;15;Team A;15;10;4  
    player 4;nick4;16;Team B;20;0;0  
    player 5;nick5;23;Team B;4;7;7  
    player 6;nick6;42;Team B;8;10;0  

#### Handball:
Each row will represent one player stats, with the format:  
player name;nickname;number;team name;goals made;goals received  
This table details the rating points each player in a handball game receives:  
| Goal made | Goal received |
|--|--|
| 2 | -1 |
E.g. a player scored 20 goals and his team received 7 goals will be granted 33 rating  
points (2*20 - 1*7 = 3).  
The winner team is the one with most goals made.
##### Example:

    HANDBALL  
    player 1;nick1;4;Team A;0;20  
    player 2;nick2;8;Team A;15;20  
    player 3;nick3;15;Team A;10;20  
    player 4;nick4;16;Team B;1;25  
    player 5;nick5;23;Team B;12;25  
    player 6;nick6;42;Team B;8;25  

Notes:  
We are interested in how you structure your code so to be easily extendable, complies with best  
OO practices, and is easy for others to modify / understand. **No UI or database access code is  
Needed.**  
You can use the Java programming language along with any external library you want