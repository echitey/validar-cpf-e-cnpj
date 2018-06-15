package com.echitey.java.validator.factory;

import java.util.function.Predicate;

/**
 *
 * @author  Yawo Echitey
 *
 */

public class Digits {

    /** Modulo usado na verficição dos dígitos */
    private static final int MODULO = 11;

    /** Quantidade de digitos de un CPF */
    private static final int QTD_DIGITS_CPF = 11;

    /** Quantidade de digitos de un CNPJ */
    private static final int QTD_DIGITS_CNPJ = 14;

    /** Quantidade de digitos verificadores*/
    private static final int QTD_VERIFICATION_DIGITS = 2;

    /** Pesos usados na verificacao do CNPJ. Eles sao fixos */
    private static final int[] PESOS_CNPJ = {6,5,4,3,2,9,8,7,6,5,4,3,2};

    /** Pesos usados na verificacao do CPF */
    private static final int[] PESOS_CPF = {11,10,9,8,7,6,5,4,3,2}; // 10

    private Pessoa pessoa;
    private String digits;


    /**
     *
     * Construtor da classe Digits recebendo como parâmetro,
     * o tipo de Pessoa e os digitos a serem verificados.
     *
     * @param pessoa
     *        Tipo de pessoa(Fisica/Juridica). Ver a enum no final da classe
     *
     * @param digits
     *        Digitos a serem verificados
     *
     * */
    public Digits(Pessoa pessoa, String digits) {
        this.pessoa = pessoa;
        this.digits = digits;
    }


    /**
     *
     * Esse metodo retorna o digito verificador com base dos digitos recebidos
     * como parametro. Ele usa o modulo 11 para tal calculo.
     *
     * @param digits
     *        Digitos a serem verificados
     *
     * @return Retorna o digito verificador
     *
     * */
    public int getVerificationDigit(String digits){
        String [] digitsArray = digits.split("");

        int sum = 0;
        int counter = pessoa == Pessoa.Fisica ?
                QTD_DIGITS_CPF - QTD_VERIFICATION_DIGITS :
                QTD_DIGITS_CNPJ - QTD_VERIFICATION_DIGITS;

        int[] pesos = pessoa == Pessoa.Fisica ? PESOS_CPF : PESOS_CNPJ;

        for(int i = digitsArray.length - 1; i >= 0; i--){
            int number = Integer.valueOf(digitsArray[i]);
            int tmp = number * pesos[counter];
            sum += tmp;

            counter -=1;
        }

        int resto = sum % MODULO;
        int verificationDigit = MODULO - resto;

        if(verificationDigit > 9){
            return 0;
        }
        return verificationDigit;
    }



    /**
     *
     * Esse metodo retorna a validade dos digitos recebidos
     * quando a instancia da classe e criada.
     * Primeiro, ele verifica se todos os caracteres sao digitos.
     * Em seguida, ele calcula os digitos verficadores e compara com os
     * inicias. O retorno eh o resultado.
     *
     * @return Retorna o resultado da comparacao
     *
     * */
    public boolean isValid() {

        int qtdDigits = pessoa == Pessoa.Fisica ? QTD_DIGITS_CPF : QTD_DIGITS_CNPJ;

        if(validateDigits().test(digits)){

            String[] cpfNumbers = digits.split("");

            String source = digits.substring(0, qtdDigits - QTD_VERIFICATION_DIGITS);
            int digit = getVerificationDigit(source);

            if(digit == Integer.valueOf(cpfNumbers[qtdDigits - QTD_VERIFICATION_DIGITS])){

                digit = getVerificationDigit(source+digit);

                if(digit == Integer.valueOf(cpfNumbers[qtdDigits - 1])){

                    return true;

                }
                return false;

            }
            return false;
        }

        return false;
    }




    /**
     *
     * Esse metodo eh um Predicate que testa que verifica se todos
     * os caracteres da cadeia recebida sao digitos
     *
     * @return Retorna o resultado do teste.
     *
     * */
    private Predicate<String> validateDigits(){
        return (digits) -> {

            int qtdDigits = pessoa == Pessoa.Fisica ? QTD_DIGITS_CPF : QTD_DIGITS_CNPJ;

            if(digits.matches("[0-9]{"+qtdDigits+"}")){

                for(int i=0; i<=9; i++){
                    String regex = i + "{"+qtdDigits+"}";
                    if(digits.matches(regex)){
                        return false;
                    }
                }
                return true;
            }
            return false;
        };
    }


    /**
     *
     * A Enum Pessoa permite escolher entre pessoa Fisica e Juridica
     *
     * */
    public enum Pessoa {
        Fisica, Juridica;
    }

}
