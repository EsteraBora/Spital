package ro.emanuel.controller.medic;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.medic.dao.SpitalDAO;
import ro.emanuel.medic.pojo.Spital;




@Controller
public class SpitalController {
	@RequestMapping(value = "listSpital.htm", method = RequestMethod.GET)
	public ModelAndView listSpital() throws SQLException{
		ModelMap model = new ModelMap();
		ArrayList<Spital> spital = SpitalDAO.getSpital();
        model.put("spital", spital);
        return new ModelAndView("listSpital.jsp", model);
	}
	@RequestMapping(value = "detaliiSpital.htm", method = RequestMethod.GET)
	public ModelAndView detaliiSpital(@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();
		Spital sp = SpitalDAO.getspitalById(id);
        model.put("spital", sp);
        return new ModelAndView("detaliiSpital.jsp", model);
	}
	 @RequestMapping(value = "adaugare-spital.htm", method = RequestMethod.GET)
	    public ModelAndView showAddSpital(Model model)  {
		 Spital sp = new Spital();
	    	model.addAttribute("spitalForm", sp);
	    	return new ModelAndView("addSpital.jsp","model", model);
	    }
	 @RequestMapping(value = "adaugare-spital-save.htm", method = RequestMethod.POST)
	    public ModelAndView addMedic(@ModelAttribute("spitalForm") Spital sp, ModelMap model, BindingResult result)  {
	    	
	    		try {
	    			SpitalDAO.createSpital(sp);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		return new ModelAndView("redirect:/listSpital.htm");
	    	}
	 @RequestMapping(value = "deleteSpital.htm", method = RequestMethod.GET)
	 public ModelAndView deleteSpital(@RequestParam Integer id) throws SQLException {
	 	
		 SpitalDAO.deleteSpital(id);
	 	return new ModelAndView("redirect:/listSpital.htm");
	 }
	 @RequestMapping(value = "editare-spital.htm", method = RequestMethod.GET)
	    public ModelAndView showEditSpital(@RequestParam Integer id, Model model) throws SQLException{
		 Spital sp = SpitalDAO.getspitalById(id);
	    	model.addAttribute("spitalForm", sp);
	    	return new ModelAndView("editSpital.jsp","model", model);
	    }
	 @RequestMapping(value = "editare-spital-save.htm", method = RequestMethod.POST)
	    public ModelAndView editMedic(@ModelAttribute("spitalForm") Spital sp, ModelMap model, BindingResult result)  {
	    	
	    		try {
	    			SpitalDAO.updateSpital(sp);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		return new ModelAndView("redirect:/listSpital.htm");
	    	}
}
