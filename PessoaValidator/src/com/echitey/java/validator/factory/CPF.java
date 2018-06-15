package com.echitey.java.validator.factory;

public class CPF extends Digits {

    private String cpf;

    public CPF(String _cpf) {

        super(Pessoa.Fisica, _cpf);
        this.cpf = _cpf;

    }

    public String format(){
        if(isValid()) {
            return this.cpf.substring(0, 3) + "." + this.cpf.substring(3, 6) + "." + this.cpf.substring(6, 9) + "-" + this.cpf.substring(9);
        }else{
            //Throw Custom Exception
            return "";
        }
    }

}
