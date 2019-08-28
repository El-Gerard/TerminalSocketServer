package ServerC;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
	
	static Boolean condi = true;

	public static void main(String[] args) {
		
		try {
			
			ServerSocket servidor = new ServerSocket(9999);

			while (condi) {
				Socket miSocket = servidor.accept();
				DataInputStream flujo_entrada = new DataInputStream(miSocket.getInputStream());
				String Mensaje_texto = flujo_entrada.readUTF();
				
				if(Mensaje_texto.equals("/exit")) {
					
					miSocket.close();
					condi = false;
					
				}else if (Mensaje_texto.indexOf(" ") == 1) {
					
					Calculator.Calcular(Mensaje_texto);
					Sender.Responder(miSocket);
					miSocket.close();					

				} else {

					Calculator calcu = new Calculator(Mensaje_texto);
					calcu.Comandos();
					Sender.Responder(miSocket);
					miSocket.close();
				}
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
