package classes.database.entity.postdatasets;

import java.util.List;

public class EPostDatasetBody {
    public EPostDatasetBody(String name,
                            List<String> plugins,
                            String description,
                            int trainingSteps){
        this.name = name;
        this.description = description;
        this.trainingSteps = trainingSteps;
        this.plugins = plugins;
    }
    public String name;
    public List<String> plugins;
    public String description;
    public int trainingSteps;
}
