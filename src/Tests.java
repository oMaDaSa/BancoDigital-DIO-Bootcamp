import java.util.Random;

public class Tests {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Teste");
        banco.adicionarConta(new ContaCorrente(new Cliente("Matheus")));
        banco.adicionarConta(new ContaCorrente(new Cliente("Carlos")));
        banco.adicionarConta(new ContaPoupanca(new Cliente("Olivia")));

        banco.listarClientes();

        for(Conta conta : banco.getContas()){
            double valor = new Random().nextDouble(1000);
            conta.depositar(valor);
            valor = new Random().nextDouble(1000);
            conta.sacar(valor);
        }
        banco.getContas().forEach(Conta::imprimirExtrato);

    }
}