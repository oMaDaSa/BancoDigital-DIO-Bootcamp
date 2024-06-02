import java.util.HashSet;
import java.util.Set;

public class Banco {

	private String nome;
	private Set<Conta> contas;

	Banco(String nome){
		setNome(nome);
		contas = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionarConta(Conta c){
		this.contas.add(c);
	}

	public void listarClientes(){
		this.contas.forEach(n -> System.out.printf("%s - %d - %s\n",n.cliente.getNome(), n.getNumero(), n.getTipo()));
	}

	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}

}
