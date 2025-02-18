package com.diardon.demo;

// API JavaTime 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
// API Stream
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.util.function.Consumer;
// Optional
import java.util.Optional;

import java.util.Arrays;
import java.util.List;

public class AppDemoJava8
{

	public static void main(String[] args)
	{
		//testLambda();
		//testStreamList();
		//testJavaTime();
		//testIFDefault();
		//testOptional();
		testJS();
	}
	public static void testJS()
	{
		// Crear el gestor de motores de scripting
		ScriptEngineManager manager = new ScriptEngineManager();
		// Obtener el motor Nashorn por su nombre
		ScriptEngine engine = manager.getEngineByName("nashorn");

		// Código JavaScript a ejecutar
		String script = "var saludo = 'Hola desde Nashorn!'; print(saludo);";

		try
		{
			// Ejecutar el script
			engine.eval(script);
		}
		catch(ScriptException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void testOptional()
	{
		// Creación de un Optional con un valor
		Optional<String> saludo = Optional.of("Hola, Mundo!");

		// Creación de un Optional que puede estar vacío
		Optional<String> posibleValor = Optional.empty();

		// Uso de ifPresent para ejecutar una acción solo si el valor existe
		saludo.ifPresent(valor -> System.out.println("El saludo es: " + valor));

		// Uso de orElse para proporcionar un valor por defecto en caso de ausencia
		String valorPorDefecto = posibleValor.orElse("Valor por defecto");
		System.out.println("Resultado: " + valorPorDefecto);

		// Uso de map para transformar el valor en caso de que esté presente
		Optional<Integer> longitud = saludo.map(String::length);
		longitud.ifPresent(len -> System.out.println("Longitud del saludo: " + len));
	}
	
	public static void testIFDefault()
	{
		ClaseDemoIF demo = new ClaseDemoIF();
		
		demo.metodo1();
		demo.metodo2();
	}

	public static void testJavaTime()
	{
		// Obtener la fecha actual
		LocalDate fechaActual = LocalDate.now();
		System.out.println("Fecha actual: " + fechaActual);
		
		// Obtener la hora actual
		LocalTime horaActual = LocalTime.now();
		System.out.println("Hora actual: " + horaActual);
		
		// Combinar fecha y hora en un LocalDateTime
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		System.out.println("Fecha y hora actual: " + fechaHoraActual);
		
		// Especificar una zona horaria y obtener la fecha y hora zonificada
		ZoneId zonaParis = ZoneId.of("Europe/Paris");
		ZonedDateTime fechaHoraParis = ZonedDateTime.now(zonaParis);
		System.out.println("Fecha y hora en París: " + fechaHoraParis);
		
		// Formatear la fecha y hora utilizando un patrón
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fechaHoraFormateada = fechaHoraActual.format(formatter);
		System.out.println("Fecha y hora formateada: " + fechaHoraFormateada);
	}
	
	public static void testStreamList()
	{
		// Lista de números
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// Utilizando Stream API para:
		// 1. Filtrar los números pares.
		// 2. Calcular el cuadrado de cada número par.
		// 3. Recopilar los resultados en una lista.
		List<Integer> cuadradosPares = numeros.stream()
		        .filter(n -> n % 2 == 0)
		        .map(n -> n * n)
		        .collect(Collectors.toList());
		
		System.out.println("Cuadrados de los números pares: " + cuadradosPares);
	}
	
	public static void testLambda()
	{
		List<String> nombres = Arrays.asList("Ana", "Carlos", "María", "Juan", "Alicia", "José");
		
		// Pasando expresión lambda
		System.out.println("Nombres:");
		nombres.forEach(new Consumer<String>()
		{
			@Override
			public void accept(String nombre)
			{
				System.out.print(nombre + " ");
			}
		});
		System.out.println("");
		
		// Usando expresiones lambda resumida
		System.out.println("Nombres:");
		nombres.forEach(nombre -> System.out.print(nombre + " "));
		System.out.println("");
	}}
