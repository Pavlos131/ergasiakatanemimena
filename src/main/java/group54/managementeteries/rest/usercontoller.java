package group54.managementeteries.rest;
import group54.managementeteries.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import  group54.managementeteries.Repository.UserRepository;
import group54.managementeteries.Repository.RoleRepository;
import java.util.List;
import group54.managementeteries.Repository.RoleRepository;
@RestController

@RequestMapping("/api/users/")
public class usercontoller {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("")
    public List<User> getusers(){

        return userRepository.findAll();

    }

    @DeleteMapping("{id}")
     public String deleteUser(@PathVariable("id") Integer id)
    {

        userRepository.deleteById(id);
        return "deleted user";

    }

    @GetMapping("/makemod/{id}")
    public String makemod(@PathVariable("id") Integer id)
    {
        User user;
       user= userRepository.findById(id).get();
       user.getRoles().add(roleRepository.findByName("ROLE_MODERATOR").get());
       userRepository.save(user);

       return "user made mod";


    }
}
