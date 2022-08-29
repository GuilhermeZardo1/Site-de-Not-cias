/*Trabalho para avaliação de Grau B do aluno Guilherme Luthemaier Zardo para a disciplina de Fundamentos de Programação, 
 Curso de Ciências da Computação, Unisinos. 

 */

public class Metodos {

    /* Classe com uma série de métodos estáticos úteis para o programa. Alguns pdoem não ter sido utilizados
    ou terem sido utilizados somente para teste.*/

    static Teclado teclado = new Teclado();
    static Site siteprovisorio;

    int n = (int)(Math.random() * 30 + 1);

    /*Método para iniciar a array de sites*/

    public static void IniciaArrayDeSites() {

        for (int i = 0; i < Arrays.todosossites.length; i++) {

            Arrays.todosossites[i] = new Site();
            Arrays.todosossites[i].setNumero(i);
            
        }
    }

    /*Menu inicial*/

    public static void MenuInicial(Usuario[] arraydeusuarios) {

     System.out.println("\nDigite:\n\n1 - para fazer Login;\n2 - para cadastrar um usuario no sistema;\n3 - para sair. \n");

     int  numero = teclado.leInt();

     if((numero==1) || (numero==2) || (numero==3)|| (numero==4)) {

        switch (numero) {
    
            case 1:
                LogIn(arraydeusuarios);
                break;
            case 2:
                CadastrarUsuario(arraydeusuarios);
                break;
            case 3:
                System.out.println("tchau!");
                System.exit(0);
                break;
            case 4:
                ImprimeUsuarios(arraydeusuarios);
                break;     
            }
        }

        else {
            System.out.println("Digite um número valido!");
            MenuInicial(arraydeusuarios);
        }

    }


    /* metodo para fazer login no sistema*/

    public static void LogIn(Usuario[] arraydeusuarios) {


    System.out.println("\nDigite o seu Login e sua senha: \n");
    System.out.println("\nLogin: \n");
    String login = teclado.leString();
    System.out.println("\nSenha: \n");
    String senha = teclado.leString();

    int indice = GetIndice(arraydeusuarios, login);

     if((ContemLogIn(arraydeusuarios, login)) && (ChecaSenha(arraydeusuarios[indice], senha))) {

        if(!login.equals("admin")) {

        
        MenuUsuario(arraydeusuarios[indice], arraydeusuarios[indice].getSites(), arraydeusuarios);

        }

        else{

            
            MenuAdmin(arraydeusuarios[indice], arraydeusuarios[indice].getSites(), arraydeusuarios);
        }
        
    }

    else {

        System.out.println("\nDados incorretos! Tente Novamente!\n");
        LogIn(arraydeusuarios);

    }   
}

/* Menu do Admin */

    public static void MenuAdmin(Usuario usuario, Site[] arraydesites, Usuario[] arraydeusuarios) {

        System.out.println("\nDigite:\n\n 1- para listar todos os sites disponíveis;\n 2- para imprimir a quantidade de assinantes" +
        "de cada site;\n 3- para imprimir o valor que cada site está ganhando com assinaturas;\n " +
        "4- para imprimir o lucro da empresa com as assinaturas;\n" +
        "5- para imprimir o endereço de todos os usuários que moram em determinado estado;\n " +
        "6- para remover fake news;\n " +
        "7- para fazer logout; \n");

        int  numero = teclado.leInt();

        if((numero==1) || (numero==2) || (numero==3)|| (numero==4) || (numero==5) || (numero==6) || 
        (numero==7)) {

            switch (numero) {
    
                case 1:
                    ImprimeSites(Arrays.todosossites);
                    MenuAdmin(usuario, arraydesites, arraydeusuarios);
                    break;
                case 2:
                    ImprimeAssinantes(Arrays.todosossites);
                    MenuAdmin(usuario, arraydesites, arraydeusuarios);
                    break;
                case 3:
                    ValorAssinaturas(Arrays.todosossites);
                    MenuAdmin(usuario, arraydesites, arraydeusuarios);
                    break;
                case 4:
                    ValorLucro(Arrays.todosossites);
                    MenuAdmin(usuario, arraydesites, arraydeusuarios);
                    break;
                case 5:
                    System.out.println("\nDigite o Estado para ser buscado: \n");
                    String  estado = teclado.leString();
                    BuscaEnderecoEstado(arraydeusuarios, estado);
                    MenuAdmin(usuario, arraydesites, arraydeusuarios);
                    break;  
                case 6:
                    EliminaFakeNews(Arrays.todosossites);
                    MenuAdmin(usuario, arraydesites, arraydeusuarios);
                    break;  
                case 7: 
                    MenuInicial(arraydeusuarios);
                    break;  
            }
        }
        else {
    
            System.out.println("\nDigite um número valido!\n");
            MenuAdmin(usuario, arraydesites, arraydeusuarios);
        }

} 

/* Método para cadastrar um usuario novo no sistema.*/

