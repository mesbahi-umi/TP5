package org.example.Business;

import org.example.Beans.Adherent;

import java.util.List;

public interface Services {
    Adherent addAdherent(Adherent adherent);
    Adherent updateAdherent(Adherent adherent);
    Adherent deleteAdherent(Adherent adherent);
    Adherent getAdherent(String login);
    List<Adherent> getAllAdherents();
}
