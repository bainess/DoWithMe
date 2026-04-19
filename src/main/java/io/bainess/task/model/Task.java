package io.bainess.task.model;

import io.bainess.epic.dto.EpicDto;
import io.bainess.epic.model.Epic;
import io.bainess.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "epic_id", nullable = true)
    private Epic epic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Task)) return false;
        return id != null && id.equals(((Task) o).getId());
    }

    @Override
    public int hashCode() {
        return 31 * id.hashCode();
    }

}