    public static void CadastrarUsuario(Usuario[] arraydeusuario) {

        System.out.println("\nDigite as informações do usuário a ser cadastrado! \n");
        System.out.println("\nDigite o nome do novo usuário: \n");
        String nome = teclado.leString();
        System.out.println("\nDigite a idade do novo usuário:  \n");
        int idade = teclado.leInt();
        System.out.println("\nDigite a cidade do novo usuário: \n");
        String cidade = teclado.leString();
        System.out.println("\nDigite o estado do novo usuário: \n");
        String estado = teclado.leString();
        System.out.println("\nDigite a rua do novo usuário: \n");
        String rua = teclado.leString();
        System.out.println("\nDigite o numero da casa do novo usuário: \n");
        int numero = teclado.leInt();
        System.out.println("\nDigite o cep do novo usuário: \n");
        int cep = teclado.leInt();
        System.out.println("\nDigite o login do novo usuário:  \n");
        String login = teclado.leString();
        System.out.println("\nDigite a senha do novo usuário:  \n");
        String senha = teclado.leString();

        Endereco e = new Endereco(cidade, estado, rua, numero, cep);

        Usuario u = new Usuario(nome, idade, e, login, senha);

        for(int i = 0; i < arraydeusuario.length; i++)
        if(arraydeusuario[i] == null) {
            arraydeusuario[i] = u;
            System.out.println("\nUsuario cadastrado!:  \n");
            break;
        }

        MenuInicial(arraydeusuario);

}  

/*  Métodos que fornece as opções para o usuário não-admin*/ 

