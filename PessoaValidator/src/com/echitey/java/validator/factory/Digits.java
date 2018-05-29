package com.echitey.java.validator.factory;

import java.util.function.Predicate;

public class Digits {

    private static final int MODULO = 11;
    private static final int QTD_DIGITS_CPF = 11;
    private static final int QTD_DIGITS_CNPJ = 14;
    private static final int QTD_VERIFICATION_DIGITS = 2;
    private static final int[] PESOS_CNPJ = {6,5,4,3,2,9,8,7,6,5,4,3,2}; // 13
    private static final int[] PESOS_CPF = {11,10,9,8,7,6,5,4,3,2}; // 10

    private Pessoa pessoa;
    private String digits;

    public Digits(Pessoa pessoa, String digits) {
        this.pessoa = pessoa;
        this.digits = digits;
    }


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


    public boolean isValid() {

        int qtdDigits = pessoa == Pessoa.Fisica ? QTD_DIGITS_CPF : QTD_DIGITS_CNPJ;

        if(validateDigits().test(digits)){

            String[] cpfNumbers = digits.split("");

            String source = digits.substring(0, qtdDigits - QTD_VERIFICATION_DIGITS);
            //System.out.println("SOURCE = "+ source);
            int digit = getVerificationDigit(source);

            //System.out.println("\nVerif1 = "+digit);

            if(digit == Integer.valueOf(cpfNumbers[qtdDigits - QTD_VERIFICATION_DIGITS])){

                //System.out.println("SOURCE = "+ source+digit);

                digit = getVerificationDigit(source+digit);

                //System.out.println("\nVerif2 = "+ digit);

                if(digit == Integer.valueOf(cpfNumbers[qtdDigits - 1])){

                    return true;

                }
                return false;

            }
            return false;
        }

        return false;
    }


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


    public enum Pessoa {
        Fisica, Juridica;
    }

}
