package util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record BirthdayUtil(LocalDate birthday) {

    public long getAge(){
        return ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }
}
