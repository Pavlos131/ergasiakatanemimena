package group54.managementeteries.rest;
import group54.managementeteries.Entity.User;
import group54.managementeteries.Service.AitisiService;
import group54.managementeteries.Service.UserDetailsImpl;
import group54.managementeteries.Service.UserDetailsServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import group54.managementeteries.Entity.aitisi;
import group54.managementeteries.Service.UserDetailsImpl;
import group54.managementeteries.Service.UserDetailsServiceImpl;
import java.util.List;
import java.util.Optional;

import group54.managementeteries.Repository.UserRepository;
import group54.managementeteries.payload.AitisiRequest;

@RestController
@RequestMapping("/api/requests/")
public class aitiseiscontroller {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AitisiService aitisiService;

    private UserDetailsImpl userDetails;
    @Secured({"ROLE_MODERATOR", "ROLE_ADMIN"})
   @GetMapping("")
    public List<aitisi> getAitiseis()
   {   Authentication auth = SecurityContextHolder. getContext(). getAuthentication();
       String username =auth.getName();
        return aitisiService.getallaitiseis();

   }

   @PostMapping("")
    public void saveAitisi(@RequestBody  AitisiRequest aitisiRequest){
       Authentication auth = SecurityContextHolder. getContext(). getAuthentication();
       String username =auth.getName();
       aitisi Aitisi = new aitisi(aitisiRequest.getCompanyname(),aitisiRequest.getKatastatiko(),aitisiRequest.getEdra(),aitisiRequest.getPartner1(),aitisiRequest.getPartner2());
      aitisiService.saveaitisi(Aitisi,username);
   }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String deleteAitisi(@PathVariable("id") Integer id){
    aitisiService.deleteaitisi(id);
     return "deleted aitisi";

    }
    @Secured({"ROLE_MODERATOR", "ROLE_ADMIN"})
@GetMapping("/approve/{id}")
    public String aproveAitisi(@PathVariable("id") Integer id){
       aitisi Aitisi = aitisiService.getaitisi(id);

       Aitisi.setCondition("Approved");
      Aitisi.setAfm();
     aitisiService.saveaitisi(Aitisi);
    return "aproved aitisi";
}

@Secured({"ROLE_MODERATOR", "ROLE_ADMIN"})
    @GetMapping("/disapprove/{id}")
    public String disaproveAitisi(@PathVariable("id") Integer id){
        aitisi Aitisi = aitisiService.getaitisi(id);

        Aitisi.setCondition("Disapproved");

        aitisiService.saveaitisi(Aitisi);
        return "Disaproved aitisi";
    }

    @GetMapping("userrequests") //epistrefei tis aitiseis tou sindedemenou xristi
    public List<aitisi>   getuseraitiseis(){
        Authentication auth = SecurityContextHolder. getContext(). getAuthentication();
        String username =auth.getName();
        Optional<User> temp = userRepository.findByUsername(username);
         User  user = temp.get();
         return user.getAitiseis();


    }

}
