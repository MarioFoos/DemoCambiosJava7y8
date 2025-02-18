package com.diardon.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AppDemoJava7
{
	public static void main(String[] args)
	{
		//testTryWithRes();
		//testMultiCatch();
		//testDiamante();
	}
	
	public static void testDiamante()
	{
		// Antes:
		// ArrayList<Integer> nums = new ArrayList<Integer>();
		// Ahora
		ArrayList<Integer> nums = new ArrayList<>();
		
		for(int i = 0; i < 5; ++i)
		{
			nums.add(2*i);
		}
		System.out.println(nums);
	}
	
	public static void testMultiCatch()
	{
		String rutaArchivo = "archivo.txt";
		String linea = "";

		// El recurso BufferedReader se cierra automáticamente al salir del bloque try.
		try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo)))
		{
			while((linea = br.readLine()) != null)
			{
				Integer num = Integer.parseInt(linea);
				System.out.println(num);
			}
		}
		catch(NumberFormatException|IOException e)
		{
			// Se puede entrar por error al leer el archivo o al formatear como número la linea leída
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void testTryWithRes()
	{
		String rutaArchivo = "archivo.txt";

		// El recurso BufferedReader se cierra automáticamente al salir del bloque try.
		try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo)))
		{
			String linea;
			while((linea = br.readLine()) != null)
			{
				System.out.println(linea);
			}
		}
		catch(IOException e)
		{
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}
	}
}
