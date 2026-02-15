package io.github.viniciusnunes01.ticketmastersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ValidacaoErroDTO {
	
    private int status;
    private String mensagem;
    private List<CampoErro> erros = new ArrayList<>();

    public void adicionarErro(String campo, String mensagem) {
        erros.add(new CampoErro(campo, mensagem));
    }

    @Data
    @AllArgsConstructor
    public static class CampoErro {
        private String campo;
        private String erro;
    }
}