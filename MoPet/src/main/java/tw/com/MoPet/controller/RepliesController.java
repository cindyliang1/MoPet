package tw.com.MoPet.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.MoPet.model.Comments;
import tw.com.MoPet.model.Replies;
import tw.com.MoPet.service.RepliesService;

@Controller
public class RepliesController {

	
	@Autowired
	private RepliesService rService;
	
	
	@GetMapping("replies/findAll")
	@ResponseBody
	public List<Replies> findAll(){
		return rService.findAllReplies();
	}
	
	
	@PostMapping("replies/add") //post送出資料
	public String addReplies(@ModelAttribute("replies") Replies replies,Model model) {
		rService.insertReplies(replies);
		
		Replies newReplies = new Replies();
		
		Replies lastest = rService.getLastest();
		
		model.addAttribute("replies", newReplies);
		model.addAttribute("lastest", lastest);
		
		return "allReples";
	}
	
	@GetMapping("replies/edit")
	public String editReplies(@RequestParam("id") Integer id,Model model) {
		
		Replies replies = rService.findById(id);
		
		
//		Integer fk_c_id = replies.getFk_c_id();
//		System.out.println(fk_c_id);
		
		model.addAttribute("replies", replies);

		return "editReplies";
	}
	
	@PostMapping("replies/edit")
	public String postEditReplies(@ModelAttribute(name="replies") Replies replies) {
		
		//取得現在時間
		Date now = Calendar.getInstance().getTime();
		
		replies.setCreateondate(now);
		
		replies.setFk_c_id(2);
		
		rService.insertReplies(replies);
		
		return "redirect:/replies/all";
	}
	
	@GetMapping("replies/delete")
	public String deleteReplies(@RequestParam("id")Integer id) {
		
		rService.deleteReplies(id);
		
		return "redirect:/replies/all";
	}
	
	
	@PostMapping("test/{id}")
	@ResponseBody
	public Integer countNumber(@PathVariable Integer id) {
		
		 return rService.countNumber(id);
	}
	
	
//	@PostMapping("test2/{id}")
//	@ResponseBody
//	public Optional<Replies> findId(@PathVariable Integer id) {
//		
//		return rService.findByid(id);
//	}
	
	
}
