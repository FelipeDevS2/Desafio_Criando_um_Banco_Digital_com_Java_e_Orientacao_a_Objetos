package main.java.banco;

public class Cliente {
    private String nome;

    public Cliente(String nome) {
        char firstChar =  Character.toUpperCase(nome.charAt(0));
        this.nome = firstChar+nome.substring(1);
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        return nome;
    }
}
