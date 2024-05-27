public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato(){
        if (!extrato.isEmpty()) {
            System.out.println("\n==== Extrato Conta Poupanca ====");
            extrato.forEach(System.out::println);
        } else {
            System.out.println("Nenhuma operacao realizada!");
        }
    }


}
