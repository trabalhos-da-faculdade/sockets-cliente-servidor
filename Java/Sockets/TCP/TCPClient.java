package Java.Sockets.TCP;

import java.io.*;
import java.net.*;
 
class TCPClient {
 
	public static void main(String argv[]) throws Exception {
		// String sentence;
		String modifiedSentence;
 
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
 
		int porta = 6789;
		String servidor = "localhost";
 
		System.out.println("Conectando ao servidor " + servidor + ":" + porta);
 
		Socket clientSocket = new Socket(servidor, porta);
 
		// Envio de dados para o Servidor
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
 
		// Recebimento de Resposta do Servidor
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 
	    // Enviando Dados do Arquivo para o Servidor
		// System.out.println("Digite string a ser enviada para o servidor");
		// sentence = inFromUser.readLine();

		// -------- TESTE ---------------

		String file = "/home/f4nt0/Desktop/sockets-cliente-servidor/Java/Sockets/TCP/teste.txt"; 
		BufferedReader readFile = new BufferedReader(new FileReader(file));

		String sentence = "";
		while(true){
			if(sentence == null){
				break;
			}
			System.out.println("Dado sendo Enviado: " + sentence);
			sentence = readFile.readLine();
			outToServer.writeBytes(sentence + '\n');
			
		}
		readFile.close();
 
		// outToServer.writeBytes(sentence + '\n');
 
		modifiedSentence = inFromServer.readLine();
 
		System.out.println("Recebido do servidor: " + modifiedSentence);
 
		clientSocket.close();
 
	}
}