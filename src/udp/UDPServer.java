/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thắng Bùi
 */
public class UDPServer {

    DatagramSocket socket;
    DatagramPacket packet;

    //1:
    public void openConnect() {
        try {
            socket = new DatagramSocket(3000);
        } catch (SocketException e) {
            System.out.println(e);
        }
    }

    //4
    public String receiveData() {
        try {
            byte[] data = new byte[1024];
            packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String str = new String(packet.getData()).trim();
            return str;
        } catch (IOException e) {
            System.out.println(e);
            return "";
        }
    }

    //7
    public void senData(String str) {
        try {
            byte[] data = new byte[1024];
            data = str.getBytes();
            InetAddress ipClient = packet.getAddress();

            int port = packet.getPort();
            packet = new DatagramPacket(data, data.length, ipClient, port);
            socket.send(packet);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //handle
    public String handle() {
        return "OK";
    }

    public static void main(String[] args) {

        ArrayList<Account> history = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src\\udp\\Bank.txt");
            BufferedReader br = new BufferedReader(fr);

            String s = "";
            while ((s = br.readLine()) != null) {
                String[] data = s.split("\\$");
                Account a = new Account(Integer.parseInt(data[0]), data[1]);
                history.add(a);
            }

        } catch (IOException e) {
            System.out.println(e);
        }

        UDPServer server = new UDPServer();
        server.openConnect();
        Scanner scan = new Scanner(System.in);
        int c = 0;

        while (c != 5) {
            c = Integer.parseInt(server.receiveData());
            switch (c) {
                case 1:
                    server.senData(server.handle());
                    break;
                case 2:
                    String mon = server.receiveData().trim();
                    int x = Integer.parseInt(mon);
                    for (int i = 0; i < history.size(); i++) {
                        
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Bạn nhập chưa đúng, mời nhập lại");
            }

        }

    }
}
