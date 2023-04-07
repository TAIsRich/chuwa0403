package coding1;

public class EncapsulationDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Alice");
        student.setAge(10);
        student.setMajor("math");
        student.setScore(95);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getMajor());
        System.out.println(student.getScore());
    }

    static class Student {
        private String name;
        private int age;
        private String major;
        private int score;

        public Student() {
        }

        public Student(String name, int age, String major, int score) {
            this.name = name;
            this.age = age;
            this.major = major;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
