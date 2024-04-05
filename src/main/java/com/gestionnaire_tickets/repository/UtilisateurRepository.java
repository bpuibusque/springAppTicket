package com.gestionnaire_tickets.repository;

import com.gestionnaire_tickets.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
