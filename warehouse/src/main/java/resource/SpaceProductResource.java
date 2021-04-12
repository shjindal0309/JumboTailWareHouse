package resource;

import dao.SpaceProductDao;
import representation.SpaceProduct;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

@Path("/space-product")
@Produces(MediaType.APPLICATION_JSON)
public class SpaceProductResource {
    SpaceProductDao spaceProductDao;
    public SpaceProductResource(SpaceProductDao spaceProductDao) {
        this.spaceProductDao = spaceProductDao;
    }

    @GET
    @Path("/{spaceId}")
    public Response fetch(@PathParam("spaceId") String spaceId) {

        List<SpaceProduct> spaceProductList = spaceProductDao.findProductBySpaceId(spaceId);

        HashMap<String, Integer> productQtyList = new HashMap<String, Integer>();
        for(SpaceProduct spaceProduct : spaceProductList) {
            productQtyList.put(spaceProduct.getProductId(), spaceProduct.getQuantity());
        }

        return Response.ok(productQtyList).build();
    }
}
