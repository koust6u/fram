package web.fram.side.article.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.fram.side.common.config.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article extends BaseTimeEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(name = "TITLE", nullable = false)
    private Title title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Embedded
    @Column(name = "CONTENT", nullable = false)
    private Content content;

    public Article(final Title title, final String author, final Content content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public String getContentAsString() {
        return content.getContent();
    }

    public String getTitleAsString() {
        return title.getTitle();
    }
}
