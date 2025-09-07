package basics.o16.interfejsy.tasks.zoo;

public abstract class AbstractAnimal implements Animal{
    private String name;
    private Integer age;
    private Diet diet;

    public AbstractAnimal(String name, Integer age, Diet diet) {
        this.name = name;
        this.age = age;
        this.diet = diet;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public Diet getDiet() {
        return diet;
    }
}
