/*Trabalho para avaliação de Grau B do aluno Guilherme Luthemaier Zardo para a disciplina de Fundamentos de Programação, 
 Curso de Ciências da Computação, Unisinos. 

 */

public class Usuario {

    /* Classe usuário com atributos, construtor, getters e setters, além de um método para
    imprimir informações do usuário */

    private String nome;
    private int idade;
    private Endereco endereco;
    private String login;
    private String senha;
    private Site[] sites;

    public Usuario(String nome, int idade, Endereco endereco, String login, String senha) {

        this.sites = new Site[10];
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.sites = new Site[20];
        
    }

    public Site[] getSites() {
        return this.sites;
    }


    public void setSites(Site[] sites) {
        this.sites = sites;
    }

    public Usuario() {
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void ImprimeUsuario() {

        
        System.out.println("\n");
        System.out.println("Nome: " + getNome() + "\n");
        System.out.println("Idade: " + getIdade() + "\n");
        System.out.println("Endereco: " + getEndereco() + "\n");
        System.out.println("Login: " + getLogin() + "\n");
        System.out.println("Senha: " + getSenha() + "\n");
        for (int i = 0; i < this.sites.length; i++) {
            if(this.sites[i]!=null) {

            System.out.println("Notícia " + i + ": ");
            sites[i].ImprimeSite();
            System.out.println("\n");
            }
            
        }
        System.out.println("\n");
        System.out.println("////////////////////////////////\n");
    
}

    
}