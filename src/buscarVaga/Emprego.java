package buscarVaga;

public class Emprego {
	import java.util.ArrayList;
		private Empresa empresa = new Empresa();
		private ArrayList<Pessoa> pessoas = new ArrayList<>();

		public Empresa getEmpresa() {
			return empresa;
		}

		public void setEmpresa(Empresa empresa) {
			this.empresa = empresa;
		}
		
		public boolean isEmpty() {
			if(getEmpresa().getNome().compareTo("") == 0) {
				return true;
			}
			return false;
		}

		public ArrayList<Pessoa> getPessoas() {
			return pessoas;
		}

		public void setPessoas(ArrayList<Pessoa> pessoas) {
			this.pessoas = pessoas;
		}
		
		public void addPessoa(Pessoa pessoa) {
			if(pessoa.getNome().compareTo("") == 0) {
				return ;
			}
			pessoas.add(pessoa);
		}
		
		public void exibirPessoas() {
			for(Pessoa p : this.pessoas) {
				p.printPessoa();
			}
		}
		
		public void começar() {
			for(Cargo cargo : getEmpresa().getCargos()) {
				for(Pessoa pessoa : getPessoas()) {
					cargo.analisarChance(pessoa);
				}
				System.out.println(cargo.getNome()+ ": ");
				for(Candidato candidato : cargo.getCandidatos()) {
					candidato.printCandidato();
				}
			}
		}
	}


