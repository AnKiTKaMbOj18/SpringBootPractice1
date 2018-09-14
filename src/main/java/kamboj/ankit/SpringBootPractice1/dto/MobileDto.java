package kamboj.ankit.SpringBootPractice1.dto;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class MobileDto {

    private Long id;
    private String name;
    private Long cost;

}
