package dev.dto.post;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Post{
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
