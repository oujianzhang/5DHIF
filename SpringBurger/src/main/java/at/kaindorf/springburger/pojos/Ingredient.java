package at.kaindorf.springburger.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ingredient {

    @Id
    private String id;
    private String name;
    private Type type;

    public static enum Type {
        PATTY,VEGGIE,CHEESE;
    }




}
