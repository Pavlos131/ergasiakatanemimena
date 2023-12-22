package group54.managementeteries.rest;
import group54.managementeteries.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import  group54.managementeteries.Repository.UserRepository;
import group54.managementeteries.Repository.RoleRepository;
import java.util.List;

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
       user.getRoles().add(roleRepository.findById(3).get());
       return "user made mod";


    }
}
