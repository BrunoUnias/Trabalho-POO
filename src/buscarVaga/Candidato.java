package buscarVaga;

public class Candidato extends Pessoa{
	private float chance = 0f;
	
	public Candidato() {
		
	}
	
	public Candidato(Pessoa pessoa) {
		setNome(pessoa.getNome());
		setCurriculo(pessoa.getCurriculo());
	}

	public float getChance() {
		return chance;
	}

	public void setChance(float chance) {
		this.chance = chance;
	}
	
	public void printCandidato() {
		System.out.println("\tNome: "+getNome()+" Chance: "+getChance() + "%");
	}
}

