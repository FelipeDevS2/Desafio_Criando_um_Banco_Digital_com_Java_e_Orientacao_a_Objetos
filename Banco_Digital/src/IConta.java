public interface IConta {
    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    void sacar(double valor);

    void imprimirInfosConta();

    void imprimirExtrato();


}
