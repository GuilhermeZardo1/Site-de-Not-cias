/*Trabalho para avaliação de Grau B do aluno Guilherme Luthemaier Zardo para a disciplina de Fundamentos de Programação, 
 Curso de Ciências da Computação, Unisinos. 

 */

public class Data {

    /* Classe data, com construtor, getters e setters */

    private int dia;
    private int mes;
    private int ano;

   
    public Data() {

        this.ano = (int)(Math.random() * (2020 - 1950 + 1) + 1950);
        this.dia = (int)(Math.random() * 30 + 1);
        this.mes = (int)(Math.random() * 12 + 1);
    }


    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String toString(){
        return dia + "/" + mes + "/" + ano + "\n"; 
       }

    
}