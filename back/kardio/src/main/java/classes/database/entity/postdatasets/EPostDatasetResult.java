package classes.database.entity.postdatasets;

import java.util.List;

public class EPostDatasetResult {
    public String id;
    public String name;
    public String description;
    public int trainingSteps;
    public int newData;
    public int dataCount;
    public int modelsCount;
    public String createdAt;
    public List<EPostDatasetPluginsResult> plugins;
}
