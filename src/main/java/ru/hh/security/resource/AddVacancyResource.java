package ru.hh.security.resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hh.security.model.Vacancy;
import ru.hh.security.repository.VacancyRepository;

@Controller
@RequestMapping("add")
public class AddVacancyResource {

  private final VacancyRepository vacancyRepository;

  public AddVacancyResource(VacancyRepository vacancyRepository) {
    this.vacancyRepository = vacancyRepository;
  }

  @GetMapping
  public String getAddPage(Model model) {
    model.addAttribute("vacancy", new Vacancy());
    return "addPage";
  }

  @PostMapping
  @Transactional
  public String addVacancy(@ModelAttribute Vacancy vacancy) {
    vacancyRepository.create(vacancy);
    return "redirect:/";
  }
}
