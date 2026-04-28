@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "http://localhost:3000")
public class ResourceController {

    @Autowired
    private ResourceRepository repo;

    @GetMapping
    public List<Resource> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Resource add(@RequestBody Resource r) {
        return repo.save(r);
    }
}