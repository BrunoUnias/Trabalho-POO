package buscarVaga;

public class Conhecimento {
	private String nome = new String();
	private int experiencia = 0;
	
	public Conhecimento() {
		
	}
	
	public Conhecimento(String nome, int meses){
		setNome(nome);
		setExperiencia(meses);
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

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		if(experiencia < 1) {
			return ;
		}
		this.experiencia = experiencia;
	}
	
}
