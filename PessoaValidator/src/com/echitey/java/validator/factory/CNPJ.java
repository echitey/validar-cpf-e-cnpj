package com.echitey.java.validator.factory;

public class CNPJ extends Digits {

    private String cnpj;

    public CNPJ(String _cnpj) {

        super(Pessoa.Juridica, _cnpj);
        this.cnpj = _cnpj;

    }
}
