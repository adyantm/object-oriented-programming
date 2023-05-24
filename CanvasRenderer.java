import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Utilities to show your canvas in the UI
 * @author CS1331 TAs
 * @version 1
 */

public class CanvasRenderer {

    private static GraphicsPanel panel;
    private static JFrame frame;
    private static int rowsCopy;
    private static int columnsCopy;
    private static boolean setup;
    private static Runnable shutdownHook;
    /**
     * The setup method for the rendered. Must be called before calls to render or
     close
     * @param rows The number of rows. Future calls to render must have a canvas
    with this number of rows
     * @param columns The number of columns. Future calls to render must have a
    canvas with this number of columns
     */
    public static void setup(int rows, int columns) {
        if (CanvasConfig.getDebug()) {
            System.out.printf("[RENDERER] SETUP: %d rows, %d columns\n", rows,
                    columns);
        }
        if (CanvasRenderer.setup) {
            throw new RuntimeException("Canvas already set up!");
        }
        if (rows <= 0) {
            throw new RuntimeException("Positive number of rows required");
        }
        if (columns <= 0) {
            throw new RuntimeException("Positive number of columns required");
        }
        CanvasRenderer.rowsCopy = rows;
        CanvasRenderer.columnsCopy = columns;
        CanvasRenderer.setup = true;
        if (!CanvasConfig.getNoUI()) {
            CanvasRenderer.panel = new CanvasRenderer.GraphicsPanel(rows, columns);
            CanvasRenderer.panel.setBackground(Color.BLACK);
            CanvasRenderer.frame = new JFrame();
            CanvasRenderer.frame.setFocusable(false);
            CanvasRenderer.frame.setContentPane(CanvasRenderer.panel);
            CanvasRenderer.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            CanvasRenderer.frame.pack();
            CanvasRenderer.frame.setLocationRelativeTo(null);
            CanvasRenderer.frame.setAlwaysOnTop(true);
            CanvasRenderer.frame.setVisible(true);
        }
    }
    private static void printCanvas(int[][] canvas) {
        System.out.print("+");
        for (int c = 0; c < CanvasRenderer.columnsCopy; c++) {
            System.out.print("------+");
        }
        System.out.println();
        for (int r = 0; r < CanvasRenderer.rowsCopy; r++) {
            System.out.print("|");
            for (int c = 0; c < CanvasRenderer.columnsCopy; c++) {
                String hex = Integer.toHexString(canvas[r][c]).toUpperCase();
                for (int p = 0; p < 6 - hex.length(); p++) {
                    System.out.print("0");
                }
                System.out.print(hex);
                System.out.print("|");
            }
            System.out.print("\n+");
            for (int c = 0; c < CanvasRenderer.columnsCopy; c++) {
                System.out.print("------+");
            }
            System.out.println();
        }
    }
    /**
     * The method to render your canvas
     * @param canvas The 2D array representing your canvas
     */
    public static void render(int[][] canvas) {
        if (CanvasConfig.getDebug()) {
            System.out.printf("[RENDERER] RENDERING\n");
        }
        if (!CanvasRenderer.setup) {
            throw new RuntimeException("Canvas not set up!");
        }
        if (canvas == null) {
            throw new RuntimeException("Array provided is null");
        }
        if (canvas.length != CanvasRenderer.rowsCopy) {
            throw new RuntimeException("Array provided has incorrect number of rows");
        }
        for (int r = 0; r < CanvasRenderer.rowsCopy; r++) {
            if (canvas[r] == null) {
                throw new RuntimeException("Array provided has one row with a null 1D array" );
            }
            if (canvas[r].length != CanvasRenderer.columnsCopy) {
                throw new RuntimeException("Array provided has one row with the incorrect number of indexes / columns");
            }
            for (int c = 0; c < CanvasRenderer.columnsCopy; c++) {
                if ((canvas[r][c] >> 24) % 256 != 0) {
                    throw new RuntimeException(String.format("Color in [%d][%d] is invalid", r, c));
                }
            }
        }
        if (CanvasConfig.getDebug()) {
            CanvasRenderer.printCanvas(canvas);
        }
        if (!CanvasConfig.getNoUI()) {
            CanvasRenderer.panel.setImage(canvas);
        }
    }
    /**
     * The method to close the UI. After it executes, calls to the render are
     invalid
     */
    public static void close() {
        if (CanvasConfig.getDebug()) {
            System.out.println("[RENDERER] CLOSE");
        }
        CanvasRenderer.setup = false;
        if (CanvasRenderer.frame != null) {
            CanvasRenderer.frame.dispose();
            CanvasRenderer.frame = null;
            CanvasRenderer.panel = null;
        }
    }
    /**
     * Method used by CanvasConfig. You should not call this method, although doing
     so will cause no problems
     */
    public static void addShutdownHook() {
        if (CanvasRenderer.shutdownHook == null) {
            CanvasRenderer.shutdownHook = new DisposeFrameOnShutdown();
            Runtime.getRuntime().addShutdownHook(new
                    Thread(CanvasRenderer.shutdownHook));
        }
    }
    private static final class GraphicsPanel extends JPanel {
        private BufferedImage image;
        private int columns;
        private int rows;
        public GraphicsPanel(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            int pixelSize = CanvasConfig.getPixelSize();
            int borderSize = CanvasConfig.getBorderSize();
            Dimension size = new Dimension(this.columns * pixelSize + 2 *
                    borderSize,
                    this.rows * pixelSize + 2 * borderSize);
            this.setPreferredSize(size);
            this.setMinimumSize(size);
            this.setMaximumSize(size);
        }
        public void setImage(int[][] image) {
            int pixelSize = CanvasConfig.getPixelSize();
            boolean showGridLines = CanvasConfig.getShowGridLines() && pixelSize >
                    2;
            this.image = new BufferedImage(this.columns * pixelSize, this.rows *
                    pixelSize, BufferedImage.TYPE_INT_RGB);
            for (int c = 0; c < columns; c++) {
                for (int r = 0; r < rows; r++) {
                    for (int cc = 0; cc < pixelSize; cc++) {
                        for (int rr = 0; rr < pixelSize; rr++) {
                            int color = image[r][c];
                            if (showGridLines && (rr == 0 || rr == pixelSize - 1 ||
                                    cc == 0 || cc == pixelSize - 1)) {
                                color = 0;
                            }
                            this.image.setRGB(c * pixelSize + cc, r * pixelSize +
                                    rr, color);
                        }
                    }
                }
            }
            this.repaint();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int borderSize = CanvasConfig.getBorderSize();
            g.drawImage(image, borderSize, borderSize, null);
        }
    }
    private static final class DisposeFrameOnShutdown implements Runnable {
        @Override
        public void run() {
            if (CanvasRenderer.frame != null) {
                CanvasRenderer.frame.dispose();
                CanvasRenderer.frame = null;
                CanvasRenderer.panel = null;
            }
        }
    }

}
