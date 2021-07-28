/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.backend.artigo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import main.backend.autor.Autor;
import main.backend.volume.Volume;

/**
 *
 * @author raphael.rembischewski
 */
@Entity
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    int ordemVolume;
    
    @Column(nullable=false, length=2)
    String idioma;

    @Column(nullable=false)
    String titulo_pt;

    @Column(nullable=false)
    String tituloIng;
    
    @Column(nullable=false, length=2048)
    String resumoPt;
    
    @Column(nullable=false, length=2048)
    String resumoIng;
    
    // Palavras chave separadas pelo caracter ";"
    @Column(nullable=false, length=256)
    String pchavePt;
    
    // Palavras chave separadas pelo caracter ";"
    @Column(nullable=false, length=256)
    String pchaveIng;
    
    int num_paginas;
    
    @OneToMany(mappedBy = "artigo")
    List<Autor> autores;
    
    @ManyToOne
    Volume volume;
    
    public Artigo() {}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdemVolume() {
        return ordemVolume;
    }

    public void setOrdemVolume(int ordem) {
        this.ordemVolume = ordem;
    }

    public String getIdioma() {
        return idioma;
    }

  
    public void setIdioma(String idioma) {
        if(idioma.matches("pt|en|es")) {
     	this.idioma = idioma;
        }
        else {
     	   System.out.println("Idioma inválido");
        }
     }
    
    public String getTituloOriginal() {
        return titulo_pt;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.titulo_pt = tituloOriginal;
    }

    public String getTituloIng() {
        return tituloIng;
    }

    public void setTituloIng(String tituloIngles) {
        this.tituloIng = tituloIngles;
    }

    public String getResumoPt() {
        return resumoPt;
    }

    public void setResumoPt(String resumoOriginal) {
        this.resumoPt = resumoOriginal;
    }

    public String getResumoIng() {
        return resumoIng;
    }

    public void setResumoIng(String resumoIngles) {
        this.resumoIng = resumoIngles;
    }

    public String getPchavePt() {
        return pchavePt;
    }

    public void setPChavePT(List<String> pChavePT) {
        String palavrasChavePortugues = String.join(";", pChavePT);
        this.pchavePt = palavrasChavePortugues;
    }

    public String getPchaveIng() {
        return pchaveIng;
    }

    public void setPChaveIng(List<String> pChaveIng) {
        String palavrasChaveIngles = String.join(";", pChaveIng);
        this.pchaveIng = palavrasChaveIngles;
    }

    public int getQuantidadePaginas() {
        return num_paginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.num_paginas = quantidadePaginas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }
}