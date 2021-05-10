package ro.emanuel.controller.pacient;

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

import ro.emanuel.pacient.dao.PacientDAO;
import ro.emanuel.pacient.pojo.Pacient;


@Controller
public class PacientController {
	@RequestMapping(value = "listPacient.htm", method = RequestMethod.GET)
	public ModelAndView listPacient() throws SQLException{
		ModelMap model = new ModelMap();
		ArrayList<Pacient> pacient = PacientDAO.getPacient();
        model.put("pacient", pacient);
        return new ModelAndView("listPacient.jsp", model);
	}
	@RequestMapping(value = "detaliiPacient.htm", method = RequestMethod.GET)
	public ModelAndView detaliiPacient(@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();
		Pacient pa = PacientDAO.getpacientById(id);
        model.put("pacient", pa);
        return new ModelAndView("detaliiPacient.jsp", model);
	}
	 @RequestMapping(value = "adaugare-pacient.htm", method = RequestMethod.GET)
	    public ModelAndView showAddPacient(Model model)  {
		 Pacient md = new Pacient();
	    	model.addAttribute("pacientForm", md);
	    	return new ModelAndView("addPacient.jsp","model", model);
	    }
	 @RequestMapping(value = "adaugare-pacient-save.htm", method = RequestMethod.POST)
	    public ModelAndView addMedic(@ModelAttribute("medicForm") Pacient pa, ModelMap model, BindingResult result)  {
	    	
	    		try {
	    			PacientDAO.createPacient(pa);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		return new ModelAndView("redirect:/listPacient.htm");
	    	}
	 @RequestMapping(value = "deletePacient.htm", method = RequestMethod.GET)
	 public ModelAndView deletePacient(@RequestParam Integer id) throws SQLException {
	 	
		 PacientDAO.deletePacient(id);
	 	return new ModelAndView("redirect:/listPacient.htm");
	 }
	 @RequestMapping(value = "editare-pacient.htm", method = RequestMethod.GET)
	    public ModelAndView showEditPacient(@RequestParam Integer id, Model model) throws SQLException{
		 Pacient pa = PacientDAO.getpacientById(id);
	    	model.addAttribute("pacientForm", pa);
	    	return new ModelAndView("editPacient.jsp","model", model);
	    }
	 @RequestMapping(value = "editare-pacient-save.htm", method = RequestMethod.POST)
	    public ModelAndView editPacient(@ModelAttribute("pacientForm") Pacient pa, ModelMap model, BindingResult result)  {
	    	
	    		try {
	    			PacientDAO.updatePacient(pa);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		return new ModelAndView("redirect:/listPacient.htm");
	    	}
}
