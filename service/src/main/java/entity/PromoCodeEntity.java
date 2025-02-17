package entity;

import entity.embeddable.PromoCodeConditionsEntity;
import entity.embeddable.PromoCodeInfoEntity;
import entity.embeddable.PromoCodeValidityEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "promo_code")
public class PromoCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "remaining_quantity")
    private int remainingQuantity;

    @Embedded
    private PromoCodeInfoEntity promoCodeInfo;

    @Embedded
    private PromoCodeConditionsEntity promoCodeConditions;

    @Embedded
    PromoCodeValidityEntity promoCodeValidity;


}
