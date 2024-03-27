import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Post> posts;

    public Department(String name) {
        this.name = name;
        this.posts = new ArrayList<>();
    }

    public void addPost(String name) {
        posts.add(new Post(name));
    }

    public int getTotalEmployees() {
        int totalEmployees = 0;
        for (Post post : posts) {
            totalEmployees += post.getEmployees().size();
        }
        return totalEmployees;
    }
    public void displayEmployees() {
        System.out.println("Employees in the " + name + " department:");
        for (Post post : posts) {
            System.out.println("Position: " + post.getName() + ", Employees: " + post.getEmployees());
        }
        System.out.println("Total employees in the " + name + " department: " + getTotalEmployees());
    }

    public Post getPost(String name) {
        for(Post post: posts){
            if (post.getName().equals(name)){
                return post;
            }
        }
        return null;
    }

    public class Post {
        private String name;
        private List<String> employees;

        public Post(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public Post(String name, List<String> employees) {
            this.name = name;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public List<String> getEmployees() {
            return employees;
        }

        public void addEmployee(String employeeName) {
            employees.add(employeeName);
        }


    }

    public static void main(String[] args) {
        Department itDepartment = new Department("IT");
        itDepartment.addPost("Software Developer");
        itDepartment.addPost("System Analyst");

        itDepartment.getPost("Software Developer").addEmployee("Vadim");
        itDepartment.getPost("Software Developer").addEmployee("Vlad");

        itDepartment.getPost("System Analyst").addEmployee("Dima");

        itDepartment.displayEmployees();

    }
}
