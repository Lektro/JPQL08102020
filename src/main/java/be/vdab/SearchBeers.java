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

            TypedQuery<Beers> query = em.createNamedQuery("findAllKriek", Beers.class);

            List<Beers> beers = query.getResultList();

            for (Beers b : beers) {
                System.out.println(b.toString());
            }

            System.out.println("Beers Retrieved");
            tx.commit();
        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
