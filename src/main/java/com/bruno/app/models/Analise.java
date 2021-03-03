package com.bruno.app.models;

import java.util.Date;

public class Analise {
    private Integer numTalhao;
    private Double areaTalhaoHa;
    private Date dataAnalise;
    private Double areaTotalHa;
    private Double profundidadeAmostraSoloCm;
    private Integer texturaSolo;
    private Integer sistemaCultivo;
    private Usuario responsavelTecnico;
    private Integer numResultadoAnaliseSolos;
    private Double fosforo;
    private Double potassio;
    private Double calcio;
    private Double magnesio;
    private Double enxofre;
    private Double aluminio;
    private Double HAL;

    public Integer getNumTalhao() {
        return numTalhao;
    }

    public void setNumTalhao(Integer numTalhao) {
        this.numTalhao = numTalhao;
    }

    public Double getAreaTalhaoHa() {
        return areaTalhaoHa;
    }

    public void setAreaTalhaoHa(Double areaTalhaoHa) {
        this.areaTalhaoHa = areaTalhaoHa;
    }

    public Date getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(Date dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public Double getAreaTotalHa() {
        return areaTotalHa;
    }

    public void setAreaTotalHa(Double areaTotalHa) {
        this.areaTotalHa = areaTotalHa;
    }

    public Double getProfundidadeAmostraSoloCm() {
        return profundidadeAmostraSoloCm;
    }

    public void setProfundidadeAmostraSoloCm(Double profundidadeAmostraSoloCm) {
        this.profundidadeAmostraSoloCm = profundidadeAmostraSoloCm;
    }

    public Integer getTexturaSolo() {
        return texturaSolo;
    }

    public void setTexturaSolo(Integer texturaSolo) {
        this.texturaSolo = texturaSolo;
    }

    public Integer getSistemaCultivo() {
        return sistemaCultivo;
    }

    public void setSistemaCultivo(Integer sistemaCultivo) {
        this.sistemaCultivo = sistemaCultivo;
    }

    public Usuario getResponsavelTecnico() {
        return responsavelTecnico;
    }

    public void setResponsavelTecnico(Usuario responsavelTecnico) {
        this.responsavelTecnico = responsavelTecnico;
    }

    public Integer getNumResultadoAnaliseSolos() {
        return numResultadoAnaliseSolos;
    }

    public void setNumResultadoAnaliseSolos(Integer numResultadoAnaliseSolos) {
        this.numResultadoAnaliseSolos = numResultadoAnaliseSolos;
    }

    public Double getFosforo() {
        return fosforo;
    }

    public void setFosforo(Double fosforo) {
        this.fosforo = fosforo;
    }

    public Double getPotassio() {
        return potassio;
    }

    public void setPotassio(Double potassio) {
        this.potassio = potassio;
    }

    public Double getCalcio() {
        return calcio;
    }

    public void setCalcio(Double calcio) {
        this.calcio = calcio;
    }

    public Double getMagnesio() {
        return magnesio;
    }

    public void setMagnesio(Double magnesio) {
        this.magnesio = magnesio;
    }

    public Double getEnxofre() {
        return enxofre;
    }

    public void setEnxofre(Double enxofre) {
        this.enxofre = enxofre;
    }

    public Double getAluminio() {
        return aluminio;
    }

    public void setAluminio(Double aluminio) {
        this.aluminio = aluminio;
    }

    public Double getHAL() {
        return HAL;
    }

    public void setHAL(Double HAL) {
        this.HAL = HAL;
    }
}