    public static void MenuUsuario(Usuario usuario, Site[] arraydesites, Usuario[] arraydeusuarios) {

        System.out.println("\nDigite:\n\n 1- para listar todos os sites disponíveis;\n 2- para assinar um site de sua escolha;\n" +
        "3- para listar todos os sites que você assina;\n 4- para cancelar a assinatura de algum dos seus sites;\n" +
        "5- para ver as manchetes de algum site que você assina;\n 6- para ler alguma notícia de um site" +
        "que você assina;\n 7- para buscar notícias em um site que você assina através de palavras-chave;\n" +
        "8- para imprimir todas as manchetes de determinado ano;\n 9- para fazer logout; \n");

        int  numero = teclado.leInt();

        if((numero==1) || (numero==2) || (numero==3)|| (numero==4) || (numero==5) || (numero==6) || 
        (numero==7)|| (numero==8) || (numero==9)) {

            switch (numero) {
        
                case 1:
                    ImprimeSites(Arrays.todosossites);
                    MenuUsuario(usuario, arraydesites, arraydeusuarios);
                    break;
                case 2:
                    System.out.println("\nDigite o número do site que você quer assinar!\n");
                    int  numero2 = teclado.leInt();
                    CadastraSite(Arrays.todosossites[numero2], usuario.getSites());
                    MenuUsuario(usuario, arraydesites, arraydeusuarios);
                    break;
                case 3:
                    ImprimeSites(usuario.getSites());
                    MenuUsuario(usuario, arraydesites, arraydeusuarios);
                    break;
                case 4:
                    System.out.println("\nDigite o número do site que você quer cancelar a assinatura!\n");
                    int  numero3 = teclado.leInt();
                    CancelarSite(GetIndiceSite(usuario.getSites(), numero3), usuario.getSites());
                    MenuUsuario(usuario, arraydesites, arraydeusuarios);
                    break;
                case 5:
                    System.out.println("\nDigite o número do site que você quer ler as manchetes!\n");
                    int  numero4 = teclado.leInt();
                    int indice1 = GetIndiceSite(usuario.getSites(), numero4);
                    MostrarManchetes(usuario.getSites()[indice1]);
                    siteprovisorio = usuario.getSites()[indice1];
                    MenuUsuario(usuario, arraydesites, arraydeusuarios);
                    break;  
                case 6:
                    System.out.println("\nDigite o número da manchete que você quer ler a noticia!\n");
                    int numero5 = teclado.leInt();
                    siteprovisorio.getNoticias()[numero5].ImprimeNoticia();
                    MenuUsuario(usuario, arraydesites, arraydeusuarios);
                    break;  
                case 7:
                    System.out.println("\nDigite a palavra chave que você quer buscar nos sites que você é assinante!\n");
                    String palavrachave = teclado.leString();
                    BuscaPalavraChave(usuario.getSites(), palavrachave);
                    MenuUsuario(usuario, arraydesites, arraydeusuarios);
                    break; 
                case 8:
                    System.out.println("\nDigite o ano que você quer buscar na data de suas notícias!\n");
                    int anoescolhido = teclado.leInt();
                    BuscaAno(usuario.getSites(), anoescolhido);
                    MenuUsuario(usuario, arraydesites, arraydeusuarios);
                    break;
                case 9:
                    MenuInicial(arraydeusuarios);
                    break;      
                }
            }
            else {
        
                System.out.println("Digite um número valido!\n");
                MenuUsuario(usuario, arraydesites, arraydeusuarios);
            }
        }


    /* Método para verificar (retornando um boolean) se uma string 
    está contida em uma array de strings. */

    public static boolean ContemString(String[] arr, String targetValue) {

        for(int i = 0; i < arr.length;) {

            if(arr[i]!=null){

            if(arr[i].equals(targetValue)) {
                return true;
            }
            else {
                i++;
                 }
                          }
        else {
            i++;
        }
    }
    return false;   
    }

    /* Método para ver o índice de um usuario em uma string de usuários */

    public static int GetIndice(Usuario[] arr, String targetValue) {

        for(int i = 0; i < arr.length;) {

            if(arr[i]!=null){

            if(arr[i].getLogin().equals(targetValue)) {
                return i;
            }
            else {
                i++;
                 }
                          }
        else {
            i++;
        }
    }
    return -1;   
    }

    /* Método para ver o indice de um site em uma array de sites pelo numero */

    public static int GetIndiceSite(Site[] arr, int targetValue) {

        for(int i = 0; i < arr.length;) {

            if(arr[i]!=null){

            if(arr[i].getNumero()==targetValue) {
                return i;
            }
            else {
                i++;
                 }
                          }
        else {
            i++;
        }
    }
    return -1;   
    }

    /* Método para verificar se uma array de Ususarios tem algum objeto com determinado valor de login
     */

    public static boolean ContemLogIn(Usuario[] arr, String targetValue) {

        for(int i = 0; i < arr.length;) {

            if(arr[i]!=null){

            if(arr[i].getLogin().equals(targetValue)) {
                return true;
            }
            else {
                i++;
                 }
                          }
        else {
            i++;
        }
    }
    return false;   
    }

     /* Método para verificar se uma array de Usuarios tem algum objeto com determinado valor de senha
     */

    public static boolean ContemSenha(Usuario[] arr, String targetValue) {

        for(int i = 0; i < arr.length;) {

            if(arr[i]!=null){

            if(arr[i].getSenha().equals(targetValue)) {
                return true;
            }
            else {
                i++;
                 }
                          }
        else {
            i++;
        }
    }
    return false;   
    }

     /* Método para verificar se um usuário tem uma senha específica
     */

