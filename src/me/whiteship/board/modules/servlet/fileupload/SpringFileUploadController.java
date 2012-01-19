package me.whiteship.board.modules.servlet.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author Keesun Baik
 */
@Controller
public class SpringFileUploadController {

    @RequestMapping(value = "/s/upload", method = RequestMethod.GET)
    public String fileUploadForm() {
        return "/supload";
    }

    @RequestMapping(value = "/s/upload", method = RequestMethod.POST)
    public String fileUploadSubmit(@RequestParam("file") Part part) {
        System.out.println(part.getName());
        System.out.println(part.getHeader("content-disposition"));
        System.out.println(part.getContentType());
        System.out.println(part.getSize());
        try {
            part.write("sample");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/s/upload";
    }

}