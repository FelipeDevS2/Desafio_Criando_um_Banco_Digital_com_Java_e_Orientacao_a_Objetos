public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato(){
        if (!extrato.isEmpty()) {
            System.out.println("\n==== Extrato Conta Corrente ====");
            extrato.forEach(System.out::println);
        } else {
            System.out.println("Nenhuma operacao realizada!");
        }
    }
}
