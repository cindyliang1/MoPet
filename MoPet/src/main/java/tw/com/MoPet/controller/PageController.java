package tw.com.MoPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.com.MoPet.model.Comments;
import tw.com.MoPet.model.Replies;
import tw.com.MoPet.service.CommentsService;
import tw.com.MoPet.service.RepliesService;

@Controller
public class PageController {

	@Autowired
	public CommentsService cService;
	
	@Autowired
	public RepliesService rService;
	
//	@GetMapping("/")
//	public String index() {
//		return"index";
//	}

//	@GetMapping("comments/all")
//	public String allComments() {
//		return"allComments";
//	}
	
	@GetMapping("comments/add")
	public String addComment(Model model) {
		
		Comments comments = new Comments();
		
		Comments lastest = cService.getLastest();
		
		model.addAttribute("comments", comments);
		model.addAttribute("lastest", lastest);
		return "addComment";
		
	}
	
	@GetMapping("replies/add")
	public String addReplies(Model model) {
		
		Replies replies = new Replies();
		
		Replies lastest = rService.getLastest();
		
		model.addAttribute("replies", replies);
		model.addAttribute("lastest", lastest);
		return "addReplies";
		
	}
	
	//取的分頁
		@GetMapping("comments/all")
		public String viewtext(@RequestParam(name="p" ,defaultValue="1") Integer pageNumber,Model model) {
			Page<Comments> page = cService.findByPage(pageNumber);
			
			model.addAttribute("page", page);
			
			return "allComments";
		}
		
		@GetMapping("replies/all")
		public String viewtext2(@RequestParam(name="p" ,defaultValue="1") Integer pageNumber,Model model) {
			Page<Replies> page = rService.findByPage(pageNumber);
			
			model.addAttribute("page", page);
			
			return "allReplies";
		}
	
//	@GetMapping("comments/all")
//	public ModelAndView viewComments(ModelAndView mav, 
//			@RequestParam(name="p", defaultValue = "1") Integer pageNumber) {
//		Page<Comments> page = cService.findByPage(pageNumber);
//		
//		mav.getModel().put("page", page);
//		mav.setViewName("allComments");
//		return mav;
//	}
	
	
	
}
