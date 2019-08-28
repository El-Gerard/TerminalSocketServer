package ServerC;

public class Calculator {

	private String comand = "";
	private static String resul;	
	private static String Respuesta = ">";
	String code = ">> ";

	public Calculator(String a) {

		this.comand = a;
	}

	public void Comandos() {
		
		switch (comand) {

		case "/help":
			Respuesta = ">> /suma: Sumar dos numeros \n" 
					+ ">> /resta: Restar dos numeros \n"
					+ ">> /mult: Multiplicar dos numeros \n"
					+ ">> /div: Dividir dos numeros \n"
					+ ">> /cole: Ecuacion de Colebrook \n"
					+ ">> /clear: Limpiar pantalla \n"
					+ ">> /exit: Salir del programa \n";
			break;
		case "/exit":
			Respuesta = ">> Saliendo del sistema...";
			//System.exit(0);
			break;
		case "/suma":
			Respuesta = "a Numeros";
			break;
		case "/resta":
			Respuesta = "b Numeros";
			break;			
		case "/mult":
			Respuesta = "c Numeros";
			break;
		case "/div":
			Respuesta = "d Numeros";
			break;
		case "/cole":
			Respuesta = "e Numeros";
			break;
		case "/clear":
			
			break;
		}
		Sender send = new Sender(Respuesta);
	}
	
	public static void Calcular(String resp) {		
		
		if(resp.indexOf("a")==0) {
			String []part = resp.split("-");
			int suma = Integer.parseInt(part[1]) + Integer.parseInt(part[2]);
		    resul = Integer.toString(suma);
		}else if(resp.indexOf("b")==0) {
			String []part = resp.split("-");
			int resta = Integer.parseInt(part[1]) - Integer.parseInt(part[2]);
		    resul = Integer.toString(resta);
			
		}else if(resp.indexOf("c")==0) {
			String []part = resp.split("-");
			int multiplicar = Integer.parseInt(part[1]) * Integer.parseInt(part[2]);
		    resul = Integer.toString(multiplicar);
			
		}else if(resp.indexOf("d")==0) {
			String []part = resp.split("-");
			//Agregar condicional por el numero 0
			int dividir = Integer.parseInt(part[1]) / Integer.parseInt(part[2]);
		    resul = Integer.toString(dividir);
			
		}else if(resp.indexOf("e")==0) {
			 resul = Double.toString(Colebrook(resp));
		}		
		Sender send = new Sender(resul);		
	}
	
	//M�todo para realizar la ecuaci�n de colebrook que devuelve un double
	//No se tiene en cuenta el di�metro
	public static double Colebrook(String resp) {
		
		double E, Re, X = 1, Y, M, Xp, Xs = 0, Xi = 0;
        int it = 0;
        String []part = resp.split("-");
        
        //Nivel de rugosidad
        E = Integer.parseInt(part[1]); 
        //Numero de reynolds
        Re = Integer.parseInt(part[2]);
        //Ecuacion de colebrook
        Y = (-2 * Math.log10((E / (3.7)) + (2.51 / (Re * Math.sqrt(X)))) * Math.sqrt(X));

        if (Y > 1) {

            Xs = Y;
            Xi = X;

        } else if (Y <= 1) {

            Xi = Y;
            Xs = X;

        }

        do {
            Xp = (Xs + Xi) / 2;

            if (Xp < 1) {
                Xi = Xp;
            } else {
                Xs = Xp;
            }
            it++;
            //System.out.println("iteracion: " + it);

        } while (Xp != 1);
        //System.out.println(Y);
        return Y;		
	}
}
