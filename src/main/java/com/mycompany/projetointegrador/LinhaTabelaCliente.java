package com.mycompany.projetointegrador;

public class LinhaTabelaCliente {

    private String nome;
    private String sobrenome;
    private String telPrincipal;
    private String email;
    private String cpf;

    public LinhaTabelaCliente(String nome, String sobrenome, String telPrincipal, String email, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telPrincipal = telPrincipal;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelPrincipal() {
        return telPrincipal;
    }

    public void setTelPrincipal(String telPrincipal) {
        this.telPrincipal = telPrincipal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
