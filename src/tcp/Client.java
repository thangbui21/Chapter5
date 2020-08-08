/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import javax.imageio.IIOException;

/**
 *
 * @author Thắng Bùi
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner scan = new Scanner(System.in);
            
            while(true) {
                System.out.println("Nhập 1 chuỗi: ");
                String job = scan.nextLine();
                dos.writeUTF(job);
                
                System.out.println(dis.readUTF());
                break;
            }
            

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
