import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Utility to save the canvas as a png image
 * @author CS1331 TAs
 * @version 1
 */


public final class CanvasImageSave {

    /**
     * This method saves a canvas to a file
     * @param canvas The 2D array representing a canvas
     * @param filename The filename used to indicate which file the canvas will be
    written to
     */
    public static void save(int[][] canvas, String filename) {
        if (canvas == null) {
            throw new RuntimeException("Array provided is null");
        }
        int rows = canvas.length;
        if (rows == 0) {
            throw new RuntimeException("Array provided has invalid number of rows");
        }
        int columns = canvas[0].length;
        if (columns == 0) {
            throw new RuntimeException("Array provided has invalid number of columns");
        }
        for (int r = 0; r < rows; r++) {
            if (canvas[r] == null) {
                throw new RuntimeException("Array provided has one row with a null 1D array");
            }
            if (canvas[r].length != columns) {
                throw new RuntimeException("Array provided has one row with the incorrect number of indexes / columns");
            }
            for (int c = 0; c < columns; c++) {
                if ((canvas[r][c] >> 24) % 256 != 0) {
                    throw new RuntimeException(String.format("Color in [%d][%d] is invalid", r, c));
                }
            }
        }
        int pixelSize = CanvasConfig.getPixelSize();
        BufferedImage image = new BufferedImage(columns * pixelSize, rows *
                pixelSize, BufferedImage.TYPE_INT_RGB);
        boolean showGridLines = CanvasConfig.getShowGridLines() && pixelSize > 2;
        for (int c = 0; c < columns; c++) {
            for (int r = 0; r < rows; r++) {
                for (int cc = 0; cc < pixelSize; cc++) {
                    for (int rr = 0; rr < pixelSize; rr++) {
                        int color = canvas[r][c];
                        if (showGridLines && (rr == 0 || rr == pixelSize - 1 || cc
                                == 0 || cc == pixelSize - 1)) {
                            color = 0;
                        }
                        image.setRGB(c * pixelSize + cc, r * pixelSize + rr,
                                color);
                    }
                }
            }
        }
        if (CanvasConfig.getDebug()) {
            System.out.println("[IMAGE_SAVE] SAVING AS: " + filename);
        }
        try {
            ImageIO.write(image, "png", new File(filename));
            if (CanvasConfig.getDebug()) {
                System.out.println("[IMAGE_SAVE] SAVED!");
            }
        } catch (IOException e) {
            if (CanvasConfig.getDebug()) {
                System.out.println("[IMAGE_SAVE] UNABLE TO SAVE");
            }
        }
    }

}
