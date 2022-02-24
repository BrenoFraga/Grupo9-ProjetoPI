package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class DevsModel implements IMonetariavel{
    private String nameGroup;
    private List<ComumUserModel> devs;
    private List<TaskModel> projectsDoing;

    public DevsModel(String nameGroup) {
        this.devs = new ArrayList<>();
        this.projectsDoing = new ArrayList<>();
    }

    @Override
    public Double menetizacao() {
        double valorReceber= 0.00;
        for (TaskModel task: projectsDoing
             ) {
            valorReceber += task.getPrice();
        }
        return valorReceber;
    }
}
