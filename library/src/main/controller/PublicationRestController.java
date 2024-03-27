import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationRestController {

    private final PublicationService publicationService;

    @Autowired
    public PublicationRestController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping
    public List<Publication> getPublicationsByFilter(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String type) {
        if (title == null && type == null) {
            return publicationService.getAllPublications();
        } else {
            return publicationService.getPublicationsByFilter(title, type);
        }
    }
}
