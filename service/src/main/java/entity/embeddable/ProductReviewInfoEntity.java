package entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class ProductReviewInfoEntity {
    @Column(name = "data_create")
    private LocalDateTime date_create;
    @Column(name = "description_review")
    private String descriptionReview;
    @Column(name = "image_product")
    private String imageProduct;
    private Integer rating;
}
