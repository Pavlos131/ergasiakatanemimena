package group54.managementeteries.rest;
import group54.managementeteries.Service.AitisiService;
import group54.managementeteries.Service.UserDetailsImpl;
import group54.managementeteries.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import group54.managementeteries.Entity.aitisi;
import group54.managementeteries.Service.UserDetailsImpl;
import group54.managementeteries.Service.UserDetailsServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/api/requests/")

public class aitiseiscontroller {
    @Autowired
    private AitisiService aitisiService;
// authentication auth = SecurityContextHolder.getContext().getAuthentication();
//       String username=auth.getName();
    private UserDetailsImpl userDetails;
   @GetMapping("")
    public List<aitisi> getAitiseis()
   {   Authentication auth = SecurityContextHolder. getContext(). getAuthentication();
       String username =auth.getName();
        return aitisiService.getallaitiseis();

   }

   @PostMapping("")
    public void saveAitisi(@RequestBody  aitisi Aitisi){
       Authentication auth = SecurityContextHolder. getContext(). getAuthentication();
       String username =auth.getName();
      aitisiService.saveaitisi(Aitisi,username);
   }






}
