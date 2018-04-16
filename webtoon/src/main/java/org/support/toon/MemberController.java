package org.support.toon;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.support.domain.Member;
import org.support.persistence.MemberDao;

@Controller
@RequestMapping(value = "member")
public class MemberController {
	@Inject
	private MemberDao dao;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String home() {
		return "member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String home(String m_id, String m_pw, HttpSession session, RedirectAttributes attr) {
		attr.addFlashAttribute("result", dao.LoginMember(m_id, m_pw, session));
		return "redirect:/result";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "member/register";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(Member m, RedirectAttributes attr) {
		attr.addFlashAttribute("result", dao.InsertMember(m));
		return "redirect:/result";
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.removeAttribute("m");
		return "redirect:login";
	}
	
}
