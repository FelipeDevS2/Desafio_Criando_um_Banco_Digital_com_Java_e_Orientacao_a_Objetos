package main.java.banco;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta{

    private static final int AGENCIA = 1;
    private static  int SEQUENCIAL = 1;

    protected int numero;
    protected int agencia;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> extrato;


    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.agencia = Conta.AGENCIA;
        this.cliente = cliente;
        this.extrato = new ArrayList<>();
    }


    @Override
    public void depositar(double valor) {
        saldo+= valor;
        System.out.println("Desposito realizado com sucesso!");
        extrato.add("Deposito de R$"+String.format("%.2f",valor));

    }

    public void depositar(double valor, String nome) {
        saldo+= valor;
        extrato.add("Transferencia Recebida de "+nome+" Valor: R$"+String.format("%.2f",valor));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(verificaSaldo(valor)){
            sacar(valor, 1);
            contaDestino.depositar(valor, cliente.getNome());
            System.out.println("Transferencia de"+String.format("%.2f",valor)+" realizado com sucesso para "+contaDestino.cliente+"!");
            extrato.add("Transferencia de R$"+String.format("%.2f",valor)+" para "+contaDestino.cliente);
        }else
            System.out.println("Saldo insuficiente");
    }


    @Override
    public void sacar(double valor) {
        if(verificaSaldo(valor)){
            saldo-= valor;
            System.out.println("Saque realizado com sucesso!");
            extrato.add("Saque de R$"+String.format("%.2f",valor));
        }else
            System.out.println("Saldo insuficiente!");
    }

    public void sacar(double valor,int i) {
        if(verificaSaldo(valor)){
            saldo-= valor;
        }else
            System.out.println("Saldo insuficiente!");
    }

    @Override
    public void imprimirExtrato() {
        if (!extrato.isEmpty()) {
            extrato.forEach(System.out::println);
        } else {
            System.out.println("Nenhuma operacao realizada!");
        }
    }


    @Override
    public void imprimirInfosConta() {
        System.out.println(this.toString());
    }



    private boolean verificaSaldo(double valor) {
        return saldo >= valor;
    }


    @Override
    public String toString() {
        return "\nTitular: " + cliente +
                "\nmain.java.banco.Conta: "+ numero +
                "\nAgencia: " + agencia +
                "\nSaldo: R$" +String.format("%.2f",saldo);
    }


}
