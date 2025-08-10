package com.locus_narrative.projects_service.domain.entities;



public class BoardEntity {
    private Long id = null;
    private String name;

    public BoardEntity(String name) {
        this.name = name;

    }

    public BoardEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
