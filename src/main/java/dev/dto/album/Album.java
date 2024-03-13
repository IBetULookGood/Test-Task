package dev.dto.album;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Album{
    private Integer userId;
    private Integer id;
    private String title;
}
