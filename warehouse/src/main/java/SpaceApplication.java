import dao.SpaceProductDao;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import representation.SpaceProduct;
import resource.SpaceProductResource;

public class SpaceApplication extends Application<SpaceConfiguration> {
    public static void main(String [] args) throws Exception {
        new SpaceApplication().run(args);
    }

    private final HibernateBundle<SpaceConfiguration> hibernate = new HibernateBundle<SpaceConfiguration>(SpaceProduct.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(SpaceConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<SpaceConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(SpaceConfiguration config, Environment environment) {
        final SpaceProductDao spaceProductDao = new SpaceProductDao(hibernate.getSessionFactory());
        environment.jersey().register(new SpaceProductResource(spaceProductDao));
    }
}
