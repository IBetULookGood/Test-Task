package dev.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User{
    private String website;
    private Address address;
    private String phone;
    private String name;
    private Company company;
    private Integer id;
    private String email;
    private String username;
}
