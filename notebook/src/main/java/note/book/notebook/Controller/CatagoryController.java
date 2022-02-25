package note.book.notebook.Controller;

// import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
// import org.springframework.web.servlet.ModelAndView;

import lombok.Data;
// import lombok.extern.slf4j.Slf4j;
import note.book.notebook.Entities.Catagory;
import note.book.notebook.Entities.Note;
import note.book.notebook.Repositories.CatagoryRepository;
import note.book.notebook.Repositories.NoteRepository;

@Controller
@RequestMapping("/currentCatagory/editCatagory")
@SessionAttributes("currentCatagory")
@Data
// @Slf4j
public class CatagoryController {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private CatagoryRepository catagoryRepository;

    @ModelAttribute("note")
    public Note note(){
        return new Note();
    }

    @GetMapping("/showcatagories")
    public String showCatagories(Model model){
        model.addAttribute("catagories", catagoryRepository.findAll());
        return "catagories";
    }

    @GetMapping("/addCatagory")
    public String addCatagory(Model model){
        model.addAttribute("catagory", new Catagory());
        return "newCatagory";
    }

    @PostMapping("/addedCatagory")
    public String catagorySubmit(@ModelAttribute Catagory catagory, Model model) {
      model.addAttribute("catagory", catagory);
      catagoryRepository.save(catagory);
      return "redirect:/currentCatagory/editCatagory/showcatagories";
    }










//   @GetMapping("/addNewNote/{catagoryid}")
//   public String showAddNoteForm(Model model, @PathVariable(value = "catagoryid") Long id){
//       Optional<Catagory> optional = catagoryRepository.findById(id);
//       Catagory currentCatagory = optional.get();
//       model.addAttribute("currentCatagory", currentCatagory);
//       return "newNote";
//   }  

//   @PostMapping("/addNewNote/{catagoryid}")
//     public ModelAndView processAddNote(@ModelAttribute Note note, @PathVariable(value = "catagoryid") Long catagoryid, Model model){
//         Optional<Catagory> optional = catagoryRepository.findById(catagoryid);
//         Catagory currentCatagory = optional.get();
//         model.addAttribute("currentCatagory", currentCatagory);
//         currentCatagory.addNote(note);
//         this.catagoryRepository.save(currentCatagory);
//         ModelAndView mv = new ModelAndView("redirect:/currentCatagory/editCatagory");
//         System.out.println("notes " + note);
//         log.info("currentCatagory note " + currentCatagory.getName());
//         mv.addObject("currentCatagory", currentCatagory);
//         return mv;
//     }

    // @GetMapping
    // public String showEditSection(Model model, @ModelAttribute("currentCatagory") Catagory currentCatagory){
    //     model.addAttribute("currentCatagory", currentCatagory);
    //     Optional<Catagory> optional = catagoryRepository.findById(currentCatagory.getId());
    //     currentCatagory = optional.get();
    //     model.addAttribute("currentCatagory", currentCatagory);
    //     return "notes";
    // }
}