    public static boolean ChecaSenha(Usuario usuario, String targetValue) {

            if(usuario !=null){

            if(usuario.getSenha().equals(targetValue)) {
                return true;
            }
            else {
                return false; 
                 }

                }

                return false;
         }
    
   
    /* Método para Verificar se um inteiro está contido em uma array
    de inteiros, retornando um boolean se for um caso. */

    public static boolean ContemInt(int[] arr, int targetValue) {

        for(int s: arr){
            if(s==targetValue)
                return true;
        }
        return false;
    }

    /* Método para checar se uma array de inteiros possui
    espaços disponíveis para que outros elementos sejam acrescentados, 
    retornando um boolean. */

    public static boolean ChecaCheioInt(int[] array) {
        
            for(int i = 0; i < array.length;) {
                
                if (array[i]==0) {

                    return false;
                   
                }
                else if((array[i]!=0) && (i!=array.length-1)) {
                    i++;
                }

                else if ((array[i]!=0) && (i==array.length-1)) {

                    return true;
                }
                
            }
            return true;
    }

    /* Método para checar se uma array de strings possui
    espaços disponíveis para que outros elementos sejam acrescentados, 
    retornando um boolean. */

    public static boolean ChecaCheioString(String[] array) {
        
        for(int i = 0; i < array.length;) {
            
            if (array[i]==null) {

                return false;
               
            }
            else if((array[i]!=null) && (i!=array.length-1)) {
                i++;
            }

            else if ((array[i]!=null) && (i==array.length-1)) {

                return true;
            }
            
        }
        return true;

    }

    /* Método que cria a sequência de pessoas que compraram as Tele Senas para o sorteio.
    Seleciona aleatoriamente nomes da array "clientes", sem repeti-los.*/

    public static Site[] CriaSequenciaSites(int n){

       Site[] a = new Site[n];
    
        for (int i = 0; i < n;) {
    
            Site p = new Site();
    
            if(!Metodos.ContemPessoa(a, p.getNome())) {
    
                a[i] = p;
                i++;
            }
        }
    
        return a;
    
        }

    /* Método que verifica se uma array de pessoas contém um pessoa determinada, 
    retornando um boolean.*/

    public static boolean ContemPessoa(Site[] arr, String targetValue) {
        for(int i = 0; i < arr.length;) {
    
            if(arr[i]!=null){
    
            if(arr[i].getNome().equals(targetValue)) {
    
                return true;
            }
            else {
                i++;
            }
        }
    
        else {
    
            i++;
        }
    
        }
    
        return false;
    
        }

    /* Métodos para selecionar Nome, Manchete ou Texto, da classe Arrays, aleatoriamente. */

    public static String SelecionaNome() {

        int n = (int)(Math.random() * 36 + 1);
    
        return Arrays.nomes[n];
    }

    public static String SelecionaManchete() {

        int n = (int)(Math.random() * 36 + 1);
    
        return Arrays.manchetes[n];
    }

    public static String SelecionaTexto() {

         int n = (int)(Math.random() * 38 + 1);
    
        return Arrays.textos[n];
    }

    /* Método para imprimir todos os sites de uma array. */

    public static void ImprimeSites(Site[] array) {
  
        for (int i = 0; i < array.length; i++) {

            if(array[i]!=null) {
            
            array[i].ImprimeSite();
            }
                
        }

    }

    /* Método para imprimir todas as notícias de uma array de notícias */

    public static void ImprimeNotícias(Noticia[] array) {

        for (int i = 0; i < array.length; i++) {

            array[i].ImprimeNoticia();
                
        }

    }

    /* Método para imprimir todos os usuários de uma array de usuários. */

    public static void ImprimeUsuarios(Usuario[] array) {

        for (int i = 0; i < array.length; i++ ) {

            if(array[i]!=null) {

            array[i].ImprimeUsuario();
                
                
        }   

        }
    }

    /* Método para acrescentar um site em uma array de sites, numa posição não nula. */

    public static void CadastraSite(Site site, Site[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if(arr[i]==null) {

                arr[i] = site;
                site.setAssinantesMais(); 
                break;
            }
            
        }

    }

