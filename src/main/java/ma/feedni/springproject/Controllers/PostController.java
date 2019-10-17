package ma.feedni.springproject.Controllers;


import ma.feedni.springproject.Model.Image;
import ma.feedni.springproject.Model.Localisation;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Requests.ImageRequest;
import ma.feedni.springproject.Responses.UploadFileResponse;
import ma.feedni.springproject.Services.FileStorageService;
import ma.feedni.springproject.Services.ImageService;
import ma.feedni.springproject.Services.PostService;
import ma.feedni.springproject.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ma.feedni.springproject.Responses.OperationsResponses.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class PostController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private PostService postService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/client/posts")
    public List<Post> getPosts(){
        return postService.findAll();
    }


    @PostMapping("/client/post/image/add")
    public UploadFileResponse addImage(@RequestParam("file") MultipartFile file, Post post) {

        String filePath = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/post?id={id}&fileName={fileName}")
                .buildAndExpand(post.getIdPost(),file.getOriginalFilename())
                .toUriString();
        Image image = new Image(file.getOriginalFilename(),filePath,file.getSize());
        image.setPost(post);
        imageService.addImage(image);
        //System.out.println(post.getDescription());

        return new UploadFileResponse(filePath, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @PostMapping("/client/post/add")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
                                                        @RequestParam("titre") String titre,
                                                        @RequestParam("description") String description,
                                                        @RequestParam("lontitude") Double lontitude,
                                                        @RequestParam("lattitude") Double lattitude,
                                                        @RequestParam("ville") String ville) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Post post = new Post(titre,description,new Date());
        post.setUtilisateur(utilisateurService.findUserByEmail(auth.getName()).get());
        post.setLocalisation(new Localisation(lontitude,lattitude,ville));
        postService.addPost(post);


        return uploadFile(files,post);
    }

    private List<UploadFileResponse> uploadFile(MultipartFile[] files,Post post){
        if(files.length!=0) {
            return Arrays.asList(files)
                    .stream()
                    .map(file -> addImage(file, post))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @PutMapping("/admin/template/updatePath")
    public String updatePath(@RequestBody ImageRequest imageRequest) throws JSONException {

        Optional<Image> image = imageService.findById(imageRequest.getId().longValue());
        if(image.isPresent()){
            image.get().setPath(imageRequest.getPath());
            return sendSuccess("Path updated");
        }
        return sendError("Template with id " + imageRequest.getId() + " doesnt exist" );
    }

    @GetMapping("/client/post")
    public ResponseEntity<Resource> getImage(@RequestParam("id") Long id, @RequestParam String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Optional<Post> post = postService.findById(id);
        if(post.isPresent()) {
            List<Image> images = imageService.findByPost(post.get());
            for(Image img : images){
                if(img.getNom().equals(fileName))
                    return new ResponseEntity<>(fileStorageService.loadFileAsResource(img.getNom()), prepareHeaderForFileReturn(img.getNom(), request, response), HttpStatus.OK);
            }
        }
        return null;
    }

    private HttpHeaders prepareHeaderForFileReturn(String fileName, HttpServletRequest request,
                                                   HttpServletResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, getContentTypeForAttachment(fileName));
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        return headers;
    }

    private String getContentTypeForAttachment(String fileName) {

        return fileName.endsWith("jpeg") ? "application/jpeg" : fileName.endsWith("png")? "application/png" : "";
    }

    @PostMapping("/client/post")
    public String addPost(@RequestBody Post post) throws JSONException{

        return sendSuccess("Post added successfully");
    }



}
