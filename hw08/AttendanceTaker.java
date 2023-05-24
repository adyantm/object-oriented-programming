package hw08;//I worked on the assignment alone, using only course-provided materials.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class represents an attendance taker.
 *
 * @author adyantm.
 * @version 1.0.
 */
public class AttendanceTaker {

    private File inputFile;
    private File outputFile;
    /**
     * Main method for the Attendance Taker class.
     *
     * @param a String[] a.
     *
     * @throws FileNotFoundException File doesn't exist exception.
     * @throws BadFileException File is in wrong format exceptionm.
     */

    public static void main(String[] a)
            throws FileNotFoundException, BadFileException {
        AttendanceTaker attendance = new AttendanceTaker(a[0], a[1]);
        attendance.takeAttendance();
    }
    /**
     * Attendance taker constructor.
     *
     * @param inputFile File inputFile.
     * @param outputFile File outputFile.
     */

    public AttendanceTaker(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }
    /**
     * Attendance taker constructor.
     *
     * @param inputFileName String inputFileName.
     *
     * @param outputFileName String outputFileName.
     *
     */

    public AttendanceTaker(String inputFileName, String outputFileName) {
        this(new File(inputFileName), new File(outputFileName));
    }

    /**
     * Take attendance method that throws exception.
     *
     * @throws FileNotFoundException File does not exist anywhere.
     * @throws BadFileException the file has the wrong format.
     */
    public void takeAttendance() throws FileNotFoundException,
            BadFileException {
        Scanner scanner = new Scanner(inputFile);
        String[] names;
        try {
            if (!(scanner.hasNextLine())) {
                throw new BadFileException("The input file was empty");
            }
            String name = scanner.nextLine();
            if (name.length() >= 6) {
                if ((name.substring(0, 3).equals("|--"))
                        && (name.substring(name.length() - 3).equals("--|"))) {
                    name = name.substring(3, name.length() - 3);
                    names = name.split("---");
                } else {
                    throw new BadFileException("The file doesn't have "
                            + "correct beginning or end");
                }
            } else {
                throw new BadFileException("The file doesn't have "
                        + "correct beginning or end");
            }
        } catch (NoSuchElementException e) {
            throw new BadFileException(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        Scanner scanner1 = new Scanner(System.in);
        PrintWriter output = new PrintWriter(outputFile);

        for (String strings : names) {
            try {
                processStudentAttendance(strings, scanner1, output);
            } catch (InvalidNameFormatException i) {
                System.out.printf("Skipping %s because of an "
                        + "invalid name format: %s\n", strings, i.getMessage());
            } catch (InvalidAttendanceInformationException ex) {
                System.out.printf("Skipping %s because of an "
                                + "invalid attendance information: %s\n",
                        strings, ex.getMessage());
            }
        }
        scanner1.close();
        output.close();
    }
    /**
     * ProcessStudentAttendance method that throws exception.
     *
     * @param name String name.
     * @param consoleScanner Scanner consoleScanner.
     * @param printWriter PrintWriter printWriter.
     * @throws InvalidNameFormatException hw08.InvalidNameFormatException exception.
     * @throws InvalidAttendanceInformationException InvalidAttendanceInformatio
     *
     */
    private static void processStudentAttendance(String name,
                                                 Scanner consoleScanner,
                                                 PrintWriter printWriter)
            throws InvalidNameFormatException,
            InvalidAttendanceInformationException {
       String upper = name.toUpperCase();
        if (!(name.equals(upper))) {
            printWriter.println("-");
            throw new InvalidNameFormatException("The name"
                    + " isn't uppercase only");
    } else {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                printWriter.println("-");
                throw new InvalidNameFormatException("The name has a digit");
            } else if (c == '|') {
                printWriter.println("-");
                throw new InvalidNameFormatException("The name "
                        + "has a pipe character");
            }
        }
    }
        System.out.print(name + ": ");
        String inputUser1 = consoleScanner.nextLine();
        if (inputUser1.length() == 0) {
            printWriter.println("-");
            throw new InvalidAttendanceInformationException("Attendance "
                    + "information missing");
        } else if (!inputUser1.equals("A") && !inputUser1.equals("P")) {
            printWriter.println("-");
            throw new InvalidAttendanceInformationException("Attendance "
                    + "information is not P or A");
        } else {
            printWriter.println(inputUser1);
        }
    }
}