    /* Método para retirar um site em uma array de sites, gerando uma posição nula.*/

    public static void CancelarSite(int pos, Site[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if(arr[i]!=null) {

                if(i==pos){
                arr[i].setAssinantesMenos();
                arr[i] = null;
                System.out.println("Assinatura Cancelada!\n");
                break;
                }
            }
            
        }

    }

    /* Método para mostrar todas as manchetes de um site*/

    public static void MostrarManchetes(Site site) {

        for (int i = 0; i < site.getNoticias().length; i++) {

            if(site.getNoticias()[i]!=null) {

                System.out.println("Manchete numero" + i + ": \n");
                System.out.println(site.getNoticias()[i].getManchete());

                
            }
            
        }

    }

    /* Método para buscar as manchetes das notícias a partir de determinada palavra-chave.*/

    public static void BuscaPalavraChave(Site[] arr, String palavra) {

        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null) {
            for (int j = 0; j < arr[i].getNoticias().length; j++) {
                if(arr[i]!=null) {
                        if(arr[i].getNoticias()[j].getTexto().contains(palavra)) {
                            contador++;
                            System.out.println("Manchete numero" + i + ": \n");
                            System.out.println(arr[i].getNoticias()[j].getManchete());
                        }
                    }
                    }
                }
        } 

    }

    /* Método para buscar as notícias por ano.*/

    public static void BuscaAno(Site[] arr, int ano) {

        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null) {
            for (int j = 0; j < arr[i].getNoticias().length; j++) {
                if(arr[i]!=null) {
                        if(arr[i].getNoticias()[j].getData().getAno() == ano) {
                            contador++;
                            System.out.println("Manchete numero" + i + ": \n");
                            System.out.println(arr[i].getNoticias()[j].getManchete());
                        }
                    }
                    }
                }
        } 

    }

    /* Método para imprimir o número de assinantes de todos os sites*/

    public static void ImprimeAssinantes(Site[] array) {

        for (int i = 0; i < array.length; i++) {

            if(array[i]!=null) {

                System.out.println("Site n.: " + array[i].getNumero() + "\n");
                System.out.println(array[i].getAssinantes() + " assinantes");
                System.out.println("\n");
            
            }
            
        }

    }

    /* Método para imprimir o valor de assinatura de todos os sites.*/

    public static void ValorAssinaturas(Site[] array) {

        for (int i = 0; i < array.length; i++) {

            if(array[i]!=null) {

                System.out.println("Site n.: " + array[i].getNumero() + "\n");
                System.out.println("R$ " + ((array[i].getAssinantes())*(array[i].getAssinatura())));
                System.out.println("\n");
            
            }
            
        }

    }

    /* Método para imprimir o valor do lucro do dono do site.*/

    public static void ValorLucro(Site[] array) {

        int contador = 0;

        for (int i = 0; i < array.length; i++) {

            if(array[i]!=null) {



                contador++;
            
            }
            
        }

        System.out.println("O valor totam com assinaturas é: R$" + (contador*0.3) + "\n");

    }

    /* Método que busca endereços por Estado.*/

    public static void BuscaEnderecoEstado(Usuario[] arr, String estado) {

        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null) {
                
                if(arr[i].getEndereco().getEstado().equals(estado)) {
                    
                    arr[i].ImprimeUsuario();
             
                }


                }
        } 

    }

    /* Método que retira "Fake News" da array dos sites*/

    public static void EliminaFakeNews(Site[] arr) {

        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null) {
            for (int j = 0; j < arr[i].getNoticias().length; j++) {
                if(arr[i].getNoticias()[j]!=null) {
                        if( (arr[i].getNoticias()[j].getTexto().length()<20) &&
                         ((arr[i].getNoticias()[j].getManchete().contains("!!!")))) {
                            contador++;
                            System.out.println("Fake News Removida!\n");
                            arr[i].getNoticias()[j].ImprimeNoticia();
                            arr[i].getNoticias()[j] = null;
                        }
                    }
                    }
                }
        } 

    }

 

}
