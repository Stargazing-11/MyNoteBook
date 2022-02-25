package note.book.notebook.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import note.book.notebook.Entities.Catagory;
import note.book.notebook.Entities.Note;
import note.book.notebook.Repositories.CatagoryRepository;
import note.book.notebook.Repositories.NoteRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/notes")
@RequiredArgsConstructor
@Data
@SessionAttributes("currentCatagory")
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CatagoryRepository catagoryRepository;

    @ModelAttribute(name = "catagory")
    public Catagory catagory(){
        return new Catagory();
    }

    // @GetMapping
    // public String showAddNewNote(Model model){
    //     model.addAttribute("note", new Note());
    //     return "newNote";
    // }

    // @PostMapping
    // public String processAddNewNote(@ModelAttribute Note note, @ModelAttribute Catagory catagory){
    //     catagory.addNote(note);
    //     this.noteRepository.save(note);
    //     return "notes";
    // }

    @GetMapping("/showNotes/{catagoryid}")
    public String showNotes(@PathVariable(value = "catagoryid") Long id, Model model){
        Optional<Catagory> optional= catagoryRepository.findById(id);
        Catagory catagory = optional.get();
        model.addAttribute("currentCatagory", catagory);
        return "showAllNotes";
    }

    @GetMapping("/addNewNote/{catagoryid}")
    public String addNewNote(Model model, @PathVariable(value = "catagoryid") Long id){
    Optional<Catagory> optional = catagoryRepository.findById(id);
      Catagory currentCatagory = optional.get();
      model.addAttribute("currentCatagory", currentCatagory);
      model.addAttribute("note", new Note());
      return "addNewNote";
    }

    @PostMapping("/addedNewNote/{catagoryid}")
    public String processAddNote(@ModelAttribute Note note, @PathVariable(value = "catagoryid") Long id, Model model){
        Optional<Catagory> optional= catagoryRepository.findById(id);
        Catagory catagory = optional.get();
        note.setCatagory(catagory);
        noteRepository.save(note);
        model.addAttribute("notes", noteRepository.findByCatagoryId(id));
        model.addAttribute("currentCatagory", catagory);
        return "showAllNotes";
    }

    @GetMapping("/showDetail/{noteid}")
    public String showDetailNote(@PathVariable(value = "noteid") Long id, Model model){
        Optional<Note> optional= noteRepository.findById(id);
        Note note = optional.get();
        model.addAttribute("currentNote", note);
        return "showDetail";
    }

    // @GetMapping("/showNotes")
    // public String getMethodName(@RequestParam String param) {
    //     return showNotes;
    // }
    
}
