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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ShoppingCartDateEntity {

    @Column(name = "creat_date")
    private LocalDateTime createDate;
    @Column(name = "status_update_date")
    private LocalDateTime statusUpdateDate;
}
