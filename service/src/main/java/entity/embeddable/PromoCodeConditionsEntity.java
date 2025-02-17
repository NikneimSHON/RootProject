package entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class PromoCodeConditionsEntity {
    @Column(name = "discount_sum")
    private BigDecimal discountSum;

    @Column(name = "min_order_amount")
    private Integer minOrderAmount;

}
