/*Trabalho para avaliação de Grau B do aluno Guilherme Luthemaier Zardo para a disciplina de Fundamentos de Programação, 
 Curso de Ciências da Computação, Unisinos. 

 */

public class Noticia {

    /* Classe Notícia, com construtor (que utiliza métodos da classe método), getters e setters, além 
    de um método para imprimir a notícia inteira */

    private String manchete;
    private Data data;
    private String texto;


    public Noticia() {

        this.manchete = Metodos.SelecionaManchete();
        this.data = new Data();
        this.texto = Metodos.SelecionaTexto();
    }


    public String getManchete() {
        return this.manchete;
    }

    public void setManchete(String manchete) {
        this.manchete = manchete;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void ImprimeNoticia() {
        
        
        System.out.println("\n");
        System.out.println("Manchete: " + getManchete() + "\n");
        System.out.println("Data: " + getData() + "\n");
        System.out.println("Texto: " + getTexto() + "\n");
        
        

    }
    
}