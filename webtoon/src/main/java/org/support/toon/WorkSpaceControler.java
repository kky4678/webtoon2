package org.support.toon;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.file.upload.FileVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.support.domain.Member;
import org.support.domain.Workspace;
import org.support.persistence.WorkspaceDao;

@Controller
@RequestMapping(value = "workspace")
public class WorkSpaceControler {
	@Inject
	private WorkspaceDao dao;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create() {
		return "workspace/createworkspace";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(Workspace w, HttpServletRequest w_file, RedirectAttributes attr, HttpSession session) {
		FileVo filevo = new FileVo();
		Member m = (Member)session.getAttribute("m");
		try {
			w.setW_logo(filevo.addfile(w_file));
			w.setW_owner(m.getM_no());
		} catch (Exception e) {
			e.printStackTrace();
		}
		attr.addFlashAttribute("result", dao.InsertWorkspace(w));
		return "redirect:/result";
	}
}
