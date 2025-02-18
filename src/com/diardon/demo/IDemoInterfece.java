package com.diardon.demo;

public interface IDemoInterfece
{
	default void metodo1()
	{
		System.out.println("metodo1 por defecto");
	}
	default void metodo2()
	{
		System.out.println("metodo2 por defecto");
	}	
}
