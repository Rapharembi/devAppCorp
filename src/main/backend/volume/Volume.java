package main.backend.volume;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import main.backend.artigo.Artigo;

/**
 *
 * @author raphael.rembischewski
 */
@Entity
public class Volume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    int edicao;
    
    @Column(nullable=false, length=32)
    String sigla;

    @Column(nullable=false, length=2048)
    String descPt;

    @Column(nullable=false, length=2048)
    String descIng;
    
    @Column(nullable=false, length=64)
    String cidade;
    
    //data no padrão yyyy-mm-dd ";"
    @Column(nullable=false)
    String data;
    
    @OneToMany(mappedBy = "volume")
    List<Artigo> artigos;
    
    final static String DATE_FORMAT = "yyyy-mm-dd";

    public static boolean validateDate(String date) 
    {
            try {
                DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                df.setLenient(false);
                df.parse(date);
                return true;
            } catch (ParseException e) {
                return false;
            }
    }
    
    
    public Volume() {}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescPt() {
        return descPt;
    }

    public void setDescPt(String descPt) {
        this.descPt = descPt;
    }

    public String getDescIng() {
        return descIng;
    }

    public void setDescIng(String descIng) {
        this.descIng = descIng;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (validateDate(data)) {
        	this.data = data;
        }
        else {
        	System.out.println("Data inválida");
        }
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setAutores(List<Artigo> artigos) {
        this.artigos = artigos;
    }

}