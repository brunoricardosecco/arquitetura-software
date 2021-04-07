package com.bruno.app.models;

import com.bruno.app.enums.FonteFosforo;

public class CorrecaoFosforo {

    private FonteFosforo fonteDeFosforo;
    private Double teorFosforoAtingirMgDm3;
    private Double teorFosforoAtualMgDm3;
    private Double percentualEficienciaFosforo;
    private Double valorFontePorTonelada;

    public CorrecaoFosforo(Double teorFosforoAtingirMgDm3, Double teorFosforoAtualMgDm3, Double percentualEficienciaFosforo, FonteFosforo fonteDeFosforo, Double valorFontePorTonelada) {
        this.teorFosforoAtingirMgDm3 = teorFosforoAtingirMgDm3;
        this.teorFosforoAtualMgDm3 = teorFosforoAtualMgDm3;
        this.percentualEficienciaFosforo = percentualEficienciaFosforo;
        this.fonteDeFosforo = fonteDeFosforo;
        this.valorFontePorTonelada = valorFontePorTonelada;
    }

    public Double transformaMgDm3EmKgHaFosforo() {
        if ((teorFosforoAtingirMgDm3 - teorFosforoAtualMgDm3) > 0.01) {
            return ((teorFosforoAtingirMgDm3 - teorFosforoAtualMgDm3) * 2);
        }
        return 0.0;
    }

    public Double transformaKgHaFosforoEmKgHaP2O5() {
        return transformaMgDm3EmKgHaFosforo() * 2.29;
    }

    public Double transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo() {
        return transformaKgHaFosforoEmKgHaP2O5() / (percentualEficienciaFosforo / 100);
    }

    public Double calculaPercentualTeorFonteP2O5() {
        switch (fonteDeFosforo) {
            case SUPERFOSFATO_TRIPLO:
                return 41.0;
            case MAP:
                return 48.0;
            case DAP:
                return 45.0;
            case SUPERFOSFATO_SIMPLES:
            case MULTIFOSFATO_MAGNESIANO:
            case YOORIN:
                return 18.0;
            case FOSFATO_ARAD:
                return 33.0;
            case FOSFATO_GAFSA:
                return 29.0;
            case FOSFATO_DAOUI:
                return 32.0;
            case FOSFATO_PATOS_MINAS:
                return 24.0;
            case ESCORIA_DE_THOMAS:
                return 18.5;
            case ACIDO_FOSFORICO:
                return 52.0;
            default:
                return 0.0;
        }
    }

    public Double calculaQuantidadeAAplicar() {
        return transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo() * (100 / calculaPercentualTeorFonteP2O5());
    }

