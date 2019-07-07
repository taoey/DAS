package lombok;

import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class StudentB {
    private Integer id;
    private String name;
    private Integer age;
}
