package classes.database.entity.user;

import java.util.ArrayList;
import java.util.List;

public class EUserPage {
    public EUserPage(){}
    public EUserPage(List<EUser> contents,
                     int page,
                     int numberOfElements,
                     int totalPages,
                     int totalElements){
        this.contents = contents;
        this.page = page;
        this.numberOfElements = numberOfElements;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
    public List<EUser> contents = new ArrayList<>();
    public int page = 1;
    public final int pageSize = 100;
    public int numberOfElements = 0;
    public int totalPages = 0;
    public int totalElements = 0;
}
