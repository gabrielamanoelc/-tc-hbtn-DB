public class Cliente {

    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;
    private String rg;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, Integer idade, String CPF, String RG) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
        this.RG = RG;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
}
