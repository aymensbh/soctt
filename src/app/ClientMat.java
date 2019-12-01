package app;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class ClientMat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte[][] array = { { 1, 1 }, { 1, 1 } };

        byte[][] array2 = { { 1, 1 }, { 1, 1 } };

        scanner.close();

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9090);

            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(array);

            ObjectOutputStream os2 = new ObjectOutputStream(socket.getOutputStream());
            os2.writeObject(array2);

            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            byte[][] array3 = (byte[][]) is.readObject();

            print2D(array3);

            socket.close();

        } catch (UnknownHostException e1) {
            System.out.println("Unknown host exception " + e1.getMessage());
        } catch (IOException e2) {
            System.out.println("IOException " + e2.getMessage());
        } catch (IllegalArgumentException e3) {
            System.out.println("Illegal Argument Exception " + e3.getMessage());
        } catch (Exception e4) {
            System.out.println("Other exceptions " + e4.getMessage());
        }
    }

    public static void print2D(byte mat[][]) {
        for (byte[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
