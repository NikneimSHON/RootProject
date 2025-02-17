package entity.embeddable;

import util.BirthdayUtil;
import converter.BirthdayConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class UserPersonalInfoEntity {
    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "birth_date")
    @Convert(converter = BirthdayConverter.class)
    private BirthdayUtil birthDate;

    @Column(name = "profile_image")
    private String profileImage;
}
