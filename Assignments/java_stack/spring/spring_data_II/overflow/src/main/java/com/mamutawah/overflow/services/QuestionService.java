package com.mamutawah.overflow.services;

import java.util.ArrayList;
import java.util.List;

import com.mamutawah.overflow.models.Answer;
import com.mamutawah.overflow.models.NewQuestion;
import com.mamutawah.overflow.models.Question;
import com.mamutawah.overflow.models.Tag;
import com.mamutawah.overflow.repositories.AnswerRepository;
import com.mamutawah.overflow.repositories.QuestionRepository;
import com.mamutawah.overflow.repositories.TagRepository;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {

  private final QuestionRepository questionRepository;

  private final AnswerRepository answerRepository;
  private final TagRepository tagRepository;

  public QuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository,
      TagRepository tagRepository) {
    this.questionRepository = questionRepository;
    this.answerRepository = answerRepository;
    this.tagRepository = tagRepository;
  }

  public List<Question> getAll() {
    return questionRepository.findAll();
  }

  public Question getOne(Long id) {
    return questionRepository.findById(id).orElse(null);
  }

  public Question create(NewQuestion question) {
    // DONE validate if three tags or not!
    List<Tag> questionsTags = new ArrayList<Tag>();
    for (String subject : question.splitTags()) {
      subject = subject.toLowerCase();
      Tag tag = this.tagRepository.findBySubject(subject).orElse(null);
      if (tag == null) {
        tag = new Tag(subject);
        this.tagRepository.save(tag);
      }
      // prevent dupe tags
      if (!questionsTags.contains(tag))
        questionsTags.add(tag);
    }
    Question newQuestion = new Question(question.getQuestion(), questionsTags);
    return this.questionRepository.save(newQuestion);
  }

  public Answer answer(Answer answer) {
    // TODO
    Answer nAnswer = new Answer(answer.getQuestion(), answer.getAnswer());
    return answerRepository.save(nAnswer);
  }

}
