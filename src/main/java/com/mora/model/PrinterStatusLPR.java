package com.mora.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PrinterStatusLPR {
/**
 * Query the state of the print queue.
 *
 * @param host Internet host name or IP address.
 * @param queue The name of the queue (traditionally the username).
 * @param out results of the request are written here.
 * @param shortResponse true if a short response is desired, false if a long response is desired.
 * @throws IOException if communication with the printer fails.
 */
    static void sendQueueState(String host, String queue, OutputStream out, boolean shortResponse) throws IOException {
        
        Socket socket = new Socket(host, 515);
        OutputStream sout = socket.getOutputStream(); 
        sout.write(new byte[] {(byte)(shortResponse?3:4)});
        sout.write(queue.getBytes());
        sout.write(" List ".getBytes());
        sout.flush();

        InputStream sin = socket.getInputStream();
        byte[] cbuffer = new byte[1024];
        int read;
        while ((read = sin.read(cbuffer)) != -1){
                out.write(cbuffer, 0, read);
        }
        out.flush();
        sout.close();
        sin.close();
        socket.close();
        }
}
