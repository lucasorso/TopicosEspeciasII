package model.atividade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Lucas Orso
 */
public class Atividade {

    private Integer mCodigo;
    private String mDescricao;
    private Date mDataCadastro;
    private Date mDataConclusao;
    private Integer mEstagio;
    private List<Nota> mNotasList;

    public Atividade() {
        mNotasList = new ArrayList<>();
    }

    public Integer getCodigo() {
        return mCodigo;
    }

    public void setCodigo(Integer mCodigo) {
        this.mCodigo = mCodigo;
    }

    public String getDescricao() {
        return mDescricao;
    }

    public void setDescricao(String mDecricacao) {
        this.mDescricao = mDecricacao;
    }

    public Date getDataCadastro() {
        return mDataCadastro;
    }

    public void setDataCadastro(Date mDataCadastro) {
        this.mDataCadastro = mDataCadastro;
    }

    public Date getDataConclusao() {
        return mDataConclusao;
    }

    public void setDataConclusao(Date mDataConclusao) {
        this.mDataConclusao = mDataConclusao;
    }

    public Integer getEstagio() {
        return mEstagio;
    }

    public void setEstagio(Integer mEstagio) {
        this.mEstagio = mEstagio;
    }

    public List<Nota> getNotasList() {
        return mNotasList;
    }

    public void setNotasList(List<Nota> mNotasList) {
        this.mNotasList = mNotasList;
    }

    public Nota getNota(Integer aCodigo) {
        for (Nota lNota : mNotasList) {
            if (lNota.getCodigo().compareTo(aCodigo) == 0) {
                return lNota;
            }
        }
        return null;
    }

    public void addNota(Nota aNota) {
        this.mNotasList.add(aNota);
    }
}
