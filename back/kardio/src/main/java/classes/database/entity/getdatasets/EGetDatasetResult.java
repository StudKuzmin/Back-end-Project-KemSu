package classes.database.entity.getdatasets;

import java.util.List;

public class EGetDatasetResult {
    public int page;
    public int limit;
    public int totalPages;
    public int totalElements;
    public List<EGetDatasetContentsResult> contents;
}
