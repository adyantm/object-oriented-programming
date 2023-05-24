import java.util.Scanner;

public class Canvas1 {
    public static void main(String[] args) {

            int rows = Integer.parseInt(args[0]);
            int columns = Integer.parseInt(args[1]);

            int[][] canvas1 = new int[rows][columns];

            fill(canvas1, getColor("#FFFFFF"));

            CanvasRenderer.setup(rows, columns);

            CanvasRenderer.render(canvas1);

            Scanner input = new Scanner(System.in);

            while (true) {

                String inp = input.nextLine();

                String[] inp2 = inp.split(" ");

                if (inp2[0].equals("PIXEL")) {
                    System.out.println(inp2[3]);
                    int color = getColor(inp2[3]);
                    setPixelColor(canvas1, Integer.parseInt(inp2[1]), Integer.parseInt(inp2[2]), color);
                }
                if (inp2[0].equals("RECTANGLE")) {
                    int color = getColor(inp2[5]);
                    drawRectangle(canvas1, Integer.parseInt(inp2[1]), Integer.parseInt(inp2[2]), Integer.parseInt(inp2[3]), Integer.parseInt(inp2[4]), color);
                }
                if (inp2[0].equals("SQUARE")) {
                    int color = getColor(inp2[4]);
                    drawSquare(canvas1, Integer.parseInt(inp2[1]), Integer.parseInt(inp2[2]), Integer.parseInt(inp2[3]), color);
                }
                if (inp2[0].equals("FILL")) {
                    int color = getColor(inp2[1]);
                    fill(canvas1, color);
                }
                if (inp2[0].equals("REPLACE")) {
                    int color1 = getColor(inp2[1]);
                    int color2 = getColor(inp2[2]);

                    replaceColor(canvas1, color1, color2);
                }
                if (inp2[0].equals("GRID")) {
                    int color = getColor(inp2[5]);
                    if (inp2[4].equals("SAME")) {
                        drawGrid(canvas1, Integer.parseInt(inp2[1]), Integer.parseInt(inp2[2]), Integer.parseInt(inp2[3]), true, color);
                    } else {
                        drawGrid(canvas1, Integer.parseInt(inp2[1]), Integer.parseInt(inp2[2]), Integer.parseInt(inp2[3]), false, color);
                    }
                }
                if (inp2[0].equals("LOWER")) {
                    int color = getColor(inp2[4]);
                    drawLowerTriangle(canvas1, Integer.parseInt(inp2[1]), Integer.parseInt(inp2[2]), Integer.parseInt(inp2[3]), color);
                }
                if (inp2[0].equals("UPPER")) {
                    int color = getColor(inp2[4]);
                    drawUpperTriangle(canvas1, Integer.parseInt(inp2[1]), Integer.parseInt(inp2[2]), Integer.parseInt(inp2[3]), color);
                }

                if (inp2[0].equals("QUIT")) {
                    break;
                } else if (inp2[0].equals("SAVE")) {
                    CanvasImageSave.save(canvas1, inp2[1]);
                } else {
                    CanvasRenderer.render(canvas1);

                }
            }

            input.close();
            CanvasRenderer.close();

        }

        public static int getColor (String color){
            int numericValue;
            String color2 = color.substring(1);
            numericValue = Integer.parseInt(color2, 16);
            return numericValue;
        }

        public static void setPixelColor ( int[][] canvas, int row, int column, int color){
            canvas[row][column] = color;
        }

        public static void drawRectangle ( int[][] canvas, int row, int column, int height, int width, int color){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    canvas[row + i][column + j] = color;
                }
            }
        }

        public static void drawSquare ( int[][] canvas, int row, int column, int size, int color){
            drawRectangle(canvas, row, column, size, size, color);
        }
        ;

        public static void fill ( int[][] canvas, int color){
            drawRectangle(canvas, 0, 0, canvas.length, canvas[0].length, color);
        }
        ;

        public static void replaceColor ( int[][] canvas, int color1, int color2){
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if (canvas[i][j] == color1) {
                        canvas[i][j] = color2;
                    }
                }
            }
        }

        public static void drawGrid ( int[][] canvas, int row, int column, int size, boolean same, int color){

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i % 2 != 0) {
                        if (same && j % 2 != 0) {
                            canvas[i + row][j + column] = color;
                        } else {
                            if (!same && j % 2 == 0) {
                                canvas[i + row][j + column] = color;
                            }
                        }
                    } else {
                        if (same && j % 2 == 0) {
                            canvas[i + row][j + column] = color;
                        } else {
                            if (!same && j % 2 != 0) {
                                canvas[i + row][j + column] = color;
                            }
                        }
                    }
                }
            }
        }
        ;

        public static void drawLowerTriangle ( int[][] canvas, int row, int column, int size, int color){
            int loopN;
            loopN = 1;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < loopN; j++) {
                    canvas[i + row][j + column] = color;
                }
                loopN += 1;
            }
        }

        public static void drawUpperTriangle ( int[][] canvas, int row, int column, int size, int color){

            int loopN;

            loopN = -1;

            for (int i = 0; i < size; i++) {
                for (int j = size - 1; j > loopN; j--) {
                    canvas[i + row][j + column] = color;
                }
                loopN += 1;
            }
        }


    }