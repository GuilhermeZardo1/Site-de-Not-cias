/*Trabalho para avaliação de Grau B do aluno Guilherme Luthemaier Zardo para a disciplina de Fundamentos de Programação, 
 Curso de Ciências da Computação, Unisinos. 

 */

public class Endereco {

    /* Classe Endereço, com construtor, getters e setters */

    private String cidade;
    private String estado;
    private String rua;
    private int numero;
    private int cep;

    public Endereco() {
    }

    public Endereco(String cidade, String estado, String rua, int numero, int cep) {

        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;

    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return this.cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String toString(){
        return "cidade: " + getCidade() + " estado: " 
        + getEstado() + " rua: " + getRua() + " numero: " + getNumero() + " cep: " + getCep() + "\n";
       }



 



    
    


    
}