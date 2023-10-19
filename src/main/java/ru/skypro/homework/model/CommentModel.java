package ru.skypro.homework.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "comment")
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int pk;

    @Column(name = "author_image")
    private String authorImage;

    @Column(name = "author_first_name")
    private String  authorFirstName;

    @Column(name = "create_data")
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "text")
    private String text;

    /*    @Column(name ="author")
    @JoinColumn(name = "user_id")
    private int author;*/

    // появляется поле user_id в таблице comments
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    // появляется поле ad_id в таблице comments
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_id")
    private AdModel adModel;

}
