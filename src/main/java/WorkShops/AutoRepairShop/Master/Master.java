package WorkShops.AutoRepairShop.Master;

import java.io.Serializable;
import java.util.Objects;

public class Master implements Serializable {

    private String name;
    private Rank rank;
    private String workExperience;
    private String resume;

    public Master(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Master(String name, String rank, String workExperience, String resume) {
        this.name = name;
        try {
        this.rank = (rank!=null) ? Rank.valueOf(rank): null;
        }  catch (IllegalArgumentException e){
            System.out.println("No such rank!");
        }
        this.workExperience = workExperience;
        this.resume = resume;
    }

    public void setRank(String rank){
        try {
            this.rank = Rank.valueOf(rank);
        }  catch (IllegalArgumentException e){
            System.out.println("No such rank!");
        }
    }

    public void setWorkExperience(String workExperience) {
        if(!workExperience.equals("")) {
            this.workExperience = workExperience;
        } else{
            this.workExperience = null;
        }
    }

    public void setResume(String resume) {
        if(!resume.equals("")){
            this.resume = resume;
        } else {
            this.resume = null;
        }
    }

    @Override
    public String toString(){
        StringBuilder information = new StringBuilder();
        information.append(name).append(" ");
        return information.toString();
    }
}
