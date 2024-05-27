public class Main {
    public static void main(String[] args) {
        Conta cc = new ContaCorrente(new Cliente("felipe nascimento"));
        ContaPoupanca contaPoupanca = new ContaPoupanca(new Cliente("Maria Soares"));

        cc.imprimirInfosConta();
        cc.depositar(1500);
        cc.transferir(780,contaPoupanca);
        cc.sacar(720);
        cc.imprimirExtrato();

        contaPoupanca.imprimirExtrato();
        contaPoupanca.imprimirInfosConta();
        contaPoupanca.sacar(780);
        contaPoupanca.sacar(20);
        contaPoupanca.imprimirExtrato();

    }
}