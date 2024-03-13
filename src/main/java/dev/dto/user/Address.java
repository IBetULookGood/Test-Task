package dev.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Address{
    private String zipCode;
    private Geo geo;
    private String suite;
    private String city;
    private String street;
}
