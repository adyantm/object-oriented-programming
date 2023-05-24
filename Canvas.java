/* In order to help learn course concepts, I worked on this homework with Ishaan Bhardwaaj*/


import java.util.Scanner;

public class Canvas {
        public static void main(String[] args) {
            int r = Integer.parseInt(args[0]);
            int c = Integer.parseInt(args[1]);
            int[][] canvasCreated = new int[r][c];
            fill(canvasCreated, getColor("#FFFFFF"));
            CanvasRenderer.setup(r, c);
            CanvasRenderer.render(canvasCreated);
            Scanner system = new Scanner(System.in);

            while (true) {
                String x = system.nextLine();
                String[] x2 = x.split(" ");

                if (x2[0].equalsIgnoreCase("RECTANGLE")) {
                    int colorGenerated = getColor(x2[5]);
                    drawRectangle(canvasCreated, Integer.parseInt(x2[1]), Integer.parseInt(x2[2]), Integer.parseInt(x2[3]), Integer.parseInt(x2[4]), colorGenerated);
                }

                if (x2[0].equalsIgnoreCase("PIXEL")) {
                    System.out.println(x2[3]);
                    int colorGenerated = getColor(x2[3]);
                    setPixelColor(canvasCreated, Integer.parseInt(x2[1]), Integer.parseInt(x2[2]), colorGenerated);
                }

                if (x2[0].equalsIgnoreCase("SQUARE")) {
                    int colorGenerated = getColor(x2[4]);
                    drawSquare(canvasCreated, Integer.parseInt(x2[1]), Integer.parseInt(x2[2]),Integer.parseInt(x2[3]), colorGenerated);
                }
                if (x2[0].equalsIgnoreCase("FILL")) {
                    int colorGenerated = getColor(x2[1]);
                    fill(canvasCreated, colorGenerated);
                }
                if (x2[0].equalsIgnoreCase("REPLACE")) {
                    int colorG1 = getColor(x2[1]);
                    int colorG2 = getColor(x2[2]);

                    replaceColor(canvasCreated, colorG1, colorG2);
                }
                if (x2[0].equalsIgnoreCase("GRID")) {
                    int colorG3 = getColor(x2[5]);
                    if (x2[4].equalsIgnoreCase("SAME")) {
                        drawGrid(canvasCreated, Integer.parseInt(x2[1]), Integer.parseInt(x2[2]),Integer.parseInt(x2[3]),true, colorG3);
                    }
                    else {
                        drawGrid(canvasCreated, Integer.parseInt(x2[1]), Integer.parseInt(x2[2]),Integer.parseInt(x2[3]),false, colorG3);
                    }
                }
                if (x2[0].equalsIgnoreCase("LOWER")) {
                    int colorG4 = getColor(x2[4]);
                    drawLowerTriangle(canvasCreated, Integer.parseInt(x2[1]), Integer.parseInt(x2[2]),Integer.parseInt(x2[3]), colorG4);
                }
                if (x2[0].equalsIgnoreCase("UPPER")) {
                    int colorG5 = getColor(x2[4]);
                    drawUpperTriangle(canvasCreated, Integer.parseInt(x2[1]), Integer.parseInt(x2[2]),Integer.parseInt(x2[3]), colorG5);
                }

                if (x2[0].equalsIgnoreCase("QUIT")) {
                    break;
                }
                else if (x2[0].equalsIgnoreCase("SAVE")) {
                    CanvasImageSave.save(canvasCreated, x2[1]);
                }
                else {
                    CanvasRenderer.render(canvasCreated);

                }
            }
            system.close();
            CanvasRenderer.close();
        }

    public static void setPixelColor(int[][] canvas, int row, int col, int color){
        canvas[row][col] = color;
    }

    public static void drawRectangle(int[][] canvas, int row, int col, int height, int width, int color) {
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                canvas[i+row][j+col] = color;
            }
        }
    }
    public static void drawSquare(int[][] canvas, int row, int column, int size, int color){
        drawRectangle(canvas, row, column, size, size, color);}

    public static int getColor(String colorReceived){
            return Integer.parseInt(colorReceived.substring(1), 16);
        }

        public static void fill(int[][] canvas, int color){
            drawRectangle(canvas, 0, 0, canvas.length, canvas[0].length, color);};

        public static void replaceColor(int[][] canvas, int oldColor, int newColor){
            for(int i = 0; i < canvas.length; i++){
                for(int j = 0; j < canvas[0].length; j++){
                    if (oldColor == canvas [i][j]) {
                        canvas[i][j] = newColor;
                    }
                }
            }}
        public static void drawGrid(int[][] canvas, int row, int col, int size, boolean same, int color){
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if (i%2 != 0){
                        if (same && j%2 != 0){
                            canvas[i+row][j+col] = color;
                        }
                        else {
                            if (!same && j%2 == 0){
                                canvas[i+row][j+col] = color;
                            }
                        }
                    }
                    else{
                        if (same && j%2 == 0){
                            canvas[i+row][j+col] = color;
                        }
                        else{
                            if (!same && j%2 != 0){
                                canvas[i+row][j+col] = color;
                            }
                        }
                    }
                }
        }}

        public static void drawLowerTriangle(int[][] canvas, int row, int col, int size, int color){
            int count = 1;
            for(int i = 0; i < size; i++){
                for(int j = 0; j < count; j++){
                    canvas[i+row][j+col] = color;
                }
                count++;
            }
        }

        public static void drawUpperTriangle(int[][] canvas, int row, int col, int size, int color){
            int count = -1;
            for(int i = 0; i < size; i++){
                for(int j = size-1; j > count; j--){
                    canvas[i+row][j+col] = color;
                }
                    count ++;
            }
        }}