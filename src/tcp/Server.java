/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcp;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Thắng Bùi
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1:
            ServerSocket myServer = new ServerSocket(3000);
            System.out.println("Server is ready!");
            
            while(true) {
                Socket socket = myServer.accept();
                System.out.println("Client connected!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                
                //handle
                String job = dis.readUTF();
                int length  = job.length();
                
                dos.writeUTF(String.valueOf(length));
                break;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
