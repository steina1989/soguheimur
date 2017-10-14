package is.hi.byrjun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import is.hi.byrjun.model.PublicationMeta;
import is.hi.byrjun.model.User;
import is.hi.byrjun.services.PublicationService;
import is.hi.byrjun.services.UserService;

/**
 * Controller for the project soguheimur
 * 
 * @author Hrafnhildur Olga hoh44@hi.is
 * @author Steina Dögg sdv6@hi.is
 * 
 */
@Controller
@RequestMapping("/browse") // Makes all path relative to /browse
public class BrowsingController {
	
    @Autowired
    private MessageSource messageSource;

	@Autowired
	PublicationService pubService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/thdemo")
	public String viewDemo(ModelMap model) {
		model.addAttribute("message", "Hello world");
		return "demo/thdemo";
	}

	/*
	 * Returns a story by id.
	 */
	@RequestMapping(value = "/{id}")
	public String viewStory(@PathVariable("id") long id, ModelMap model) {

		PublicationMeta pmeta = pubService.findById(id);
		if (pmeta != null) {
			model.addAttribute("storyText", pmeta.getText());
			model.addAttribute("storyTitle", pmeta.getTitle());
		} else {
			model.addAttribute("storyText", "Sorry engin saga hér.");

		}

		return "browse/viewStory";
	}

}