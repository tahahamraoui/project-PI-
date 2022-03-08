package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Forum;


import tn.esprit.spring.services.CommentaireService;
import tn.esprit.spring.services.ICommentaireService;
import tn.esprit.spring.services.IForumService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Api(tags = "Commentaire CRUD")
@RequestMapping("/commentaire")
@CrossOrigin(origins = "http://localhost:8089")
public class CommentaireController {

@Autowired
ICommentaireService commentaireService;

//http://localhost:8089/SpringMVC/commentaire/retrieve-all-commentaires
@GetMapping("/retrieve-all-commentaires")
@ResponseBody
@ApiOperation(value = "Récupérer la liste des commentaires")
public List<Commentaire> getCommentaires() {
List<Commentaire> listCommentaires = commentaireService.retrieveAllCommentaires();
return listCommentaires;
}

//http://localhost:8089/SpringMVC/commentaire/retrieve-commentaire/1
@GetMapping("/retrieve-commentaire/{idCommentaire}")
@ResponseBody
public Commentaire retrieveCommentaire(@PathVariable("idCommentaire") Long idCommentaire) {
 return commentaireService.retrieveCommentaire(idCommentaire);
}

//http://localhost:8089/SpringMVC/commentaire/add-commentaire/{idf}
@PostMapping("/add-commentaire/{idf}")
@ResponseBody
public Commentaire addCommentaire(@RequestBody Commentaire c , @PathVariable("idf") long idf)
{
	Commentaire commentaire = commentaireService.addCommentaire(c, idf);
	return commentaire;
}

//http://localhost:8089/SpringMVC/commentaire/remove-commentaire/{commentaire-id}
@DeleteMapping("/remove-commentaire/{commentaire-id}")
@ResponseBody
public void removeCommentaire(@PathVariable("commentaire-id") Long commentaireId) {
	commentaireService.deleteCommentaire(commentaireId);
}

//http://localhost:8089/SpringMVC/commentaire/modify-commentaire
@PutMapping("/modify-commentaire")
@ResponseBody
public Commentaire modifyCommentaire(@RequestBody Commentaire commentaire) {
return commentaireService.updateCommentaire(commentaire);
}
}

