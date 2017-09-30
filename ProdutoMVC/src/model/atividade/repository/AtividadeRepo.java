package model.atividade.repository;

import model.atividade.Atividade;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Orso
 */
public class AtividadeRepo {

    private static List<Atividade> sListAtividades = new ArrayList<>();

    public static void salvar(Atividade aAtividade) {
        sListAtividades.add(aAtividade);
    }

    public static Atividade getAtividade(Integer aCodigo) {
        for (Atividade lAtividade : sListAtividades) {
            if (lAtividade.getCodigo().compareTo(aCodigo) == 0) {
                return lAtividade;
            }
        }
        return null;
    }

    public static List<Atividade> getListaAtividades() {
        return sListAtividades;
    }
}
