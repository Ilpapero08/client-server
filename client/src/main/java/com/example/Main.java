package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket_client = new Socket("127.0.0.1", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
        PrintWriter out = new PrintWriter(socket_client.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una stringa:");
        

        String testo = " ";
        while (true) {
            System.out.println("Inserisci il testo da mandare: ");
            testo = scanner.nextLine();
            out.println(testo);
            if(testo.equals("exit")){
                break;
            }
            System.out.println(in.readLine());
        }
        System.out.println("Finito, e' stato mandato l'exit");
        scanner.close();
    }
}