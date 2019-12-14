package Utils;

import Models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();

        configuration.addAnnotatedClass(User.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        return configuration.buildSessionFactory(builder.build());
    }
}
