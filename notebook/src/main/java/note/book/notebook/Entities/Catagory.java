package note.book.notebook.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catagory")
    private List<Note> notes = new ArrayList<>(); 
 
    public void addNote(Note note){
        this.notes.add(note);
    }


    public Optional<Catagory> findById(Long id2) {
        return null;
    }
}