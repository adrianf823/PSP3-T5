package Ejercicio_5_1;

import java.io.IOException;
import java.security.*;

import librerias.trycatch;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		MessageDigest md;
		trycatch s=new trycatch();

		System.out.println("PRUEBA CON MD5");
		try {
			md= MessageDigest.getInstance("MD5");
			String texto="Esto es un texto plano";
			String clave="Clave de cifrado";
			
			byte dataBytes[]= texto.getBytes();

			md.update(dataBytes);

			byte resumen[]=md.digest(clave.getBytes());
			
			System.out.println("Mensaje original: "+texto);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			
			System.out.println("Mensaje en Hexadecimal "+Hexadecimal(resumen));
			
			Provider proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("AHORA COMPARAREMOS DOS CADENAS CON SHA-256");
		
		try {
			md= MessageDigest.getInstance("SHA-256");
			
			System.out.println("INTRODUCE UNA CLAVE");
			String clave=s.String();
			System.out.println("INTRODUCE UN TEXTO");
			String texto1=s.String();
			System.out.println("INTRODUCE OTRO");
			String texto2=s.String();
			
			
			System.out.println("\nCASO UNO");
			byte dataBytes[]= texto1.getBytes();
			md.update(dataBytes);

			byte resumen[]=md.digest(clave.getBytes());
			
			System.out.println("Mensaje original: "+texto1);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			
			System.out.println("Mensaje en Hexadecimal "+Hexadecimal(resumen));
			
			Provider proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
			
			
			
			System.out.println("\nCASO DOS");
			dataBytes= texto2.getBytes();
			md.update(dataBytes);

			resumen=md.digest(clave.getBytes());
			
			System.out.println("Mensaje original: "+texto2);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			
			System.out.println("Mensaje en Hexadecimal "+Hexadecimal(resumen));
			
			proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
			
			System.out.println("\nCOMO HEMOS COMPROBADO, LOS RESUMENES NO SON IGUALES");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	static String Hexadecimal(byte[] resumen) {
		String hex="";
		for (int i = 0; i < resumen.length; i++) {
			String h=Integer.toHexString(resumen[i] & 0xFF);
			if(h.length()==1) hex+="0";
			hex+=h;
		}
		return hex.toUpperCase();
	}

}