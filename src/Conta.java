
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;

	protected String tipo;
	protected Cliente cliente;

	public Conta(Cliente cliente, String tipo) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipo = tipo;
	}

	@Override
	public boolean sacar(double valor) {
		if(valor > getSaldo())
			System.out.println("Saldo insuficiente");
		else {
			saldo -= valor;
			return true;
		}
		return false;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public boolean transferir(double valor, IConta contaDestino) {
		if(this.sacar(valor)){
			contaDestino.depositar(valor);
		}
		return false;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getTipo() {
		return tipo;
	}

	protected void imprimirInfosComuns() {
		System.out.printf("Titular: %s%n", this.cliente.getNome());
		System.out.printf("Agencia: %d%n", this.agencia);
		System.out.printf("Numero: %d%n", this.numero);
		System.out.printf("Saldo: %.2f%n", this.saldo);
	}
}
