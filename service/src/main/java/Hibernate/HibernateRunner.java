package Hibernate;

import entity.*;
import entity.embeddable.*;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Builder
public class HibernateRunner {

    public static void main(String[] args) {
        ShoppingCartEntity shoppingCartEntity = ShoppingCartEntity.builder()
                .userId(1L)
                .orderStatus("good")
                .shoppingCartDate(ShoppingCartDateEntity.builder()
                        .createDate(LocalDateTime.now())
                        .statusUpdateDate(LocalDateTime.now())
                        .build())
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            log.trace("Transaction begin , {}", transaction);

            session.persist(shoppingCartEntity);


            session.getTransaction().commit();
        }

    }
}
