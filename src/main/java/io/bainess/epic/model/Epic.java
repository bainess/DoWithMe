package io.bainess.epic.model;

import io.bainess.task.model.Task;
import io.bainess.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "epics")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Epic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @OneToMany(mappedBy = "epic")
    private List<Task> tasks = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Epic)) return false;
        return id != null && id.equals(((Epic) o).getId());
    }

    @Override
    public int hashCode() {
        return 31 * id.hashCode();
    }
}
