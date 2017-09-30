package model.produto.repository;

import java.util.ArrayList;
import java.util.List;
import model.produto.Produto;

public class ProdutoRepo {
    
    public static ProdutoRepo INSTANCE;
    
    private List<Produto> mLista = new ArrayList<Produto>();
    
    public ProdutoRepo getInstance(){
        if (INSTANCE != null) {
            INSTANCE = new ProdutoRepo();
        }
        return INSTANCE;
    }
    
    public Produto getProduto(Long aIdProduto) {
        return null;
    }
}
