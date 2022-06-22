package models;

import entities.Pessoa;
import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {
    public void create(Produto p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        Produto produto = em.find(Produto.class, p.getId());

        em.getTransaction().begin();
        produto.setNome(p.getNome());
        produto.setQuantidade(p.getQuantidade());
        produto.setPreco(p.getPreco());
        produto.setStatus(p.getStatus());
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void delete(Produto p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        Produto produto = em.find(Produto.class, p.getId());

        em.getTransaction().begin();
        em.remove(produto);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

    public Produto findById(Produto p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, p.getId());
        em.close();
        emf.close();
        return produto;
    }

    @SuppressWarnings("unchecked")
    public List<Produto> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        List<Produto> produtos = new ArrayList<>();

        produtos = em.createQuery("FROM " + Produto.class.getName()).getResultList();
        em.close();
        emf.close();
        return produtos;
    }
}