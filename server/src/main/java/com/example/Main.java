package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();

        System.out.println("Qualcuno si e' colleagato!!!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String s = "pippo";

        while (true) {
            s = in.readLine();
            s = s.toUpperCase();
            if(s.equals("EXIT")){
                break;
            }
            out.println(s);
        }   
        System.out.println("Finito, e' stato mandato l'exit");
        
    }
}