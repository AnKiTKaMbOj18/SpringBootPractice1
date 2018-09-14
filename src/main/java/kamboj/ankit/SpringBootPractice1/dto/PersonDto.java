package kamboj.ankit.SpringBootPractice1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Builder(toBuilder = true)
@ToString
@JsonInclude(Include.NON_NULL)
public class PersonDto {

    private final Long id;
    private final String name;
    private final List<MobileDto> mobileDtos;

    private PersonDto(){
        id=null;
        name=null;
        mobileDtos=new ArrayList<>();
    }
}
