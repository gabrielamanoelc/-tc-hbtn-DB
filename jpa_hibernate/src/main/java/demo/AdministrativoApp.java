package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.Date;
import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();


        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

//         1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        Produto p1_update = new Produto(1L,"TV" , 300, 100, true);
        produtoModel.update(p1_update);


        Produto p1_findById = new Produto(1L);
        Produto produto = produtoModel.findById(p1_findById);
        System.out.println(produto);

        Produto p1_delete = new Produto(1L);
        produtoModel.delete(p1_delete);

        List<Produto> produtos_FinalList = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos_FinalList.size());


        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Alefe Patrick Dias Ramos");
        pessoa1.setIdade(24);
        pessoa1.setCpf("123456");
        pessoa1.setDataNascimento(new Date());

//         1) Criando uma pessoa
        pessoaModel.create(pessoa1);

        //2) Buscando todos as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        Pessoa pessoa1_update = new Pessoa(1L,"Lucas Adriano Dias Ramos" , 28, "145879", new Date());
        pessoaModel.update(pessoa1_update);

        Pessoa pessoa1_findById = new Pessoa(1L);
        Pessoa pessoa = pessoaModel.findById(pessoa1_findById);
        System.out.println(pessoa);

        Pessoa pessoa1_delete = new Pessoa(1L);
        pessoaModel.delete(pessoa1_delete);

        List<Pessoa> pessoas_FinalList = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas_FinalList.size());


    }
}