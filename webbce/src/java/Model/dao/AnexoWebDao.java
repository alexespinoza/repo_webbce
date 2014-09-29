package Model.dao;

import Dao.AnexoWeb;
import java.util.List;

public interface AnexoWebDao {

    public int insertar(AnexoWeb anexo);

    public List<AnexoWeb> buscar(String CodAnexo,String Documento);
    
    public int pass(AnexoWeb anexo);
    
    public int actualizar(AnexoWeb anexo);

     public List<AnexoWeb> listar(String CodAnexo);
}
