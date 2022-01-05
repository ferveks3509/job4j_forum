package forum.control;

import forum.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexControl {

    private final PostService postService;

    public IndexControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"/", "/index"})
    public String index(@RequestParam(value = "login", required = false) String login,
                        @RequestParam(value = "username", required = false) String username,
                        Model model) {
        if (login != null) {
            model.addAttribute("posts", postService.getAllPost());
            model.addAttribute("username", username);
            return "index";
        }
        return "login";
    }
}
