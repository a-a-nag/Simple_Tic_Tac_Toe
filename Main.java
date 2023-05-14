import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            
        String[][] grid = new String[5][9];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                /* Top and bottom line (---------) */
                if (i == 0 || i == 4) {
                    grid[i][j] = "-";
                }

                /* Pipe symbol (|) to the beginning and end of each line of the grid */
                if (i > 0 && i < 4 && (j == 0 || j == 8)) {
                    grid[i][j] = "|";
                }

                /* Spaces between X and O */
                if (i > 0 && i < 4 && j % 2 != 0) {
                    grid[i][j] = " ";
                }

                /* Place empty */
                if (i > 0 && i < 4 && j > 0 && j < 8 && j % 2 == 0) {
                    grid[i][j] = " ";
                }
            }
        }

        for (String[] subgrid : grid) {
            for (String elem : subgrid) {
                System.out.print(elem);
            }
            System.out.println();
        }

        for (int g = 0; g < 9; g++) {
            
            while (true) {
                try {
                    int input1 = scanner.nextInt();
                    int input2 = scanner.nextInt();
                    
                    if (input1 < 1 || input1 > 3 || input2 < 1 || input2 > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else {
                        if (input2 == 1) {
                            input2 += 1;
                        } else if (input2 == 2) {
                            input2 += 2;
                        } else {
                            input2 += 3;
                        }
                        
                        if (!(" ".equals(grid[input1][input2]))) {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {

                            if (g % 2 == 0) {
                                grid[input1][input2] = "X";
                                break;
                            } else {
                                grid[input1][input2] = "O";
                                break;
                            } 
                        }
                    }
                } catch(Exception e) {
                    System.out.println("You should enter numbers!");
                    scanner.next();
                }
            }
            
            for (String[] subgrid : grid) {
                for (String elem : subgrid) {
                    System.out.print(elem);
                }
                System.out.println();
            }

            boolean xWinsAll = false;
            boolean xWinsOpt1 = false;
            boolean xWinsOpt2 = false;
            boolean xWinsOpt3 = false;
            boolean xWinsOpt4 = false;
            boolean xWinsOpt5 = false;
            boolean xWinsOpt6 = false;
            boolean xWinsOpt7 = false;
            boolean xWinsOpt8 = false;

            xWinsOpt1 = "X".equals(grid[1][2]) && "X".equals(grid[1][4]) && "X".equals(grid[1][6]);
            xWinsOpt2 = "X".equals(grid[2][2]) && "X".equals(grid[2][4]) && "X".equals(grid[2][6]);
            xWinsOpt3 = "X".equals(grid[3][2]) && "X".equals(grid[3][4]) && "X".equals(grid[3][6]);
            xWinsOpt4 = "X".equals(grid[1][2]) && "X".equals(grid[2][2]) && "X".equals(grid[3][2]);
            xWinsOpt5 = "X".equals(grid[1][4]) && "X".equals(grid[2][4]) && "X".equals(grid[3][4]);
            xWinsOpt6 = "X".equals(grid[1][6]) && "X".equals(grid[2][6]) && "X".equals(grid[3][6]);
            xWinsOpt7 = "X".equals(grid[1][2]) && "X".equals(grid[2][4]) && "X".equals(grid[3][6]);
            xWinsOpt8 = "X".equals(grid[1][6]) && "X".equals(grid[2][4]) && "X".equals(grid[3][2]);

            xWinsAll = xWinsOpt1 || xWinsOpt2 || xWinsOpt3 || xWinsOpt4 ||
                xWinsOpt5 || xWinsOpt6 || xWinsOpt7 || xWinsOpt8;
    
            boolean oWinsAll = false;
            boolean oWinsOpt1 = false;
            boolean oWinsOpt2 = false;
            boolean oWinsOpt3 = false;
            boolean oWinsOpt4 = false;
            boolean oWinsOpt5 = false;
            boolean oWinsOpt6 = false;
            boolean oWinsOpt7 = false;
            boolean oWinsOpt8 = false;
    
            oWinsOpt1 = "O".equals(grid[1][2]) && "O".equals(grid[1][4]) && "O".equals(grid[1][6]);
            oWinsOpt2 = "O".equals(grid[2][2]) && "O".equals(grid[2][4]) && "O".equals(grid[2][6]);
            oWinsOpt3 = "O".equals(grid[3][2]) && "O".equals(grid[3][4]) && "O".equals(grid[3][6]);
            oWinsOpt4 = "O".equals(grid[1][2]) && "O".equals(grid[2][2]) && "O".equals(grid[3][2]);
            oWinsOpt5 = "O".equals(grid[1][4]) && "O".equals(grid[2][4]) && "O".equals(grid[3][4]);
            oWinsOpt6 = "O".equals(grid[1][6]) && "O".equals(grid[2][6]) && "O".equals(grid[3][6]);
            oWinsOpt7 = "O".equals(grid[1][2]) && "O".equals(grid[2][4]) && "O".equals(grid[3][6]);
            oWinsOpt8 = "O".equals(grid[1][6]) && "O".equals(grid[2][4]) && "O".equals(grid[3][2]);
        
            oWinsAll = oWinsOpt1 || oWinsOpt2 || oWinsOpt3 || oWinsOpt4 ||
                oWinsOpt5 || oWinsOpt6 || oWinsOpt7 || oWinsOpt8;
    
            boolean hasEmptySpace = false;
            for (int i = 1; i < 4; i++) {
                for (int j = 2; j < 7; j += 2) {
                    if (" ".equals(grid[i][j])) {
                        hasEmptySpace = true;
                        break;
                    }
                }
    
                if (hasEmptySpace) {
                    break;
                }
            }

            if (xWinsAll) {
                System.out.println("X wins");
                break;
            } else if (oWinsAll) {
                System.out.println("O wins");
                break;
            } else if (hasEmptySpace) {
                continue;
            } else {
                if (!(hasEmptySpace))
                System.out.println("Draw");
                break;
            }
        }
    }
}
