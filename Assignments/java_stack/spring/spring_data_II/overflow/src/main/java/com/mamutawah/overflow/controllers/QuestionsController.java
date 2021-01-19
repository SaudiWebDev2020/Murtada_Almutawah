package com.mamutawah.overflow.controllers;

import javax.validation.Valid;

import com.mamutawah.overflow.models.Answer;
import com.mamutawah.overflow.models.NewQuestion;
import com.mamutawah.overflow.models.Question;
import com.mamutawah.overflow.services.QuestionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

  private final QuestionService questionService;

  public QuestionsController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @RequestMapping("")
  public String getAll(Model model) {
    model.addAttribute("questions", questionService.getAll());
    return "questions/index.jsp";
  }

  @RequestMapping("/new")
  public String create(@ModelAttribute("newQuestion") NewQuestion newQuestion, Model model) {
    return "questions/new.jsp";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String create(@Valid @ModelAttribute("newQuestion") NewQuestion newQuestion, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      return "questions/new.jsp";
    }
    // Create a question
    questionService.create(newQuestion);
    return "redirect:/questions";
  }

  @RequestMapping(value = "/{id}")
  public String answer(@ModelAttribute("newAnswer") Answer newAnswer, @PathVariable("id") Long id, Model model) {
    model.addAttribute("question", questionService.getOne(id));
    return "questions/view.jsp";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public String answerPOST(@Valid @ModelAttribute("newAnswer") Answer newAnswer, BindingResult result, Model model,
      @PathVariable("id") Long id) {
    if (result.hasErrors()) {
      model.addAttribute("question", questionService.getOne(id));
      return "questions/new.jsp";
    }
    // Create a question
    Answer ans = questionService.answer(newAnswer);
    System.out.println(ans.getQuestion().getId());
    System.out.println(ans.getId());
    return "redirect:/questions/" + id;
  }
}
