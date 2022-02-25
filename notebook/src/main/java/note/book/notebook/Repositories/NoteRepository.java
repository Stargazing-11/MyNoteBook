package note.book.notebook.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// import note.book.notebook.Entities.Catagory;
import note.book.notebook.Entities.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
   
   public List<Note> findByCatagoryId(Long id);
}
