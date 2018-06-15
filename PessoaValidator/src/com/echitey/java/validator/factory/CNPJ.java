package com.echitey.java.validator.factory;

public class CNPJ extends Digits {

    private String cnpj;

    public CNPJ(String _cnpj) {

        super(Pessoa.Juridica, _cnpj);
        this.cnpj = _cnpj;

    }

    public String format(){
        if(isValid()) {
            return this.cnpj.substring(0, 2) + "." + this.cnpj.substring(2, 5) + "." + this.cnpj.substring(5, 8) + "/" + this.cnpj.substring(8, 12) + "-" + this.cnpj.substring(12);
        }else{
            //Throw Custom Exception
            return "";
        }
    }
}
