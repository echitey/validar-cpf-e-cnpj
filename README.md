## Validador de CPF e CNPJ

Esse é uma bibliotéca de validação de CPF(Cadastro de Pessoas Físicas) e CNPJ(Cadastro Nacional de Pessoas Jurídicas) escrita em Java.
Ele realiza os cálculos de verificação de dígitos verificadores para efetuar a
validação.

Portanto, somente é feita a validação do CPF/CNPJ.
Para ter acesso a dados de cadatros do CPF ou CNPJ, visite o [site](http://idg.receita.fazenda.gov.br/orientacao/tributaria/cadastros) da [Receita Federal](http://idg.receita.fazenda.gov.br/orientacao/tributaria/cadastros).

### Como usar?

Na raíz do repositório, encontra-se o arquivo [PessoaValidator.jar](PessoaValidator.jar). Baixe-o
e adicione-o ao seu projeto Java como bibliotéca externa.

Para referenciar a classe CPF/CNPJ da bibliotéca, é preciso importá-la:

```java
import com.echitey.java.validator.factory.CPF;
import com.echitey.java.validator.factory.CNPJ;
```


Para criar e validar un CPF:

```java
CPF cpf = new CPF("11122233344");
System.out.println(cpf.isValid());
// Para retornar o CNPJ formatado, existe o metodo format() da classe CNPJ
// Esse metodo só funciona quando o CPF for válido
System.out.println(cpf.format());
```


Para criar e validar un CNPJ:

```java
CNPJ cnpj = new CNPJ("11122233344455");
System.out.println(cnpj.isValid());
// Para retornar o CNPJ formatado, existe o metodo format() da classe CNPJ
// Esse metodo só funciona quando o CNPJ for válido
System.out.println(cnpj.format());
```
