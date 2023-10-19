package ru.skypro.homework.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ad")

public class AdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_id")
    private int pk;

    @Column(name = "ad_image")
    private String image;

    @Column(name = "price")
    private int price;

    @Column(name = "title")
    private String title;

/*    @Column(name = "user_id")
    @JoinColumn(name = "author_id")
    private int author;*/


    // появляется поле user_id в таблице ad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    // у одного объявления много комментариев
    @OneToMany(mappedBy = "adModel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CommentModel> commentModels;


}
