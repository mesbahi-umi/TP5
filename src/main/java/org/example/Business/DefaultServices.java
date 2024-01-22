package org.example.Business;

import org.example.Beans.Adherent;
import org.example.Dao.AdherentDao;
import org.example.Dao.AdherentDaoJdbc;

import java.util.List;

public class DefaultServices implements Services{
    private static DefaultServices instance = null;
    private final AdherentDao adherentDao;

    public static DefaultServices getInstance() {
        if(instance==null)
            instance=new DefaultServices(new AdherentDaoJdbc());
        return instance;
    }
    private DefaultServices(AdherentDao adherentDao) {
        this.adherentDao=adherentDao;
    }
    @Override
    public Adherent addAdherent(Adherent adherent) {
        return adherentDao.save(adherent);
    }

    @Override
    public Adherent updateAdherent(Adherent adherent) {
        return adherentDao.update(adherent);
    }

    @Override
    public Adherent deleteAdherent(Adherent adherent) {
        return adherentDao.delete(adherent);
    }

    @Override
    public Adherent getAdherent(String login) {
        return adherentDao.findById(login);
    }

    @Override
    public List<Adherent> getAllAdherents() {
        return adherentDao.getAll();
    }
}
