package classes.database.entity.getdatasets;

import java.util.List;

public class EGetDatasetContentsResult {
    public String id;
    public String name;
    public String description;
    public int trainingSteps;
    public int newData;
    public int dataCount;
    public int modelsCount;
    public String createdAt;
    public String bestModelId;
    public List<String> plugins;
}
