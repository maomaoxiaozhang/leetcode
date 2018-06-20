package Study.io.stream;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable{
    private String name;
    private String password;
    private transient int money;
}
