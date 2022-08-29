/*Trabalho para avaliação de Grau B do aluno Guilherme Luthemaier Zardo para a disciplina de Fundamentos de Programação, 
 Curso de Ciências da Computação, Unisinos. 

 */

public class Principal {

    public static void main( String[] args ) {

        //Inicia a Array "todosossites", que monta um conjunto de sites com um número aleatório de notícias

        Metodos.IniciaArrayDeSites();

        Teclado teclado = new Teclado();

        int m = (int)(Math.random() * 40 + 1);

        /*inicia uma array de usuários, com um número de 1 a 40 componentes e insere um usuario
        admin.*/

        Usuario[] arraydeusuarios = new Usuario[m];

        arraydeusuarios[0] = new Usuario("blabla", 999, 
        new Endereco("blabla", "blabla", "blabla", 999, 99999 ), "admin", "admin");

        /* Retire o comentário multibloco abaixo se você quiser rodar o programa já com alguns usuários
        previamente inseridos*/
        
        
        /*arraydeusuarios[1] = new Usuario("Camargo", 18, 
        new Endereco("Porto Alegre", "Rio Grande do Sul", "Sofia Veloso", 94, 703 ), "Joao1", "123");
        arraydeusuarios[2] = new Usuario("Correia", 19, 
        new Endereco("Recife", "Pernambuco", "Rua das Moreiras", 34, 803 ), "Joao2", "123");
        arraydeusuarios[3] = new Usuario("Companhia", 18, 
        new Endereco("Manaus", "Amazonas", "Rua das Bromelias", 84, 903 ), "Joao3", "123");
        arraydeusuarios[4] = new Usuario("Companhia", 18, 
        new Endereco("Jaboatao", "Pernambuco", "Rua das Margaridas", 104, 9030 ), "Joao4", "123");*/

        
        // Inicia o método "MenuInicial" com um conjunto de todos os usuários, que no momento possui só o admi
        Metodos.MenuInicial(arraydeusuarios);
      
      

    }
    
}