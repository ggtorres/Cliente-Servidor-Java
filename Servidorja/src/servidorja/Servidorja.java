//Servidor 1

package servidorja;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidorja {

    
    public static void main(String[] args) {
        try {
            //Serviço de escuta
            ServerSocket servidor = new ServerSocket(3334);
            System.out.println("Conectado ao cliente");
            
            //Canal de comunicação
            Socket cliente = servidor.accept();
            System.out.println("Cliente do ip: " + cliente.getInetAddress().getHostAddress());
            
            Scanner entrada = new Scanner(cliente.getInputStream());
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }
            
            entrada.close();
            servidor.close();
                    
                    
        } catch (IOException ex) {
            System.out.println("Erro ao criar o servidor");
            Logger.getLogger(Servidorja.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
    }
    
}
