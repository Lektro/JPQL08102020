package be.vdab;

import javax.persistence.*;
import java.util.List;

public class SearchBeers {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("read");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            TypedQuery<Beer> query = em.createNamedQuery("findAllBeers", Beer.class);

            List<Beer> beers = query.getResultList();

            for (Beer b : beers) {
                System.out.println(b.toString());
            }

            System.out.println("Beer Retrieved");
            tx.commit();
        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
