package com.target;

public class FaturamentoMensal_4 {
    public static void main(String[] args) {
        /*
         4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

         SP – R$67.836,43
         RJ – R$36.678,66
         MG – R$29.229,88
         ES – R$27.165,48
         Outros – R$19.849,53
         */

        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;
        double total = sp + rj + mg + es + outros;

        double percentualSP = (sp / total) * 100;
        double percentualRJ = (rj / total) * 100;
        double percentualMG = (mg / total) * 100;
        double percentualES = (es / total) * 100;
        double percentualOutros = (outros / total) * 100;

        System.out.println("Percentual de representação de cada estado no faturamento mensal da distribuidora:");
        System.out.printf("SP: %.2f%%\n", percentualSP);
        System.out.printf("RJ: %.2f%%\n", percentualRJ);
        System.out.printf("MG: %.2f%%\n", percentualMG);
        System.out.printf("ES: %.2f%%\n", percentualES);
        System.out.printf("Outros: %.2f%%\n", percentualOutros);


    }
}