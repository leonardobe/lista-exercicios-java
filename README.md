# 📘 Lista de Exercícios em Java

Este repositório contém uma coleção de exercícios resolvidos em **Java**, abordando conceitos fundamentais de **POO (Programação Orientada a Objetos)**, boas práticas e padrões de projeto.

Cada exercício possui sua própria implementação em Java, com menus interativos usando `Scanner` para facilitar a execução no console.

---

## 🚀 Tecnologias

* Java 17+ (compatível também com Java 11)
* `Scanner` para interação no console
* Estrutura orientada a objetos com **encapsulamento, herança, polimorfismo, abstração e generics**

---

## 📝 Exercícios

### **Exercício 1 — Encapsulamento (Classe Produto)**

* Implementação de uma classe `Produto` com atributos privados.
* Uso de **getters e setters com validações**.
* Tratamento de erros com `IllegalArgumentException`.

---

### **Exercício 2 — Encapsulamento com Validação de Regra (Desconto)**

* Extensão da classe `Produto` com método `aplicarDesconto(double porcentagem)`.
* Regra: desconto entre **0% e 50%**.
* Uso de exceções (`IllegalArgumentException` ou `DescontoInvalidoException`).

---

### **Exercício 3 — Herança (Hierarquia de Funcionários)**

* Classe base `Funcionario` com atributos `nome` e `salario`.
* Subclasses `Gerente` e `Desenvolvedor` com regras de **bônus diferenciadas**.
* Uso de **List<Funcionario>** para polimorfismo.

---

### **Exercício 4 — Polimorfismo com Interface (IMeioTransporte)**

* Interface `IMeioTransporte` com métodos `acelerar()` e `frear()`.
* Implementações: `Carro`, `Bicicleta`, `Trem`.
* Exemplo prático com **lista de transportes** e invocação polimórfica.
* Tratamento de operações inválidas com exceções.

---

### **Exercício 5 — Abstração (Sistema de Pagamentos)**

* Classe abstrata `FormaPagamento` com métodos `validarPagamento()` e `processarPagamento()`.
* Implementações: `CartaoCredito`, `Boleto`, `Pix`.
* Validações específicas (ex.: número do cartão, chave Pix).
* Exceção `PagamentoInvalidoException`.

---

### **Exercício 6 — Imutabilidade e Objetos de Valor (Carrinho de Compras)**

* Objeto de valor `Dinheiro` (imutável).
* `Carrinho` com lista imutável de itens (`ItemCarrinho`).
* Operações retornam **novos carrinhos** (imutabilidade).
* Suporte a cupons (limite de 30%).
* Impressão detalhada de carrinhos com e sem cupom.

---

### **Exercício 7 — Generics (Repositório Genérico em Memória)**

* Interface `Identificavel<ID>`.
* Repositório genérico `IRepository<T, ID>`.
* Implementação `InMemoryRepository` com `Map<ID, T>`.
* Exceção `EntidadeNaoEncontradaException`.
* Exemplo com entidades `Produto` e `Funcionario`.

---

### **Exercício 8 — Padrão Strategy (Cálculo de Frete com Lambdas)**

* Interface `CalculadoraFrete` (Strategy).
* Estratégias: `Sedex`, `Pac`, `RetiradaNaLoja` e **Promocional (lambda)**.
* Classe `Pedido` que recebe e troca estratégia em tempo de execução.
* Validação de **CEP** com exceção.
* Menu interativo para simular **múltiplos pedidos**.

---

## ▶️ Como Executar

1. Clone este repositório:

   ```bash
   git clone https://github.com/seu-usuario/lista-exercicios-java.git
   cd lista-exercicios-java
   ```

2. Compile o exercício desejado (exemplo para o exercício 1):

   ```bash
   cd exercicio01-encapsulamento
   javac Main.java
   ```

3. Execute:

   ```bash
   java Main
   ```

---

## 📚 Conceitos Trabalhados

* Encapsulamento
* Validações e exceções personalizadas
* Herança e polimorfismo
* Interfaces
* Classes abstratas
* Imutabilidade
* Generics e coleções
* Padrão de projeto **Strategy** com lambdas

---

## ✨ Autor

Implementado por **Leonardo Curtis** como parte de estudos em **Java e Programação Orientada a Objetos**.
