import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 2019-08-27
 */

public class FileAccess{

    public static String readFile(String filnavn) {
        if (filnavn == "" ) { filnavn="index.html";}
        String htmlContent ="";

        try {
            RandomAccessFile fil = new RandomAccessFile("htdocs"+filnavn, "rw");
            // available stream to be read
            String linje;
            do {

                // reads characters encoded with modified UTF-8
                linje = fil.readLine();

                if (linje == null) {break;}
                // print
                System.out.print(linje+"\n");

                htmlContent = htmlContent +linje;

            } while (linje != null);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return htmlContent;
    }


}
