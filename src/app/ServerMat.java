package app;

import java.io.*;
import java.util.Arrays;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMat {

    public static void main(String[] args){


        try{

        ServerSocket server = new ServerSocket(9090);
        Socket socket = server.accept();


        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        byte[][] array = (byte[][]) is.readObject();


        ObjectInputStream is2 =new ObjectInputStream(socket.getInputStream());
        byte[][] array2 = (byte[][]) is2.readObject();

            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());


            os.writeObject(mult(array,array2));
            print2D(mult(array,array2));

            
            server.close();
            socket.close();

        }catch(ClassNotFoundException e1){

            System.out.println(e1.getMessage());
        }catch(IOException e2){

            System.out.println(e2.getMessage());

        }    



    }
    public static byte[][] mult(byte [][] array,byte [][] array2) {
        byte[][] c = new byte[array2.length][array[0].length];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                c[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    c[i][j] += array[i][k] * array2[k][j];
                }
            }
        return c;
    }

    public static void print2D(byte mat[][]){
        for (byte[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
