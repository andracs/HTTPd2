/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 2019-08-27
 */

public class RequestParser {

    // Dette er et eksempel på, hvordan vi kan parse en HTTP GET request
    public static void main(String[] args) {
        String req = "GET /hest.html HTTP/1.1";
        System.out.println(req);
        String fil = req.substring(4);
        System.out.println(fil);
        String[] reqArr = req.split(" ");
        System.out.println(reqArr[1]);
    }

}
