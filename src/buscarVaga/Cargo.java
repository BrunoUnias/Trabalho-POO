package buscarVaga;

import java.util.ArrayList;

public class Cargo {
	private String nome = "";
	private ArrayList<Conhecimento> requisitos = new ArrayList<>();
	private ArrayList<Candidato> candidatos = new ArrayList<>();
	private float remuneracao = 0.0f;
	private Pessoa contratado = null;
	
	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public Cargo() {
		
	}
	
	public Cargo(String nome, float salario) {
		this.nome = nome;
		this.remuneracao = salario;
		
	}
	
	
	public void setNome(String nome2) {
		// TODO Auto-generated method stub
		
	}
	
	public String getNome() {
		return nome;
	}

	public ArrayList<Conhecimento> getRequisitos() {
		return requisitos;
	}
	
	public void setRequisitos(ArrayList<Conhecimento> requisitos) {
		if(requisitos.size() < 1) {
			return ;
		}
		this.requisitos = requisitos;
	}

	public void addRequisito(Conhecimento novoRequisito) {
		// TODO Auto-generated method stub
		
	}
	
}
