package com.echitey.java.works;


import com.echitey.java.validator.factory.CNPJ;
import com.echitey.java.validator.factory.CPF;

public class Main {

    public static void main(String[] args) {

        boolean valid;

        String cpf_dilma = "13326724691";
        String cnpj_google = "06990590000123";

        String cpf_fake_1 = "00000000000";
        String cpf_fake_2 = "00000450000";
        String cpf_fake_3 = "00000ee0000";

        String cnpj_fake_1 = "1111114118111";
        String cnpj_fake_2 = "1111111no1f11";
        String cnpj_fake_3 = "11111111111111";

        CPF cpf = new CPF(cpf_fake_1);

        CNPJ cnpj = new CNPJ(cnpj_google);


        valid = cpf.isValid();

        System.out.println("\n\nCPF: "+ cpf.format() +" Valid = "+ valid);

        valid = cnpj.isValid();

        System.out.println("\n\nCNPJ: "+ cnpj.format()+ " Valid = "+ valid);

    }
}
