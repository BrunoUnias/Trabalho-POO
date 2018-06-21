package logica;
import java.util.Scanner;

import buscarVaga.Cargo;
import buscarVaga.Conhecimento;
import buscarVaga.Empresa;
import buscarVaga.Emprego;
import buscarVaga.Pessoa;

public class Principal {

	public static void main(String[] args) {
		int opcao = 1;
		Emprego emprego = new Emprego();	
		Scanner scan = new Scanner(System.in);
		while(opcao > 0 && opcao < 5) {
				opcao = scan.nextInt();
			scan.nextLine();
			switch (opcao) {
			case 1:
				Empresa empresa = cadastrarEmpresa(scan);
				cadastrarCargos(empresa, scan);
				emprego.setEmpresa(empresa);
				break;
				
			case 2:
				Pessoa pessoa = cadastrarPessoa(scan);
				emprego.addPessoa(pessoa);
				//job.exibirPessoas();
				break;
				
			case 3:
				if(emprego.isEmpty()) System.exit(0);
				System.out.println("Certo, vamos começar!");
				System.out.println("Vamos analisar os candidatos e dizer qual a chance de cada um conseguir o emprego com base nos requisitos.");
				emprego.começar();
				
				break;
				
			case 4:
				Empresa emp = new Empresa("FAP");
				Cargo c1 = new Cargo("Gerente", 1500f);
				Cargo c2 = new Cargo("Suporte", 1000f);
				Cargo c3 = new Cargo("Desenvolvedor", 1200f);
				Conhecimento ch1 = new Conhecimento("gestao", 4);
				Conhecimento ch2 = new Conhecimento("java", 3);
				Conhecimento ch3 = new Conhecimento("php", 2);
				c1.addRequisito(ch1);
				c1.addRequisito(ch2);
				c1.addRequisito(ch3);
				c2.addRequisito(ch2);
				c2.addRequisito(ch3);
				c3.addRequisito(ch3);
				emp.addCargo(c1);
				emp.addCargo(c2);
				emp.addCargo(c3);
				emprego.setEmpresa(emp);
				Pessoa p1 = new Pessoa("Joao", 1500);
				Pessoa p2 = new Pessoa("Maria", 1000);
				p1.addToCurriculo(ch1);
				p1.addToCurriculo(ch2);
				p1.addToCurriculo(ch3);
				p2.addToCurriculo(ch2);
			    emprego.addPessoa(p1);
				emprego.addPessoa(p2);
				
				break;
				

			default:
				System.exit(0);
				break;
			}
		}
	}
	
	
	public static void printMenu(Emprego trabalho) {
		System.out.println("Bem-vindo!\nNós somos o Jobber, e estamos aqui para te ajudar a arrumar um emprego ou funcinários para sua Empresa");
		System.out.println("Vamos começar!\nEscolha uma das opções abaixo: ");
		System.out.println("1 - Cadastrar Empresa");
		System.out.println("2 - Cadastrar Funcionário");
		if(!trabalho.isEmpty()) System.out.println("3 - Começar!");
		System.out.println("4 - Teste");
		System.out.println("(Ou outro valor para sair do programa.)");
		System.out.print("-> ");
	}
	
	public static Empresa cadastrarEmpresa(Scanner scan) {
		String nome = "";
		Empresa empresa = new Empresa();
		while(nome.compareTo("") == 0) {
			System.out.println("Insira o nome da sua Empresa: ");
			nome = scan.nextLine();
			empresa.setNome(nome);
		}
		System.out.println("Pronto!\nA empresa " + empresa.getNome() + " foi criada!");
		return empresa;
	}
	
	public static void cadastrarCargos(Empresa empresa, Scanner scan) {
		int opt = 0;
		System.out.println("Hora de cadastrar os cargos disponíveis!");
		System.out.println("Adicione quantos preferir.");
		while(opt == 0) {
			System.out.println("Gostaria de adionar um cargo disponível?");
			System.out.println("1 - Sim\t 2 - Não");
			System.out.print("->");
			opt = scan.nextInt();
			scan.nextLine();
			if(opt == 1){
				empresa.addCargo(novoCargo(scan));
				opt = 0;
			}	
		}
		System.out.println("Já terminou? OK, então.");
		return ;
		
	}
	
	public static Cargo novoCargo(Scanner scan) {
		Cargo cargo = new Cargo();
		String nome = "";
		int opt = 1;
		while(nome.compareTo("") == 0) {
			System.out.println("Certo! Vamos começar dando um nome ao Cargo: ");
			nome = scan.nextLine();
			cargo.setNome(nome);
		}
		System.out.println("Agora vamos ao requisitos");
		while(opt == 1) {
			System.out.println("Gostaria de adionar um requisito ao cargo de " + cargo.getNome() + " ?");
			System.out.println("1 - Sim\t2 - Não");
			System.out.print("->");
			opt = scan.nextInt();
			scan.nextLine();
			if(opt == 2) {
				break;
			}
			cargo.addRequisito(novoRequisito(scan));
		}
		return cargo;
		
	}
	
	public static Conhecimento novoRequisito(Scanner scan) {
		Conhecimento req = new Conhecimento();
		String nome = "";
		int anos = -1;
		
		while(nome.compareTo("") == 0) {
			System.out.println("Insira qual o requisito: ");
			nome = scan.nextLine();
			req.setNome(nome);
		}
		System.out.println("OK!");
		while(anos < 0) {
			System.out.println("Agora insira a quantidade de anos de experiencia desejados: ");
			anos = scan.nextInt();
			scan.nextLine();
			req.setExperiencia(anos);
		}
		return req;
		
	}
	
	public static Pessoa cadastrarPessoa(Scanner scan) {
		Pessoa pessoa = new Pessoa();
		String nome = "";
		int opt = 1;
		while(nome.compareTo("") == 0) {
			System.out.println("Insira o nome da Pessoa: ");
			System.out.println("->");
			nome = scan.nextLine();
			pessoa.setNome(nome);
		}
		System.out.println("Ok! Agora vamos aos conhecimentos do(a) " + pessoa.getNome());
		while(opt == 1) {
			System.out.println("Deseja cadastrar um novo conhecimento para " + pessoa.getNome()+ "?");
			System.out.println("1 - Sim\t2 - Não");
			opt = scan.nextInt();
			scan.nextLine();
			if(opt == 2) break;
			pessoa.addToCurriculo(novoConhecimento(scan));
			
		}
		System.out.println("Pronto! Agora o(a) " + pessoa.getNome() + " já está preparado para ingressar no mercado!");
		return pessoa;
	}
	
	public static Conhecimento novoConhecimento(Scanner scan) {
		Conhecimento conhecimento = new Conhecimento();
		String nome = "";
		while(nome.compareTo("") == 0) {
			System.out.println("Insira um nome para o conhecimento a ser adicionado: ");
			System.out.println("->");
			nome = scan.nextLine();	
			conhecimento.setNome(nome);
		}
		System.out.println("Certo!\nAgora é hora de dizer quantos anos de experiência com " + conhecimento.getNome() + ": ");
		System.out.println("->");
		conhecimento.setExperiencia(Math.abs(scan.nextInt()));
		scan.nextLine();
		return conhecimento;
		
		
	}
}
