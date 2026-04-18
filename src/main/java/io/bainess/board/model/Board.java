package io.bainess.board.model;

import io.bainess.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "boards")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Builder.Default
    @ManyToMany
    @JoinTable(name = "board_collaborators",
            joinColumns = @JoinColumn(name = "board_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> collaborators = new ArrayList<>();

    public void addCollobarator(User collaborator) {
        collaborators.add(collaborator);
        collaborator.getBoards().add(this);
    }
}
