package classes.database.entity;

import java.util.List;

public class EDataset {
    public String id;
    public String name;
    public String description;
    public int trainingSteps;
    public int newData;
    public int dataCount;
    public int modelsCount;
    public String createdAt;
    public List<EPlugins> plugins;
}
