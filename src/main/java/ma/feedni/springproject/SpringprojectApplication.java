package ma.feedni.springproject;

import ma.feedni.springproject.Helper.FileStorageProperties;
import ma.feedni.springproject.Model.*;
import ma.feedni.springproject.Services.CommentaireService;
import ma.feedni.springproject.Services.RoleService;
import ma.feedni.springproject.Services.UtilisateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class SpringprojectApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringprojectApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringprojectApplication.class);
    }

    @Bean
    CommandLineRunner initDatabase(UtilisateurService utilisateurService, CommentaireService commentaireService, RoleService roleService) {
        return args -> {
            Role r = new Role("admin");
            Role r2 = new Role("moderator");
            Role r3 = new Role("client");
            roleService.addRole(r);
            roleService.addRole(r2);
            roleService.addRole(r3);

            Admin admin = new Admin("OUFRID","Youness","youness.oufrid1@gmail.com","123");
            Commentaire commentaire = new Commentaire("Tessstttt", new Date());
            commentaire.setUtilisateur(admin);
            admin.setListCommentaires(new ArrayList<>());
            admin.getListCommentaires().add(commentaire);
            admin.setRole(r);
            utilisateurService.addUser(admin);

            List<Commentaire> list = commentaireService.findByUser(admin);
            for(Commentaire c : list){
                System.out.println(c.getCommentaire());
            }


            Client client = new Client("OUFRID", "amine", "a@gmail.com","123");
            client.setRole(r3);
            Moderator moderator = new Moderator("OUFRID", "Taha", "Taha.1@gmail.com","123", "P");
            moderator.setRole(r2);
            utilisateurService.addUser(client);
            utilisateurService.addUser(moderator);
            List<Utilisateur> utilisateurs = utilisateurService.findByType("P");
            for(Utilisateur u : utilisateurs){
                System.out.println(u.getPrenom());
            }
        };
    }

}
