package lesson.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_type", nullable = false)
    private PostType postType;

    // todo: N + 1 https://vladmihalcea.com/n-plus-1-query-problem/
//    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @Builder.Default
//    @ToString.Exclude
//    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_post"))
    @ToString.Exclude
    private UserEntity userEntity;

//    public PostEntity withComment(final CommentEntity commentEntity) {
//        if (nonNull(commentEntity)) {
//            this.commentEntityList.add(commentEntity.setPostEntity(this));
//        }
//        return this;
//    }
}
