package com.gestionnaire_tickets.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_sequence_generator")
    @SequenceGenerator(name = "ticket_sequence_generator", sequenceName = "ticket_sequence", allocationSize = 1)
    private Long id;
    
    @Column(name = "Titre", nullable = false, length = 255)
    private String titre;

    @Column(name = "Description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "Statut", nullable = false, length = 255)
    private String statut;

    @Column(name = "DateDeCreation", nullable = false)
    private LocalDateTime dateDeCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UtilisateurID")
    private Utilisateur utilisateur;

    public Ticket() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDateTime dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", statut='" + statut + '\'' +
                ", dateDeCreation=" + dateDeCreation +
                ", utilisateur=" + (utilisateur != null ? utilisateur.getId() : null) +
                '}';
    }
}
