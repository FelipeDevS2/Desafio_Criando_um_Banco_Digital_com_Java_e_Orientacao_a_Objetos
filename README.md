# Desafio de Código DIO: Criando um Banco Digital com Java e Orientação a Objetos

Este projeto foi desenvolvido como parte de um desafio de código do bootcamp **Santander 2024 - Backend com Java** realizado pela [Digital Innovation One (DIO)](https://web.dio.me), para aplicar conceitos de Programação Orientada a Objetos (POO) na criação de um sistema simples de banco digital. O sistema simula operações bancárias básicas como depósitos, saques e transferências entre contas.

## Funcionalidades do Sistema

- **Criação de Conta**: Permite criar diferentes tipos de contas (Conta Corrente e Conta Poupança).
- **Depósito**: Permite depositar dinheiro numa conta.
- **Saque**: Permite sacar dinheiro de uma conta, respeitando o saldo disponível.
- **Transferência**: Permite transferir dinheiro entre contas.
- **Impressão de Extrato**: Permite imprimir o extrato das operações realizadas em uma conta.

## Conceitos de POO Aplicados

### 1. Classes e Objetos

- **Banco**: Classe para gerenciar o banco e as contas associadas.
- **Cliente**: Classe para representar um cliente do banco.
- **Conta**: Classe abstrata base para representar uma conta bancária. Contém atributos e métodos comuns a todas as contas.
- **ContaCorrente** e **ContaPoupanca**: Classes derivadas da classe `Conta`, cada uma com comportamentos específicos.

### 2. Encapsulamento

- Atributos das classes são privados e acessados/manipulados através de métodos públicos (`get` e `set`), garantindo a integridade dos dados.

```java
public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.contas = new ArrayList<>();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
```

### 3. Herança

- `ContaCorrente` e `ContaPoupanca` herdam da classe `Conta`, reutilizando código e adicionando funcionalidades específicas.

```java
public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("\n==== Extrato Conta Corrente ====");
        super.imprimirExtrato();
    }
}

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("\n==== Extrato Conta Poupanca ====");
        super.imprimirExtrato();
    }
}
```

### 4. Polimorfismo

- Métodos como `depositar`, `sacar` e `transferir` são definidos na interface `IConta` e implementados na classe `Conta`, podendo ser sobrescritos nas subclasses para comportamentos específicos.

```java
public interface IConta {
    void depositar(double valor);
    void transferir(double valor, Conta contaDestino);
    void sacar(double valor);
    void imprimirInfosConta();
    void imprimirExtrato();
}

public abstract class Conta implements IConta {
    // Implementação dos métodos da interface IConta
}
```

### 5. Abstração

- A classe `Conta` é abstrata o suficiente para representar uma conta bancária genérica, enquanto as subclasses `ContaCorrente` e `ContaPoupanca` implementam detalhes específicos.

```java
public abstract class Conta implements IConta {
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

    // Implementação dos métodos da interface IConta
}
```

## Estrutura do Projeto

```
/src
  /main
    /java
      /banco
        Banco.java
        Cliente.java
        Conta.java
        ContaCorrente.java
        ContaPoupanca.java
        IConta.java
        Main.java
```

- **Banco.java**: Gerencia a criação de contas e operações entre elas.
- **Cliente.java**: Representa um cliente do banco.
- **Conta.java**: Classe base para contas bancárias.
- **ContaCorrente.java**: Implementa uma conta corrente com funcionalidades específicas.
- **ContaPoupanca.java**: Implementa uma conta poupança com funcionalidades específicas.
- **IConta.java**: Interface que define os métodos básicos para operações em contas bancárias.
- **Main.java**: Classe principal para execução do programa.

## Como Executar

1. Clone o repositório:
    ```
    https://github.com/FelipeDevS2/Desafio_Criando_um_Banco_Digital_com_Java_e_Orientacao_a_Objetos.git
    ```
2. Compile o projeto:
    ```
    javac -d bin src/main/java/banco/*.java
    ```
3. Execute a aplicação:
    ```
    java -cp bin banco.Main
    ```

## Exemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        Conta cc = new ContaCorrente(new Cliente("Felipe Nascimento"));
        ContaPoupanca cp = new ContaPoupanca(new Cliente("Maria Soares"));

        cc.imprimirInfosConta();
        cc.depositar(1500);
        cc.transferir(780, cp);
        cc.sacar(720);
        cc.imprimirExtrato();

        cp.imprimirExtrato();
        cp.imprimirInfosConta();
        cp.sacar(780);
        cp.sacar(20);
        cp.imprimirExtrato();
    }
}
```

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

---

Este projeto é um exemplo educativo para a prática de conceitos de POO e não deve ser utilizado em produção.