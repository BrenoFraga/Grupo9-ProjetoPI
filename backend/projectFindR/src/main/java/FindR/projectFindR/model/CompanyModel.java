package FindR.projectFindR.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CompanyModel {
    private List<ManegerUserModel> usersManeger;
    private List<TaskModel> projects;


    public CompanyModel() {
        this.projects = new ArrayList<>();
        this.usersManeger = new ArrayList<>();
    }


}
