package com.echitey.java.validator.factory;

/**
 *
 * @author  Yawo Echitey
 *
 */
public class CPF extends Digits {

    private String cpf;

    /**
     *
     * Inicializa um novo CPF e escolha o tipo de pessoa
     * como Fisica
     *
     * @param cpf
     *        cadeia de caracteres do CPF sem a pontuacao
     *
     * */
    public CPF(String cpf) {

        super(Pessoa.Fisica, cpf);
        this.cpf = cpf;

    }

    /**
     *
     * Retorna o CPF formatado se ele for valido.
     *
     * */
    public String format(){
        if(isValid()) {
            return this.cpf.substring(0, 3) + "." + this.cpf.substring(3, 6) + "." + this.cpf.substring(6, 9) + "-" + this.cpf.substring(9);
        }else{
            //Throw Custom Exception
            return "";
        }
    }

}
