@Entity
public class Resource {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    // getters & setters
}