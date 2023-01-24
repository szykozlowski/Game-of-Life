
public class GOL
{
    public static void main(String args[])
    {
        int rows = 200;
        int cols = 200;
        int [][] Board = new int [rows][cols];
        int [][] Next = new int [rows][cols];
        int neighbors = 0;

        for(int i = 0;i<cols - 1;i++){
            for(int j = 0;j<rows - 1;j++){
                Board[i][j] = (int)(Math.random() * 2);
            }        
        }
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1440,1440);
        StdDraw.setScale(0,200);
        while(true){
                for(int i = 1;i<cols-1;i++){
                    for(int j = 1;j<rows - 1;j++){
                        neighbors = 0;
                        for (int x = -1; x <= 1; x++) {
                            for (int y = -1; y <= 1; y++) {
                                neighbors += Board[i+y][j+x];
                            }
                        }
                        neighbors -= Board[i][j];
                        if (Board[i][j] == 1 && neighbors <  2){ 
                            Next[i][j] = 0;                        
                        }           
                        else if (Board[i][j] == 1 && neighbors >  3){ 
                            Next[i][j] = 0;                        
                        }         
                        else if (Board[i][j] == 0 && neighbors == 3){
                            Next[i][j] = 1;                       
                        }
                        else{
                            Next[i][j] = Board[i][j];                     
                        }     

                    }        
                }
                StdDraw.clear();
                for(int i = 0;i<cols;i++){
                    for(int j = 0;j<rows;j++){
                        if(Board[i][j] == 1){
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledSquare(i + 0.5,j + 0.5,0.5);

                        }
                        else{
                            StdDraw.setPenColor(StdDraw.WHITE);
                            StdDraw.filledSquare(i + 0.5,j + 0.5,0.5);

                        }
                    }        
                }
                StdDraw.show();
                StdDraw.pause(17);
                Board = Next;
                Next = new int [rows][cols];
            }

        }
    }

