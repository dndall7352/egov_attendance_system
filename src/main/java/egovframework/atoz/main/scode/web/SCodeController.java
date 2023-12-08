package egovframework.atoz.main.scode.web;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.atoz.main.scode.service.SCodeService;
import egovframework.atoz.main.scode.service.SCodeVO;



@Controller
public class SCodeController {

	@Resource(name = "sCodeService")
	private SCodeService sCodeService;

	@RequestMapping("/sGroupCodeListAndWrite.do")
	public String sGroupCodeListAndWrite(SCodeVO vo, ModelMap model) throws Exception {
		List<?> list = sCodeService.selectSGroupCodeList(vo);
		model.addAttribute("resultList", list);
		return "/scode/sGroupCodeListAndWrite"; // 메소드를 실행한 곳에 던진다
	}

	@RequestMapping("/sGroupCodeWriteSave.do")
	@ResponseBody
	public String insertSGroupCode(SCodeVO vo) throws Exception {
		String result = sCodeService.insertSGroupCode(vo);
		String msg = "";
		if (result == null) {
			msg = "ok";
		} else {
			msg = "fail";
		}
		return msg;
	}

	@RequestMapping("/sCodeListAndWrite.do")
	public String selectSCodeWriteAndList(SCodeVO vo, ModelMap model) throws Exception {
		List<?> list = sCodeService.selectSCodeList(vo);
		model.addAttribute("resultList", list);
		return "/scode/sCodeListAndWrite";
	}

	@RequestMapping("/sCodeWriteSave.do")
	@ResponseBody
	public String sCodeListAndWrite(SCodeVO vo) throws Exception {
		String result = sCodeService.insertSCode(vo);
		String msg = "";
		if (result == null) {
			msg = "ok";
		} else {
			msg = "fail";
		}
		return msg;
	}


//	@RequestMapping("/sCodeListAndWrite.do")
//    public String getCodesByCodeGroup(SCodeVO vo, ModelMap model) {
//        String codeGroup = "123"; // Change this value as needed
//        List<?> resultList = sCodeService.getCodesByCodeGroup(vo);
//        model.addAttribute("resultList", resultList);
//        return "scode/sCodeListAndWrite"; // Replace with the actual name of your JSP view
//    }
//	


}
