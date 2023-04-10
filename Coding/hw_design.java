//
public class hw_design {
    public static void main(String[] args){
        try {
            Person person = new Person();
            person.receive(new Email());
            person.receive(new SMS());
            person.receive(new WeChat());
        }
        catch (Exception e){
            System.out.print("error");
        }
    }
}
interface receive{
    public String getInfo();
}
class Email implements receive{
    public String getInfo(){
        return "Email";
    }
}
class SMS implements receive{
    public String getInfo(){
        return "SMS";
    }
}
class WeChat implements receive{
    public String getInfo(){
        return "WeChat";
    }
}
class Person{
    public void receive(receive r){
        System.out.print(r.getInfo());
    }
}

