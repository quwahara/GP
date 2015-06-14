package hello.controller

import hello.domain.Memo
import hello.service.MemoRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
// Add
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
// Add
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class MemoController {

    @Autowired
    private MemoRepository memoRepository

    @RequestMapping("/memo/new")
    @ResponseBody
    Memo new_(@RequestParam(required=false) String text) {
        Memo memo = new Memo(text:text?:"", creationDate:new Date())
        return memoRepository.save(memo)
    }

    @RequestMapping("/memo/find-all")
    @ResponseBody
    List<Memo> findAll() {
        return memoRepository.findAll()
    }

    @RequestMapping("/memo/find/{id}")
    @ResponseBody
    List<Memo> find(@PathVariable Long id) {
        Memo memo = memoRepository.findOne(id)
        return (memo?[memo]:[]) as Memo[]
    }

    // Add
    @RequestMapping(value="/memo/one", method=RequestMethod.GET)
    String one(Model model) {
        model.addAttribute("memo", memoRepository.findOne(1L))
        return "memo_one";
    }
}
