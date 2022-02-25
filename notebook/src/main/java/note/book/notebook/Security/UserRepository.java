package note.book.notebook.Security;

// import note.book.notebook.Security.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    public User findByUsername(String username);
    
}
