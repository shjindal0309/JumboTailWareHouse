package dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import representation.SpaceProduct;

import java.util.List;

public class SpaceProductDao extends AbstractDAO<SpaceProduct> {
    public SpaceProductDao(SessionFactory factory) {
        super(factory);
    }

    @SuppressWarnings("unchecked")
    public List<SpaceProduct> findProductBySpaceId(String spaceId) {
        Query query = currentSession().getNamedQuery("SpaceProductBySpaceID");
        query.setParameter(spaceId, spaceId);
        List<SpaceProduct> spaceProducts = query.getResultList();
        return spaceProducts;
    }
}
