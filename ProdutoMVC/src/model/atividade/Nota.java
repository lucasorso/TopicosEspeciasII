package model.atividade;

import java.util.Date;

/**
 *
 * @author Lucas Orso
 */
public class Nota {

    private Integer mCodigo;
    private String mDescricaoNota;
    private Date mDataCadastro;

    public Integer getCodigo() {
        return mCodigo;
    }

    public void setCodigo(Integer aCodigo) {
        mCodigo = aCodigo;
    }

    public String getDescricaoNota() {
        return mDescricaoNota;
    }

    public void setDescricaoNota(String aDescricaoNota) {
        mDescricaoNota = aDescricaoNota;
    }

    public Date getDataCadastro() {
        return mDataCadastro;
    }

    public void setDataCadastro(Date aDataCadastro) {
        mDataCadastro = aDataCadastro;
    }
}
