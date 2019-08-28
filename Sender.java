package ServerC;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sender {

	private static String respuesta;
	
	public Sender(String a) {

		Sender.respuesta = a;
	}

	public static void Responder(Socket soc) {

		try {

			DataOutputStream flujo_salida = new DataOutputStream(soc.getOutputStream());
			flujo_salida.writeUTF(respuesta);
			flujo_salida.close();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
		System.out.println(e1.getMessage());
		}
	}
}
