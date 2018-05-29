package com.echitey.java.validator.factory;

public class CPF extends Digits {

    private String cpf;

    public CPF(String _cpf) {

        super(Pessoa.Fisica, _cpf);
        this.cpf = _cpf;

    }

}
