package ma.feedni.springproject.Controllers;


import ma.feedni.springproject.Model.Moderator;
import ma.feedni.springproject.Model.Utilisateur;
import ma.feedni.springproject.Services.UtilisateurService;
import static ma.feedni.springproject.Responses.OperationsResponses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/noauth/moderator/add")
    public String addUser(@RequestBody Moderator m) throws JSONException {
        Optional<Utilisateur> user = utilisateurService.findUserByEmail(m.getEmail());
        if(user.isPresent()){
            return sendError("Email already exists");
        }
        //System.out.println(m.getPassword());
        utilisateurService.addUser(m);
        return sendSuccess("Moderator added successfully");
    }



    @PostMapping(value = {"/admin/profil/update", "/moderator/profil/update", "/client/profil/update"})
    public String updateUser(@RequestBody Utilisateur m) throws JSONException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!utilisateurService.findUserByEmail(m.getEmail()).isPresent() || m.getEmail().equals(auth.getName())) {
            Utilisateur appUser = utilisateurService.findUserByEmail(auth.getName()).get();
            m.setIdUtilisateur(appUser.getIdUtilisateur());
            if (utilisateurService.updateUser(m)) {
                return sendSuccess("User updated");
            }
        }
        return sendError("cannot execute the update. Please check your new email. it can be used by another user");
    }
}
