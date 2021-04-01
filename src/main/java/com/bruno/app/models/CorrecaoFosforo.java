package com.bruno.app.models;

public class CorrecaoFosforo {

    private Integer fonteDeFosforo;
    private Double teorFosforoAtingirMgDm3;
    private Double teorFosforoAtualMgDm3;
    private Double percentualEficienciaFosforo;
    private Double valorFontePorTonelada;

    public CorrecaoFosforo(Double teorFosforoAtingirMgDm3, Double teorFosforoAtualMgDm3, Double percentualEficienciaFosforo, Integer fonteDeFosforo, Double valorFontePorTonelada) {
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
            case 1:
                return 18.0;
            case 2:
                return 41.0;
            case 3:
                return 48.0;
            case 4:
                return 45.0;
            case 5:
                return 18.0;
            case 6:
                return 33.0;
            case 7:
                return 29.0;
            case 8:
                return 32.0;
            case 9:
                return 24.0;
            case 10:
                return 18.5;
            case 11:
                return 52.0;
            case 12:
                return 18.0;
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
        private Integer fonteDeFosforo;

        public CalculaPrimeiroResidual(Double kgHaConsiderandoEficienciaFosforo, Integer fonteDeFosforo, Double teorDeP2O5EmFonteFosforo, Double quantidadeDeFosforoAAplicar) {
            this.kgHaConsiderandoEficienciaFosforo = kgHaConsiderandoEficienciaFosforo;
            this.fonteDeFosforo = fonteDeFosforo;
            this.teorDeP2O5EmFonteFosforo = teorDeP2O5EmFonteFosforo;
            this.quantidadeDeFosforoAAplicar = quantidadeDeFosforoAAplicar;
            switch (fonteDeFosforo) {
                case 1:
                    this.nomeResidual = "Enxofre";
                    break;
                case 12:
                    this.nomeResidual = "Enxofre";
                    break;
                case 5:
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
                    case 5:
                        return quantidadeDeFosforoAAplicar * 0.15;
                    case 1:
                        return (calculaKgAlResiduo() * 0.1) / 2.42;
                    case 12:
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
        private Integer fonteDeFosforo;

        public CalculaSegundoResidual(Double kgHaConsiderandoEficienciaFosforo, Integer fonteDeFosforo, Double teorDeP2O5EmFonteFosforo) {
            this.kgHaConsiderandoEficienciaFosforo = kgHaConsiderandoEficienciaFosforo;
            this.fonteDeFosforo = fonteDeFosforo;
            this.teorDeP2O5EmFonteFosforo = teorDeP2O5EmFonteFosforo;
            switch (fonteDeFosforo) {
                case 1:
                    this.nomeResidual = "Cálcio";
                    break;
                case 2:
                    this.nomeResidual = "Cálcio";
                    break;
                case 3:
                    this.nomeResidual = "Nitrogênio";
                    break;
                case 4:
                    this.nomeResidual = "Nitrogênio";
                    break;
                case 5:
                    this.nomeResidual = "Cálcio";
                    break;
                case 6:
                    this.nomeResidual = "Cálcio";
                    break;
                case 7:
                    this.nomeResidual = "Cálcio";
                    break;
                case 8:
                    this.nomeResidual = "Cálcio";
                    break;
                case 9:
                    this.nomeResidual = "Cálcio";
                    break;
                case 10:
                    this.nomeResidual = "Cálcio";
                    break;
                case 11:
                    this.nomeResidual = "Cálcio";
                    break;
                case 12:
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
                case 1:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.28);
                    break;
                case 2:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.2);
                    break;
                case 3:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.09);
                    break;
                case 4:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.16);
                    break;
                case 5:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.28);
                    break;
                case 6:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.52);
                    break;
                case 7:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.52);
                    break;
                case 8:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.45);
                    break;
                case 9:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.28);
                    break;
                case 10:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.44);
                    break;
                case 11:
                    depoisDeCalculado = (calculaKgAlResiduo() * 0.0);
                    break;
                case 12:
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
