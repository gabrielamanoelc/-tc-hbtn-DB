package models;

import entities.Pessoa;
import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    public void create(Pessoa p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa pessoa = em.find(Pessoa.class, p.getId());

        em.getTransaction().begin();
        pessoa.setNome(p.getNome());
        pessoa.setIdade(p.getIdade());
        pessoa.setCpf(p.getCpf());
        pessoa.setDataNascimento(p.getDataNascimento());
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void delete(Pessoa p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa pessoa = em.find(Pessoa.class, p.getId());

        em.getTransaction().begin();
        em.remove(pessoa);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

    public Pessoa findById(Pessoa p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Pessoa pessoa = em.find(Pessoa.class, p.getId());
        em.close();
        emf.close();
        return pessoa;
    }

    @SuppressWarnings("unchecked")
    public List<Pessoa> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas = em.createQuery("FROM " + Pessoa.class.getName()).getResultList();
        em.close();
        emf.close();
        return pessoas;
    }
}