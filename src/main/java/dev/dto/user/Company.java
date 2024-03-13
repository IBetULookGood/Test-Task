package dev.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Company{
    private String bs;
    private String catchPhrase;
    private String name;
}
