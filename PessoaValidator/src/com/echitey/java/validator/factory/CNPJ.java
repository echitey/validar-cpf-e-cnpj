package com.echitey.java.validator.factory;


/**
 *
 * @author  Yawo Echitey
 *
 */
public class CNPJ extends Digits {

    private String cnpj;

    /**
     *
     * Inicializa um novo CNPJ e escolha o tipo de pessoa
     * como Fisica
     *
     * @param cnpj
     *        cadeia de caracteres do CNPJ sem a pontuacao
     *
     * */
    public CNPJ(String cnpj) {

        super(Pessoa.Juridica, cnpj);
        this.cnpj = cnpj;

    }


    /**
     *
     * Retorna o CNPJ formatado se ele for valido.
     *
     * */
    public String format(){
        if(isValid()) {
            return this.cnpj.substring(0, 2) + "." + this.cnpj.substring(2, 5) + "." + this.cnpj.substring(5, 8) + "/" + this.cnpj.substring(8, 12) + "-" + this.cnpj.substring(12);
        }else{
            //Throw Custom Exception
            return "";
        }
    }
}
