package classes.database.entity.patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EPatientPage {
    public List<Map<String, String>> contents = new ArrayList<>();
    public int page;
    public final int pageSize = 100;
    public int numberOfElements;
    public int totalPages;
    public int totalElements;
}
