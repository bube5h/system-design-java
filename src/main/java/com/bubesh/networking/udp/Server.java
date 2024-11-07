package com.bubesh.networking.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket(6000);
        byte[] b;

        DatagramPacket dp1, dp2;

        String s;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        b = new byte[1024];

        do {

            dp1 = new DatagramPacket(b, b.length);

            ds.receive(dp1);

            b = dp1.getData();

            s = new String(b);

            System.out.println(s);

            if (s.equals("exit"))
                break;

            s = br.readLine();

            b = s.getBytes();

            dp2 = new DatagramPacket(b, s.length(), dp1.getAddress(), dp1.getPort());

            ds.send(dp2);

        } while (!s.equals("exit"));

    }
}
