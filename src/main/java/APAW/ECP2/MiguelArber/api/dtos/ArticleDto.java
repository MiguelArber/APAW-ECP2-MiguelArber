package APAW.ECP2.MiguelArber.api.dtos;

import APAW.ECP2.MiguelArber.api.entities.Article;

public class ArticleDto {

    private String reference;

    private int id;

    public ArticleDto() {
    }

    public ArticleDto(Article article) {
       id = article.getID();
       reference = article.getReference();
    }

    public int getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public void setreference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + reference + "\"}";
    }
}
