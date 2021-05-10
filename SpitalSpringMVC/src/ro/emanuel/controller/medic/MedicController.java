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

import ro.emanuel.medic.dao.MedicDAO;
import ro.emanuel.medic.pojo.Medic;


@Controller
public class MedicController {
	@RequestMapping(value = "listMedic.htm", method = RequestMethod.GET)
	public ModelAndView listMedic() throws SQLException{
		ModelMap model = new ModelMap();
		ArrayList<Medic> medic = MedicDAO.getMedic();
        model.put("medic", medic);
        return new ModelAndView("listMedic.jsp", model);
	}
	
	@RequestMapping(value = "detaliiMedic.htm", method = RequestMethod.GET)
	public ModelAndView detaliiMedic(@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();
        Medic md = MedicDAO.getmedicById(id);
        model.put("medic", md);
        return new ModelAndView("detaliiMedic.jsp", model);
	}
	 @RequestMapping(value = "adaugare-medic.htm", method = RequestMethod.GET)
	    public ModelAndView showAddMedic(Model model)  {
	    	Medic md = new Medic();
	    	model.addAttribute("medicForm", md);
	    	return new ModelAndView("addMedic.jsp","model", model);
	    }
	 @RequestMapping(value = "adaugare-medic-save.htm", method = RequestMethod.POST)
	    public ModelAndView addMedic(@ModelAttribute("medicForm") Medic md, ModelMap model, BindingResult result)  {
	    	
	    		try {
					MedicDAO.createMedic(md);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		return new ModelAndView("redirect:/listMedic.htm");
	    	}
	 @RequestMapping(value = "deleteMedic.htm", method = RequestMethod.GET)
	 public ModelAndView deleteMedic(@RequestParam Integer id) throws SQLException {
	 	
	 	MedicDAO.deleteMedic(id);
	 	return new ModelAndView("redirect:/listMedic.htm");
	 }
	 @RequestMapping(value = "editare-medic.htm", method = RequestMethod.GET)
	    public ModelAndView showEditMedic(@RequestParam Integer id, Model model) throws SQLException{
	    	Medic md = MedicDAO.getmedicById(id);
	    	model.addAttribute("medicForm", md);
	    	return new ModelAndView("editMedic.jsp","model", model);
	    }
	 @RequestMapping(value = "editare-medic-save.htm", method = RequestMethod.POST)
	    public ModelAndView editMedic(@ModelAttribute("medicForm") Medic md, ModelMap model, BindingResult result)  {
	    	
	    		try {
					MedicDAO.updateMedic(md);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		return new ModelAndView("redirect:/listMedic.htm");
	    	}
}
