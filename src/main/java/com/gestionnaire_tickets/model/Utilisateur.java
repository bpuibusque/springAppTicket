package com.gestionnaire_tickets.model;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateur_sequence_generator")
    @SequenceGenerator(name = "utilisateur_sequence_generator", sequenceName = "utilisateur_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "Nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "Email", nullable = false, length = 191, unique = true)
    private String email;

    @Column(name = "MotDePasse", nullable = false, length = 255)
    private String motDePasse;

    @Column(name = "Role", nullable = false, length = 255)
    private String role;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String email, String motDePasse, String role) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
        for(Ticket ticket : tickets) {
            ticket.setUtilisateur(this);
        }
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + "********" + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