    public Double calculaKgHaPrimeiroResiduo() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        return new CalculaPrimeiroResidual(kgHaConsiderandoEficienciaFosforo, fonteDeFosforo, calculaPercentualTeorFonteP2O5(), calculaQuantidadeAAplicar()).calculaKgHaPrimeiroResidual();
    }

    public String calculaNomePrimeiroResiduo() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        return new CalculaPrimeiroResidual(kgHaConsiderandoEficienciaFosforo, fonteDeFosforo, calculaPercentualTeorFonteP2O5(), calculaQuantidadeAAplicar()).getNomeResidual();
    }

    public Double calculaKgHaSegundoResiduo() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        return new CalculaSegundoResidual(kgHaConsiderandoEficienciaFosforo, fonteDeFosforo, calculaPercentualTeorFonteP2O5()).calculaKgHaPrimeiroResidual();
    }

    public String calculaNomeSegundoResiduo() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        return new CalculaSegundoResidual(kgHaConsiderandoEficienciaFosforo, fonteDeFosforo, calculaPercentualTeorFonteP2O5()).getNomeResidual();
    }

    public double calculaCustoPorHa() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        Double kgAlFosforo = (kgHaConsiderandoEficienciaFosforo * 100 / calculaPercentualTeorFonteP2O5()) * 2.42;

        return (valorFontePorTonelada * kgAlFosforo / 1000) / 2.42;
    }

    private class CalculaPrimeiroResidual {
        private Double kgHaConsiderandoEficienciaFosforo;
        private Double teorDeP2O5EmFonteFosforo;
        private Double quantidadeDeFosforoAAplicar;
        private String nomeResidual;
        private FonteFosforo fonteDeFosforo;

        public CalculaPrimeiroResidual(Double kgHaConsiderandoEficienciaFosforo, FonteFosforo fonteDeFosforo, Double teorDeP2O5EmFonteFosforo, Double quantidadeDeFosforoAAplicar) {
            this.kgHaConsiderandoEficienciaFosforo = kgHaConsiderandoEficienciaFosforo;
            this.fonteDeFosforo = fonteDeFosforo;
            this.teorDeP2O5EmFonteFosforo = teorDeP2O5EmFonteFosforo;
            this.quantidadeDeFosforoAAplicar = quantidadeDeFosforoAAplicar;
            switch (fonteDeFosforo) {
                case MULTIFOSFATO_MAGNESIANO:
                case SUPERFOSFATO_SIMPLES:
                    this.nomeResidual = "Enxofre";
                    break;
                case YOORIN:
                    this.nomeResidual = "Magnésio";
                    break;
                default:
                    this.nomeResidual = "";
            }
        }

        public String getNomeResidual() {
            return nomeResidual;
        }

        public Double calculaKgHaPrimeiroResidual() {
                switch (fonteDeFosforo) {
                    case YOORIN:
                        return quantidadeDeFosforoAAplicar * 0.15;
                    case SUPERFOSFATO_SIMPLES:
                        return (calculaKgAlResiduo() * 0.1) / 2.42;
                    case MULTIFOSFATO_MAGNESIANO:
                        return (calculaKgAlResiduo() * 0.11) / 2.42;
                    default:
                        return 0.0;
                }
        }

        private Double calculaKgHeResiduo() {
            return kgHaConsiderandoEficienciaFosforo * 100 / teorDeP2O5EmFonteFosforo;
        }

        private Double calculaKgAlResiduo() {
            return calculaKgHeResiduo() * 2.42;
        }


    }

    private class CalculaSegundoResidual {
        private Double kgHaConsiderandoEficienciaFosforo;
        private Double teorDeP2O5EmFonteFosforo;
        private String nomeResidual;
        private FonteFosforo fonteDeFosforo;

        public CalculaSegundoResidual(Double kgHaConsiderandoEficienciaFosforo, FonteFosforo fonteDeFosforo, Double teorDeP2O5EmFonteFosforo) {
            this.kgHaConsiderandoEficienciaFosforo = kgHaConsiderandoEficienciaFosforo;
            this.fonteDeFosforo = fonteDeFosforo;
            this.teorDeP2O5EmFonteFosforo = teorDeP2O5EmFonteFosforo;
            switch (fonteDeFosforo) {
                case MAP:
                case DAP:
                    this.nomeResidual = "Nitrogênio";
                    break;
                case SUPERFOSFATO_SIMPLES:
                case SUPERFOSFATO_TRIPLO:
                case YOORIN:
                case FOSFATO_ARAD:
                case FOSFATO_GAFSA:
                case FOSFATO_DAOUI:
                case FOSFATO_PATOS_MINAS:
                case ESCORIA_DE_THOMAS:
                case ACIDO_FOSFORICO:
                case MULTIFOSFATO_MAGNESIANO:
                    this.nomeResidual = "Cálcio";
                    break;
                default:
                    this.nomeResidual = "";
            }
        }

        public String getNomeResidual() {
            return nomeResidual;
        }

        public Double calculaKgHaPrimeiroResidual() {
            Double depoisDeCalculado;
            switch (fonteDeFosforo) {
                case SUPERFOSFATO_TRIPLO:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.2);
                    break;
                case MAP:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.09);
                    break;
                case DAP:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.16);
                    break;
                case SUPERFOSFATO_SIMPLES:
                case YOORIN:
                case FOSFATO_PATOS_MINAS:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.28);
                    break;
                case FOSFATO_ARAD:
                case FOSFATO_GAFSA:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.52);
                    break;
                case FOSFATO_DAOUI:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.45);
                    break;
                case ESCORIA_DE_THOMAS:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.44);
                    break;
                case ACIDO_FOSFORICO:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.0);
                    break;
                case MULTIFOSFATO_MAGNESIANO:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.18);
                    break;
                default:
                    return 0.0;
            }
            return depoisDeCalculado / 2.42;
        }

        private Double calculaKgHeResiduo() {
            return kgHaConsiderandoEficienciaFosforo * 100 / teorDeP2O5EmFonteFosforo;
        }

        private Double calculaKgAlResiduo() {
            return calculaKgHeResiduo() * 2.42;
        }


    }
}
