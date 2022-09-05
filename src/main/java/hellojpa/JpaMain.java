package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        // DB당 하나만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 고객이 요청이 올때마다 썻다가 , 다시 버려야됨.
        EntityManager em = emf.createEntityManager();

        // JPA의 모든 데이터 변경은 트랙잭션 안에서 실행.
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작.
        tx.begin();
        // code
        try{
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        System.out.println("tx = " + tx);
        emf.close();
    }
}



