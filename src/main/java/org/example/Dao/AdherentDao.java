package org.example.Dao;

import org.example.Beans.Adherent;

import java.util.List;

public interface AdherentDao {
    Adherent save(Adherent adherent);
    Adherent findById(String login);
    List<Adherent> getAll();
    Adherent update(Adherent adherent);
    Adherent delete(Adherent adherent);
}
