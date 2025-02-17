package entity;

import entity.embeddable.UserActivityEntity;
import entity.embeddable.UserCredentialsEntity;
import entity.embeddable.UserPersonalInfoEntity;
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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private RoleType role;

    @Embedded
    private UserPersonalInfoEntity personalInfo;
    @Embedded
    private UserCredentialsEntity credentials;
    @Embedded
    private UserActivityEntity activity;


}
