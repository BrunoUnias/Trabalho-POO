package buscarVaga;

import java.util.ArrayList;

public class Empresa {
	private String nome = "";
	private ArrayList<Cargo> cargos = new ArrayList<>();
	
	public Empresa() {
		
	}
	
	public Empresa(String nome) {
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.compareTo("") == 0) {
			return ;
		}
		this.nome = nome;
	}
	
	public void addCargo(Cargo c) {
		this.cargos.add(c);
	}
	
	public void exibirTudo() {
		for(Cargo cargo : this.cargos) {
			System.out.println(cargo.getNome()+":\n\tRequisitos:");
			for(Conhecimento req : cargo.getRequisitos()) {
				System.out.println("\t\t" + req.getNome() + " " + req.getExperiencia() + " anos");
			}
		}
	}

	public ArrayList<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(ArrayList<Cargo> cargos) {
		this.cargos = cargos;
	}
}
