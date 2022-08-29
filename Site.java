/*Trabalho para avaliação de Grau B do aluno Guilherme Luthemaier Zardo para a disciplina de Fundamentos de Programação, 
 Curso de Ciências da Computação, Unisinos. 

 */

public class Site {

    /* Classe site, com atributos, construtor e métodos respectivos. O construtor geram um site
    com um número aleatório de notícias entre 1 e 4. Há também um método para a impressão de informações
    do Site, além de getters, setters, incluindo um de incremento e decremento do número de assinantes. */

    private String nome;
    private String url;
    private double assinatura;
    private int assinantes;
    private Noticia[] noticias;
    int numero;

  

    public Site() {

        int n = (int)(Math.random() * 4 + 1);
        
        Noticia[] a = new Noticia[n];

        for (int i = 0; i < a.length; i++) {

            a[i] = new Noticia();
        }

        this.noticias = a;
        this.nome = Metodos.SelecionaNome();
        this.assinatura = (double)(Math.random() * 30 + 1);
        this.assinantes = 0;
        this.url = "www." + this.nome + ".com.br";

    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Noticia[] getNoticias() {
        return this.noticias;
    }

    public void setNoticias(Noticia[] noticias) {
        this.noticias = noticias;
    }


    public double getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(double assinatura) {
        this.assinatura = assinatura;
    }

    public int getAssinantes() {
        return this.assinantes;
    }

    public void setAssinantesMais() {
        this.assinantes++;
    }

    public void setAssinantesMenos() {
        this.assinantes--;
    }

    public void ImprimeSite() {

        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println("\n");
        System.out.println("Nome: " + getNome() + "\n");
        System.out.println("URL: " + getUrl() + "\n");
        System.out.println("Assinatura: " + getAssinatura() + "\n");
        System.out.println("Assinantes: " + getAssinantes() + "\n");
        System.out.println("Número: " + getNumero() + "\n");

        for (int i = 0; i < noticias.length; i++) {

            if(noticias[i]!=null) {

            System.out.println("Notícia " + i + ": ");
            noticias[i].ImprimeNoticia();
            System.out.println("\n");
            }
        }

        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");

    }




   

    
}