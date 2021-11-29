package Principal;

import java.lang.Comparable;
import java.util.Comparator;
import java.util.*;

import Amigo.*;
import Emprestimo.*;
import Item.*;

public class Principal {

    private static Biblioteca bib = new Biblioteca("Biblioteca Pessoal");
    private static ListaEmprestimos emprestimos = new ListaEmprestimos();
    private static ListaAmigos amigos = new ListaAmigos();
    private static ListaItens itens = new ListaItens();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        int idAmigo;

        idAmigo = amigos.addAmigo("Fulano");
        System.out.println("Adicionado com código " + idAmigo);

        idAmigo = amigos.addAmigo("Ciclano");
        System.out.println("Adicionado com código " + idAmigo);

        ArrayList<Amigo> alAmigos = amigos.getListaAmigos();
        for (Amigo amigo : alAmigos) {
            System.out.println(amigo);
        }
        try {
            do {
                System.out.println("\n======= MENU =======");
                System.out.println("\nOpção: ");
                System.out.println("0 - Sair\n" +
                        "1 - Cadastrar item\n" +
                        "2 - Cadastrar amigo\n" +
                        "3 - Emprestar\n" +
                        "4 - Devolver\n" +
                        "5 - Listar emprestimos atuais\n" +
                        "6 - Listar histórico de empréstimos\n" +
                        "7 - Listar biblioteca\n" +
                        "8 - Alterar estado\n");
                opcao = teclado.nextInt();

                switch (opcao) {
                    case 0:
                        System.out.println("  Obrigado por usar o sistema");
                        break;
                    case 1:
                        CadastraItem();
                        break;
                    case 2:
                        CadastrarAmigo();
                        break;
                    case 3:
                        Emprestar();
                        break;
                    case 4:
                        Devolver();
                        break;
                    case 5:
                        EmprestimosAtuais();
                        break;
                    case 6:
                        HistoricoEmprestimos();
                        break;
                    case 7:
                        ListarBiblioteca();
                        break;
                    case 8:
                        AlterarEstado();
                        break;

                    default:
                        System.out.println("Opção inexidente!");
                        break;
                }
            } while (opcao != 0);
        } catch (InputMismatchException e) {
            System.out.println("A opção escolhida deve estar no formato numeral");
        }
    }

    public static void CadastraItem() {
        Item item = null;
        int opcao;
        int idItem = itens.getAlItens().size() + 1;
        String titulo;
        Date dataDeLancamento;


        try {
            System.out.println("Tipo de item");
            System.out.println("1- Livro\n" +
                    "2- Jogo \n" +
                    "3- Filme\n");
            opcao = teclado.nextInt();
            System.out.println("Titulo");
            titulo = teclado.next();
            System.out.println("Data de lancamento: ");
            String datastring = teclado.next();
            dataDeLancamento = new Date(datastring);

            switch (opcao) {
                case 1:
                    String autor;
                    try {
                        System.out.println("Autor");
                        autor = teclado.next();
                        System.out.println("Número de páginas");
                        String input = teclado.next();
                        int pag = Integer.valueOf(input);
                        Livro l = new Livro(idItem, titulo, dataDeLancamento, autor, pag);
                        itens.addItem(l);
                        System.out.println("Item cadastratrado com sucesso");
                    } catch (InputMismatchException e) {
                        System.out.println("ERRO!! o numero de paginas deve estar em formato numeral!");
                    }
                    break;
                case 2:
                    String estudio, plataforma;

                    System.out.println("Estudio: ");
                    estudio = teclado.next();
                    System.out.println("Plataforma: ");
                    plataforma = teclado.next();

                    Jogo j = new Jogo(idItem, titulo, dataDeLancamento, estudio, plataforma);
                    itens.addItem(j);
                    System.out.println("Item cadastratrado com sucesso");
                    break;
                case 3:
                    String Genero;
                    System.out.println("Genero: ");
                    Genero = teclado.next();

                    Filme F = new Filme(idItem, titulo, dataDeLancamento, Genero);
                    itens.addItem(F);
                    System.out.println("Item cadastratrado com sucesso");
                    break;
                default:
                    System.out.println("Opção inexidente");
            }
            if (item != null) {
                itens.addItem(item);
            }

        } catch (InputMismatchException e) {
            System.out.println("ERRO!! a opção deve ser escrita no formato numeral");
        }

    }

    public static void CadastrarAmigo() {
        Amigo amigo;
        String nome;
        int id = amigos.getAlAmigos().size() + 1;


        System.out.println("Nome do amigo: ");
        nome = teclado.next();
        amigo = new Amigo(id, nome);
        amigos.addAmigo(nome);
        System.out.print(nome + " adicionado com sucesso!!\n" + "Id Amigo:" + id);
    }

    public static void Emprestar() {
        System.out.println("\n======= Emprestimo =======");
        Emprestimo em;
        String amigo;
        int i = 0, j = 0;
        boolean achouAmigo = false;
        boolean achouItem = false;

        System.out.println("Digite o nome do amigo: ");
        amigo = teclado.next();

        for (Amigo a : amigos.getAlAmigos()) {
            if (amigo.toUpperCase().equals(a.getNomeAmigo().toUpperCase())) {
                achouAmigo = true;
                System.out.println("\n\n=============================== Itens cadastrados ==============================");
                for (Item it : itens.getListaItens()) {
                    System.out.println(it.toString());
                }
                System.out.println("\n\nDigite o código de identicação do item desejado: ");
                String input = teclado.next();
                int idItem = Integer.valueOf(input);
                for (Item it : itens.getAlItens()) {
                    if (idItem == it.getIdItem()) {
                        achouItem = true;
                        if (it.getDispItem() == Disponibilidade.DISPONIVEL) {

                            try {
                                System.out.println("Data de emprestimo: ");
                                String datastring = teclado.next();
                                Date DataEmprestimo = new Date(datastring);

                                em = new Emprestimo(a.getIdAmigo(), idItem, DataEmprestimo);
                                emprestimos.addEmprestimo(em);
                                it.setDispItem(Disponibilidade.EMPRESTADO);
                                System.out.println("Item emprestado com sucesso!!");
                            } catch (InputMismatchException e) {
                                System.out.println("ERRO!! A data deve ta no formato XX/XX/XXXX !");
                            }
                        } else {
                            System.out.println("O item está: " + it.getDispItem());
                        }
                    }
                }
                if (achouItem == false) {
                    System.out.println("Não encontramos o item desejado!");
                }
            }
        }
        if (achouAmigo == false) {
            System.out.println("Não encontramos o amigo desejado!");
        }
    }

    public static void Devolver() {
        System.out.println("\n======= Devolucao de itens =======");
        String dataD;
        int idItem;
        int i = 0;

        System.out.println("Digite o codigo de identicação do item: ");
        String input = teclado.next();
        idItem = Integer.valueOf(input);

        for (Item it : itens.getAlItens()) {
            if (idItem == it.getIdItem()) {
                if (it.getDispItem().equals(Disponibilidade.EMPRESTADO)) {
                    for (Emprestimo em : emprestimos.getAlEmprestimos()) {
                        if (idItem == em.getIdItem() && em.getDataDevolucao() == null) {
                            try {
                                System.out.println("Data da devolucao: ");
                                String datastring = teclado.next();
                                Date DataDevolucao = new Date(datastring);

                                em.setDataDevolucao(DataDevolucao);

                                it.setDispItem(Disponibilidade.DISPONIVEL);
                                System.out.println("O item foi devolvido com sucesso!!");
                            } catch (InputMismatchException e) {
                                System.out.println("ERRO!! A data deve ta no formato XX/XX/XXXX !");
                            }
                        }
                    }

                } else {
                    System.out.println("O item nao está emprestado!");
                }
            } else {
                i++;
            }
        }
        if (i >= itens.getAlItens().size()) {
            System.out.println("Não encontramos o item desejado!");
        }
    }

    private static void EmprestimosAtuais() {
        for (Emprestimo em : emprestimos.getAlEmprestimos()) {
            for (Amigo amigo : amigos.getAlAmigos()) {
                for (Item it : itens.getListaItens()) {
                    if (amigo.getIdAmigo() == em.getIdAmigo() && it.getIdItem() == em.getIdItem()) {
                        if (it.getDispItem() == Disponibilidade.EMPRESTADO) {
                            System.out.println("\n======================== Itens Emprestados Atualemnte ========================");
                            System.out.println(it + "\n");
                            System.out.println("Nome: " + amigo.getNomeAmigo());
                            System.out.println("Emprestou: " + it.getTituloItem());
                            System.out.println("Data de emprestimo: " + em.getDataEmprestimoBr1());
                        } else {
                            System.out.println("Não possuimos nenhum item emprestado atualmete");
                        }
                    }
                }
            }
        }
    }

    private static void HistoricoEmprestimos() {
        System.out.println("\n=======Historico de emprestimo======");
        for (Emprestimo em : emprestimos.getAlEmprestimos()) {
            for (Amigo amigo : amigos.getAlAmigos()) {
                for (Item it : itens.getListaItens()) {
                    if (amigo.getIdAmigo() == em.getIdAmigo() && it.getIdItem() == em.getIdItem()) {
                        System.out.println("Nome: " + amigo.getNomeAmigo());
                        System.out.println("Emprestou: " + it.getTituloItem());
                        System.out.println("Data de emprestimo: " + em.getDataEmprestimoBr1());
                        if (it.getDispItem() == Disponibilidade.DISPONIVEL) {
                            System.out.println("Situação: Disponivel");
                        } else if (it.getDispItem() == Disponibilidade.EMPRESTADO) {
                            System.out.println("Situação: Emprestado");
                            System.out.println("Data de devolução: " + em.getDataDevolucao());
                        }
                    }
                }
            }
        }
    }

    private static void ListarBiblioteca() {
        System.out.println("\n=======Listagem da biblioteca=======");
        Collections.sort(itens.getListaItens());
        for (Item it : itens.getListaItens()) {
            System.out.println("Titulo: " + it.getTituloItem() + " Disponibilidade: " + it.getDispItem());
        }
    }

    private static void AlterarEstado() {
        int id, opcao;
        boolean j = false;
        Scanner teclado = new Scanner(System.in);

        System.out.println("\n\n=============================== Itens cadastrados ==============================");
        for (Item it : itens.getListaItens()) {
            System.out.println(it.toString());
        }
        System.out.println("\n\n:: Digite o numero de identicação do item desejado: ");
        id = teclado.nextInt() - 1;
        if (id <= itens.size()) {
            for (Item it : itens.getListaItens()) {
             
                    System.out.println("Digite a opção de auteração de estado desejada");
                    System.out.println("1 - Consultural\n" +
                            "2 - Danificado\n" +
                            "3 - Extravidado\n");
                    opcao = teclado.nextInt();
                    switch (opcao) {
                        case 1:
                            if (it.getDispItem() == Disponibilidade.EMPRESTADO) {
                                it.setDispItem(Disponibilidade.CONSULTALOCAL);
                                j = true;
                                break;
                            } else {
                                System.out.println("Não foi possivel efetuar a mudança pois o item não esta emprestado");
                            }
                        case 2:
                            it.setDispItem(Disponibilidade.DANIFICADO);
                            j = true;
                            break;
                        case 3:
                            it.setDispItem(Disponibilidade.EXTRAVIADO);
                            j = true;
                            break;
                        default:
                            System.out.println("Opção inexistente");
                            break;
                    }
                    if (j == true) {
                        System.out.println("Mudança efetuada com sucesso");
                    }
                
            }
        }
    }
}