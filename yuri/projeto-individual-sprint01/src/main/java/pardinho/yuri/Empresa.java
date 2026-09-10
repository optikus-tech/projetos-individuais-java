package pardinho.yuri;

public class Empresa {

    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private String numero;
    private String complemento;
    private String cep;
    private String cargo;
    private String email;
    private String senha;

    public Empresa(String cnpj, String email, String senha) {
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
    }

    public boolean autenticar(String emailDigitado, String senhaDigitada) {
        return this.email.equals(emailDigitado) && this.senha.equals(senhaDigitada);
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
