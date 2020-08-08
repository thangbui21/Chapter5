/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Thắng Bùi
 */
public class UDPClient {

    DatagramSocket socket;
    DatagramPacket packet;

    //2: Giống nhau này.
    public void openConnect() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            System.out.println(e);
        }
    }

    //3
    public void senData(String str) {
        try {
            byte[] data = new byte[1024];
            data = str.getBytes();
            InetAddress ipServer = InetAddress.getByName("localhost");
            packet = new DatagramPacket(data, data.length, ipServer, 3000);
            socket.send(packet);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //7
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

    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        client.openConnect();
        Scanner scan = new Scanner(System.in);
        int c = 0;

        do {
            System.out.println("1. Thu tiền");
            System.out.println("2. Chi tiền");
            System.out.println("3. Số dư");
            System.out.println("4. Lịch sử");
            System.out.println("5. Thoát");
            System.out.println("Bạn chọn?");

            c = scan.nextInt();
            scan.nextLine();
            client.senData(String.valueOf(c));

            switch (c) {
                case 1:
                    System.out.println(client.receiveData());
                    break;
                case 2:
                    System.out.println("Nhập số tiền muốn thu: ");
                    float mon = scan.nextFloat();
                    client.senData(String.valueOf(mon));
                    System.out.println(client.receiveData());
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

        } while (c != 5);
    }
}
