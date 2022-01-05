package forum.control;

import forum.model.Post;
import forum.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostControl {

    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "edit";
    }

    @GetMapping("/post")
    public String show(@RequestParam("id") int id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("/add.comment")
    public String addComment(@RequestParam("id") int id, HttpServletRequest request, Model model) {
        String comment = request.getParameter("comment");
        Post post = postService.findPostById(id);
        post.addComment(comment);
        model.addAttribute("post", post);
        return "post";
    }
}
