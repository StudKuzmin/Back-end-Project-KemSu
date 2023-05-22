package classes.database.entity;

import java.util.List;

public class EModelPage {
    public int page;
    public int limit;
    public int totalPages;
    public int totalElements;
    public List<EModelContent> contents;
}
