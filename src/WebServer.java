import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 2019-08-27
 */

public class WebServer {

    int port;


    public WebServer(int port) {
        this.port = port;
    }

    public boolean start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running");
            while(true) {
                Socket server = serverSocket.accept();
                // Create a new thread for the connection
                RequestHandler requestHandler = new RequestHandler(server);

                // Start the new thread
                new Thread(requestHandler).start();}
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Connection received.");

        return true;
    }

}


class RequestHandler implements Runnable {

    Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader in = null;

            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String request = in.readLine();
            System.out.println("Browser har sendt denne request: " + request);

            String[] reqArr = request.split(" ");
            System.out.println("Så vil vores server rerturnere denne respons: " + reqArr[1]);
            String html = FileAccess.readFile(reqArr[1]);

            // Send the headers
            out.println("HTTP/1.0 200 OK");
            out.println("Content-Type: text/html");
            out.println("Server: DatamatikerBitch");
            // this blank line signals the end of the headers
            out.println("");
            // Send html
            out.println(html);
            out.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
