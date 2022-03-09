package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Question;
import tn.esprit.spring.entity.QuestionsWithReponses;
import tn.esprit.spring.entity.Reponse;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.ReponseRepository;

@Service
public class QuestionService implements IQuestionService {

		@Autowired
		QuestionRepository QuestionRepo;
		@Autowired
		ReponseRepository reponseRepo;
		@Override
		public List<Question> retrieveAllQuestion() {
			List<Question> av = (List<Question>) QuestionRepo.findAll();
			return av;
		}

		@Override
		public Question addQuestion(Question c) {
			return QuestionRepo.save(c); 
		}

		@Override
		public String deleteQuestion(Integer id) {
			if(QuestionRepo.findById(id).orElse(null) != null) {
				QuestionRepo.deleteById(id);
				return "Question removed successfully!";
			}
			else return "Question id not found!";
		}

		@Override
		public Question updateidQuestion(Question c) {
			return QuestionRepo.save(c);
		}

		public List<Object[]> ListerLesReponseByQuestions(){
			return QuestionRepo.NumberReponsesGroupedByQuestions();
			
		}

		@Override
		public  String statistic2 () {
		 List<Object[]> s = QuestionRepo.NumberReponsesGroupedByQuestions();
		 
		 
		 if(((Long)s.get(0)[1])>(Long)s.get(1)[1])
			 return "voyage non résussi ";
		 else 
			 if(((Long)s.get(0)[1])<(Long)s.get(1)[1])
				 return "voyage réussi ";
		 else
			 return "neutre";
			/*for(Object[] o : s)
			{}*/
				/*System.out.println(o[1]);
				if(((Long)o[1]) .equals() >3 )
				{
					mailling("marwa.hadidan@esprit.tn","nous avons recu plus que 3 reclamations , il faut bloque ce type de reclamation " );
				}
					System.out.println(o[1].getClass());}*/
			 
			//return QuestionRepo.NumberReponsesGroupedByQuestions();
		}
		

		@Override
		public Question retrieveidQuestion(int idR) {
			return QuestionRepo.findById(idR).orElse(null);
			
		}


		public QuestionsWithReponses questionsAndReponses(int idR) {
			Question qs = QuestionRepo.findById(idR).orElse(null);
			List<Reponse> Reponses =   reponseRepo.findByQyestionId(qs);
			QuestionsWithReponses obj = new QuestionsWithReponses();
			obj.setQuestion(qs);
			obj.setReponses(Reponses);
			return obj;
		}
	
		
}
