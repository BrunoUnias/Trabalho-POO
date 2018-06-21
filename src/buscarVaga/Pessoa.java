package buscarVaga;

import java.util.ArrayList;

public class Pessoa {
	private String nome = "";
	private ArrayList<Conhecimento> curriculo = new ArrayList<>();
	private float sal_desejado = 0f;

	public void setCurriculo(ArrayList<Conhecimento> curriculo) {
		this.curriculo = curriculo;
	}
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, float sal_desejado) {
		setNome(nome);
		setSal_desejado(sal_desejado);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome.equals("")) {
			return ;
		}
		this.nome = nome;
	}
	
	public ArrayList<Conhecimento> getCurriculo() {
		return curriculo;
	}
	
	
	public float getSal_desejado() {
		return sal_desejado;
	}
	
	public void setSal_desejado(float sal_desejado) {
		if(Float.compare(sal_desejado, this.sal_desejado) < 0) {
			return ;
		}
		this.sal_desejado = sal_desejado;
	}
	
	public void printPessoa() {
		System.out.println(getNome() + ": ");
		for(Conhecimento c : this.curriculo) {
			System.out.println("\t" + c.getNome() + "\t" + c.getExperiencia() + " anos");
		}
	}

	public void addToCurriculo(Conhecimento conhecimento) {
		// TODO Auto-generated method stub
		if(conhecimento.getNome().compareTo("") == 0) {
			return ;
		}
		getCurriculo().add(conhecimento);
	}
	
}

