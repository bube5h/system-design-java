package com.bubesh.networking.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket();

        DatagramPacket dp1, dp2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        byte[] b;

        String s;
        do {

            s = br.readLine();

            b = new byte[1024];

            b = s.getBytes();

            dp1 = new DatagramPacket(b, s.length(), InetAddress.getByName("localhost"), 6000);
            ds.send(dp1);

            dp2 = new DatagramPacket(b, b.length);

            ds.receive(dp2);

            b = dp2.getData();

            s = new String(b);

            System.out.println(s);

        } while (!s.equals("exit"));

    }

}
