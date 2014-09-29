package service.Impl;

import Dao.AnexoWeb;
import java.util.List;
import Model.dao.AnexoWebDao;
import Model.dao.Impl.AnexoWebDaoImp;

public class AnexoWebServiceImp implements AnexoWebDao {
    private AnexoWebDao anexoWebDao;
    @Override
    public int insertar(AnexoWeb anexo) {

        anexoWebDao = new AnexoWebDaoImp();
        return anexoWebDao.insertar(anexo);
        }

    @Override
    public List<AnexoWeb> buscar(String CodAnexo, String Documento) {
        
          anexoWebDao = new AnexoWebDaoImp();
        return anexoWebDao.buscar(CodAnexo,Documento);
    
    }

    @Override
    public int actualizar(AnexoWeb anexo) {
   
         anexoWebDao = new AnexoWebDaoImp();
        return anexoWebDao.actualizar(anexo);
      
    }

    @Override
    public List<AnexoWeb> listar(String CodAnexo) {
        
       anexoWebDao = new AnexoWebDaoImp();
        return anexoWebDao.listar(CodAnexo);
    
    }
    @Override
    public int pass(AnexoWeb anexo) {
      anexoWebDao = new AnexoWebDaoImp();
        return anexoWebDao.pass(anexo);
    }

}
