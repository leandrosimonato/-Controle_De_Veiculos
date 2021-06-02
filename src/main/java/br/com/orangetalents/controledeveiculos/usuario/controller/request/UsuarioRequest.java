package br.com.orangetalents.controledeveiculos.usuario.controller.request;

import br.com.orangetalents.controledeveiculos.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class UsuarioRequest {

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @Email
    @NotBlank(message = "Campo obrigatório")
    private String email;

    @NotBlank
    @CPF
    private String cpf;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date nascimento;


    @Deprecated
    public UsuarioRequest() {
    }

    public UsuarioRequest(String nome, String email, String cpf, Date nascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return "UsuarioRequest{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nascimento=" + nascimento +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public Usuario converter() {
        return new Usuario(nome, email, cpf, nascimento);
    }
}