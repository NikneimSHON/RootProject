package util;

import converter.BirthdayConverter;
import entity.*;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.addAnnotatedClass(UserEntity.class);
        configuration.addAnnotatedClass(PromoCodeEntity.class);
        configuration.addAnnotatedClass(AddressEntity.class);
        configuration.addAnnotatedClass(ProductEntity.class);
        configuration.addAnnotatedClass(ProductReviewEntity.class);
        configuration.addAnnotatedClass(ShoppingCartEntity.class);
        configuration.addAttributeConverter(new BirthdayConverter(),true);
        configuration.configure();

        return configuration.buildSessionFactory();
    }

}
