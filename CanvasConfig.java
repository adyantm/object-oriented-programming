import java.io.File;
import java.util.Scanner;
/**
 * Code to use the configuration from canvas.config in the provided code. You don't
 need to interact with this class
 * @author CS1331 TAs
 * @version 1
 */


public class CanvasConfig {

    private static boolean debug = false;
    private static boolean noUI = false;
    private static boolean showGridLines = false;
    private static int pixelSize = 20;
    private static int borderSize = 5;
    /**
     * Get debug config. You don't need to interact with this method
     * @return debug
     */
    public static boolean getDebug() {
        return debug;
    }
    /**
     * Get noUI config. You don't need to interact with this method
     * @return noUI
     */
    public static boolean getNoUI() {
        return noUI;
    }
    /**
     * Get showGridLines config. You don't need to interact with this method
     * @return showGridLines
     */
    public static boolean getShowGridLines() {
        return showGridLines;
    }
    /**
     * Get pixelSize config. You don't need to interact with this method
     * @return pixelSize
     */
    public static int getPixelSize() {
        return pixelSize;
    }
    /**
     * Get borderSize config. You don't need to interact with this method
     * @return borderSize
     */
    public static int getBorderSize() {
        return borderSize;
    }
    static {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("canvas.config"));
            while (sc.hasNextLine()) {
                String[] lineInfo = sc.nextLine().split(" ");
                if (lineInfo.length > 0) {
                    switch (lineInfo[0]) {
                        case "debug":
                            CanvasConfig.debug = true;
                            break;
                        case "noUI":
                            CanvasConfig.noUI = true;
                            break;
                        case "showGridLines":
                            CanvasConfig.showGridLines = true;
                            break;
                        case "pixelSize":
                            if (lineInfo.length >= 2) {
                                try {
                                    CanvasConfig.pixelSize =
                                            Integer.parseInt(lineInfo[1]);
                                    if (CanvasConfig.pixelSize < 1) {
                                        CanvasConfig.pixelSize = 1;
                                    }
                                } catch (NumberFormatException e) {
                                    continue;
                                }
                            }
                            break;
                        case "borderSize":
                            if (lineInfo.length >= 2) {
                                try {
                                    CanvasConfig.borderSize =
                                            Integer.parseInt(lineInfo[1]);
                                    if (CanvasConfig.borderSize < 1) {
                                        CanvasConfig.borderSize = 1;
                                    }
                                } catch (NumberFormatException e) {
                                    continue;
                                }
                            }
                            break;
                        default:
                    }
                }
            }
        } catch (Throwable t) {
            System.out.println("[CANVAS_CONFIG] Unknown error while reading configuration");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        if (!CanvasConfig.noUI) {
            CanvasRenderer.addShutdownHook();
        }
    }
}

