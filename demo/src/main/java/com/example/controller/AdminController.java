package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.dao.ItemDAO;
import com.example.vo.ItemVO;
import com.example.vo.BoardVO;
import com.example.dao.BoardDAO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private ItemDAO iDAO = null; 
	
	@RequestMapping(value = "/home")
	public String home() {
		return "/admin/home";
	}
	
	@RequestMapping(value = "/iteminsert")
	public String iteminsert() {
		return "/admin/iteminsert";
}
	
	@RequestMapping(value = "/iteminsert", method= RequestMethod.POST)
	public String iteminsertpost(
			@RequestParam("name[]") String[] name,
			@RequestParam("content[]") String[] content,
			@RequestParam("price[]") int[] price,
			@RequestParam("qty[]") int[] qty){
		
		List<ItemVO> list = new ArrayList<ItemVO>();
		for(int i= 0; i<name.length; i++) {
			ItemVO obj = new ItemVO();
			obj.setIt_na(name[i]);
			obj.setIt_exp(content[i]);
			obj.setIt_price(price[i]);
			obj.setIt_itno(qty[i]);
			
			
			list.add(obj);
		}
		iDAO.insertItemBatch(list);
				
		return "redirect:/admin/home";
	}
	
	@RequestMapping(value = "/item")
	public String list(Model model,
			HttpSession httpSession, @RequestParam(value="page" , defaultValue = "1", required = false) int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", page*10-9);
		map.put("end", page*10);
		
		List<ItemVO> list = iDAO.selectItemList(map);
		
		int cnt = iDAO.countItem();
	
		model.addAttribute("cnt", (cnt-1)/10+1);
		model.addAttribute("list", list);
		return "/admin/item";
	}
	
	@RequestMapping(value="/item", method=RequestMethod.POST)
	public String itembatch(@RequestParam("btn") String btn,
			RedirectAttributes redirectAttributes,
			@RequestParam(value="chk[]", required = false) int[] itemno) {
		if(btn.equals("일괄삭제")) {
			iDAO.deleteItemBatch(itemno);
		}
		else if( btn.equals("일괄수정")) {
			redirectAttributes.addFlashAttribute("abc", itemno);
			return "redirect:/admin/itemupdate";
		}
		return "redirect:/admin/item";
	}
	
	
	@RequestMapping(value="/itemupdate")
	public String itemupdate(Model model, HttpServletRequest req) {
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(req);
		if(map != null) {
			int[] tmp = (int[]) map.get("abc");
			for(int i=0;i<tmp.length;i++) {
				System.out.println(tmp[i]);
			}
			List<ItemVO> list = iDAO.selectItemWhere(tmp);
			model.addAttribute("list", list);	
			return "/admin/itemupdate";
		}
		else {
			return "redirect:/admin/item";
	}
		
	}
	
	@RequestMapping(value="/itemupdate", method = RequestMethod.POST)
	public String itemupdatepost(
			@RequestParam(value = "no[]") int[] no,
			@RequestParam("name[]") String[] name,
			@RequestParam("exp[]") String[] exp,
			@RequestParam("price[]") int[] price,
			@RequestParam("itno[]") int[] itno) {
		
		List<ItemVO> list = new ArrayList<ItemVO>();
		for(int i=0; i<no.length; i++) {
			ItemVO obj = new ItemVO();
			obj.setIt_no(no[i]);
			obj.setIt_na(name[i]);
			obj.setIt_exp(exp[i]);
			obj.setIt_price(price[i]);
			obj.setIt_itno(itno[i]);
			list.add(obj);
		}
		iDAO.updateItemBatch(list);
		
		return "redirect:/admin/item";
	}
			
			
			
}