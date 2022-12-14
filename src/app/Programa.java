package app;

import java.util.Locale;
import java.util.Scanner;
import entities.Conta;
import exceptions.BusinessException;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Digite os dados da conta");
		System.out.print("Número:");
		int numero=sc.nextInt();
		System.out.print("Titular:");
		sc.nextLine();
		String titular=sc.nextLine();
		System.out.print("Saldo Inicial:");
		double saldo=sc.nextDouble();
		System.out.print("Limite de saque:");
		double retirarLimite=sc.nextDouble();
		
		Conta c=new Conta(numero,titular,saldo,retirarLimite);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar;");
		double quantia=sc.nextDouble();
		
		try {
			c.retirar(quantia);
			System.out.printf("Novo saldo:%.2f%n",c.getSaldo());
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
