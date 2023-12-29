package group54.managementeteries.rest;
import group54.managementeteries.Entity.User;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import  group54.managementeteries.Repository.UserRepository;
import group54.managementeteries.Repository.RoleRepository;

import java.beans.Encoder;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import group54.managementeteries.Repository.RoleRepository;
import group54.managementeteries.payload.edituserrequest;
//mono o admin  exei prosvasi edo
@RestController

@RequestMapping("/api/users/")
public class usercontoller {
    @Autowired
    BCryptPasswordEncoder encoder;
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
    @GetMapping("/removemod/{id}")
    public String removemod(@PathVariable("id") Integer id)
    {
        User user;
        user= userRepository.findById(id).get();
        user.getRoles().remove(roleRepository.findByName("ROLE_MODERATOR").get());
        userRepository.save(user);

        return "user removed mod role";


    }

    @PostMapping("/edituser/{id}")
    public String editUser(@PathVariable("id") Integer id, @RequestBody edituserrequest editUserRequest) {
        // Retrieve the user by ID
        User user = userRepository.findById(id).get();


        // Update user properties if they are not null in the request
        if (editUserRequest.getEmail() != null) {
            user.setEmail(editUserRequest.getEmail());
        }

        if (editUserRequest.getUsername() != null) {
            user.setUsername(editUserRequest.getUsername());
        }

        if (editUserRequest.getPassword() != null) {
            // Hash and set the new password
            user.setPassword(encoder.encode(editUserRequest.getPassword()));
        }

        // Save the updated user
        userRepository.save(user);

        return "Edited user";
    }

}
