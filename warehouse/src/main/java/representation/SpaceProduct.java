package representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;

@Entity
@NamedQueries({
        @NamedQuery(name="SpaceProductBySpaceID", query="Select spaceProduct.productId, spaceProduct.quantity from SpaceProduct spaceProduct where spaceProduct = :sp")
})
@Getter
public class SpaceProduct {

    @Id
    String id;

    @NotBlank
    @JsonProperty("space_id")
    String spaceId;

    @JsonProperty
    String productId;

    @JsonProperty
    Integer quantity;
}
