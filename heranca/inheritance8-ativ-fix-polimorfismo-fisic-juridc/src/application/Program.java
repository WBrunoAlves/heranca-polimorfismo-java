package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entities.Pagador;
import entities.PFisica;
import entities.PJuridica;

/*Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais
podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um,
bem como o total de imposto arrecadado.
Os dados de pessoa física são: nome, renda anual e gastos com saúde. Os dados de pessoa jurídica
são nome, renda anual e número de funcionários. As regras para cálculo de imposto são as
seguintes:
Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50%
destes gastos são abatidos no imposto.
Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
fica: (50000 * 25%) - (2000 * 50%) = 11500.00
Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10
funcionários, ela paga 14% de imposto.
Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica:
400000 * 14% = 56000.00*/


public abstract class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pagador>List = new ArrayList<>();
		
		System.out.println("Entre com o numero de Pagadores: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Pagador # " + i + " data:");
			System.out.println("Pessoa Fisica ou Juridica (f/j)?");
			char type = sc.next().charAt(0);
			System.out.println("Nome: ");
			sc.nextLine();
			String nomePg = sc.nextLine();
			System.out.println("Gastos Anuais : ");
			double gastoAnuais = sc.nextDouble();
			
			if (type == 'f') {
				
				System.out.println("Gastos com Saúde : ");
				double gastoSaude = sc.nextDouble();
				
				List.add(new PFisica(nomePg, gastoAnuais, gastoSaude));
			} else if (type =='j') {
				
					
				System.out.println("Numero de empregados : ");
				int numeroImpregados = sc.nextInt();
				
				List.add(new PJuridica(nomePg, gastoAnuais, numeroImpregados));	
			}
		
		}
		
		double sum = 0.0;
		
		System.out.println();
		System.out.println("Impostos Pagos: ");		
		for (Pagador pg : List) {
			double tax = pg.tax(); //variavel tax recebe o valor de todos os impostos
			System.out.println(pg.getNome() + ": $ " + String.format("%.2f", pg.tax()));
			sum +=tax;
		}

		System.out.println();
		System.out.println("TOTAL IMPOSTOS: $ " + String.format("%.2f", sum));// imprime todas os imposotos total
		
		sc.close();

	}

}
